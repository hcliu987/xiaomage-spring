package org.geekbang.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 注解属性覆盖示例
 */
@MyComponentScan2(packages = "org.geekbang.thinking.in.spring.annotation")
public class AttributeOverridesDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    //注册 Configuration calss
    context.register(AttributeOverridesDemo.class);
    //启动 spring 上下文
    context.refresh();
    //依赖查找 TestClass Bean
    // TestClass 标注 @MyComponent2
    // @MyComponent2 <- @MyComponent <- @Component
    // 从 Spring 4.0 开始支持多层次 @Component "派生"

    TestClass testClass = context.getBean(TestClass.class);
    // Annotation -> AnnotationAttributes(Map)

    System.out.println(testClass);

    // 关闭 Spring 应用上下文
    context.close();
  }
}
