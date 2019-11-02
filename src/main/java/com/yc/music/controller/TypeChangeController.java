package com.yc.music.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.CombinationInfo;
import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.service.IAdminService;
import com.yc.music.service.ITypeChangeService;

@RestController
@RequestMapping("/TypeChange")
public class TypeChangeController {

	@Autowired
	private ITypeChangeService service;

	//添加应用场景类型
	@RequestMapping("/addApplicationType")
	public int addApplicationType(HttpSession session,ApplicationTypeInfo alt){

		if( this.findApplicationType(session).size()>10 ){
			return -2;
		}

		return service.addApplicationType(alt);
	}

	//查询所有的应用场景
	@RequestMapping("/findApplicationType")
	public List<ApplicationTypeInfo> findApplicationType(HttpSession session) {
		List<ApplicationTypeInfo> list=service.findApplicationType();
		session.setAttribute("findApplicationType", list);
		return list;
	}

	//获取我们存下来的应用的场景
	@RequestMapping("/obtainsApplicationType")
	public List<ApplicationTypeInfo> obtainsApplicationType(HttpSession session) {
		List<ApplicationTypeInfo> list= (List<ApplicationTypeInfo>) session.getAttribute("findApplicationType");
		if( list == null ){
			list=service.findApplicationType();
		}
		return list;
	}


	//删除应用场景  和应用场景下面所有的类型
	@RequestMapping("/deleteApplicationType")
	public int deleteApplicationType(ApplicationTypeInfo alt){
		int result=-1;
		result=service.deleteApplicationType(alt);
		service.deleteSongTypeInfo(alt);
		return result;
	}

	//添加类型
	@RequestMapping("/addSongType")
	public int addSongType(SongTypeInfo songTypeInfo){	
		if( service.findByAtidSongType(songTypeInfo.getAtid()).size()>10  ){
			return -1;
		}
		return service.addSongType(songTypeInfo.getAtid(), songTypeInfo.getStype());
	}

	//查询场景下面对应的类型
	@RequestMapping("/findByAtidSongType")
	public  List<SongTypeInfo> findByAtidSongType(int atid){
		return service.findByAtidSongType(atid);	
	}

	//删除类型
	@RequestMapping("/deleteSongType")
	public int deleteSongType(int sid){
		return service.deleteSongType(sid);
	}



	//歌手的分页查询
	@RequestMapping("/pagingSingerInfo")
	public Map<String, Object> pagingSingerInfo(Integer pageNo, Integer pageSize){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total",service.findSingerInfo().size() );
		map.put("paging",service.pagingSingerInfo(pageNo, pageSize) );
		return map;	
	}

	//删除歌手
	@RequestMapping("/deleteSingerInfo")
	public int deleteSingerInfo(SingerInfo singerInfo){
		int result=service.deleteSingerInfo(singerInfo);
		//这个是删除歌手之后  删除歌手下面所有的歌曲
		service.deleteSingerInfoMusicinfo(singerInfo);
		return result;
	}

	//组合的分页查询
	@RequestMapping("/pagingCombinationInfo")
	public Map<String, Object> pagingCombinationInfo(Integer pageNo, Integer pageSize){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total",service.findCombinationInfo().size() );
		map.put("paging",service.pagingCombinationInfo(pageNo, pageSize) );
		return map;
	}

	//组合的分页查询
	@RequestMapping("/deleteCombinationInfo")
	public int deleteCombinationInfo(CombinationInfo combinationinfo){
		return service.deleteCombinationInfo(combinationinfo);
	}

	//查询所有的歌曲
	@RequestMapping("/findMusicInfo")
	public Map<String, Object> findMusicInfo(HttpServletRequest request, HttpServletResponse response,Integer pageNo,Integer pageSize,String mname){
		return service.findsMusicInfo(pageNo, pageSize,request,response,mname);
	}

	//删除单个的歌曲
	@RequestMapping("/deleteMusicInfo")
	public int deleteMusicInfo(MusicInfo musicInfo) {
		return service.deleteMusicInfo(musicInfo);
	}

	//查询所有的歌曲
	@RequestMapping("/participle")
	public int participle(HttpServletRequest request){
		List<Map<String, Object>> list=service.findpadd(request);
		return 1;
	}



}
