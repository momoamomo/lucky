package com.szl.lucky.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szl.lucky.dao.entity.SysUser;
import com.szl.lucky.dao.entity.User;
import com.szl.lucky.dao.mapper.SysUserMapper;
import com.szl.lucky.dao.mapper.UserMapper;
import com.szl.lucky.web.dto.SysUserQueryReqDto;
import com.szl.lucky.web.dto.SysUserQueryRespDto;
import com.szl.lucky.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageInfoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunzhilin
 * @date 2020/3/18  10:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public String test() {
        User user = userMapper.selectByPrimaryKey(1L);
        String name = user.getUserName();
        return name;
    }

    /**
     * 系统用户查询
     *
     * @param reqDto 查询条件
     * @return
     */
    @Override
    public PageInfo<SysUserQueryRespDto> getUsers(SysUserQueryReqDto reqDto){
        PageHelper.startPage(reqDto.getPageNum(),reqDto.getPageSize());
        List<SysUser> sysUsers = sysUserMapper.selectByConditon(reqDto.getUserId(),reqDto.getUserName(),reqDto.getUserPhone());
        List<SysUserQueryRespDto> userQueryRespDtos = new ArrayList<>(sysUsers.size());
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        for(SysUser user: sysUsers){
            SysUserQueryRespDto respDto = new SysUserQueryRespDto();
            BeanUtils.copyProperties(user,respDto);
            userQueryRespDtos.add(respDto);
        }
        return PageInfoUtil.changeList(pageInfo, userQueryRespDtos);
    }
}
