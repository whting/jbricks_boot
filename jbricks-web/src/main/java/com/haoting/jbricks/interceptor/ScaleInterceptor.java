package com.haoting.jbricks.interceptor;

import io.prometheus.client.Counter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author haoting.wang
 * @Date 2018/8/6
 */
public class ScaleInterceptor extends HandlerInterceptorAdapter {

    private static final String  REQ_PARAM_TIMING = "timing";

    private static final Counter REQUEST_TOTAL    = Counter.build().name("http_requests_total").labelNames("method",
            "handler",
            "status").help("Http Request Total").register();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute(REQ_PARAM_TIMING, System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception e) throws Exception {

        String handlerLabel = handler.toString();

        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            handlerLabel = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        }
        REQUEST_TOTAL.labels(request.getMethod(), handlerLabel, Integer.toString(response.getStatus())).inc();

    }
}
