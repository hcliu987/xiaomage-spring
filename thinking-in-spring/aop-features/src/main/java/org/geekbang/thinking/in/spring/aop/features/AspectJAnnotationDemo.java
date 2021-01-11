package org.geekbang.thinking.in.spring.aop.features;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect  //声明为  apsect 切面
@Configuration
@EnableAspectJAutoProxy  //激活 aspect 注解自动代理
public class AspectJAnnotationDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(AspectJAnnotationDemo.class);
    context.refresh();
    AspectJAnnotationDemo aspectJAnnotationDemo = context.getBean(AspectJAnnotationDemo.class);
    context.close();
  }
}
