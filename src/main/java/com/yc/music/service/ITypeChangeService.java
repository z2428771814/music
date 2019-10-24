package com.yc.music.service;

import java.util.List;
import java.util.Map;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.CombinationInfo;
import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
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
	
	//添加歌手
	public int addSingerInfo(SingerInfo singerInfo);
	
	//查询所有的歌手
	public List<SingerInfo> findSingerInfo();
	
	// 删除歌手
	public int deleteSingerInfo(SingerInfo singerInfo);
	
	//歌手的分页查询
	public List<SingerInfo> pagingSingerInfo(Integer pageNo,Integer pageSize);
	
	//删除歌手之后，把歌手夏敏的歌曲全部删除
	public int deleteSingerInfoMusicinfo(SingerInfo singerInfo);
	
	//添加组合
	public int addCombinationInfo(CombinationInfo combinationinfo);
	
	//查询所有的组合
	public List<CombinationInfo> findCombinationInfo();
	
	//删除单个的组合
	public int deleteCombinationInfo(CombinationInfo combinationinfo);
	
	//分页查询组合
	public List<CombinationInfo> pagingCombinationInfo(Integer pageNo,Integer pageSize);
	
	//添加音乐
	public int addMusicInfo(MusicInfo musicinfo,String sgname,String cname);
	
}
