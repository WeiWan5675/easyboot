package com.weiwan.box.module.mp.convert.account;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.module.mp.controller.admin.account.vo.MpAccountCreateReqVO;
import com.weiwan.box.module.mp.controller.admin.account.vo.MpAccountRespVO;
import com.weiwan.box.module.mp.controller.admin.account.vo.MpAccountSimpleRespVO;
import com.weiwan.box.module.mp.controller.admin.account.vo.MpAccountUpdateReqVO;
import com.weiwan.box.module.mp.dal.dataobject.account.MpAccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MpAccountConvert {

    MpAccountConvert INSTANCE = Mappers.getMapper(MpAccountConvert.class);

    MpAccountDO convert(MpAccountCreateReqVO bean);

    MpAccountDO convert(MpAccountUpdateReqVO bean);

    MpAccountRespVO convert(MpAccountDO bean);

    List<MpAccountRespVO> convertList(List<MpAccountDO> list);

    PageResult<MpAccountRespVO> convertPage(PageResult<MpAccountDO> page);

    List<MpAccountSimpleRespVO> convertList02(List<MpAccountDO> list);

}
