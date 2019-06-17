package com.operatormanager.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.operatormanager.user.entity.SysUser;



public interface  SysUserService  extends IService<SysUser>{
	
	SysUser Login(String uid,String password);
	
	void  updatePwd(Long id,String password);
}
