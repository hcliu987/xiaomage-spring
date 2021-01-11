package org.geekbang.thinking.in.spring.annotation;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.AnnotationMetadata;

/**
 * "HelloWorld" 模块 {@link ImportBeanDefinitionRegistrar}
 */
public class HelloWorldImportBeanDefinitionRegistrar {

  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
      BeanDefinitionRegistry registry) {
    AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(
        HelloWorldConfiguration.class);
    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
  }
}
