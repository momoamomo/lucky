package com.szl.lucky.web.service;

import com.szl.lucky.dao.entity.SysUser;
import com.szl.lucky.web.dto.SysUserQueryReqDto;
import com.szl.lucky.web.dto.SysUserQueryRespDto;
import com.github.pagehelper.PageInfo;


/**
 * @author sunzhilin
 * @date 2020/3/18  10:11
 */
public interface UserService {
    String test();

    /**
     * 系统用户查询
     *
     * @param reqDto 查询条件
     * @return 用户列表
     */
    PageInfo<SysUserQueryRespDto> getUsers(SysUserQueryReqDto reqDto);
}
