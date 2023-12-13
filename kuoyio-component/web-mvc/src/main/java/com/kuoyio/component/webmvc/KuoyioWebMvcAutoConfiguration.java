package com.kuoyio.component.webmvc;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.server.PathContainer;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.List;

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
        List<WebMvcProperties.PathPrefix> pathPrefixList = webMvcProperties.getPathPrefix();
        if (CollectionUtils.isEmpty(pathPrefixList)) {
            return;
        }
        PathPatternParser patternParser = new PathPatternParser();
        patternParser.setPathOptions(PathContainer.Options.MESSAGE_ROUTE);
        for (WebMvcProperties.PathPrefix pathPrefix : pathPrefixList) {
            if (!pathPrefix.available()) continue;
            configurer.addPathPrefix(pathPrefix.getPrefix(), (clazz) -> pathPrefix.getPackages()
                    .parallelStream()
                    .anyMatch(up -> patternParser.parse(up)
                            .matches(PathContainer.parsePath(clazz.getPackageName(), PathContainer.Options.MESSAGE_ROUTE))));


        }

    }


}
