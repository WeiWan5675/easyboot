package com.weiwan.box.module.bpm.framework.flowable.core.candidate.strategy.user;

import com.weiwan.box.framework.common.util.string.StrUtils;
import com.weiwan.box.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import com.weiwan.box.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import com.weiwan.box.module.system.api.permission.PermissionApi;
import com.weiwan.box.module.system.api.permission.RoleApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 角色 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author kyle
 */
@Component
public class BpmTaskCandidateRoleStrategy implements BpmTaskCandidateStrategy {

    @Resource
    private RoleApi roleApi;
    @Resource
    private PermissionApi permissionApi;

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.ROLE;
    }

    @Override
    public void validateParam(String param) {
        Set<Long> roleIds = StrUtils.splitToLongSet(param);
        roleApi.validRoleList(roleIds);
    }

    @Override
    public Set<Long> calculateUsers(String param) {
        Set<Long> roleIds = StrUtils.splitToLongSet(param);
        return permissionApi.getUserRoleIdListByRoleIds(roleIds);
    }

}