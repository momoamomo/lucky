package com.szl.lucky.dao.mapper;

import com.szl.lucky.dao.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //以上为自动生成
    SysUser selectOne(SysUser record);

    /**
     * 根据条件查询sysUser
     *
     * @param userId
     * @param userName
     * @param userPhone
     * @return
     */
    List<SysUser> selectByConditon(String userId, String userName, String userPhone);

    /**
     * selectBySysUserId
     *
     * @param userId
     * @return
     */
    SysUser selectBySysUserId(@Param("userId") String userId);


    /**
     * selectByPhone
     *
     * @param userPhone
     * @return
     */
    SysUser selectByPhone(@Param("userPhone") String userPhone);

    /**
     * 查找最大的userId
     *
     * @return
     */
    String selectLastId();

}