package com.llicat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: lipan
 * @date: 2021/2/17 21:24
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success", produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return " 登录成功";
    }

    /*** 测试资源1 * @param session * @return */
    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session) {

        return  "访问资源1";
    }


    /*** 测试资源2 * @param session * @return */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session) {

        return  "访问资源2";
    }
}
