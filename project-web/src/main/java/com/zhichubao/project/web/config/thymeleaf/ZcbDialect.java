package com.zhichubao.project.web.config.thymeleaf;

import com.google.common.collect.Sets;
import com.zhichubao.project.web.utils.ApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.Set;

/**
 * Created by fenglvming on 17/3/14.
 */
@Component
public class ZcbDialect extends AbstractProcessorDialect {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    public static final String NAME = "ZhiChuBao";
    public static final String PREFIX = "zcb";

    public ZcbDialect() {
        super(NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors = Sets.newHashSet();
        processors.add(new HasRoleElementProcessor());
        processors.add(new HasModulesProcessor(redisTemplate));
        return processors;
    }
}
