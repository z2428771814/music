package com.yc.music.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/upload")
public class FileUoladController {


	@RequestMapping("/addGood")
	public int addGood(@RequestParam("lc")MultipartFile[] pics,HttpServletRequest request   ){
		System.out.println( pics );
		//说明有图片
			try {
				String savepath="pics";
				
				String basepath = request.getServletContext().getRealPath("");
				String temp = request.getServletContext().getInitParameter("uploadPaht");

				if( temp!=null ){
					savepath=temp;
				}
				
				String picstr="";
				File dest=null;
				String path=null;
				
				//开始循环图片循环上传
				for(MultipartFile f1:pics  ){
					System.out.println("参数为"+f1);
					path=savepath+"/" + new Date().getTime()+"_"+f1.getOriginalFilename(); //  pics/1570609193550_qq.png
					dest=new File( new File(basepath).getParentFile(),path );
					f1.transferTo(dest);
					picstr+=path+";";
				}
				System.out.println( picstr );
				if( !"".equals(picstr) ){
					picstr=picstr.substring(0,picstr.lastIndexOf(";"));
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return 0;
		
	
	}
	
	
}
