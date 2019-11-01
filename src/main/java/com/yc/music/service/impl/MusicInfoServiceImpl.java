package com.yc.music.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.mapper.IMusicInfoMapper;
import com.yc.music.redis.dao.IRedisDao;
import com.yc.music.service.IMusicInfoService;
@Service
public class MusicInfoServiceImpl implements IMusicInfoService {

	@Autowired
	private IMusicInfoMapper mapper;
	
	@Autowired
	private IRedisDao redisDao;

	//查询所有地区
	@Override
	public List<SingerInfo> findAddr() {
		return mapper.findAddr();
	}

	//查询最新歌曲信息
	@Override
	public List<MusicInfo> newSong(int total, int page, int rows) {
		int pages = (int) Math.ceil(total / rows);
		//page = Math.min(page, pages);
		if (page > pages) {
			page = 1;
		} else if (page < 1) {
			page = pages;
		}
		//page = Math.max(page, 1);
		
		System.out.println(page +"*************page");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("total", total);
		map.put("page",(page - 1) * rows);
		map.put("rows",rows);
		return mapper.newSong(map);
	}

	//查询歌曲详细信息
	@Override
	public MusicInfo songDetail(int mid) {
		return mapper.songDetail(mid);
	}

	//根据地区查询歌曲
	@Override
	public List<MusicInfo> seleAddr(String addr,int total, int page, int rows) {
		int pages = (int) Math.ceil(total / rows);
		//page = Math.min(page, pages);
		if (page > pages) {
			page = 1;
		} else if (page < 1) {
			page = pages;
		}
		//page = Math.max(page, 1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addr", addr);
		map.put("total", total);
		map.put("page",(page - 1) * rows);
		map.put("rows",rows);
		return mapper.seleAddr(map);
	}

	//查询所有歌手类型
	@Override
	public List<SingerInfo> singType() {
		return mapper.singType();
	}

	//歌手展示
	@Override
	public List<SingerInfo> singerShow(int page, int rows) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page - 1) * rows);	
		map.put("rows",rows);
		return mapper.singerShow(map);
	}

	@Override
	public Map<String, Object> findByFirst(int page, int rows) {
		int count = mapper.singerNum();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);								
		map.put("singer", this.singerShow(page, rows));
		return map;
	}
	
	//地区歌手数量
	@Override
	public Map<String, Object> addrFirst(String addr, int page, int rows) {
		int count = mapper.addrNum(addr);
		System.out.println(count + "shulsds");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("addr", this.findAddrSinger(addr, page, rows));
		return map;
	}

	//查询地区歌手
	@Override
	public List<SingerInfo> findAddrSinger(String addr, int page, int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addr", addr);
		map.put("page",(page - 1) * rows);
		map.put("rows",rows);
		return mapper.findAddrSinger(map);
	}

	//根据性别查歌手
	@Override
	public List<SingerInfo> findSex(String sex, int page, int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sex", sex);
		map.put("page",(page - 1) * rows);
		map.put("rows",rows);
		return mapper.findSex(map);
	}

	//根据字母查询歌手
	@Override
	public List<SingerInfo> findletter(String addr, String sex, String genre, Integer start, Integer stop, String let, Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addr", addr);
		map.put("sex", sex);
		map.put("genre", genre);
		map.put("start", start);
		map.put("stop", stop);
		map.put("let", let);
		map.put("page", (page - 1) * rows);
		map.put("rows", rows);
		System.out.println(map + "***12346map");
		return mapper.findlet(map);
	}
	
	@Override
	public Map<String, Object> letterFirst(String addr, String sex, String genre, Integer start, Integer stop, String let, Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addr", addr);
		map.put("sex", sex);
		map.put("genre", genre);
		map.put("start", start);
		map.put("stop", stop);
		map.put("let", let);
		Integer count = mapper.letterNum(map);
		System.out.println(map + "map**********");
//		if(count == null) {
//			count = 0;
//		}
		System.out.println(count + "caonoma");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("count", count);
		map1.put("letter", this.findletter(addr, sex, genre, start, stop, let, page, rows));
		System.out.println(map1 + "**********************数据");
		return map1;
	}

	
	
}
