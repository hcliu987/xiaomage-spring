package org.geekbang.thinking.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * 最终执行后置拦截器
 */
public interface FinallyInterceptor {

  Object finalize(Object proxy, Method method, Object[] args, Object returnResult);
}
