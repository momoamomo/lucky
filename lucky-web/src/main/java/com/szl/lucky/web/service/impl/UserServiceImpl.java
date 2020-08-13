package com.szl.lucky.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szl.lucky.dao.entity.SysUser;
import com.szl.lucky.dao.entity.User;
import com.szl.lucky.dao.mapper.SysUserMapper;
import com.szl.lucky.dao.mapper.UserMapper;
import com.szl.lucky.web.dto.SysUserQueryReqDto;
import com.szl.lucky.web.dto.SysUserQueryRespDto;
import com.szl.lucky.web.dto.SysUserSaveDto;
import com.szl.lucky.web.enums.LuckyWebErrorEnum;
import com.szl.lucky.web.service.UserService;
import exception.LuckyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.BaseChecker;
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

    /**
     * 保存用户（新增，编辑）
     *
     * @param saveDto
     */
    @Override
    public void saveUser(SysUserSaveDto saveDto) {
        BaseChecker.checkNotNull(saveDto.getUserPhone(),"userPhone");
        BaseChecker.checkNotNull(saveDto.getUserName(),"userName");
        BaseChecker.checkNotNull(saveDto.getRole(),"role");
        BaseChecker.checkNotNull(saveDto.getSex(),"sex");
        //TODO:还没完成
        if(saveDto.getUserId()!=null){
            SysUser sysUser = sysUserMapper.selectBySysUserId(saveDto.getUserId());
            if(!sysUser.getUserPhone().equals(saveDto.getUserPhone())){
                if(sysUserMapper.selectByPhone(saveDto.getUserPhone())!=null){
                    throw new LuckyException(LuckyWebErrorEnum.USER_EXSIST);
                }
            }
        }else {
            SysUser sysUser = sysUserMapper.selectByPhone(saveDto.getUserPhone());
            if(sysUser != null){
                throw new LuckyException(LuckyWebErrorEnum.USER_EXSIST);
            }
        }
        //
        SysUser sysUser = new SysUser();
        sysUser.setUserName(saveDto.getUserName());
        sysUser.setUserPhone(saveDto.getUserPhone());
        sysUser.setRole(saveDto.getRole());
        sysUser.setSex(saveDto.getSex());
        if(saveDto.getUserId()!=null){
            //编辑更新
            sysUser.setUserId(saveDto.getUserId());
            sysUserMapper.updateByPrimaryKeySelective(sysUser);
        }else {
            //新增
            //TODO:(密码暂时还没加密)
            sysUser.setPassword(saveDto.getPassword());
            Long userId = Long.valueOf(sysUserMapper.selectLastId())+1;
            sysUser.setUserId(userId.toString());
            sysUserMapper.insert(sysUser);
            //ToDO：发送短信
        }


    }
}
