package com.kuoyio.component.datajdbc.datasource;

import com.kuoyio.core.constant.KuoyioConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;

import java.util.Map;

@ConfigurationProperties(prefix = KuoyioConstant.KUOYIO+".datasource")
public class KuoyioDataSourceProperties {
    @NonNull
    private String primary = "master";
    private Map<String,Object> multiple;

    @NonNull
    public String getPrimary() {
        return primary;
    }

    public void setPrimary(@NonNull String primary) {
        this.primary = primary;
    }

    public Map<String, Object> getMultiple() {
        return multiple;
    }

    public void setMultiple(Map<String, Object> multiple) {
        this.multiple = multiple;
    }
}
