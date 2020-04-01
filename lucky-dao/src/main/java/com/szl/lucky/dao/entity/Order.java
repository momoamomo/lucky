package com.szl.lucky.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Long id;

    private String orderId;

    private String roomId;

    private Integer orderPrice;

    private String orderStatus;

    private Date orderTime;

    public Order(Long id, String orderId, String roomId, Integer orderPrice, String orderStatus, Date orderTime) {
        this.id = id;
        this.orderId = orderId;
        this.roomId = roomId;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }
}