package com.llicat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author: lipan
 * @date: 2021/2/17 20:45
 */
@EnableWebSecurity
public class WebSecurityConfig   extends WebSecurityConfigurerAdapter {


    /**
     * 定义用户信息
     * @return
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        userDetailsManager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return userDetailsManager;
    }

    /**
     * 密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //配置安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //访问 /r/**资源需要登录认证，其他资源放开，允许表单登录，登录成功跳转/login-success
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")
                .antMatchers("/r/r2").hasAnyAuthority("p2")
                .antMatchers("/r/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .successForwardUrl("/login-success");
    }
}

