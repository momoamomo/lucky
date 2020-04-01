package com.szl.lucky.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CheckinInfo {
    private Long id;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 入住人姓名
     */
    private String customerName;

    /**
     * 是否为会员
     */
    private String isVip;

    /**
     * 性别
     */
    private String gender;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 押金
     */
    private Integer deposit;

    /**
     * 入住时间
     */
    private Date checkinTime;

    public CheckinInfo(Long id, String roomId, String customerName, String isVip, String gender, String idcard, String phone, Integer deposit, Date checkinTime) {
        this.id = id;
        this.roomId = roomId;
        this.customerName = customerName;
        this.isVip = isVip;
        this.gender = gender;
        this.idcard = idcard;
        this.phone = phone;
        this.deposit = deposit;
        this.checkinTime = checkinTime;
    }
}