package com.yc.music.mapper;

import java.util.List;
import java.util.Map;

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
	public List<MusicInfo> newSong(Map<String, Integer> map);
	
	/**
	 * 根据地区查询歌曲
	 * @return
	 */
	public List<MusicInfo> seleAddr(Map<String, Object> map);
	
	/**
	 * 查询歌曲详细信息
	 * @return
	 */
	public MusicInfo songDetail(int mid);

	/**
	 * 查询所有歌手类型
	 * @return
	 */
	public List<SingerInfo> singType();
	
	/**
	 * 歌手展示
	 * @return
	 */
	public List<SingerInfo> singerShow(Map<String, Object> map);
	
	/**
	 * 歌手数量
	 * @return
	 */
	public int singerNum();
	
	/**
	 * 地区歌手数量
	 * @return
	 */
	public int addrNum(String addr);
	
	/**
	 * 根据字母查询数量
	 * @param map
	 * @return
	 */
	public Integer letterNum(Map<String, Object> map);
	
	/**
	 * 查询地区歌手
	 * @param si
	 * @return
	 */
	public List<SingerInfo> findAddrSinger(Map<String, Object> map);
	
	/**
	 * 根据性别查歌手
	 * @param map
	 * @return
	 */
	public List<SingerInfo> findSex(Map<String, Object> map);
	
	/**
	 * 根据字母查歌手
	 * @param map
	 * @return
	 */
	public List<SingerInfo> findlet(Map<String, Object> map);
}


