package com.yc.music.mapper;

import com.yc.music.bean.UserInfo;

/**
 * 用户表
 * @author lenovo1
 *
 */
public interface IUserInfoMapper {
	/**
	 * 用户登录
	 * @param userInfo	用户对象
	 * @return
	 */
	public UserInfo login(UserInfo userInfo);
	
	/**
	 * 注册用户
	 * @param userInfo
	 * @return
	 */
	public int add(UserInfo userInfo);
}
