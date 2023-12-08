package com.kuoyio.component.webmvc;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.server.PathContainer;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.List;
import java.util.Map;

/**
 * @author xyz
 * @since 1.0
 */
@EnableConfigurationProperties({WebMvcProperties.class})
public class KuoyioWebMvcAutoConfiguration implements WebMvcConfigurer {

    private final WebMvcProperties webMvcProperties;

    public KuoyioWebMvcAutoConfiguration(WebMvcProperties webMvcProperties) {
        this.webMvcProperties = webMvcProperties;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        final Map<String, List<String>> pathPrefix = webMvcProperties.getPathPrefix();
        if (pathPrefix == null) return;
        PathPatternParser patternParser = new PathPatternParser();
        patternParser.setPathOptions(PathContainer.Options.MESSAGE_ROUTE);
        pathPrefix.forEach((k, v) -> configurer.addPathPrefix(k, clazz -> {
            if (clazz == null) return false;
            if (CollectionUtils.isEmpty(v)) return false;
            return v.parallelStream()
                    .anyMatch(up -> patternParser.parse(up)
                    .matches(PathContainer.parsePath(clazz.getPackageName(), PathContainer.Options.MESSAGE_ROUTE)));

        }));
    }

}
