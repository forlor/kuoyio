package com.kuoyio.component.datajdbc;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author xyz
 * @since 1.0
 */
@Configuration(proxyBeanMethods = false)
public class KuoyioDataSourceConfig implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private Environment environment;
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        GenericBeanDefinition beandefinition=new GenericBeanDefinition();
        beandefinition.setBeanClassName("javax.sql.DataSource");
        registry.registerBeanDefinition("xyzDataSource",beandefinition);

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
