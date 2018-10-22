package com.xie.market.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xie.common.utils.IDUtils;
import com.xie.common.utils.SFtpUtil;
import com.xie.market.service.PictureService;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	
	@Value("${SFTP_ADDRESS}")
	private String SFTP_ADDRESS;
	
	@Value("${SFTP_PORT}")
	private Integer SFTP_PORT;
	
	@Value("${SFTP_USERNAME}")
	private String SFTP_USERNAME;
	
	@Value("${SFTP_PASSWORD}")
	private String SFTP_PASSWORD;
	
	@Value("${SFTP_BASEPATH}")
	private String SFTP_BASEPATH;
	
	@Value("${SFTP_DIRECTORY}")
	private String SFTP_DIRECTORY;
	

	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		
		Map<String,Object> resultMap  = new HashMap<>();
		try {
			//取出久的文件名
			String oldName = uploadFile.getOriginalFilename();
			
			//生成新的名字
			String newName = IDUtils.getImageName();
			
			//新名字加上原来的名字
			newName = newName +oldName.substring(oldName.lastIndexOf("."));
			 
			SFtpUtil sFtpUtil = new SFtpUtil(SFTP_USERNAME,SFTP_PASSWORD,SFTP_ADDRESS,SFTP_PORT);
			sFtpUtil.login();
			
			//图片上传
			sFtpUtil.upload(SFTP_BASEPATH, SFTP_DIRECTORY, newName, uploadFile.getInputStream());
			
			sFtpUtil.logout();
			resultMap.put("error",0);
			resultMap.put("url",SFTP_BASEPATH+SFTP_DIRECTORY+"/"+newName );
			return resultMap;
			
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
		
	}

}
