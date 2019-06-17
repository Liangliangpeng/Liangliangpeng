package com.operatormanager.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.operatormanager.mappers.SuperMapper;
import com.operatormanager.user.entity.SysUser;

public interface SysUserMapper  extends SuperMapper<SysUser>{
	
	SysUser Login( @Param("uid")String uid,@Param("password")String password);
	
	void updatePwd( @Param("id")Long id,@Param("password")String password);
}
