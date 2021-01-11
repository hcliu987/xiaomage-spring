package org.geekbang.thinking.in.spring.aop.features;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {


  public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
    System.out.printf("method: %s , args: %s ,target: %s ,exception: %s\n",
        method, Arrays.asList(args), target, e);
  }
}
