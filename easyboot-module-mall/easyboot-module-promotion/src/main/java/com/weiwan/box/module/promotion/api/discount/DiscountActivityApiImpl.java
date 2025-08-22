package com.weiwan.box.module.promotion.api.discount;

import com.weiwan.box.framework.common.util.object.BeanUtils;
import com.weiwan.box.module.promotion.api.discount.dto.DiscountProductRespDTO;
import com.weiwan.box.module.promotion.dal.dataobject.discount.DiscountProductDO;
import com.weiwan.box.module.promotion.service.discount.DiscountActivityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;

/**
 * 限时折扣 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DiscountActivityApiImpl implements DiscountActivityApi {

    @Resource
    private DiscountActivityService discountActivityService;

    @Override
    public List<DiscountProductRespDTO> getMatchDiscountProductListBySkuIds(Collection<Long> skuIds) {
        List<DiscountProductDO> list = discountActivityService.getMatchDiscountProductListBySkuIds(skuIds);
        return BeanUtils.toBean(list, DiscountProductRespDTO.class);
    }

}
