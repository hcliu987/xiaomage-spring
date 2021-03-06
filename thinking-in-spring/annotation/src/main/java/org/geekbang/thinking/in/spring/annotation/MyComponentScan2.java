package org.geekbang.thinking.in.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;

/**
 * 自定义 {@link org.springframework.stereotype.Component} Scan
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponentScan
public @interface MyComponentScan2 {

  @AliasFor(annotation = MyComponentScan.class, attribute = "scanBasePackages") // 隐性别名
  String[] basePackages() default {};
  // @MyComponentScan2.basePackages
  // -> @MyComponentScan.scanBasePackages
  // -> @ComponentScan.value
  // -> @ComponentScan.basePackages

  /**
   * 与元注解 @MyComponentScan 同名属性
   *
   * @return
   */
  String[] scanBassPackages() default {};

  @AliasFor("scanBasePackages")
  String[] packages() default {};

  // packages 覆盖了 scanBasePackages 覆盖了元注解 scanBasePackages
}
