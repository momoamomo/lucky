package com.szl.lucky.web.controller;

import base.LuckyResult;
import com.szl.lucky.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author sunzhilin
 * @date 2020/3/25  9:54
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/register")
    public LuckyResult register(@RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam("rePassword") String rePassword){
        return LuckyResult.ok();

    }
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    public LuckyResult login(@RequestParam("userName") String userName,
                             @RequestParam("password") String password) {
        return loginService.login(userName, password);
    }

}
