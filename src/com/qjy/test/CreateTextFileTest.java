package com.qjy.test;

import com.qjy.service.CreateTextFile;

/**
 * 
 * @author qijianyun
 *文件测试
 */
public class CreateTextFileTest {
	public static void main(String[] args) {
		CreateTextFile ctf = new CreateTextFile();
		ctf.createFile("/users/qijianyun/tempfile/qijy.txt");
	}
}
