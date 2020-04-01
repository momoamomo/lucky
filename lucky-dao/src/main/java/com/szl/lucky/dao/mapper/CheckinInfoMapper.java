package com.szl.lucky.dao.mapper;

import com.szl.lucky.dao.entity.CheckinInfo;

public interface CheckinInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckinInfo record);

    int insertSelective(CheckinInfo record);

    CheckinInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CheckinInfo record);

    int updateByPrimaryKey(CheckinInfo record);
}