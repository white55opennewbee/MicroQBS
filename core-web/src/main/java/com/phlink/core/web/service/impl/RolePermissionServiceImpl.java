/*
 * @Author: sevncz.wen
 * @Date: 2020-05-06 14:52:50
 * @Last Modified by:   sevncz.wen
 * @Last Modified time: 2020-05-06 14:52:50
 */
package com.phlink.core.web.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phlink.core.web.entity.RolePermission;
import com.phlink.core.web.mapper.RolePermissionMapper;
import com.phlink.core.web.service.RolePermissionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wen
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Override
    public List<RolePermission> listByPermissionId(String permissionId) {
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RolePermission::getPermissionId, permissionId);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<RolePermission> listByRoleId(String roleId) {
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RolePermission::getRoleId, roleId);
        return baseMapper.selectList(queryWrapper);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteByRoleId(String roleId) {
        UpdateWrapper<RolePermission> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(RolePermission::getRoleId, roleId);
        baseMapper.delete(wrapper);
    }
}
