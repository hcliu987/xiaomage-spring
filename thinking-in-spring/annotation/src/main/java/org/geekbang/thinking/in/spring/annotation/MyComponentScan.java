package org.geekbang.thinking.in.spring.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan
public @interface MyComponentScan {


  @AliasFor(annotation = ComponentScan.class, attribute = "value") //隐性别名
  //多态,子注解提供新的属性方法引用父元注解中的属性方法
  String[] scanBassPackages() default {"#"};
  // scanBasePackages ->
  //          @AliasFor @ComponentScan.basePackages -> @AliasFor @ComponentScan.value (显性别名）
  // @AliasFor @ComponentScan.value // 传递隐性别名
}
