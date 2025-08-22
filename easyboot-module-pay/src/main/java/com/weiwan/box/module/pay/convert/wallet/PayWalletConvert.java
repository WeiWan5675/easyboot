package com.weiwan.box.module.pay.convert.wallet;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.module.pay.controller.admin.wallet.vo.wallet.PayWalletRespVO;
import com.weiwan.box.module.pay.controller.app.wallet.vo.wallet.AppPayWalletRespVO;
import com.weiwan.box.module.pay.dal.dataobject.wallet.PayWalletDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletConvert {

    PayWalletConvert INSTANCE = Mappers.getMapper(PayWalletConvert.class);

    AppPayWalletRespVO convert(PayWalletDO bean);

    PayWalletRespVO convert02(PayWalletDO bean);

    PageResult<PayWalletRespVO> convertPage(PageResult<PayWalletDO> page);

}
