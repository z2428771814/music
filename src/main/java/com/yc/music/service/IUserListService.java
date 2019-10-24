package com.yc.music.service;

import java.util.List;

import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserListInfo;

public interface IUserListService {

	/**
	 * 歌单推荐类型
	 * @param st
	 * @return
	 */
	public List<SongTypeInfo> oodType();
	
	/**
	 * 最新歌单
	 * @return
	 */
	public List<UserListInfo> newOdd();
}
