package com.weiwan.box.module.erp.dal.mysql.stock;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.module.erp.controller.admin.stock.vo.warehouse.ErpWarehousePageReqVO;
import com.weiwan.box.module.erp.dal.dataobject.stock.ErpWarehouseDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 仓库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ErpWarehouseMapper extends BaseMapperX<ErpWarehouseDO> {

    default PageResult<ErpWarehouseDO> selectPage(ErpWarehousePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpWarehouseDO>()
                .likeIfPresent(ErpWarehouseDO::getName, reqVO.getName())
                .eqIfPresent(ErpWarehouseDO::getStatus, reqVO.getStatus())
                .orderByDesc(ErpWarehouseDO::getId));
    }

    default ErpWarehouseDO selectByDefaultStatus() {
        return selectOne(ErpWarehouseDO::getDefaultStatus, true);
    }

    default List<ErpWarehouseDO> selectListByStatus(Integer status) {
        return selectList(ErpWarehouseDO::getStatus, status);
    }

}