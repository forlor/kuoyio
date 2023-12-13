package com.kuoyio.component.datajdbc.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xyz
 * @since 1.0
 */
class DynamicDataSourceHolder {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    /**
     * 保存动态数据源名称
     */
    private static final InheritableThreadLocal<String> DYNAMIC_DATASOURCE_KEY = new InheritableThreadLocal<>();

    /**
     * 设置/切换数据源，决定当前线程使用哪个数据源
     */
    public static void setDynamicDataSourceKey(String key) {
        if (logger.isDebugEnabled()) {
            logger.debug("当前线程数据源切换为：{}", key);
        }
        DYNAMIC_DATASOURCE_KEY.set(key);
    }

    /**
     * 获取动态数据源名称，默认使用mater数据源
     */
    public static String getDynamicDataSourceKey() {
        return DYNAMIC_DATASOURCE_KEY.get();
    }

    /**
     * 移除当前数据源
     */
    public static void removeDynamicDataSourceKey() {
        if (logger.isDebugEnabled()) {
            logger.debug("移除当前线程数据源信息：{}", DYNAMIC_DATASOURCE_KEY.get());
        }
        DYNAMIC_DATASOURCE_KEY.remove();
    }

}
