package com.zhichubao.project;

import com.zhichubao.project.web.utils.ApplicationContextUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-05-03 15:23
 **/
@SpringBootApplication(scanBasePackages = "com.zhichubao.project")
@MapperScan(basePackages = {"com.zhichubao.project.core.mapper"})
public class ProjectApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProjectApp.class, args);
        //获取上下文信息，生成上下文信息的工具类
        ApplicationContextUtils.setApplicationContext(applicationContext);
    }
}
