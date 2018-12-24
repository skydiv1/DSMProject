package com.kh.w7.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
		
	public File rename(File oldFile) {
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		
		int randomNumber = (int)(Math.random()*1000000);
		
		// 20181219120600+랜덤수로 겹치지 않게 파일 저장
		
		// 확장자명 가져오기
		String name = oldFile.getName();
		String body = null;
		String ext = null; // 확장자
		int dot = name.lastIndexOf(".");
		if(dot != -1) { // 확장자가 있는 경우
			body = name.substring(0, dot); // dot 전까지 자른다.
			ext = name.substring(dot); // 끝까지 자른다.
			
		}else { // 확장자가 없는 경우
			body = name;
			ext="";			
		}
		
		// 파일명 완성
		String fileName = ft.format(new Date(currentTime)) + randomNumber + ext ;
		
		//파일 객체 만들어서 리턴
		File newFile = new File(oldFile.getParent(), fileName); // 기존 객체를  만들어진 파일 객체로 바꿔서 리턴
		
		return newFile;
	}
		
}
