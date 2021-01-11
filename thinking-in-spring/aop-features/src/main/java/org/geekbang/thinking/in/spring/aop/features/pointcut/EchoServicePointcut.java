package org.geekbang.thinking.in.spring.aop.features.pointcut;

import java.lang.reflect.Method;
import java.util.Objects;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class EchoServicePointcut extends StaticMethodMatcherPointcut {

  private String methodName;
  private Class targetCalss;

  public EchoServicePointcut(String methodName, Class targetCalss) {
    this.methodName = methodName;
    this.targetCalss = targetCalss;
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }

  public Class getTargetCalss() {
    return targetCalss;
  }

  public void setTargetCalss(Class targetCalss) {
    this.targetCalss = targetCalss;
  }

  @Override
  public boolean matches(Method method, Class<?> aClass) {
    return Objects.equals(methodName, method.getName())
        && this.targetCalss.isAssignableFrom(aClass);
  }
}
