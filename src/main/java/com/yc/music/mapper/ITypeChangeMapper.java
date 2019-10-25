package com.yc.music.mapper;

import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.data.redis.connection.ReactiveListCommands.LInsertCommand;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.CombinationInfo;
import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
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
	
	/**
	 * 添加歌手
	 * @param singerInfo
	 * @return
	 */
	public int addSingerInfo(SingerInfo singerInfo);
	
	/**
	 * 查询所有的歌手
	 * @return
	 */
	public List<SingerInfo> findSingerInfo();

	/**
	 * 删除歌手
	 * @param SingerInfo
	 * @return
	 */
	public int deleteSingerInfo(SingerInfo singerInfo);
	
	/**
	 * 歌手的分页查询
	 * @param map
	 * @return
	 */
	public List<SingerInfo> pagingSingerInfo(Map<String,Object> map );
	
	/**
	 * 删除歌手之后，把歌手夏敏的歌曲全部删除
	 * @param singerInfo
	 * @return
	 */
	public int deleteSingerInfoMusicinfo(SingerInfo singerInfo);
	
	/**
	 * 添加组合
	 * @param combinationinfo
	 * @return
	 */
	public int addCombinationInfo(CombinationInfo combinationinfo);
	
	/**
	 * 查询所有的组合
	 * @return
	 */
	public List<CombinationInfo> findCombinationInfo();
	
	/**
	 * 删除单个的组合
	 * @param combinationinfo
	 * @return
	 */
	public int deleteCombinationInfo(CombinationInfo combinationinfo);
	
	/**
	 * 分页查询组合
	 * @return
	 */
	public List<CombinationInfo> pagingCombinationInfo(Map<String, Object> map);
	
	/**
	 * 添加音乐
	 * @param musicinfo
	 * @return
	 */
	public int addMusicInfo(MusicInfo musicinfo);
	
	/**
	 * 查询单个歌手是否存在
	 * @param sgname
	 * @return
	 */
	public SingerInfo findbySingerInfoId(String sgname);
	
	/**
	 * 查询单个的组合
	 * @param cname
	 * @return
	 */
	public CombinationInfo findByCombinationInfoId(String cname);
	
	
}
