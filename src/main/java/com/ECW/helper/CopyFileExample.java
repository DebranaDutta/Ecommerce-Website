package com.ECW.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileExample {
	public static void main(String[] args) {
		String src="/Users/debra/Downloads/Path1/img.jpg";
		String dest="/Users/debra/OneDrive/Desktop/Path2/img.jpg";
		File srcFile=new File(src);
		System.out.println(srcFile);
		
		File desFile=new File(dest);
		System.out.println(desFile);
		
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
		
		try {
			fileInputStream=new FileInputStream(srcFile);
			fileOutputStream=new FileOutputStream(desFile);
			System.out.println(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(fileInputStream.available());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int i=0;
		try {
			while((i=fileInputStream.read())!=-1) {
				fileOutputStream.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fileInputStream!=null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fileOutputStream!=null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
