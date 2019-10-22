package com.yc.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.mapper.IMusicInfoMapper;
import com.yc.music.mapper.IUserListMapper;
import com.yc.music.service.IMusicInfoService;
import com.yc.music.service.IUserListService;
@Service
public class MusicInfoServiceImpl implements IMusicInfoService {

	@Autowired
	private IMusicInfoMapper mapper;

	//查询所有地区
	@Override
	public List<SingerInfo> findAddr() {
		return mapper.findAddr();
	}

	//查询最新歌曲信息
	@Override
	public List<MusicInfo> newSong() {
		return mapper.newSong();
	}
	
}
