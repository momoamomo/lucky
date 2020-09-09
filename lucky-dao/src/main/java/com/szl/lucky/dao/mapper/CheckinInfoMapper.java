package com.szl.lucky.dao.mapper;

import com.szl.lucky.dao.entity.CheckinInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CheckinInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckinInfo record);

    int insertSelective(CheckinInfo record);

    CheckinInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CheckinInfo record);

    int updateByPrimaryKey(CheckinInfo record);

    //以上为自动生成

    List<CheckinInfo> queryCheckinInfo(@Param("roomId") String roomId,
                                       @Param("customerName") String customerName,
                                       @Param("startTime") Date startTime,
                                       @Param("endTime") Date endTime);
}