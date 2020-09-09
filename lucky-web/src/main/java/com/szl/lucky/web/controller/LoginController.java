package com.szl.lucky.web.controller;

import base.LuckyResult;
import com.szl.lucky.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 * 登录管理
 *
 * @author sunzhilin
 * @date 2020/3/25  9:54
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    //不做新用户注册设计，直接系统添加管理员，自动生成密码

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    public LuckyResult login(@RequestParam("userName") String userName,
                             @RequestParam("password") String password) {
        return loginService.login(userName, password);
    }

    private static List<String> getBetweenDate(LocalDate start, LocalDate end) {
        List<String> list = new ArrayList<>();
        long distance = ChronoUnit.DAYS.between(start, end);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(start, date -> date.plusDays(1)).limit(distance + 1).forEach(date -> list.add(date.toString()));
        return list;
    }

//    public static void main(String[] args) {
//        String ds = "fsdfs" + 2 +"fdsg";
//        LocalDate a = LocalDate.now();
//        LocalDate b = a.minusDays(7);
//        LocalDate c = a.minusDays(1);
//        List<String> list = getBetweenDate(b,c);
//        NumberFormat nf = NumberFormat.getPercentInstance();
//        nf.setMinimumFractionDigits(2);
//        String riseRatio = nf.format((double) 5 / 6 -1);
//        System.out.println(list);
//        System.out.println(riseRatio);
//    }

}
