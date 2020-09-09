package com.szl.lucky.web.controller;

import base.LuckyResult;
import com.szl.lucky.dao.annotation.NotBlank;
import com.szl.lucky.web.dto.CheckinInfoReqDto;
import com.szl.lucky.web.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 入住管理
 *
 * @author sunzhilin
 * @date 2020/8/11  10:18
 */
@RestController
@RequestMapping("/chenckin")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    //办理入住
    //入住信息查询
    //消费记录
    //结账退房
    //查询空房

    /**
     * 查询所有的空闲房间
     *
     * @return
     */
    @PostMapping("/getFreeRoom")
    public LuckyResult getFreeRoom() {
        return checkInService.getFreeRooms();
    }

    /**
     * 入住信息查询
     *
     * @param checkinInfoReqDto
     * @return
     */
    @PostMapping("/getCheckinInfo")
    public LuckyResult getCheckinInfo(@NotBlank CheckinInfoReqDto checkinInfoReqDto) {
        return checkInService.getCheckinInfo(checkinInfoReqDto);
    }
}
