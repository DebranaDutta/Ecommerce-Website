package com.ECW.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

public class fileInputOutput {
	public static boolean saveFile(InputStream inputStream, String path) {
		boolean status=false;
		try {
			byte data[]=new byte[inputStream.available()];
			inputStream.read(data);
			FileOutputStream fileOutputStream=new FileOutputStream(path);
			fileOutputStream.write(data);
			fileOutputStream.flush();
			fileOutputStream.close();
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
