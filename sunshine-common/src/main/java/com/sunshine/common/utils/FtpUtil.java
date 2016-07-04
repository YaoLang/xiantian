package com.sunshine.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * FTP上传下载工具
 * @author yaolang
 *
 */
public class FtpUtil {
	
	public final static Logger debug = Logger.getLogger(FtpUtil.class.getName());
	
	/**
	 * 上传文件到FTP服务器
	 * @param hostname 服务器地址
	 * @param port	          端口号
	 * @param username 用户名
	 * @param password 密码
	 * @param basePath 基路径
	 * @param filePath 文件路径
	 * @param filename 文件名
	 * @param input    输入流
	 * @return
	 */
	public static boolean uploadFile(String hostname,int port,String username,String password,String basePath,
			String filePath, String filename, InputStream input){
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(hostname, port);
			ftp.login(username, password);
			if(debug!=null)
				debug.info("user "+username+" connected into ftpserver"+hostname);
			
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				if(debug!=null)
					debug.info("username or password error");
				ftp.disconnect();
				return result;
			}
			//切换到上传目录
			if (!ftp.changeWorkingDirectory(basePath+filePath)) {
				//如果目录不存在创建目录
				String[] dirs = filePath.split("/");
				String tempPath = basePath;
				for (String dir : dirs) {
					if (null == dir || "".equals(dir)) continue;
					tempPath += "/" + dir;
					if (!ftp.changeWorkingDirectory(tempPath)) {
						if (!ftp.makeDirectory(tempPath)) {
							return result;
						} else {
							ftp.changeWorkingDirectory(tempPath);
						}
					}
				}
			}
			//设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			//上传文件
			if (!ftp.storeFile(filename, input)) {
				return result;
			}
			if(debug!=null)
				debug.info("upload success");
			input.close();
			ftp.logout();
			result = true;
		} catch (IOException e) {
			if(debug!=null)
				debug.info("file upload failed");
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}
	

	/**
	 * 从FTP下载文件
	 * @param hostname 服务器地址
	 * @param port	          端口号
	 * @param username 用户名
	 * @param password 密码
	 * @param remotePath 远程服务器相对路径
	 * @param fileName   文件名
	 * @param localPath  本地保存地址
	 * @return
	 */
	public static boolean downloadFile(String hostname, int port, String username, String password, String remotePath,
			String fileName, String localPath) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(hostname, port);
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			
			if(debug!=null)
				debug.info("user "+username+" connected into ftpserver"+hostname);
			
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return result;
			}
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());

					OutputStream is = new FileOutputStream(localFile);
					ftp.retrieveFile(ff.getName(), is);
					if(debug!=null)
						debug.info("download success");
					is.close();
				}
			}
			ftp.logout();
			result = true;
		} catch (IOException e) {
			if(debug!=null)
				debug.info("file upload failed");
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}
}
