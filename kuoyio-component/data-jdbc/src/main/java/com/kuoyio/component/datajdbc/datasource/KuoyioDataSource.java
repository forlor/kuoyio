package com.kuoyio.component.datajdbc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

/**
 * 数据源
 * 继承AbstractRoutingDataSource实现多数据源路由
 *
 * @author xyz
 * @since 1.0
 */
public class KuoyioDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        String dynamicDataSourceKey = DynamicDataSourceHolder.getDynamicDataSourceKey();
        if (StringUtils.hasText(dynamicDataSourceKey)) {
           return getResolvedDataSources().get(dynamicDataSourceKey);
        }
        return getResolvedDefaultDataSource();
    }
}
