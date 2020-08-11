package com.szl.lucky.web.service.impl;

        import base.LuckyResult;
        import com.szl.lucky.dao.entity.SysUser;
        import com.szl.lucky.dao.mapper.SysUserMapper;
        import com.szl.lucky.web.enums.ErrorTextEnum;
        import com.szl.lucky.web.service.LoginService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

/**
 * @author sunzhilin
 * @date 2020/3/25  10:19
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    public LuckyResult login(String userName, String password) {
        SysUser sysUser = getSysUserInfo(userName);
        if(sysUser == null){
            return LuckyResult.businessError(ErrorTextEnum.userNotExits.text);
        }
        if(!password.equals(sysUser.getPassword())){
            return LuckyResult.businessError(ErrorTextEnum.passwordFalse.text);
        }
        return LuckyResult.ok();
    }

    /**
     * 获取当前用户信息
     * @param userName
     * @return
     */
    private SysUser getSysUserInfo(String userName){
        SysUser user = new SysUser();
        user.setUserName(userName);
        return sysUserMapper.selectOne(user);
    }
}
