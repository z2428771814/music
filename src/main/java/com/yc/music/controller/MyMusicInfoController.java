package com.yc.music.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.bean.UserMusiceInfo;
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
	
	/**
	 * 获取歌单分类
	 * @return
	 */
	@RequestMapping("/gedanType")
	public List<SongTypeInfo> gedanType(){
		return service.gedanType();
	}
	
	/**
	 * 创建歌单
	 * @param lname
	 * @param by1
	 * @return
	 */
	@RequestMapping("/createGedan")
	public int createGedan(UserListInfo ul ,Integer uid ,HttpSession session){
		Object obj = session.getAttribute("loginUser");
		if( obj == null ){
			return -1;
		}
		UserInfo ui = (UserInfo) obj;
		ul.setUid(ui.getUid());
		return service.createGedan(ul);
	}
	/**
	 * 根据用户编号查找歌手信息
	 * @param si
	 * @param session
	 * @return
	 */
	@RequestMapping("/showSinger")
	public List<SingerInfo> showSinger(SingerInfo si,HttpSession session){
		Object obj = session.getAttribute("loginUser");
		if( obj == null ){
			return null;
		}
		UserInfo ui = (UserInfo) obj;
		si.setUid(ui.getUid());
		return service.showSinger(si);
	}
	
	/**
	 * 根据歌手id取消关注
	 * @param sgid
	 * @return
	 */
	@RequestMapping("/unfollow")
	public int unfollow(Integer sgid){
		return service.unfollow(sgid);
	}
	
	
	// 根据用户id查询歌单的名字
	@RequestMapping("/findGedanName")
	public List<UserListInfo> findGedanName(UserListInfo ul ,Integer uid ,HttpSession session ){
		Object obj = session.getAttribute("loginUser");
		if( obj == null ){
			return null;
		}
		UserInfo ui = (UserInfo) obj;
		ul.setUid(ui.getUid());
		return service.findGedanName(ul);
		
	}
	
	/**
	 * 添加单个歌曲到歌单
	 * @param umi
	 * @param session
	 * @return
	 */
	@RequestMapping("/AddSongToPlayList")
	public int AddSongToPlayList(UserMusiceInfo umi ){
		return service.AddSongToPlayList(umi);
	}
	
	/**
	 * 添加多个歌曲到歌单
	 * @param umi
	 * @param mid
	 * @return
	 */
	@RequestMapping("/AddSongsToPlayList")
	public int AddSongsToPlayList(Integer lid , String mids){
		return service.AddSongsToPlayList(lid, mids);
		
	}
	
	/**
	 * 根据歌单id查询歌单信息
	 * @param ul
	 * @return
	 */
	@RequestMapping("/getPlayListInfo")
	public List<UserListInfo> getPlayListInfo(UserListInfo ul , HttpSession session){
		Object obj = session.getAttribute("loginUser");
		if( obj == null ){
			return null;
		}
		UserInfo ui = (UserInfo) obj;
		ul.setUid(ui.getUid());
		return service.getPlayListInfo(ul);
	}
	
	/**
	 * 根据歌单id查询歌单信息
	 * @param ul
	 * @return
	 */
	@RequestMapping("/getPlayList")
	public List<UserListInfo> getPlayList(UserListInfo ul , HttpSession session){
		Object obj = session.getAttribute("loginUser");
		if( obj == null ){
			return null;
		}
		UserInfo ui = (UserInfo) obj;
		ul.setUid(ui.getUid());
		return service.getPlayList(ul);
	}
	
	/**
	 * 根据歌单id修改歌单图片
	 * @param ul
	 * @param pic 歌单第一张歌曲的图片
	 * @return
	 */
	@RequestMapping("/updatePic")
	public Integer updatePic(String pice , UserListInfo ul) {
		ul.setBy3(pice);
		System.out.println(ul.getBy3());
		return service.updatePic( ul);
	}
}
