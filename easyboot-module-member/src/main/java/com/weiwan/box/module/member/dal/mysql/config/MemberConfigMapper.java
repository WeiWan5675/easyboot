package com.weiwan.box.module.member.dal.mysql.config;

import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.module.member.dal.dataobject.config.MemberConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分设置 Mapper
 *
 * @author QingX
 */
@Mapper
public interface MemberConfigMapper extends BaseMapperX<MemberConfigDO> {
}
