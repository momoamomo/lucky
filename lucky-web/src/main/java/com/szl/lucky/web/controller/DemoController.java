package com.szl.lucky.web.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.szl.lucky.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunzhilin
 * @date 2019/12/21  22:29
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    UserService userService;

    @NacosValue(value = "${tvName:hahaha}", autoRefreshed = true)
    private String tvName;

    @GetMapping("/test")
    public String test(){
//        String result = userService.test();
//        System.out.println(result);
////        return demoService.test();
        String result = tvName;
        System.out.println(result);
        return result;
    }


}
