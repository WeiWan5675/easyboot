package com.weiwan.box.module.iot.controller.admin.device;

import com.weiwan.box.framework.common.pojo.CommonResult;
import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.common.util.object.BeanUtils;
import com.weiwan.box.module.iot.controller.admin.device.vo.data.IotDeviceLogPageReqVO;
import com.weiwan.box.module.iot.controller.admin.device.vo.data.IotDeviceLogRespVO;
import com.weiwan.box.module.iot.dal.dataobject.device.IotDeviceLogDO;
import com.weiwan.box.module.iot.service.device.data.IotDeviceLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.weiwan.box.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - IoT 设备日志")
@RestController
@RequestMapping("/iot/device/log")
@Validated
public class IotDeviceLogController {

    @Resource
    private IotDeviceLogService deviceLogService;

    @GetMapping("/page")
    @Operation(summary = "获得设备日志分页")
    @PreAuthorize("@ss.hasPermission('iot:device:log-query')")
    public CommonResult<PageResult<IotDeviceLogRespVO>> getDeviceLogPage(@Valid IotDeviceLogPageReqVO pageReqVO) {
        PageResult<IotDeviceLogDO> pageResult = deviceLogService.getDeviceLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotDeviceLogRespVO.class));
    }

}