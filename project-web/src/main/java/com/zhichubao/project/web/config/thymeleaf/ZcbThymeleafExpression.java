package com.zhichubao.project.web.config.thymeleaf;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 * ${支出宝thmeleaf 自定义内置对象}
 *
 * @author
 * @create 2018-03-05 18:17
 **/
public class ZcbThymeleafExpression extends AbstractDialect implements IExpressionObjectDialect {
    public ZcbThymeleafExpression() {
        super(ZcbThymeleafExpressionFactory.STRING_UTILS_EXPRESSION_OBJECT_NAME);
    }

    private final IExpressionObjectFactory EXPRESSION_OBJECTS_FACTORY = new ZcbThymeleafExpressionFactory();

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return this.EXPRESSION_OBJECTS_FACTORY;
    }
}
