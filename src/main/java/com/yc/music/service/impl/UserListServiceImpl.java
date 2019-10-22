package com.yc.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.mapper.IUserListMapper;
import com.yc.music.service.IUserListService;
@Service
public class UserListServiceImpl implements IUserListService {

	@Autowired
	private IUserListMapper mapper;
	
	//歌单推荐类型
	@Override
	public List<SongTypeInfo> oodType() {
		return mapper.oodType();
	}

	//最新歌单
	@Override
	public List<UserListInfo> newOdd() {
		return mapper.newOdd();
	}

}
