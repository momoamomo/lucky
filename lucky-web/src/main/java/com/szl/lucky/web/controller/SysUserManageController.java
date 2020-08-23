package com.szl.lucky.web.controller;

import base.LuckyResult;
import com.github.pagehelper.PageInfo;
import com.szl.lucky.web.dto.SysUserQueryReqDto;
import com.szl.lucky.web.dto.SysUserQueryRespDto;
import com.szl.lucky.web.dto.SysUserSaveDto;
import com.szl.lucky.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户管理
 *
 * @author sunzhilin
 * @date 2020/8/11  10:30
 */
@RestController
@RequestMapping("/auth/user")
public class SysUserManageController {

    @Autowired
    private UserService userService;

    //查询
    //保存（新增、编辑）
    //删除
    //重置密码

    /**
     * 查询系统用户信息
     *
     * @param sysUserQueryReqDto
     * @return
     */
    @PostMapping(value = "/page")
    public LuckyResult querySysUserInfo(SysUserQueryReqDto sysUserQueryReqDto) {
        PageInfo<SysUserQueryRespDto> users = userService.getUsers(sysUserQueryReqDto);
        return LuckyResult.ok(users);
    }

    /**
     * 保存用户（新增，更新）
     * @param saveDto
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public LuckyResult saveSysUser(SysUserSaveDto saveDto) {
        userService.saveUser(saveDto);
        return LuckyResult.ok();
    }

    /**
     * 删除用户
     * @param reqDto
     * @return
     */
    @PostMapping(value = "/delete")
    public LuckyResult deleteSysUser(SysUserQueryReqDto reqDto) {
        userService.deleteUser(reqDto);
        return LuckyResult.ok();
    }

    /**
     * 重置密码
     * @param reqDto
     * @return
     */
    @PostMapping(value = "/reset")
    public LuckyResult resetPassword(SysUserQueryReqDto reqDto) {
        userService.resetPassword(reqDto);
        return LuckyResult.ok();
    }


}
