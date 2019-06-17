package com.operatormanager.user.entity;

import javax.validation.constraints.NotEmpty;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.operatormanager.beans.SuperEntity;
import com.operatormanager.user.enums.StateEnum;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@TableName(value = 	"sys_user")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SysUser  extends  SuperEntity<SysUser>{
	
	private static final long serialVersionUID = -9052979597387435329L;

	public interface  a{}
	
	
	@TableField("user_name")
	private String  userName;		//用户名
	
	@TableField("uid")
	@NotEmpty(message = "账号不能为空", groups = {SysUser.a.class})
	private String uid;
	
	@TableField("password")
	@NotEmpty(message = "密码不能为空", groups = {SysUser.a.class})
	private String  password;		//密码
	
	@TableField("state")
	private StateEnum state;		//状态
	
	@TableField("phone")	
	private String phone;			//手机
	

	
	
}
