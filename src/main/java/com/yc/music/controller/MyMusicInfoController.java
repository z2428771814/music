package com.yc.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.service.IMyMusicInfoService;
import com.yc.music.util.StringUtil;

/**
 * 我的音乐
 * @author 沐十二
 * 2019年10月20日
 */
@RestController
@RequestMapping("/myMusic")
public class MyMusicInfoController {
	
	@Autowired
	IMyMusicInfoService service;
	
	/**
	 *  查询我喜欢
	 * @return
	 */
	@RequestMapping("/findLike")
	public List<MusicInfo> findLike(){
		return service.findLike();
	}
	
	/**
	 * 根据歌曲id删除歌曲
	 * @return
	 */
	@RequestMapping("/deleteMusic")
	public int deleteMusic(Integer mid){
		return service.deleteMusic(mid);
	}
	
	/**
	 * 根据用户id查询歌单
	 * @param uid
	 * @return
	 */
	@RequestMapping("/findSongList")
	public List<UserListInfo> findSongList(Integer uid){
		return service.findSongList(uid);
		
	}
}
