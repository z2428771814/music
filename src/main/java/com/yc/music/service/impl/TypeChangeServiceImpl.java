package com.yc.music.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.CombinationInfo;
import com.yc.music.bean.MusicInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.mapper.ITypeChangeMapper;
import com.yc.music.service.ITypeChangeService;
import com.yc.music.util.StringUtil;

@Service
public class TypeChangeServiceImpl implements ITypeChangeService {
	
	@Autowired
	private ITypeChangeMapper mapper;

	
	public int addApplicationType(ApplicationTypeInfo alt) {
		if( StringUtil.checkNull( alt.getAtname() ) ){
			return -1;
		}
		return mapper.addApplicationType(alt);
	}


	@Override
	public List<ApplicationTypeInfo> findApplicationType() {
		return mapper.findApplicationType();
	}


	@Override
	public int deleteApplicationType(ApplicationTypeInfo alt) {
		return mapper.deleteApplicationType(alt);
	}


	@Override
	public int deleteSongTypeInfo(ApplicationTypeInfo alt) {
		return mapper.deleteSongTypeInfo(alt);
	}


	@Override
	public int addSongType(int aitd,String stype) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("atid", aitd);
		map.put("stype", stype);
		return mapper.addSongType(map);
	} 


	@Override
	public List<SongTypeInfo> findByAtidSongType(int atid) {
		return mapper.findByAtidSongType(atid);
	}


	@Override
	public int deleteSongType(int sid) {
		return mapper.deleteSongType(sid);
	}


	@Override
	public int addSingerInfo(SingerInfo singerInfo) {
		if( StringUtil.checkNull( singerInfo.getAddr(),singerInfo.getSgname(),singerInfo.getGenre(),singerInfo.getSex() ) ){
			return -1;
		}
		return mapper.addSingerInfo(singerInfo);
	}


	@Override
	public List<SingerInfo> findSingerInfo() {
		return mapper.findSingerInfo();
	}


	@Override
	public int deleteSingerInfo(SingerInfo singerInfo) {
		return mapper.deleteSingerInfo(singerInfo);
	}


	@Override
	public List<SingerInfo> pagingSingerInfo(Integer pageNo, Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		pageNo = (pageNo-1)*pageSize;
		if( pageNo <=0 ){
			pageNo = 0;
		}
		map.put("pageNo", pageNo);
		
		map.put("pageSize", pageSize);
		return mapper.pagingSingerInfo(map);
	}


	@Override
	public int deleteSingerInfoMusicinfo(SingerInfo singerInfo) {
		return mapper.deleteSingerInfoMusicinfo(singerInfo);
	}


	@Override
	public int addCombinationInfo(CombinationInfo combinationinfo) {
		if( StringUtil.checkNull( combinationinfo.getCname() ) ){
			return -1;
		}
		return mapper.addCombinationInfo(combinationinfo);
	}


	@Override
	public List<CombinationInfo> findCombinationInfo() {
		return mapper.findCombinationInfo();
	}


	@Override
	public int deleteCombinationInfo(CombinationInfo combinationinfo) {
		return mapper.deleteCombinationInfo(combinationinfo);
	}


	@Override
	public List<CombinationInfo> pagingCombinationInfo(Integer pageNo, Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		pageNo = (pageNo-1)*pageSize;
		if( pageNo <=0 ){
			pageNo = 0;
		}
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		return mapper.pagingCombinationInfo(map);
	}


	@Override
	public int addMusicInfo(MusicInfo musicinfo, String sgname, String cname) {
		if( sgname != "" || sgname != null ){
			SingerInfo singerInfo=mapper.findbySingerInfoId(sgname);
			if( singerInfo != null){
				musicinfo.setSgid( singerInfo.getSgid()  );
			}else{
				return -1;
			}
		}else if( cname != "" || cname != null  ){
			CombinationInfo combinationInfo=mapper.findByCombinationInfoId(cname);
			if( combinationInfo!=null ){
				musicinfo.setCid( combinationInfo.getCid() );
			}else{
				return -1;
			}
		}else{
			return -1;
		}
		System.out.println( musicinfo );
		return mapper.addMusicInfo(musicinfo);
	}


	@Override
	public List<Map<String, Object>> findMusicInfo(Integer pageNo,Integer pageSize) {
		Map<String, Object> map=new HashMap<String,Object>();
		if( pageNo == 0 && pageSize == 0 ){
			map.put("pageNo", null);
			map.put("pageSize", null);
			return mapper.findMusicInfo(map);
		}else{
			map.put("pageNo", (pageNo-1)*pageSize);
			map.put("pageSize", pageSize);
			return mapper.findMusicInfo(map);
		}
		
	}


	@Override
	public Map<String, Object> findsMusicInfo(Integer pageNo, Integer pageSize) {
		List<CombinationInfo> com=this.findCombinationInfo();
		//这个是查询全部
		List<Map<String, Object>> mu=this.findMusicInfo(0,0);
		//这个是首页的分页查询
		List<Map<String, Object>> music=this.findMusicInfo(pageNo,pageSize);
		for( int i=0;i<music.size();i++ ){
			int cid= (int) music.get(i).get("cid");
			if( cid != 0 ){
				String cname="";
				for(int j=0;i<com.size();j++){
					if( cid == com.get(j).getCid() ){
						music.get(i).put("sgname",com.get(j).getCname() );
					}
				}
			}
		}
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("total", mu.size());
		map.put("music", music);
		return map;
	}


	@Override
	public int deleteMusicInfo(MusicInfo musicInfo) {
		return mapper.deleteMusicInfo(musicInfo);
	}

}
