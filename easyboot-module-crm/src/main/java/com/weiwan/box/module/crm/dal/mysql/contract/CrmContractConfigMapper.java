package com.weiwan.box.module.crm.dal.mysql.contract;

import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.framework.mybatis.core.query.QueryWrapperX;
import com.weiwan.box.module.crm.dal.dataobject.contract.CrmContractConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 合同配置 Mapper
 *
 * @author Wanwan
 */
@Mapper
public interface CrmContractConfigMapper extends BaseMapperX<CrmContractConfigDO> {

    default CrmContractConfigDO selectOne() {
        return selectOne(new QueryWrapperX<CrmContractConfigDO>().limitN(1));
    }

}