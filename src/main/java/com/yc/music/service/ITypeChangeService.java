package com.yc.music.service;

import java.util.List;
import java.util.Map;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.SongTypeInfo;

public interface ITypeChangeService {
	
	//添加应用场景
	public int addApplicationType(ApplicationTypeInfo alt);
	
	//查询所有的应用场景
	public List<ApplicationTypeInfo> findApplicationType();

	//删除应用场景
	public int deleteApplicationType(ApplicationTypeInfo alt);
	
	//删除对应场景下面所有的类型
	public int deleteSongTypeInfo(ApplicationTypeInfo alt);
	
	//添加类型
	public int addSongType(int aitd,String stype);
	
	//查询场景下面对应的类型
	public List<SongTypeInfo> findByAtidSongType(int atid);
	
	//删除类型
	public int deleteSongType(int sid);
}
