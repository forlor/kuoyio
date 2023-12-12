package com.kuoyio.component.datajdbc.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSourceTarget {
    /**
     * 切换数据源名称
     */
    String value() default "";
}
