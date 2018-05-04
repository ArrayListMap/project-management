package com.zhichubao.project.web.config.thymeleaf;

import com.zhichubao.core.domain.enterprisesetting.employee.Role;
import com.zhichubao.tenant.module.role.SystemTypeConst;
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
import java.util.List;

import static at.pollux.thymeleaf.shiro.processor.ThymeleafFacade.evaluateAsStringsWithDelimiter;
import static at.pollux.thymeleaf.shiro.processor.ThymeleafFacade.getRawValue;


/**
 * Created by fenglvming on 17/3/14.
 */
@Component
public class HasRoleElementProcessor extends AbstractAttributeTagProcessor {

    private static final String DELIMITER = ",";
    private static final String ATTRIBUTE_NAME = "hasrole";
    private static final int PRECEDENCE = 300;

    public HasRoleElementProcessor() {
        super(
                TemplateMode.HTML, // This processor will apply only to HTML mode
                ZcbDialect.PREFIX, // Prefix to be applied to name for matching
                null, // No tag name: match any tag name
                false, // No prefix to be applied to tag name
                ATTRIBUTE_NAME, // Name of the attribute that will be matched
                true, // Apply dialect prefix to attribute name
                PRECEDENCE, // Precedence (inside dialect's precedence)
                true); // Remove the matched attribute afterwards

    }


    /**
     * @param employeeRoles 当前审批人的角色
     * @param values
     * @return
     */
    private boolean hasAllRoles(List<Role> employeeRoles, List<String> values) {
        if (values == null || values.size() <= 0) {
            return true;
        }

        if (employeeRoles == null || employeeRoles.size() <= 0) {
            return false;
        }

        boolean find = false;
        for (String roleName : values) {
            for (Role employeeRole : employeeRoles) {
                if (employeeRole.getRoleName().equals(SystemTypeConst.ROLE_SUPER_ADMIN)) { //如果是超级管理员, 那么默认开启所有模块.
                    find = true;
                    break;
                }
                if (employeeRole.getRoleName().equals(roleName)) {
                    find = true;
                    break;
                }
            }

        }
        if (!find) {
            return false;
        }
        return true;
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler) {
        final String rawValue = getRawValue(tag, attributeName);
        final List<String> values = evaluateAsStringsWithDelimiter(context, rawValue, DELIMITER);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        List<Role> employeeRoles = (List<Role>)request.getSession().getAttribute("roles");
        if (hasAllRoles(employeeRoles, values)) {
            structureHandler.removeAttribute(attributeName);
        } else {
            structureHandler.removeElement();
        }
    }
}
