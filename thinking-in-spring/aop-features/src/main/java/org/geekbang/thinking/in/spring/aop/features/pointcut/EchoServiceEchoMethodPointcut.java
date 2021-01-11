package org.geekbang.thinking.in.spring.aop.features.pointcut;

import java.lang.reflect.Method;
import java.util.Objects;
import org.geekbang.thinking.in.spring.aop.overview.EchoService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

public class EchoServiceEchoMethodPointcut implements Pointcut {

  public static final EchoServiceEchoMethodPointcut INSTANCE = new EchoServiceEchoMethodPointcut();


  private EchoServiceEchoMethodPointcut() {
  }

  @Override
  public ClassFilter getClassFilter() {
    return new ClassFilter() {
      @Override
      public boolean matches(Class<?> aClass) {
        return EchoService.class.isAssignableFrom(aClass);
      }
    };
  }

  @Override
  public MethodMatcher getMethodMatcher() {
    return new MethodMatcher() {
      @Override
      public boolean matches(Method method, Class<?> aClass) {
        return "echo".equals(method.getName())
            && method.getParameterTypes().length == 1
            && Objects.equals(String.class, method.getParameterTypes()[0]);
      }

      @Override
      public boolean isRuntime() {
        return false;
      }

      @Override
      public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return false;
      }
    };
  }
}
