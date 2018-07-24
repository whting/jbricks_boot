package com.haoting.jbricks;

import com.haoting.jbricks.core.tkmybatis.IMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author haoting.wang
 * @Date 2018/7/11
 */
@SpringBootApplication
@MapperScan(basePackages = "com.haoting.jbricks.*.infrastructure.dao.mapper", markerInterface = IMapper.class)
public class AppMain {

  public static void main(String[] args) {
    SpringApplication.run(AppMain.class,args);
  }

}
