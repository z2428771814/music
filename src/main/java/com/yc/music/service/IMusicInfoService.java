package com.yc.music.service;

import java.util.List;
import java.util.Map;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;

public interface IMusicInfoService {

	/**
	 * 查询所有地区
	 * @return
	 */
	public List<SingerInfo> findAddr();
	
	/**
	 * 查询最新歌曲信息
	 * @return
	 */
	public List<MusicInfo> newSong(int total, int page, int rows);
	
	/**
	 * 根据地区查询歌曲
	 * @return
	 */
	public List<MusicInfo> seleAddr(String addr,int total, int page, int rows);
	
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
	public List<SingerInfo> singerShow(int page, int rows);
	
	public Map<String, Object> findByFirst(int page, int rows);
	
	public Map<String, Object> addrFirst(String addr, int page, int rows);
	
	public Map<String, Object> letterFirst(String addr, String sex, String genre, Integer start, Integer stop, String let, Integer page, Integer rows);
	
	/**
	 * 查询地区歌手
	 * @param si
	 * @return
	 */
	public List<SingerInfo> findAddrSinger(String addr, int page, int rows);
	
	/**
	 * 根据性别查歌手
	 * @param map
	 * @return
	 */
	public List<SingerInfo> findSex(String sex, int page, int rows);

	public List<SingerInfo> findletter(String addr, String sex, String genre, Integer start, Integer stop, String let, Integer page, Integer rows);
}
