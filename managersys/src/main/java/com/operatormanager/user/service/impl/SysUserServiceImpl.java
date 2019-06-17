package com.operatormanager.user.service.impl;

import org.springframework.stereotype.Service;

import com.operatormanager.user.entity.SysUser;
import com.operatormanager.user.mapper.SysUserMapper;
import com.operatormanager.user.service.SysUserService;
import com.operatormanager.utils.BaseService;

@Service
public class SysUserServiceImpl  extends BaseService< SysUserMapper,  SysUser>  implements SysUserService{	
	
	@Override
	public SysUser Login(String uid,String password) {
		// TODO Auto-generated method stub
		return baseMapper.Login( uid,password);
	}

	@Override
	public void updatePwd(Long id, String password) {
		// TODO Auto-generated method stub
		 baseMapper.updatePwd(id, password);
	}




	

}
