package com.haoting.jbricks.interceptor;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Random;

public class RequestCounterInterceptor extends HandlerInterceptorAdapter {
//
//    private Random               random           = new Random();
//
//    private static final String  REQ_PARAM_TIMING = "timing";
//    // @formatter:off
//    // Note (1)
//    private static final Counter requestTotal     = Counter.build().name("http_requests_total").labelNames("method",
//                                                                                                           "handler",
//                                                                                                           "status").help("Http Request Total").register();
//
//    private static final Gauge   gauge            = Gauge.build().name("gauge_test").labelNames("method").help("gauge_test_help").register();
//
//    static final Histogram       requestLatency   = Histogram.build().name("requests_latency_seconds").buckets(0.1,0.2,0.5,1,2,5,10).help("Request latency in seconds.").register();
//
//    private static final Summary responseTimeInMs = Summary.build().name("http_response_time_milliseconds").labelNames("method",
//                                                                                                                       "handler",
//                                                                                                                       "status").help("Request completed time in milliseconds").register();
//
//    private static final Counter resultCode       = Counter.build().name("result_code").labelNames("method", "handler",
//                                                                                                  "code").help("result code").register();
//
//    Histogram.Timer requestTimer;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//                             Object handler) throws Exception {
//        // Note (2)
//        request.setAttribute(REQ_PARAM_TIMING, System.currentTimeMillis());
//        requestTimer = requestLatency.startTimer();
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
//                                Exception e) throws Exception {
//
//        gauge.labels("get").inc();
//
//        Long timingAttr = (Long) request.getAttribute(REQ_PARAM_TIMING);
//        long completedTime = System.currentTimeMillis() - timingAttr;
//
//        // Update counters
//        String handlerLabel = handler.toString();
//        // get short form of handler method name
//        if (handler instanceof HandlerMethod) {
//            Method method = ((HandlerMethod) handler).getMethod();
//            handlerLabel = method.getDeclaringClass().getSimpleName() + "." + method.getName();
//        }
//        // Note (2)
//        requestTotal.labels(request.getMethod(), handlerLabel, Integer.toString(response.getStatus())).inc();
//
//        int randomInt = random.nextInt(10);
//        if (randomInt % 2 == 0) {
//            gauge.labels("get").dec();
//        }
//        requestTimer.observeDuration();
//        responseTimeInMs.labels(request.getMethod(), handlerLabel,
//                                Integer.toString(response.getStatus())).observe(completedTime);
//
//        Thread.sleep(1000-randomInt*100);
//        resultCode.labels(request.getMethod(), handlerLabel,randomInt+"").inc();
//    }
}
