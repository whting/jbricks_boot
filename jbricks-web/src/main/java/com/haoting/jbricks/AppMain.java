package com.haoting.jbricks;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.haoting.jbricks.core.tkmybatis.IMapper;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author haoting.wang
 * @Date 2018/7/11
 */
@SpringBootApplication
@MapperScan(basePackages = "com.haoting.jbricks.*.infrastructure.dao.mapper", markerInterface = IMapper.class)
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class AppMain{

  public static void main(String[] args) {
    SpringApplication.run(AppMain.class,args);
  }
}
