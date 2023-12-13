package com.kuoyio.component.datajdbc.datasource;

import com.kuoyio.core.constant.KuoyioConstant;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源连接配置
 * 通过读取到的{@link KuoyioDataSourceProperties}配置进行多数据源配置
 * 多数据源若没有指定type属性，则使用spring boot默认的hikari作为连接池
 *
 * @author xyz
 * @see KuoyioDataSource
 * @since 1.0
 */
@Configuration(proxyBeanMethods = false)
public class KuoyioDataSourceConfig implements EnvironmentAware {

    private final KuoyioDataSourceProperties dataSourceProperties;
    private Environment environment;


    public KuoyioDataSourceConfig(KuoyioDataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    /**
     * 遍历{@link KuoyioDataSourceProperties}读取到的多个数据源，通过{@link KuoyioDataSource}进行多数据源构建
     *
     * @return 构建好的KuoyioDataSource
     */
    @Bean
    public DataSource dataSource() {
        final Map<String, Object> multipleDataSourceProperties = dataSourceProperties.getMultiple();
        if (CollectionUtils.isEmpty(multipleDataSourceProperties)) {
            throw new KuoyioDataSourceInitException("multipleDataSourceProperties must not be empty");
        }
        KuoyioDataSource dataSource = new KuoyioDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(multipleDataSourceProperties.size());
        multipleDataSourceProperties.forEach((k, v) -> {
            final String typeClassPath = environment.getProperty(KuoyioConstant.KUOYIO + ".datasource." + k + ".type", dataSourceProperties.getType());
            try {
                final Class<DataSource> typeClass = (Class<DataSource>) Class.forName(typeClassPath);
                final DataSource build = DataSourceBuilder.create(dataSourceProperties.getClass().getClassLoader())
                        .type(typeClass)
                        .build();
                final BindResult<DataSource> targetDataSource = Binder.get(environment)
                        .bind(KuoyioConstant.KUOYIO + ".datasource.multiple." + k, Bindable.ofInstance(build));
                dataSourceMap.put(k, targetDataSource.get());
                if (k.equals(dataSourceProperties.getPrimary())) {
                    dataSource.setDefaultTargetDataSource(targetDataSource.get());
                }
            } catch (ClassNotFoundException e) {
                throw new KuoyioDataSourceInitException("kuoyioDataSource init fail", e);
            }
        });
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
