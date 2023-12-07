package com.kuoyio.component.datajdbc;

import com.kuoyio.core.constant.KuoyioConstant;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories(basePackages = {"${" + KuoyioConstant.KUOYIO + ".data.jdbc.basePackages}"}, repositoryBaseClass = KuoyioJdbcRepositoryImpl.class)
public class KuoyioJdbcAutoConfiguration {

}
