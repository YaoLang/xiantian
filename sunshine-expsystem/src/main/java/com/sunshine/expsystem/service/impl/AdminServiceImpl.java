package com.sunshine.expsystem.service.impl;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.utils.CookieUtils;
import com.sunshine.common.utils.DataCheckUtils;
import com.sunshine.common.utils.JsonUtils;
import com.sunshine.expsystem.dao.JedisClient;
import com.sunshine.expsystem.service.AdminService;
import com.sunshine.mapper.TbAdminMapper;
import com.sunshine.pojo.TbAdmin;
import com.sunshine.pojo.TbAdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private JedisClient jedisClient;

	@Autowired
	private TbAdminMapper tbAdminMapper;

	@Value("${REDIS_ADMIN_SESSION}")
	private String REDIS_ADMIN_SESSION;
	
	@Value("${ADMIN_SSO_SESSION_EXPIRE}")
	private Integer ADMIN_SSO_SESSION_EXPIRE;
	
	@Value("${XT_ADMIN_TOKEN}")
	public String XT_ADMIN_TOKEN;
	
	@Override
	public CommonResult checkData(String content, Integer type) {
		if(!DataCheckUtils.notNull(content))
			return CommonResult.build(400, "不能为空");

		if((1==type&&!DataCheckUtils.isUname(content))||(2==type&&!DataCheckUtils.isMobile(content))||(3==type&&!DataCheckUtils.isEmail(content)))
			return CommonResult.build(400, "格式错误");
		
		TbAdminExample adminExample = new TbAdminExample();

		TbAdminExample.Criteria criteria = adminExample.createCriteria();
		if(1==type)
			criteria.andUsernameEqualTo(content);
		else if(2==type)
			criteria.andPhoneEqualTo(content);
		else if(3==type)
			criteria.andEmailEqualTo(content);

		int count = tbAdminMapper.countByExample(adminExample);
		if(count>0)
			return CommonResult.build(400, "已被使用");

		return CommonResult.ok();
	}

	@Override
	public CommonResult createUser(TbAdmin tbAdmin) {
		tbAdmin.setCreated(new Date());
		tbAdmin.setUpdated(new Date());
		tbAdmin.setPassword(DigestUtils.md5DigestAsHex(tbAdmin.getPassword().getBytes()));

		tbAdminMapper.insertSelective(tbAdmin);

		return CommonResult.ok();
	}

	@Override
	public CommonResult userLogin(String username, String password,HttpServletRequest req,HttpServletResponse resp) {
		TbAdminExample example = new TbAdminExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<TbAdmin> loginuser = tbAdminMapper.selectByExample(example);
		if(loginuser==null||loginuser.size()==0)
			return CommonResult.build(400, "该用户没注册");

		TbAdmin tbAdmin = loginuser.get(0);
		String encode = DigestUtils.md5DigestAsHex(password.getBytes());
		if(!tbAdmin.getPassword().equals(encode))
			return CommonResult.build(400, "密码错误");

		String token = UUID.randomUUID().toString();
		tbAdmin.setPassword(null);
		jedisClient.set(REDIS_ADMIN_SESSION+":"+token, JsonUtils.objectToJson(tbAdmin));
		jedisClient.expire(REDIS_ADMIN_SESSION+":"+token, ADMIN_SSO_SESSION_EXPIRE);


		CookieUtils.setCookie(req, resp, XT_ADMIN_TOKEN, token);
		return CommonResult.ok(token);
	}

	@Override
	public CommonResult getUserByToken(String token) {
		String json = jedisClient.get(REDIS_ADMIN_SESSION+":"+token);
		if(json==null)
			return CommonResult.build(400, "密码已过期");
		TbAdmin user = JsonUtils.jsonToPojo(json, TbAdmin.class);
		jedisClient.expire(REDIS_ADMIN_SESSION+":"+token, ADMIN_SSO_SESSION_EXPIRE);
		return CommonResult.ok(user);
	}

	@Override
	public CommonResult userLogout(String token) {
		
		jedisClient.del(REDIS_ADMIN_SESSION+":"+token);
		return CommonResult.ok();
	}

	@Override
	public TbAdmin getUserByRequst(HttpServletRequest req){
		String token = CookieUtils.getCookieValue(req, XT_ADMIN_TOKEN);
		if(token!=null){
			return (TbAdmin) getUserByToken(token).getData();
		}
		return null;
	}

	@Override
	public CommonResult logout(HttpServletRequest req,HttpServletResponse resp) {
		CookieUtils.deleteCookie(req, resp, XT_ADMIN_TOKEN);
		return CommonResult.ok();
	}
	
}
