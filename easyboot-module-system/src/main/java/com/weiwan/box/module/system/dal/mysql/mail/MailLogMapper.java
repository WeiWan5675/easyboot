package com.weiwan.box.module.system.dal.mysql.mail;

import cn.hutool.core.util.StrUtil;
import com.weiwan.box.framework.common.pojo.PageResult;
import com.weiwan.box.framework.mybatis.core.mapper.BaseMapperX;
import com.weiwan.box.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.weiwan.box.framework.mybatis.core.util.MyBatisUtils;
import com.weiwan.box.module.system.controller.admin.mail.vo.log.MailLogPageReqVO;
import com.weiwan.box.module.system.dal.dataobject.mail.MailLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailLogMapper extends BaseMapperX<MailLogDO> {

    default PageResult<MailLogDO> selectPage(MailLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MailLogDO>()
                .eqIfPresent(MailLogDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MailLogDO::getUserType, reqVO.getUserType())
                .eqIfPresent(MailLogDO::getAccountId, reqVO.getAccountId())
                .eqIfPresent(MailLogDO::getTemplateId, reqVO.getTemplateId())
                .eqIfPresent(MailLogDO::getSendStatus, reqVO.getSendStatus())
                .betweenIfPresent(MailLogDO::getSendTime, reqVO.getSendTime())
                .apply(StrUtil.isNotBlank(reqVO.getToMail()),
                        MyBatisUtils.findInSet("to_mails", reqVO.getToMail()))
                .orderByDesc(MailLogDO::getId));
    }

}
