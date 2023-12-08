package com.kuoyio.component.webmvc;

import com.kuoyio.core.constant.KuoyioConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = KuoyioConstant.KUOYIO + ".mvc")
public class WebMvcProperties {
    @Nullable
    private  Map<String, List<String>> pathPrefix;

    @Nullable
    public Map<String, List<String>> getPathPrefix() {
        return pathPrefix;
    }

    public void setPathPrefix(@Nullable Map<String, List<String>> pathPrefix) {
        this.pathPrefix = pathPrefix;
    }
}
