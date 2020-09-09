package com.szl.lucky.web.dto;

import com.szl.lucky.dao.annotation.NotBlank;
import lombok.Data;

import java.util.Date;

/**
 * 入住信息查询实体类
 *
 * @author sunzhilin
 * @date 2020/9/9  16:27
 */
@Data
public class CheckinInfoReqDto {
    /**
     * 分页信息，当前页
     */
    @NotBlank
    private Integer current;

    /**
     * 分页信息，每页数量
     */
    @NotBlank
    private Integer size;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 起始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
}
