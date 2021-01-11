package org.geekbang.thinking.in.spring.aop.features;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
@Configuration
public class AspectJXmlDemo {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "classpath:/META-INF/spring-aop-context.xml");
    context.close();
  }
}
