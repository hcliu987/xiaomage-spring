package org.geekbang.thinking.in.spring.aop.features;

import org.geekbang.thinking.in.spring.aop.features.interceptor.EchoServiceMethodInterceptor;
import org.geekbang.thinking.in.spring.aop.features.pointcut.EchoServiceEchoMethodPointcut;
import org.geekbang.thinking.in.spring.aop.features.pointcut.EchoServicePointcut;
import org.geekbang.thinking.in.spring.aop.overview.DefaultEchoService;
import org.geekbang.thinking.in.spring.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class PointcutAPIDemo {

  public static void main(String[] args) {
    EchoServicePointcut echoServicePointcut = new EchoServicePointcut("echo", EchoService.class);
    ComposablePointcut pointcut = new ComposablePointcut(
        EchoServiceEchoMethodPointcut.INSTANCE);
    //组合实现
    pointcut.intersection(echoServicePointcut.getClassFilter());
    pointcut.intersection(echoServicePointcut.getMethodMatcher());
    //将 point 适配成Advice
    DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,
        new EchoServiceMethodInterceptor());

    DefaultEchoService defaultEchoService = new DefaultEchoService();
    ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
    //添加 advice
    proxyFactory.addAdvisor(advisor);
    //获取代理对象
    EchoService echoService = (EchoService) proxyFactory.getProxy();
    System.out.println(echoService.echo("hello,world"));
  }
}
