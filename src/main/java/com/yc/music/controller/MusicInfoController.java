package com.yc.music.controller;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public List<MusicInfo> newSong(Integer total, Integer page, Integer rows) {
		return service.newSong(total,page, rows);
	}

	//查询地区歌曲
	@RequestMapping("/seleAddr")
	public List<MusicInfo> seleAddr(String addr,Integer total, Integer page, Integer rows) {
		return service.seleAddr(addr, total, page, rows);
	}

	//查询分页最新歌曲
	//	@RequestMapping("/findByPage")
	//	public List<MusicInfo> findByPage(Integer total, Integer page, Integer rows) {
	//		return service.newSong(total,page, rows);
	//	}

	//查询歌曲详细信息
	@RequestMapping("/songDetail")
	public MusicInfo songDetail(Integer mid) {
		return service.songDetail(mid);

	}

	//查询所有地区
	@RequestMapping("/singType")
	public List<SingerInfo> singType() {
		return service.singType();
	}

	//歌手展示
	@RequestMapping("/singerShow")
	public List<SingerInfo> singerShow(Integer page, Integer rows) {
		return service.singerShow(page, rows);
	}

	@RequestMapping("/findByFirst")
	public Map<String, Object> findByFirst(Integer page, Integer rows) {
		return service.findByFirst(page, rows);
	}

	//查询地区歌手
	@RequestMapping("/addrFirst")
	public Map<String, Object> addrFirst(String addr, Integer page, Integer rows) {
		return service.addrFirst(addr, page, rows);
	}

	//根据性别查询歌手
	@RequestMapping("/findSex")
	public List<SingerInfo> findSex(String sex, Integer page, Integer rows) {
		return service.findSex(sex, page, rows);
	}

	//根据字母查询歌手
	@ResponseBody
	@RequestMapping("/findLet")
	public Map<String, Object> findLet(String addr, String sex, String genre, Integer start, Integer stop, String let, Integer page, Integer rows) {
		return service.letterFirst(addr, sex, genre, start, stop, let, page, rows);
	}
}
