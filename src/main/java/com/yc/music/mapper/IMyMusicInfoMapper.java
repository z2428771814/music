package com.yc.music.mapper;

import java.util.List;

import com.yc.music.bean.MusicInfo;
/**
 * 我的音乐
 * @author 沐十二
 * 2019年10月20日
 */
public interface IMyMusicInfoMapper {
	
	//  查询我喜欢
	public List<MusicInfo> findLike();
	
}
