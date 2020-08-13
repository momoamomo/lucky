package com.szl.lucky.web.service;

import com.szl.lucky.dao.entity.SysUser;
import com.szl.lucky.web.dto.SysUserQueryReqDto;
import com.szl.lucky.web.dto.SysUserQueryRespDto;
import com.github.pagehelper.PageInfo;
import com.szl.lucky.web.dto.SysUserSaveDto;


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

    /**
     * 保存用户（新增，编辑）
     *
     * @param saveDto
     */
    void saveUser(SysUserSaveDto saveDto);
}
