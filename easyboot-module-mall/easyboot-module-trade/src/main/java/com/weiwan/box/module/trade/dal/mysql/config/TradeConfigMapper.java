package com.weiwan.box.module.trade.dal.mysql.config;

import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.module.trade.dal.dataobject.config.TradeConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 交易中心配置 Mapper
 *
 * @author owen
 */
@Mapper
public interface TradeConfigMapper extends BaseMapperX<TradeConfigDO> {

}
