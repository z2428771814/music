package com.yc.music.service;

import java.util.List;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserListInfo;
/**
 * 我的音乐
 * @author 沐十二
 * 2019年10月20日
 */
public interface IMyMusicInfoService {
	
	//我的音乐  查询我喜欢
	public List<MusicInfo> findLike();
	
	//根据古曲id删除歌曲
	public int deleteMusic(Integer mid);
	
	// 根据用户id查询歌单
	public List<UserListInfo> findSongList(Integer uid);
	
	// 根据歌单id删除歌单
	public int deleteGedan(Integer lid);
	
	// 获取歌单的分类
	public List<SongTypeInfo> gedanType();
	
	// 创建歌单
	public int createGedan(UserListInfo ul );
}
