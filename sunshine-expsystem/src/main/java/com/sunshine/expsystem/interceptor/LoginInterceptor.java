package com.sunshine.expsystem.interceptor;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.utils.CookieUtils;
import com.sunshine.expsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Autowired
	private AdminService adminService;

	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
//		String XT_TOKEN = userService.XT_ADMIN_TOKEN;
		String token = CookieUtils.getCookieValue(arg0, "XT_ADMIN_TOKEN");

		System.out.println("token>>"+token);
		if(token==null){
//			arg1.sendRedirect("/login"+"?redirect="+arg0.getRequestURL());
			arg0.getRequestDispatcher("/login?redirect="+arg0.getRequestURL()).forward(arg0,arg1);
			return false;
		}
		CommonResult user = adminService.getUserByToken(token);
		if(user==null||user.getStatus()!=200){
			arg0.getRequestDispatcher("/login?redirect="+arg0.getRequestURL()).forward(arg0,arg1);
			return false;
		}
		arg0.setAttribute("user", user);
		return true;
	}

}
