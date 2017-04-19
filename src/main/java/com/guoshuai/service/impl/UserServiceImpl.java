package com.guoshuai.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.guoshuai.domain.User;
import com.guoshuai.service.UserService;

@WebService(targetNamespace="http://service.guoshuai.com/",endpointInterface = "com.guoshuai.service.UserService",serviceName="userService")
/**
 * 那么原因就是：在CXF发布服务的时候，发布的是业务类(UserServiceImpl.java)，那么默认的命名空间就会是业务类所在包（路径），而对外界暴露的则是接口类(UserService.java)，那么对于客户端调用的时侯，需要按照接口类所在路径进行命名空间的定义。
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {

	private Map<String, User> userMap = new HashMap<String, User>();

	public UserServiceImpl() {
		System.out.println("向实体类插入数据");
		User user = new User();
		user.setUserId("411001");
		user.setUsername("zhansan");
		user.setAge("20");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);

		user = new User();
		user.setUserId("411002");
		user.setUsername("lisi");
		user.setAge("30");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);

		user = new User();
		user.setUserId("411003");
		user.setUsername("wangwu");
		user.setAge("40");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);

	}

	@Override
	public String getName(String userId) {
		// TODO Auto-generated method stub
		return "liyd-" + userId;
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		System.out.println("userMap是:"+userMap);
	    return userMap.get(userId);
	}

}
