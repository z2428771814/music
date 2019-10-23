package com.yc.music.mapper;

import java.util.List;
import java.util.Map;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.SongTypeInfo;

public interface ITypeChangeMapper {

	/**
	 * 添加应用场景
	 * @param alt
	 * @return
	 */
	public int addApplicationType(ApplicationTypeInfo alt);
	
	/**
	 * 查询所有的应用场景的id
	 * @return
	 */
	public List<ApplicationTypeInfo> findApplicationType();
	
	/**
	 * 删除应用场景
	 * @return
	 */
	public int deleteApplicationType(ApplicationTypeInfo alt);
	
	/**
	 * 删除对应场景下面所有的类型
	 * @param alt
	 * @return
	 */
	public int deleteSongTypeInfo(ApplicationTypeInfo alt);
	
	/**
	 * 添加类型
	 * @param map
	 * @return
	 */
	public int addSongType(Map<String,Object> map);
	
	/**
	 * 查询所属对应场景下面的类型
	 * @param atid
	 * @return
	 */
	public List<SongTypeInfo> findByAtidSongType(int atid);
	
	/**
	 * 删除类型
	 * @param sid
	 * @return
	 */
	public int deleteSongType(int sid);
	
}
