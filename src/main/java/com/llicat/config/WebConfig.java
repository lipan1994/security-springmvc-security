package com.llicat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author: lipan
 * @date: 2021/2/16 20:31
 * WebMvcConfigurer 此接口用来增加一些自定义的handler、interceptor、ViewReslover等，多用于springboot下的客户化
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.llicat")
public class WebConfig implements WebMvcConfigurer {




    //添加视图解析器
    @Bean
    public InternalResourceViewResolver resourceViewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;

    }

    /**
     * 访问根路径重定向到/login资源 由springSecurity提供
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }



}
