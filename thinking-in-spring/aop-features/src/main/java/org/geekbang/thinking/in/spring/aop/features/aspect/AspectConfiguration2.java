package org.geekbang.thinking.in.spring.aop.features.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

/**
 * aspect 配置类
 */
@Aspect
public class AspectConfiguration2 implements Ordered {

  @Before("execution( public * *(..))")
  public void beforeAnyPublicMehod2() {
    System.out.println("@Before any public method.(2)");
  }
  

  @Override
  public int getOrder() {
    return 0;
  }
}
