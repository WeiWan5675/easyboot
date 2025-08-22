package com.weiwan.box.module.pay.controller.admin.app.vo;

import com.weiwan.box.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiwan.box.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 支付应用信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayAppPageReqVO extends PageParam {

    @Schema(description = "应用名", example = "小豆")
    private String name;

    @Schema(description = "应用标识", example = "easyboot")
    private String appKey;

    @Schema(description = "开启状态", example = "0")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;

}
