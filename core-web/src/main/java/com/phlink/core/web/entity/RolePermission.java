package com.phlink.core.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.phlink.core.web.base.PhlinkBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wen
 */
@Data
@TableName("t_role_permission")
@ApiModel(value = "角色权限")
public class RolePermission extends PhlinkBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "权限id")
    private String permissionId;
}