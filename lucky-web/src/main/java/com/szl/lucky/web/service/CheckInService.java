package com.szl.lucky.web.service;

import base.LuckyResult;
import com.szl.lucky.web.dto.CheckinInfoReqDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author sunzhilin
 * @date 2020/9/9  14:42
 */
public interface CheckInService {

    /**
     * 查询所有的空闲房间
     *
     * @return
     */
    LuckyResult getFreeRooms();

    /**
     * 入住信息查询
     *
     * @param checkinInfoReqDto
     * @return
     */
    LuckyResult getCheckinInfo(CheckinInfoReqDto checkinInfoReqDto);
}
