package com.yc.music.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.bean.UserMusiceInfo;
import com.yc.music.mapper.IMyMusicInfoMapper;
import com.yc.music.service.IMyMusicInfoService;
import com.yc.music.util.StringUtil;
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
	
	// 获取歌单分类
	@Override
	public List<SongTypeInfo> gedanType() {
		return mapper.gedanType();
	}

	// 创建歌单
	@Override
	public int createGedan(UserListInfo ul ) {
		if( StringUtil.checkNull(ul.getLname(),ul.getBy1()) ){
			return -1;
		}
		return mapper.createGedan(ul);
	}

	// 查找歌手信息
	@Override
	public List<SingerInfo> showSinger( Integer uid) {
		return mapper.showSinger(uid);
	}
	
	// 根据歌手id取消关注
	@Override
	public int unfollow(Integer sgid) {
		return mapper.unfollow(sgid);
	}

	// 根据用户id查询歌单名字
	@Override
	public List<UserListInfo> findGedanName(UserListInfo ul) {
		return mapper.findGedanName(ul);
	}

	// 添加的单个歌曲到歌单
	@Override
	public int AddSongToPlayList(UserMusiceInfo umi  ) {
		return mapper.AddSongToPlayList(umi);
	}

	// 添加多个歌曲到歌单
	@Override
	public int AddSongsToPlayList(Integer lid , String mids) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mids",mids.split(","));
		System.out.println(mids);
		map.put("lid", lid);
		return mapper.AddSongsToPlayList(map);
	}
	
	
	

}
