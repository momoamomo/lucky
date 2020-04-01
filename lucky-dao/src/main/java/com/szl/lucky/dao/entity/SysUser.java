package com.szl.lucky.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Long id;

    private String userId;

    private String userPhone;

    private String userName;

    private String password;

    private String role;

    private String sex;

    private Date ct;

    private Date mt;

    public SysUser(Long id, String userId, String userPhone, String userName, String password, String role, String sex, Date ct, Date mt) {
        this.id = id;
        this.userId = userId;
        this.userPhone = userPhone;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.sex = sex;
        this.ct = ct;
        this.mt = mt;
    }

    public SysUser(){

    }
}