package com.operatormanager.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.operatormanager.beans.SuperEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@TableName(value = 	"sys_role")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SysRole   extends  SuperEntity<SysRole>{

	private static final long serialVersionUID = 5394068326036310590L;
	
	@TableField("role_desc")
	private String roleDesc;
}
