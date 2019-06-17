package com.operatormanager.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.api.R;
import com.operatormanager.user.entity.SysUser;
import com.operatormanager.user.service.SysUserService;
import com.operatormanager.utils.MD5;
import com.operatormanager.utils.UserContext;




@Controller
@RequestMapping("/api/user")
public class SysUserController {
	
	  @Autowired
	   private SysUserService sysUserService;
	  
	  @RequestMapping("registered")
	  @ResponseBody
	  public R<?> sysUserSave(@Validated(SysUser.a.class)SysUser sysUser){
		  String passWord = sysUser.getPassword();
		  String pwd = MD5.md5(passWord);
		  sysUser.setPassword(pwd);
		  sysUserService.save(sysUser);
		  return R.ok("注册成功");
	  }
	  
	  @RequestMapping("login")
	  @ResponseBody
	  public R<?> Login(@Validated(SysUser.a.class) SysUser sysUser,HttpServletRequest request, HttpServletResponse response){
		  SysUser sysUser1 = sysUserService.Login(sysUser.getUid(),  MD5.md5(sysUser.getPassword()));
		  if(null==sysUser1) {
			  return R.failed("账号或者密码错误!");
		  }else {
		       HttpSession session = request.getSession();  
		       session.setAttribute(UserContext.USER_IN_SESSION, sysUser1);
		       session.setMaxInactiveInterval(-1);
		       return R.ok("登录成功");
		  }
	  }
	  
	
}
