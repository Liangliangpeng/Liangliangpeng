package com.operatormanager.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.operatormanager.beans.SuperEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@TableName(value = 	"sys_user_role")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRole extends  SuperEntity<SysUserRole>{
	
	private static final long serialVersionUID = 6642896923613438855L;
	
	@TableField("user_id")
	private Long userId;
	
	@TableField("role_id")
	private Long roleId;
}
