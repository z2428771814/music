package com.yc.music.service;

import com.yc.music.bean.UserInfo;

public interface IUserInfoService {
	
	//用户登录
	public UserInfo login(UserInfo userInfo);
	
	//注册用户
	public int add(UserInfo userInf);

}
