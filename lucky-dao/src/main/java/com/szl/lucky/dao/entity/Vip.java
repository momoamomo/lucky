package com.szl.lucky.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Vip {
    private Long id;

    private String vipId;

    private Float vipDiscount;

    private String idcard;

    private Date dealTime;

    public Vip(Long id, String vipId, Float vipDiscount, String idcard, Date dealTime) {
        this.id = id;
        this.vipId = vipId;
        this.vipDiscount = vipDiscount;
        this.idcard = idcard;
        this.dealTime = dealTime;
    }
}