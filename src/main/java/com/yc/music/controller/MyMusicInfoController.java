package com.yc.music.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.UserInfo;
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
	public List<UserListInfo> findSongList(Integer uid,HttpSession session){
		Object obj = session.getAttribute("loginUser");
		if( obj == null ){
			return null;
		}
		UserInfo ui = (UserInfo) obj;
		System.out.println(ui.getUid());
		return service.findSongList(ui.getUid());
	}
	
	/**
	 * 根据歌单id删除歌单
	 * @param lid
	 * @return
	 */
	@RequestMapping("/deleteGedan")
	public int deleteGedan(Integer lid){
		return service.deleteGedan(lid);
	}
}
