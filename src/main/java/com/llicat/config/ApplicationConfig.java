package com.llicat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置spring容器(spring-service.xml、spring-dao.xml)
 * @author: lipan
 * @date: 2021/2/16 20:17
 */
@Configuration
@ComponentScan(basePackages = "com.llicat")
public class ApplicationConfig {


}
