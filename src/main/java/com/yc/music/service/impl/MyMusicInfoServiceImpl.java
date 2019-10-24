package com.yc.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.mapper.IMyMusicInfoMapper;
import com.yc.music.service.IMyMusicInfoService;
/**
 * 我的音乐
 * @author 沐十二
 * 2019年10月20日
 */
@Service
public class MyMusicInfoServiceImpl implements IMyMusicInfoService {
	@Autowired
	IMyMusicInfoMapper mapper;
	
	@Override
	//我的音乐  查询我喜欢
	public List<MusicInfo> findLike() {
		return mapper.findLike();
	}
	
	@Override
	//根据歌曲id删除歌曲
	public int deleteMusic(Integer mid) {
		return mapper.deleteMusic(mid);
	}
	
	// 根据用户id查询歌单
	@Override
	public List<UserListInfo> findSongList(Integer uid) {
		return mapper.findSongList(uid);
	}
	
	// 根据歌单id删除歌单
	@Override
	public int deleteGedan(Integer lid) {
		return mapper.deleteGedan(lid);
	}
	
	
	
	

}
