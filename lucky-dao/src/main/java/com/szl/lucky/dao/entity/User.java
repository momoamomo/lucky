package com.szl.lucky.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private Long userId;

    private String userPhone;

    private String userName;

    private String password;

    private String sex;

    private Date ct;

    private Date mt;

    public User(Long id, Long userId, String userPhone, String userName, String password, String sex, Date ct, Date mt) {
        this.id = id;
        this.userId = userId;
        this.userPhone = userPhone;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.ct = ct;
        this.mt = mt;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public Date getCt() {
        return ct;
    }

    public Date getMt() {
        return mt;
    }
}