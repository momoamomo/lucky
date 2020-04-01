package com.szl.lucky.dao.entity;

import lombok.Data;

@Data
public class Room {
    private Long id;

    private String roomId;

    private String roomStatus;

    private Long roomTypeId;

    public Room(Long id, String roomId, String roomStatus, Long roomTypeId) {
        this.id = id;
        this.roomId = roomId;
        this.roomStatus = roomStatus;
        this.roomTypeId = roomTypeId;
    }
}