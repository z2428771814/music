package com.yc.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.UserInfo;
import com.yc.music.mapper.IUserInfoMapper;
import com.yc.music.service.IUserInfoService;
import com.yc.music.util.StringUtil;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private IUserInfoMapper userInfoMapper;

	//用户登录
	public UserInfo login(UserInfo userInfo) {
		if( StringUtil.checkNull( userInfo.getUname(),userInfo.getPwd() ) ){
			return null;
		}
		System.out.println( "德尔边"+userInfo );
		return userInfoMapper.login(userInfo);
	}

	@Override
	public int add(UserInfo userInf) {
		if( StringUtil.checkNull( userInf.getEmail(),userInf.getPwd(),userInf.getUname() ) ){
			return -1;
		}
		System.out.println( "德尔边"+userInf );
		return userInfoMapper.add(userInf);
	}

}
