package com.kuoyio.component.webmvc;

import com.kuoyio.core.constant.KuoyioConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.List;

@ConfigurationProperties(prefix = KuoyioConstant.KUOYIO + ".mvc")
public class WebMvcProperties {
    @Nullable
    private List<PathPrefix> pathPrefix;

    @Nullable
    List<PathPrefix> getPathPrefix() {
        return pathPrefix;
    }

    void setPathPrefix(@Nullable List<PathPrefix> pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    static class PathPrefix {
        private String prefix;
        private List<String> packages;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public List<String> getPackages() {
            return packages;
        }

        public void setPackages(List<String> packages) {
            this.packages = packages;
        }

        public boolean available() {
            return (StringUtils.isNotBlank(prefix) && !CollectionUtils.isEmpty(packages));
        }
    }
}
