package com.operatormanager.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.operatormanager.beans.SuperEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@TableName(value = 	"sys_role_resources")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleResources extends  SuperEntity<SysRoleResources>{


	private static final long serialVersionUID = -7410077887393295064L;
	
	@TableField("role_id")
	private Long roleId;
	
	@TableField("resources_id")
	private Long resourcesId;
}
