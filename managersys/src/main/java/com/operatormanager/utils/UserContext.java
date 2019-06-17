package com.operatormanager.utils;



import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.operatormanager.user.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//当前用户的上下文工具
public abstract class UserContext {

    //当前用户在session中的常量KEY
    public static final String USER_IN_SESSION = "USER_IN_SESSION";

    private static HttpSession getSession() {
        return ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }
    
    public static String getToken() {
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	String token = request.getHeader("Authorization") ;
    	if(StringUtils.isEmpty(token)) {
    		return null ;
    	}
    	String[]array = token.split(" ");

    	return array.length > 1 ? array[1] : null;
    }
    
    //设置当前登录的用户
    public static void setCurrentUser(SysUser user) {
        getSession().setAttribute(USER_IN_SESSION,user);
    }

    //获取当前登录的用户
    public static SysUser getCurrentUser() {
        return (SysUser) getSession().getAttribute(USER_IN_SESSION);
    }

}
