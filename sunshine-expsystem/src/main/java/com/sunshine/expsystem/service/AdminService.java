package com.sunshine.expsystem.service;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbAdmin;
import com.sunshine.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员业务
 * @author yaolang
 *
 */
public interface AdminService {

	/**
	 * 数据校验
	 * @param content
	 * 校验参数
	 * @param type
	 * 参数类型
	 * @return
	 */
	public CommonResult checkData(String content, Integer type);
	
	/**
	 * 创建管理员
	 * @param tbAdmin
	 * @return
	 */
	public CommonResult createUser(TbAdmin tbAdmin);
	
	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @return
	 */
	public CommonResult userLogin(String username, String password, HttpServletRequest req, HttpServletResponse resp);
	
	/**
	 * 使用token获取管理员信息
	 * @param token
	 * @return
	 */
	public CommonResult getUserByToken(String token);
	
	/**
	 * 管理员登出
	 * @param token
	 * @return
	 */
	public CommonResult userLogout(String token);

	public TbAdmin getUserByRequst(HttpServletRequest req);

	public CommonResult logout(HttpServletRequest req,HttpServletResponse resp);
}
