package com.ECW.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.FileCopyUtils;

public class fileInputOutput {
	public static boolean deleteFile(String path) {
		boolean status = false;
		try {
			File file = new File(path);
			status = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean saveFile(InputStream inputStream, String path) {
		boolean status = false;
		try {
			byte data[] = new byte[inputStream.available()];
			inputStream.read(data);
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			fileOutputStream.write(data);
			fileOutputStream.flush();
			fileOutputStream.close();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static void fileCopy(String AdminPath, String UserPath){
		File srcFile=new File(AdminPath);
		File destFile=new File(UserPath);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
