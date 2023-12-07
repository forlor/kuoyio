package com.kuoyio.component.datajdbc;

import com.kuoyio.core.constant.KuoyioConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJdbcRepositories(basePackages = {"${" + KuoyioConstant.KUOYIO + ".data.jdbc.basePackages}"}, repositoryBaseClass = KuoyioJdbcRepositoryImpl.class)
@EnableJdbcAuditing
@EnableTransactionManagement
@Configuration(proxyBeanMethods = false)
public class KuoyioJdbcAutoConfiguration {
//    @Bean
//    AuditorAware auditorProvider() {
//        return new AuditorAwareImpl();
//    }
}
