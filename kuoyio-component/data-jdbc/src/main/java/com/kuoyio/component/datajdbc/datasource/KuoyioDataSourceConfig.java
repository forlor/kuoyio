package com.kuoyio.component.datajdbc.datasource;

import org.springframework.boot.context.properties.bind.BindMethod;
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
import java.util.Map;

/**
 * @author xyz
 * @since 1.0
 */
@Configuration(proxyBeanMethods = false)
public class KuoyioDataSourceConfig implements EnvironmentAware {

    private final KuoyioDataSourceProperties properties;
    private Environment environment;
    private static final String HIKARI_CLASS_PATH = "com.zaxxer.hikari.HikariDataSource";

    public KuoyioDataSourceConfig(KuoyioDataSourceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public DataSource dataSource() {

        final Map<String, Object> multiple = properties.getMultiple();
        if (CollectionUtils.isEmpty(multiple)) {
            throw new RuntimeException();
        }
        KuoyioDataSource dataSource = new KuoyioDataSource();
        multiple.forEach((k, v) -> {
            final String typeClassPath = environment.getProperty("kuoyio.datasource." + k + ".type", HIKARI_CLASS_PATH);
            try {
                final Class<DataSource> typeClass = (Class<DataSource>) Class.forName(typeClassPath);
                final DataSource build = DataSourceBuilder.create(properties.getClass().getClassLoader())
                        .type(typeClass)
                        .build();
                final BindResult<DataSource> targetDataSource = Binder.get(environment)
                        .bind("kuoyio.datasource.multiple."+k, Bindable.ofInstance(build));
                System.out.println(1);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        return dataSource;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
