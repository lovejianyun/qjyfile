package com.qjy.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * @author qijianyun
 *
 */
public class CreateTextFile {
	public void createFile(String path) {
		Random r = new Random();
		File file = new File(path);
		if(!file.getParentFile().exists()) {
			file.mkdirs();
		}
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			PrintWriter pw = new PrintWriter(bos);
			for(int i=0;i<10000000;i++) {
				pw.write(UUID.randomUUID().toString()+","+r.nextInt(100000)+"\r\n");
			}
			pw.flush();
			pw.close();
			System.out.println("文件生成完毕!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
