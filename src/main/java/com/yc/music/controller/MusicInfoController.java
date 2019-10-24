package com.yc.music.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.service.IMusicInfoService;



@RestController
@RequestMapping("/music")
public class MusicInfoController {
	
	@Autowired
	private IMusicInfoService service;
	
	//查询所有地区
	@RequestMapping("/findAddr")
	public List<SingerInfo> findAddr() {
		return service.findAddr();
	}
	
	//查询最新歌曲
	@RequestMapping("/newSong")
	public List<MusicInfo> newSong() {
		return service.newSong();
	}
	
	//查询歌曲详细信息
	@RequestMapping("/songDetail")
	public MusicInfo songDetail(Integer mid) {
		return service.songDetail(mid);
		
	}
}
