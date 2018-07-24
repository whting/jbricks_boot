package com.haoting.jbricks.core.support;

import com.haoting.jbricks.core.util.spring.SpringContextUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/****************************************
 * @@CREATE : 2018-02-01 下午10:46
 * @@AUTH : NOT A CAT【NOTACAT@CAT.ORZ】
 * @@DESCRIPTION : 通用组件注入
 * @@VERSION :
 *
 *****************************************/
@Configuration
public class SupportConfig {


    @Bean(name = "springContextUtil")
    public SpringContextUtil SpringContextUtil() {
        SpringContextUtil springContextUtil = new SpringContextUtil();
        return springContextUtil;
    }





}
