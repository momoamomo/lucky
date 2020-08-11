package com.szl.lucky.web.dto;

import lombok.Data;

/**
 * 系统用户查询入参dto
 *
 * @author sunzhilin
 * @date 2020/8/11  10:57
 */
@Data
public class SysUserQueryReqDto {
    private String userId;

    private String userPhone;

    private String userName;

    private Integer pageNum;

    private Integer pageSize;
}
