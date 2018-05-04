package com.zhichubao.project.web.config.thymeleaf;

import com.google.common.base.Strings;
import com.zhichubao.common.consts.SystemTypeConst;
import com.zhichubao.core.domain.enterprisesetting.employee.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * ${角色判断精度处理类}
 *
 * @author wzw
 * @create 2018-03-05 15:51
 **/
@Component
public class OptionRoleProcessorExpresssion {
    /**
     * 判断是否有角色
     * @param
     * @param
     * @return
     */
    public Boolean hasroles(String context) {
        if (Strings.isNullOrEmpty(context)){
            return false;
        }
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        List<Role> employeeRoles = (List<Role>)request.getSession().getAttribute("roles");
        String[] values = context.split(",");
        return hasAllRoles(employeeRoles, Arrays.asList(values));
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
}
