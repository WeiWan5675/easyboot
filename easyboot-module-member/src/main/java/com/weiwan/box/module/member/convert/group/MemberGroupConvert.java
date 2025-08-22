package com.weiwan.box.module.member.convert.group;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.module.member.controller.admin.group.vo.MemberGroupCreateReqVO;
import com.weiwan.box.module.member.controller.admin.group.vo.MemberGroupRespVO;
import com.weiwan.box.module.member.controller.admin.group.vo.MemberGroupSimpleRespVO;
import com.weiwan.box.module.member.controller.admin.group.vo.MemberGroupUpdateReqVO;
import com.weiwan.box.module.member.dal.dataobject.group.MemberGroupDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户分组 Convert
 *
 * @author owen
 */
@Mapper
public interface MemberGroupConvert {

    MemberGroupConvert INSTANCE = Mappers.getMapper(MemberGroupConvert.class);

    MemberGroupDO convert(MemberGroupCreateReqVO bean);

    MemberGroupDO convert(MemberGroupUpdateReqVO bean);

    MemberGroupRespVO convert(MemberGroupDO bean);

    List<MemberGroupRespVO> convertList(List<MemberGroupDO> list);

    PageResult<MemberGroupRespVO> convertPage(PageResult<MemberGroupDO> page);

    List<MemberGroupSimpleRespVO> convertSimpleList(List<MemberGroupDO> list);
}
