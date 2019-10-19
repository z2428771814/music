package com.yc.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.UserInfo;
import com.yc.music.mapper.UserInfoMapper;
import com.yc.music.service.IUserInfoService;
import com.yc.music.util.StringUtil;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	//用户登录
	public UserInfo login(UserInfo userInfo) {
		if( StringUtil.checkNull( userInfo.getUname(),userInfo.getPwd() ) ){
			return null;
		}
		return userInfoMapper.login(userInfo);
	}

}
