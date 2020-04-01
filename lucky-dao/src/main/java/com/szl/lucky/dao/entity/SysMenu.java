package com.szl.lucky.dao.entity;

import lombok.Data;

@Data
public class SysMenu {
    private Long id;

    private Long menuId;

    private String menuName;

    private String menuUrl;

    private Long parentId;

    public SysMenu(Long id, Long menuId, String menuName, String menuUrl, Long parentId) {
        this.id = id;
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
    }
}