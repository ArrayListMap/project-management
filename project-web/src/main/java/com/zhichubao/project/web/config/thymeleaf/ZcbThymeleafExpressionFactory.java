package com.zhichubao.project.web.config.thymeleaf;

import com.zhichubao.project.web.utils.ApplicationContextUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-03-05 18:25
 **/
public class ZcbThymeleafExpressionFactory implements IExpressionObjectFactory {
    public static final String STRING_UTILS_EXPRESSION_OBJECT_NAME = "roles";


    public static final Set<String> ALL_EXPRESSION_OBJECT_NAMES;


    static {
        final Set<String> allExpressionObjectNames = new LinkedHashSet<String>();
        allExpressionObjectNames.add(STRING_UTILS_EXPRESSION_OBJECT_NAME);
        ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(allExpressionObjectNames);

    }
    public ZcbThymeleafExpressionFactory(){
        super();
    }

    @Override
    public Set<String> getAllExpressionObjectNames() {
        return ALL_EXPRESSION_OBJECT_NAMES;
    }

    @Override
    public Object buildObject(IExpressionContext context, String expressionObjectName) {
        //如果有多个内置对象可以根据名字进行返回
        return STRING_UTILS_EXPRESSION_OBJECT_NAME.equals(expressionObjectName) ? ApplicationContextUtils.getBean(OptionRoleProcessorExpresssion.class) : null;

    }

    public boolean isCacheable(String expressionObjectName) {
        return expressionObjectName != null && STRING_UTILS_EXPRESSION_OBJECT_NAME.equals(expressionObjectName);
    }
}
