package org.geekbang.thinking.in.spring.aop.features.interceptor;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class EchoServiceMethodInterceptor implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    Method method = methodInvocation.getMethod();
    System.out.println("拦截 echoService 方法 :" + method);
    return methodInvocation.proceed();
  }
}
