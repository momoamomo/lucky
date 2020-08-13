package com.szl.lucky.web.dto;

import lombok.Data;

/**
 * 系统用户保存dto(新增，编辑)
 *
 * @author sunzhilin
 * @date 2020/8/12  11:13
 */
@Data
public class SysUserSaveDto {
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
}
