package com.operatormanager.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.operatormanager.beans.SuperEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@TableName(value = 	"sys_resources")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SysResources   extends  SuperEntity<SysResources>{

	private static final long serialVersionUID = -8335816255569657087L;

	@TableField("user_name")
	private String userName;
	
	@TableField("res_url")
	private String resUrl;
	
	@TableField("user_type")
	private Long userType;
	
	@TableField("parent_id")
	private Long parentId;
	
	@TableField("user_sort")
	private Long userSort;
	

}
