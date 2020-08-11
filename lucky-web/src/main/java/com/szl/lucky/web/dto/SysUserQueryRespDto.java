package com.szl.lucky.web.dto;

import lombok.Data;

/**
 * 系统用户查询响应结果
 *
 * @author sunzhilin
 * @date 2020/8/11  11:09
 */
@Data
public class SysUserQueryRespDto {
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
     * 角色
     */
    private String role;

    /**
     * 性别
     */
    private String sex;
}
