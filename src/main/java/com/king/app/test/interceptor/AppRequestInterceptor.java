package com.king.app.test.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppRequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(AppRequestInterceptor.class);

    private String mode = "prd";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        logger.info("ip:" + request.getRemoteAddr() + ",mode:" + mode + ",url:" + request.getRequestURI());

        Object target = null;
        if (handler instanceof HandlerMethod) {
            target = ((HandlerMethod) handler).getBean();
        } else {
            logger.info("非法url:" + request.getRequestURI());
            return false;
        }
        String apiName = target.getClass().getSimpleName();
        logger.info("请求的类名：" + apiName);

        return true;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
