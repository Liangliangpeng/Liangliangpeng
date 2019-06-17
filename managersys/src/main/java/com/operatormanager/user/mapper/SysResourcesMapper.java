package com.operatormanager.user.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.operatormanager.mappers.SuperMapper;
import com.operatormanager.user.entity.SysResources;


public interface SysResourcesMapper  extends SuperMapper<SysResources>{
	
	
	  Set<String> findRoleNameByUserId(@Param("userId") int userId);
}
