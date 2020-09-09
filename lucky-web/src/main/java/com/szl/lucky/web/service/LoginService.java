package com.szl.lucky.web.service;

import base.LuckyResult;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.transform.Result;

/**
 * @author sunzhilin
 * @date 2020/3/25  10:18
 */
public interface LoginService {

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    LuckyResult login(String userName, String password);



}
