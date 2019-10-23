package com.yc.music.mapper;

import java.util.List;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;

public interface IMusicInfoMapper {
	
	/**
	 * 查询所有地区
	 * @return
	 */
	public List<SingerInfo> findAddr();
	
	/**
	 * 查询最新歌曲信息
	 * @return
	 */
	public List<MusicInfo> newSong();
	
	/**
	 * 查询歌曲详细信息
	 * @return
	 */
	public MusicInfo songDetail(int mid);
}
