package org.geekbang.thinking.in.spring.aop.features;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.geekbang.thinking.in.spring.aop.features.aspect.AspectConfiguration;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJAnnotationUsingAPIDemo {

  public static void main(String[] args) {
    // 通过创建一个 HashMap 缓存 作为被代理对象
    HashMap<String, Object> cache = new HashMap<>();
    // 创建 proxy 工厂(Aspect)
    AspectJProxyFactory proxyFactory = new AspectJProxyFactory(cache);
    // 增加 Aspect 配置类
    proxyFactory.addAspect(AspectConfiguration.class);
    proxyFactory.addAspect(
        new MethodBeforeAdvice() {
          @Override
          public void before(Method method, Object[] objects, Object o) throws Throwable {
            if ("put".equals(method.getName()) && args.length == 2) {
              System.out.printf(
                  "[MethodBeforeAdvice] 当前存放的是key: $s , value: $s \n ", args[0], args[1]);
            }
          }
        });
    // 添加 AfterReturningAdvice
    proxyFactory.addAspect(
        new AfterReturningAdvice() {
          @Override
          public void afterReturning(Object returnValue, Method method, Object[] args,
              Object target)
              throws Throwable {
            if ("put".equals(method.getName()) && args.length == 2) {
              System.out.printf(
                  "[AfterReturningAdvice] 当前存放的是 key: %s 新存放的value ： %s ,之前关联的 value： %s \n",
                  args[0],
                  args[1],
                  returnValue);
            }
          }
        });
    //存储数据
    //cache.put("1","A")
    //通过代理对象存储数据
    Map<String, Object> proxy = proxyFactory.getProxy();
    proxy.put("1", "A");
    proxy.put("1", "B");
    System.out.println(cache.get("1"));
  }
}
