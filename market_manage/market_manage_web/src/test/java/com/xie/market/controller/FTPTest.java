package com.xie.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {

	@Test
	public void testFtp() throws Exception{
		// 创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		// 连接
		ftpClient.connect("192.168.1.106", 22);
		// 登录
		ftpClient.login("root", "xieweining0728");
		// 文件输入流
		InputStream local = new FileInputStream(new File("C:\\Users\\xjh3373199\\Desktop\\hi.jpg"));

		// 修改上传文件的格式
		ftpClient.changeWorkingDirectory("/home/ada/www/images");
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.storeFile("happy.jpg", local);
		ftpClient.logout();

	}
	
	

}
