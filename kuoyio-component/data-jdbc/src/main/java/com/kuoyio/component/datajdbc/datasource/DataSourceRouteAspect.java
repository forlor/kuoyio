package com.kuoyio.component.datajdbc.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 *
 * @author xyz
 * @since 1.0
 */

@Aspect
@Order(-1)
public class DataSourceRouteAspect {
    @Pointcut("@annotation(com.kuoyio.component.datajdbc.datasource.DataSourceTarget)")
    public void cut() {
    }

    @Before("@annotation(dt)")
    public void before(JoinPoint point, DataSourceTarget dt) {
        String value = dt.value();
        if (value != null && !value.isBlank()) {
            DynamicDataSourceHolder.setDynamicDataSourceKey(value);
        }
    }

    @After("@annotation(dt)")
    public void after(JoinPoint point, DataSourceTarget dt) {
        DynamicDataSourceHolder.removeDynamicDataSourceKey();
    }
}
