package com.weiwan.box.module.product.dal.mysql.property;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.weiwan.box.module.product.controller.admin.property.vo.property.ProductPropertyPageReqVO;
import com.weiwan.box.module.product.dal.dataobject.property.ProductPropertyDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductPropertyMapper extends BaseMapperX<ProductPropertyDO> {

    default PageResult<ProductPropertyDO> selectPage(ProductPropertyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductPropertyDO>()
                .likeIfPresent(ProductPropertyDO::getName, reqVO.getName())
                .betweenIfPresent(ProductPropertyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductPropertyDO::getId));
    }

    default ProductPropertyDO selectByName(String name) {
        return selectOne(ProductPropertyDO::getName, name);
    }

}
