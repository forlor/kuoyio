package com.kuoyio.component.datajdbc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.List;

public class KuoyioDataSource extends AbstractRoutingDataSource {
    private List<Object> propertis;
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {

        return null;
    }
}
