package com.kuoyio.component.datajdbc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * 数据源
 * 继承AbstractRoutingDataSource实现多数据源路由
 *
 * @author xyz
 * @since 1.0
 */
public class KuoyioDataSource extends AbstractRoutingDataSource {
    private List<Object> propertis;

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {

        return null;
    }
}
