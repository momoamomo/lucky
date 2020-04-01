package com.szl.lucky.web.service;

import base.LuckyResult;

import javax.xml.transform.Result;

/**
 * @author sunzhilin
 * @date 2020/3/25  10:18
 */
public interface LoginService {
    LuckyResult login(String userName, String password);
}
