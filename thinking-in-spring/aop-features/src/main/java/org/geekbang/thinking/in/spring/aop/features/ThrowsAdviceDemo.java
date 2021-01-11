package org.geekbang.thinking.in.spring.aop.features;

import java.util.Random;
import org.springframework.aop.framework.ProxyFactory;

public class ThrowsAdviceDemo {

  public static void main(String[] args) {
    ThrowsAdviceDemo instance = new ThrowsAdviceDemo();
    ProxyFactory proxyFactory = new ProxyFactory(instance);
    proxyFactory.addAdvice(new MyThrowsAdvice());
    ThrowsAdviceDemo proxy = (ThrowsAdviceDemo) proxyFactory.getProxy();
    proxy.execute();
    proxy.execute();
  }

  public void execute() {
    Random random = new Random();
    if (random.nextBoolean()) {
      throw new RuntimeException("For Furpose");
    }
    System.out.println("Exceuting....");
  }
}
