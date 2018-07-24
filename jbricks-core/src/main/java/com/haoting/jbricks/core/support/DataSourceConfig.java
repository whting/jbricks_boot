package com.haoting.jbricks.core.support;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author haoting.wang
 * @Date 2018/7/11
 */
@Configuration
public class DataSourceConfig {


	@Autowired
	private Environment env;

	@Bean(name = "dataSource", initMethod = "init",destroyMethod="close")
	@ConfigurationProperties(prefix="spring.datasource.druid.primary")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}


	/**
	 * {@link StatViewServlet}
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		reg.addInitParameter("resetEnable", "false");
		reg.addInitParameter("loginUsername", "kraken");
		reg.addInitParameter("loginPassword", "krakenAdmin");
		return reg;
	}

	/**
	 * {@link WebStatFilter}
	 *
	 * @return
	 */
	@Bean
	public FilterRegistrationBean druidWebStatFilterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "/druid/*,*.ico,/error");
		return filterRegistrationBean;
	}
}
