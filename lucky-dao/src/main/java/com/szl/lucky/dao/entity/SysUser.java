package com.szl.lucky.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

    /**
     * 性别
     */
    private String sex;

    /**
     * 创建时间
     */
    private Date ct;

    /**
     * 更新时间
     */
    private Date mt;

    /**
     * true即1表示已删除，false即0表示未删除
     */
    private Boolean isDeleted;

    public SysUser(Long id, String userId, String userPhone, String userName, String password, String role, String sex, Date ct, Date mt, Boolean isDeleted) {
        this.id = id;
        this.userId = userId;
        this.userPhone = userPhone;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.sex = sex;
        this.ct = ct;
        this.mt = mt;
        this.isDeleted = isDeleted;
    }

    public SysUser() {

    }
}