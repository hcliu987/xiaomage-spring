package org.geekbang.thinking.in.spring.aop.features;

import org.geekbang.thinking.in.spring.aop.features.aspect.AspectConfiguration;
import org.geekbang.thinking.in.spring.aop.features.aspect.AspectConfiguration2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //激活 aspest 注解自动代理
public class AspectJAnnotatedPointcutDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(AspectJAnnotatedPointcutDemo.class,
        AspectConfiguration.class,
        AspectConfiguration2.class);
    context.refresh();
    AspectJAnnotatedPointcutDemo aspectJAnnotationDemo = context
        .getBean(AspectJAnnotatedPointcutDemo.class);
    aspectJAnnotationDemo.execute();
    context.close();
  }

  public void execute() {
    System.out.println("execute()...");
  }
}
