package com.haoting.jbricks.interceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;

public class CounterInterceptor extends HandlerInterceptorAdapter {

    private static final String    REQ_PARAM_TIMING          = "timing";

    private static final Counter   REQUEST_TOTAL             = Counter.build().name("http_requests_total").labelNames("method",
                                                                                                                      "handler",
                                                                                                                      "status").help("Http Request Total").register();

    private static final Summary   RESPONSE_TIME_MS          = Summary.build().name("http_response_time_milliseconds_summary").labelNames("method",
                                                                                                                                          "handler",
                                                                                                                                          "status").help("Request completed time in milliseconds").register();

    private static final Histogram REQUEST_LATENCY_HISTOGRAM = Histogram.build().name("requests_latency_milliseconds_histogram").labelNames("method",
                                                                                                                                            "handler",
                                                                                                                                            "status").buckets(100,
                                                                                                                                                              200,
                                                                                                                                                              500,
                                                                                                                                                              1000,
                                                                                                                                                              2000,
                                                                                                                                                              5000,
                                                                                                                                                              10000).help("Request latency in seconds.").register();

    private static final Counter   CODE_SCALE_TOTAL          = Counter.build().name("response_code_total").labelNames("method",
                                                                                                                      "handler",
                                                                                                                      "code").help("Http Request Total").register();

    private static List<String>    codeList                  = new ArrayList<>(16);

    private Random                 random                    = new Random();
    static {
        codeList.add("0000");
        codeList.add("0001");
        codeList.add("0002");
        codeList.add("0003");
        codeList.add("0004");
        codeList.add("0005");
        codeList.add("0006");
        codeList.add("0007");
        codeList.add("0008");
        codeList.add("1111");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute(REQ_PARAM_TIMING, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        Thread.sleep(random.nextInt(10) * 100);

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception e) throws Exception {

        Long startTime = (Long) request.getAttribute(REQ_PARAM_TIMING);

        Long completeTime = System.currentTimeMillis() - startTime;

        System.out.println(completeTime);
        String handlerLabel = handler.toString();

        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            handlerLabel = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        }

        int i = random.nextInt(10);

        String code = codeList.get(i);

        REQUEST_TOTAL.labels(request.getMethod(), handlerLabel, Integer.toString(response.getStatus())).inc();

        CODE_SCALE_TOTAL.labels(request.getMethod(), handlerLabel, code).inc();

        RESPONSE_TIME_MS.labels(request.getMethod(), handlerLabel,
                                Integer.toString(response.getStatus())).observe(completeTime);

        REQUEST_LATENCY_HISTOGRAM.labels(request.getMethod(), handlerLabel,
                                         Integer.toString(response.getStatus())).observe(completeTime);
    }
}
