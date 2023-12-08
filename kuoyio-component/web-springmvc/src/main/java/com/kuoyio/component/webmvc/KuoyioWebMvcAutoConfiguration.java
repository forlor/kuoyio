package com.kuoyio.component.webmvc;

import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xyz
 * @since 1.0
 */
public class KuoyioWebMvcAutoConfiguration implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/app-api", HandlerTypePredicate.forBasePackage(""));
    }
}
