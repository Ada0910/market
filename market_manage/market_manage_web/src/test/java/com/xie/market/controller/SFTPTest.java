package com.xie.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.jcraft.jsch.SftpException;
import com.xie.common.utils.SFtpUtil;

public class SFTPTest {
	
	@Test
	public  void testSFtpUtil()  throws SftpException, IOException {
		SFtpUtil sftp = new SFtpUtil("root", "xieweining0728", "172.22.4.119", 22);
		sftp.login();
		File file = new File("C:\\Users\\xjh3373199\\Desktop\\hi.jpg");
		InputStream is = new FileInputStream(file);

		sftp.upload("/home/ada/www/", "images", "test_sftp.jpg", is);
		sftp.logout();
	}

}
