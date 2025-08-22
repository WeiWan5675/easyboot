package com.weiwan.box.module.bpm.dal.mysql.definition;

import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.module.bpm.controller.admin.definition.vo.expression.BpmProcessExpressionPageReqVO;
import com.weiwan.box.module.bpm.dal.dataobject.definition.BpmProcessExpressionDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * BPM 流程表达式 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface BpmProcessExpressionMapper extends BaseMapperX<BpmProcessExpressionDO> {

    default PageResult<BpmProcessExpressionDO> selectPage(BpmProcessExpressionPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmProcessExpressionDO>()
                .likeIfPresent(BpmProcessExpressionDO::getName, reqVO.getName())
                .eqIfPresent(BpmProcessExpressionDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BpmProcessExpressionDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmProcessExpressionDO::getId));
    }

}