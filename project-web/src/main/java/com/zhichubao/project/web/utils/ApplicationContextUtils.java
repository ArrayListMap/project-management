package com.zhichubao.project.web.utils;

import org.springframework.context.ApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-05-03 17:36
 **/
public class ApplicationContextUtils {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static <T> T getBean(Class<T> tClass)  {
        return (T)applicationContext.getBean(tClass);
    }

}
