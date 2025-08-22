package com.weiwan.box.module.pay.convert.wallet;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.module.pay.controller.admin.wallet.vo.transaction.PayWalletTransactionRespVO;
import com.weiwan.box.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import com.weiwan.box.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import com.weiwan.box.module.pay.service.wallet.bo.WalletTransactionCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<PayWalletTransactionRespVO> convertPage2(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(WalletTransactionCreateReqBO bean);

}
