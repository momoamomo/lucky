package com.szl.lucky.web.service.impl;

import base.LuckyResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szl.lucky.dao.entity.CheckinInfo;
import com.szl.lucky.dao.entity.Room;
import com.szl.lucky.dao.mapper.CheckinInfoMapper;
import com.szl.lucky.dao.mapper.RoomMapper;
import com.szl.lucky.web.dto.CheckinInfoReqDto;
import com.szl.lucky.web.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入住管理Impl
 *
 * @author sunzhilin
 * @date 2020/9/9  14:43
 */
@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private CheckinInfoMapper checkinInfoMapper;

    /**
     * 查询所有的空闲房间
     *
     * @return
     */
    @Override
    public LuckyResult getFreeRooms() {
        List<Room> list = roomMapper.selectFreeRooms();
        return LuckyResult.ok(list);
    }

    /**
     * 入住信息查询
     *
     * @param reqDto
     * @return
     */
    @Override
    public LuckyResult getCheckinInfo(CheckinInfoReqDto reqDto) {
        PageHelper.startPage(reqDto.getCurrent(),reqDto.getSize());
        List<CheckinInfo> checkinInfos = checkinInfoMapper.queryCheckinInfo(reqDto.getRoomId(),
                reqDto.getCustomerName(), reqDto.getStartTime(), reqDto.getEndTime());
        PageInfo pageInfo = new PageInfo(checkinInfos);
        return LuckyResult.ok(pageInfo);
    }


}
