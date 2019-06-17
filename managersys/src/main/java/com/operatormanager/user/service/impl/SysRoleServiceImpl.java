package com.operatormanager.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operatormanager.user.service.SysRoleService;

@Service
public class SysRoleServiceImpl  implements SysRoleService{

	  @Autowired
	  private SysRoleService sysRoleService;
	
/*	@Override
	public Set<String> findRoleNameByUserId(int userId) {
		// TODO Auto-generated method stub
		return sysRoleService.findRoleNameByUserId(userId);
	}*/

}
