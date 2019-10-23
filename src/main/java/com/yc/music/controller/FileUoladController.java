package com.yc.music.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yc.music.bean.CombinationInfo;
import com.yc.music.bean.SingerInfo;
import com.yc.music.service.ITypeChangeService;



@RestController
@RequestMapping("/file")
public class FileUoladController {

	@Autowired
	private ITypeChangeService service;

	//添加歌手图片和歌手
	@RequestMapping("/addSingerInfo")
	public int addSingerInfo(@RequestParam("pic")MultipartFile pic,HttpServletRequest request,SingerInfo singerInfo ){
		
		
		if( pic.isEmpty() ){
			return -1;
		}
		
		try {
			String savepath="pics";
			
			String path = request.getServletContext().getRealPath(""); //这个是获取服务器路径  D:\tomcat\apache-tomcat-8.5.41\webapps\music\
			String temp = request.getServletContext().getInitParameter("uploadPaht");
			
			if( temp!=null ){
				savepath=temp;
			}
			
			//在用户上传图片前面加上时间
			savepath+="/" + new Date().getTime()+"_"+pic.getOriginalFilename(); //  pics/1570609193550_qq.png
			System.out.println( savepath );
			File dest=new File( new File(path).getParentFile(),savepath );
			//将文件保存到本地路径
			pic.transferTo(dest);
			
			singerInfo.setBy1(savepath);
			
		
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return  service.addSingerInfo(singerInfo);
	}
	
	//添加组合图片和组合
	@RequestMapping("/addCombinationInfo")
	public int addCombinationInfo(@RequestParam("pic")MultipartFile pic,HttpServletRequest request,CombinationInfo combinationInfo ){
		
		
		if( pic.isEmpty() ){
			return -1;
		}
		
		try {
			String savepath="pics";
			
			String path = request.getServletContext().getRealPath(""); //这个是获取服务器路径  D:\tomcat\apache-tomcat-8.5.41\webapps\music\
			String temp = request.getServletContext().getInitParameter("uploadPaht");
			
			if( temp!=null ){
				savepath=temp;
			}
			
			//在用户上传图片前面加上时间
			savepath+="/" + new Date().getTime()+"_"+pic.getOriginalFilename(); //  pics/1570609193550_qq.png
			System.out.println( savepath );
			File dest=new File( new File(path).getParentFile(),savepath );
			//将文件保存到本地路径
			pic.transferTo(dest);
			
			combinationInfo.setBy1(savepath);
			
		
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return  service.addCombinationInfo(combinationInfo);
	}
	
}
