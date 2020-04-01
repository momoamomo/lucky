package com.szl.lucky.dao.entity;

import lombok.Data;

@Data
public class RoomType {
    private Integer id;

    private String roomTypeName;

    private Integer roomPrice;

    public RoomType(Integer id, String roomTypeName, Integer roomPrice) {
        this.id = id;
        this.roomTypeName = roomTypeName;
        this.roomPrice = roomPrice;
    }
}