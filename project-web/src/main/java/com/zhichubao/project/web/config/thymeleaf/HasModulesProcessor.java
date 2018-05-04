package com.zhichubao.project.web.config.thymeleaf;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhichubao.core.domain.tenant.Account;

import com.zhichubao.core.dto.auth.AuthenticationDTO;
import com.zhichubao.project.web.utils.ApplicationContextUtils;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static at.pollux.thymeleaf.shiro.processor.ThymeleafFacade.evaluateAsStringsWithDelimiter;
import static at.pollux.thymeleaf.shiro.processor.ThymeleafFacade.getRawValue;


/**
 * Created by fenglvming on 17/3/14.
 */
@Component
public class HasModulesProcessor extends AbstractAttributeTagProcessor {
    private static RedisTemplate<String, String> redisTemplate;
    private static final String DELIMITER = ",";
    private static final String ATTRIBUTE_NAME = "hasmoudle";
    private static final int PRECEDENCE = 300;

    public HasModulesProcessor(RedisTemplate<String, String> redisTemplate) {
        super(
                TemplateMode.HTML, // This processor will apply only to HTML mode
                ZcbDialect.PREFIX, // Prefix to be applied to name for matching
                null, // No tag name: match any tag name
                false, // No prefix to be applied to tag name
                ATTRIBUTE_NAME, // Name of the attribute that will be matched
                true, // Apply dialect prefix to attribute name
                PRECEDENCE, // Precedence (inside dialect's precedence)
                true); // Remove the matched attribute afterwards
        this.redisTemplate = redisTemplate;

    }

    private boolean hasModules(Map<String, AuthenticationDTO> authMap, List<String> values) {
        if (values == null || values.size() <= 0) {
            return true;
        }

        if (authMap == null || authMap.size() <= 0) {
            return false;
        }

        for (String modulesCode : values) {
            if (authMap.get(modulesCode) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler) {
        final String rawValue = getRawValue(tag, attributeName);
        final List<String> values = evaluateAsStringsWithDelimiter(context, rawValue, DELIMITER);
        Environment env = ApplicationContextUtils.getBean(Environment.class);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        Account account = (Account) request.getSession().getAttribute("account");
        String mapkey = "p2p_tenant_module_"+env.getProperty("zcb.pro.version")+"_"+account.getTenantId();
        //获取该租户的模块
        String authString = redisTemplate.opsForValue().get(mapkey);
        if(StringUtils.isNotEmpty(authString)){
            Map<String, AuthenticationDTO> authMap = auth2Map(authString);
            if (hasModules(authMap, values)) {
                structureHandler.removeAttribute(attributeName);
            } else {
                structureHandler.removeElement();
            }
        }
    }

    /**
     * 鉴权字符串转为Map
     *
     * @param authString
     * @return
     */
    private Map<String, AuthenticationDTO> auth2Map(String authString) {
        JSONArray jsonArray = JSON.parseArray(authString);
        List<AuthenticationDTO> auths = jsonArray.toJavaList(AuthenticationDTO.class);

        Map<String, AuthenticationDTO> authMap = new HashMap<String, AuthenticationDTO>();
        for (AuthenticationDTO auth : auths) {
            authMap.put(auth.getModuleCode(), auth);
        }
        return authMap;
    }
}
