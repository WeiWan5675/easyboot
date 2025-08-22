package com.weiwan.box.module.iot.controller.admin.ota;

import com.weiwan.box.framework.common.pojo.CommonResult;
import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.common.util.object.BeanUtils;
import com.weiwan.box.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwarePageReqVO;
import com.weiwan.box.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwareRespVO;
import com.weiwan.box.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwareCreateReqVO;
import com.weiwan.box.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwareUpdateReqVO;
import com.weiwan.box.module.iot.dal.dataobject.ota.IotOtaFirmwareDO;
import com.weiwan.box.module.iot.service.ota.IotOtaFirmwareService;
import com.fhs.core.trans.anno.TransMethodResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.weiwan.box.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - IoT OTA 固件")
@RestController
@RequestMapping("/iot/ota-firmware")
@Validated
public class IotOtaFirmwareController {

    @Resource
    private IotOtaFirmwareService otaFirmwareService;

    @PostMapping("/create")
    @Operation(summary = "创建 OTA 固件")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:create')")
    public CommonResult<Long> createOtaFirmware(@Valid @RequestBody IotOtaFirmwareCreateReqVO createReqVO) {
        return success(otaFirmwareService.createOtaFirmware(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新 OTA 固件")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:update')")
    public CommonResult<Boolean> updateOtaFirmware(@Valid @RequestBody IotOtaFirmwareUpdateReqVO updateReqVO) {
        otaFirmwareService.updateOtaFirmware(updateReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得 OTA 固件")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:query')")
    @TransMethodResult
    public CommonResult<IotOtaFirmwareRespVO> getOtaFirmware(@RequestParam("id") Long id) {
        IotOtaFirmwareDO otaFirmware = otaFirmwareService.getOtaFirmware(id);
        return success(BeanUtils.toBean(otaFirmware, IotOtaFirmwareRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得 OTA 固件分页")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:query')")
    public CommonResult<PageResult<IotOtaFirmwareRespVO>> getOtaFirmwarePage(@Valid IotOtaFirmwarePageReqVO pageReqVO) {
        PageResult<IotOtaFirmwareDO> pageResult = otaFirmwareService.getOtaFirmwarePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotOtaFirmwareRespVO.class));
    }

}
