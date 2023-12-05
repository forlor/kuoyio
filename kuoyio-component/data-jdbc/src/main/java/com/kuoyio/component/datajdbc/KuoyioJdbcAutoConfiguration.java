package com.kuoyio.component.datajdbc;

import com.kuoyio.core.constant.KuoyioConstant;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Import(KuoyioJdbcAutoConfiguration.KuoyioJdbcRepositoryConfig.class)
public class KuoyioJdbcAutoConfiguration {
    @EnableJdbcRepositories(basePackages = "${" + KuoyioConstant.KUOYIO + ".data.jdbc.basePackages}", repositoryBaseClass = KuoyioJdbcRepository.class)
    static class KuoyioJdbcRepositoryConfig {

    }
}
