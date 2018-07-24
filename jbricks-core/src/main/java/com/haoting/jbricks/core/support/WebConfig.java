package com.haoting.jbricks.core.support;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.haoting.jbricks.core.filter.LogFilter;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by libinsong on 2017/4/19.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${filter.slow.reqmillis:3000}")
    private String slowReqMillis;


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }


    /**
     * {@link LogFilter}
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean logFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "/druid/*,*.ico,/error");
        filterRegistrationBean.addInitParameter("slowReqMillis", slowReqMillis);
        return filterRegistrationBean;
    }


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
        super.addInterceptors(registry);
    }
}
