package com.yc.music.mapper;

import java.util.List;
import java.util.Map;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.bean.UserMusiceInfo;
/**
 * 我的音乐
 * @author 沐十二
 * 2019年10月20日
 */
public interface IMyMusicInfoMapper {
	
	//  查询我喜欢
	public List<MusicInfo> findLike();
	
	// 根据歌曲id删除歌曲
	public int deleteMusic(Integer mid);
	
	// 根据用户id查询歌单
	public List<UserListInfo> findSongList(Integer uid);
	
	// 根据歌单id删除歌单
	public int deleteGedan(Integer lid);
	
	// 获取歌单的分类
	public List<SongTypeInfo> gedanType();
	
	// 创建歌单
	public int createGedan(UserListInfo ul  );
	
	//查询歌手信息
	public List<SingerInfo> showSinger(Integer uid);
	
	// 根据歌手id取消关注
	public int unfollow(Integer sgid);
	
	// 根据用户id查询歌单的名字
	public List<UserListInfo> findGedanName(UserListInfo ul);
	
	// 添加单个歌曲到歌单
	public int AddSongToPlayList(UserMusiceInfo umi );
	
	// 添加多个歌曲到歌单
	public int AddSongsToPlayList(Map<String,Object> map );
	
	
}
