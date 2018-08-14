package com.haoting.jbricks.config;

import java.text.SimpleDateFormat;
import java.util.List;

import com.haoting.jbricks.interceptor.CounterInterceptor;
import com.haoting.jbricks.interceptor.RequestCounterInterceptor;
import com.haoting.jbricks.interceptor.RequestTimingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.haoting.jbricks.core.filter.LogFilter;

/**
 * Created by libinsong on 2017/4/19.
 */
@Configuration
public class WebConfig2 extends WebMvcConfigurerAdapter {

    /**
     * 请求中的参数绑定
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
    }

    /**
     *  <mvc:interceptor>
     *             <mvc:mapping path="/**"/>
     *             <mvc:exclude-mapping path="/error/**"/>
     *             <mvc:exclude-mapping path="/vehicle/get_vehicle_detection"/>
     *             <bean class="cn.jbricks.toolkit.web.rest.interceptors.RestInterceptor"></bean>
     *         </mvc:interceptor>
     *     </mvc:interceptors>
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        RequestCounterInterceptor counterInterceptor = new RequestCounterInterceptor();
        CounterInterceptor interceptor = new CounterInterceptor();
     //   RequestTimingInterceptor timingInterceptor = new RequestTimingInterceptor();
        registry.addInterceptor(interceptor);
    //    registry.addInterceptor(timingInterceptor);
        super.addInterceptors(registry);
    }
}
