package org.geekbang.thinking.in.spring.aop.overview;

import java.lang.reflect.Method;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.MethodCallback;
import org.springframework.util.ReflectionUtils.MethodFilter;

/**
 * aop 目标过滤示例
 */
public class TargetFilterDemo {

  public static void main(String[] args) throws ClassNotFoundException {
    String targetClassName = "org.geekbang.thinking.in.spring.aop.overview.EchoService";
    // 获取当前线程 classLoader
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    // 获取目标类
    Class<?> targetClass = classLoader.loadClass(targetClassName);
    // 方法定义:string echo(string message)
    // spring 放射工具类
    Method targetMethod = ReflectionUtils.findMethod(targetClass, "echo", String.class);
    System.out.println(targetMethod);
    // 查询方法 throws 类型为nullPointerException
    ReflectionUtils.doWithMethods(
        targetClass,
        new MethodCallback() {
          @Override
          public void doWith(Method method)
              throws IllegalArgumentException, IllegalAccessException {
            System.out.println("仅抛出 NullPointerException 方法为：" + method);
          }
        },
        new MethodFilter() {
          @Override
          public boolean matches(Method method) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            return parameterTypes.length == 1
                && String.class.equals(parameterTypes[0])
                && exceptionTypes.length == 1
                && NullPointerException.class.equals(exceptionTypes[0]);
          }
        });
  }
}
