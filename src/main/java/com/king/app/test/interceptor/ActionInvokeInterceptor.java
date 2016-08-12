package com.king.app.test.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * 类名称: ActionInvokeInterceptor <br>
 * 类描述: <br>
 *
 * @author: hua.jin
 * @since: 16/8/11 下午5:29
 * @version: 1.0.0
 */
public class ActionInvokeInterceptor implements MethodInterceptor {

    private Logger LOGGER = Logger.getLogger(ActionInvokeInterceptor.class);

    private static final String _appname = "app";

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        Method method = methodInvocation.getMethod();
        String methodName = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        Object[] arguments = methodInvocation.getArguments();
        Object result = method.getReturnType().newInstance();
        try {
            LOGGER.info("[" + _appname + "] - [" + methodName + "]");
            result = methodInvocation.proceed();
        } finally {
            long time = (System.currentTimeMillis() - startTime);
            LOGGER.info("[" + _appname + "] - [执行时间] - [" + methodName + "] - 耗时[" + time + "]毫秒");
        }
        LOGGER.info("[" + _appname + "] - [返回结果] - [" + methodName + "] - " + "result");
        return result;
    }

}
