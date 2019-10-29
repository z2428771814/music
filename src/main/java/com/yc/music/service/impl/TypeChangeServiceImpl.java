package com.yc.music.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public List<Map<String, Object>> findMusicInfo(Integer pageNo,Integer pageSize,String mname) {
		Map<String, Object> map=new HashMap<String,Object>();
		if( pageNo == 0 && pageSize == 0 ){
			if( mname == "" || mname.length()<=0  ){
				map.put("pageNo", null);
				map.put("pageSize", null);
				map.put("mname", null);
				return mapper.findMusicInfo(map);
			}else{
				map.put("mname", mname);
				map.put("pageNo", null);
				map.put("pageSize", null);
				return mapper.findMusicInfo(map);
			}
			
		}else{
			if( mname == "" || mname.length()<=0  ){
				map.put("pageNo", (pageNo-1)*pageSize);
				map.put("pageSize", pageSize);
				map.put("mname", null);
				return mapper.findMusicInfo(map);
			}else{
				map.put("mname", mname);
				map.put("pageNo", (pageNo-1)*pageSize);
				map.put("pageSize", pageSize);
				return mapper.findMusicInfo(map);
			}
			
		}
		
	}


	@Override
	public Map<String, Object> findsMusicInfo(Integer pageNo,Integer pageSize,HttpServletRequest request, HttpServletResponse response,String mname) {
		//获取我们tomcat所在的路径
		String path = request.getServletContext().getRealPath(""); //这个是获取服务器路径  D:\tomcat\apache-tomcat-8.5.41\webapps\music\
		path=path.substring(0,(path.length()-6));
		List<CombinationInfo> com=this.findCombinationInfo();
		
		
		//这个是查询全部
		List<Map<String, Object>> mu=this.findMusicInfo(0,0,mname);
		//这个是首页的分页查询
		List<Map<String, Object>> music=this.findMusicInfo(pageNo,pageSize,mname);
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
			if( music.get(i).get("lyricaddr") != null && music.get(i).get("lyricaddr") != ""){
				path+=music.get(i).get("lyricaddr");
				try {
					InputStream is = new FileInputStream(path);
					byte[] b = new byte[is.available()];//把所有的数据读取到这个字节当中
					//完整的读取一个文件
					is.read(b);
					music.get(i).put("lyricaddr", new String(b));//把我们的歌词返回获取
					//关闭流
					is.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
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
