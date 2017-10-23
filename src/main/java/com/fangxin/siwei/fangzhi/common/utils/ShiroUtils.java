package com.fangxin.siwei.fangzhi.common.utils;
import com.fangxin.siwei.fangzhi.modal.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * Shiro工具类
 * @author cjw
 * @email chenjunwenchn@gmail.com
 * @date 2017年8月23日14:16:47
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static SysUser getCurrentUser() {
		 SysUser _sysUser=(SysUser)SecurityUtils.getSubject().getPrincipal();
		 return  _sysUser;
	}

	public static String  getCurrentUserNo() {
		SysUser _sysUser=getCurrentUser();
		if (_sysUser==null){
			return "system";
		}else{
			return  _sysUser.getUserNo();
		}
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}


	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	

}
