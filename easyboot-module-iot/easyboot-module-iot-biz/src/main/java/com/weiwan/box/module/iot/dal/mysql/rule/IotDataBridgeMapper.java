package com.weiwan.box.module.iot.dal.mysql.rule;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.weiwan.box.module.iot.controller.admin.rule.vo.databridge.IotDataBridgePageReqVO;
import com.weiwan.box.module.iot.dal.dataobject.rule.IotDataBridgeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * IoT 数据桥梁 Mapper
 *
 * @author HUIHUI
 */
@Mapper
public interface IotDataBridgeMapper extends BaseMapperX<IotDataBridgeDO> {

    default PageResult<IotDataBridgeDO> selectPage(IotDataBridgePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IotDataBridgeDO>()
                .likeIfPresent(IotDataBridgeDO::getName, reqVO.getName())
                .eqIfPresent(IotDataBridgeDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(IotDataBridgeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(IotDataBridgeDO::getId));
    }

}