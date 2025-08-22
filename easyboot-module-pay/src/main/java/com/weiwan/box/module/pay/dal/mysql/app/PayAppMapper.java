package com.weiwan.box.module.pay.dal.mysql.app;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.weiwan.box.module.pay.controller.admin.app.vo.PayAppPageReqVO;
import com.weiwan.box.module.pay.dal.dataobject.app.PayAppDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayAppMapper extends BaseMapperX<PayAppDO> {

    default PageResult<PayAppDO> selectPage(PayAppPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PayAppDO>()
                .likeIfPresent(PayAppDO::getName, reqVO.getName())
                .likeIfPresent(PayAppDO::getAppKey, reqVO.getAppKey())
                .eqIfPresent(PayAppDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PayAppDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PayAppDO::getId));
    }

    default PayAppDO selectByAppKey(String appKey) {
        return selectOne(PayAppDO::getAppKey, appKey);
    }

}
