package com.kuoyio.component.datajdbc.datasource;

import com.kuoyio.core.constant.KuoyioConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;

import java.util.Map;

/**
 * kuoyio配置信息
 *
 * @author xyz
 * @since 1.0
 */
@ConfigurationProperties(prefix = KuoyioConstant.KUOYIO + ".datasource")
public class KuoyioDataSourceProperties {
    private static final String HIKARI_CLASS_PATH = "com.zaxxer.hikari.HikariDataSource";
    /**
     * 指定主数据源
     */
    @NonNull
    private String primary = "master";
    /**
     * 数据源类型，默认使用{@link com.zaxxer.hikari.HikariDataSource}
     * 若multiple里面单个数据源没有设置数据源类型，将使用该数据源类型。
     */
    @NonNull
    private String type = HIKARI_CLASS_PATH;
    private Map<String, Object> multiple;

    @NonNull
    public String getPrimary() {
        return primary;
    }

    public void setPrimary(@NonNull String primary) {
        this.primary = primary;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    public Map<String, Object> getMultiple() {
        return multiple;
    }

    public void setMultiple(Map<String, Object> multiple) {
        this.multiple = multiple;
    }
}
