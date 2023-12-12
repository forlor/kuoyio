package com.kuoyio.component.datajdbc;

import com.kuoyio.core.constant.KuoyioConstant;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJdbcRepositories(basePackages = {"${" + KuoyioConstant.KUOYIO + ".data.jdbc.basePackages}"}, repositoryBaseClass = KuoyioJdbcRepositoryImpl.class)
@EnableJdbcAuditing
@EnableTransactionManagement
@ConditionalOnMissingBean(type = "io.r2dbc.spi.ConnectionFactory")
@EnableConfigurationProperties(DataSourceProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@Import(KuoyioJdbcAutoConfiguration.KuoyioDataSourceConfiguration.class)
public class KuoyioJdbcAutoConfiguration {
    //    @Bean
//    AuditorAware auditorProvider() {
//        return new AuditorAwareImpl();
//    }
    @Configuration(proxyBeanMethods = false)
  //  @ConditionalOnProperty(KuoyioConstant.KUOYIO + ".datasource.primary.*")
    @Import({KuoyioDataSourceConfig.class})
    protected static class KuoyioDataSourceConfiguration {

    }
}
