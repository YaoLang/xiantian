package com.taotao.common.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSClient;
import org.junit.Test;

public class FTPTest {

	public static void main(String[] args) {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect("192.168.206.130", 21);
			ftpClient.login("kong", "123");
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			
			File file = new File("C:\\Users\\Administrator\\Desktop\\架构设计.png");
			InputStream in = new FileInputStream(file);
			System.out.println(file.exists());
			if(!file.exists())
				return;
			ftpClient.changeWorkingDirectory("/home/kong/Desktop");
			String newName = "abc"+file.getName().substring(file.getName().lastIndexOf('.'));
			ftpClient.storeFile("abc.png",in);
			in.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				ftpClient.logout();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void testUpload(){
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect("192.168.206.130", 21);
			ftpClient.login("kong", "123");
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			
			File file = new File("C:\\Users\\Administrator\\Desktop\\架构设计.png");
			InputStream in = new FileInputStream(file);
			System.out.println(file.exists());
			if(!file.exists())
				return;
			ftpClient.changeWorkingDirectory("/home/kong/Desktop");
			String newName = "abc"+file.getName().substring(file.getName().lastIndexOf('.'));
			ftpClient.storeFile("abc.png",in);
			in.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				ftpClient.logout();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void testDownLoad(){
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect("192.168.130.129", 21);
			ftpClient.login("kong", "123");
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	/*		int reply = ftpClient.getReplyCode();
			System.out.println(reply);
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				return;
			}*/
			File file = new File("C:\\Users\\Administrator\\Desktop\\架构设计.png");
			InputStream in = new FileInputStream(file);
			System.out.println(file.exists());
			if(!file.exists())
				return;
			ftpClient.changeWorkingDirectory("/");
//			String newName = "abc"+file.getName().substring(file.getName().lastIndexOf('.'));
//			ftpClient.storeFile("abc.png",in);
			
			FTPFile[] files = ftpClient.listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
			in.close();
		} catch (SocketException e) {
			if(ftpClient!=null)
				System.out.println(ftpClient.getReplyCode());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				ftpClient.logout();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
