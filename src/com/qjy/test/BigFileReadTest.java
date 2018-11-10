package com.qjy.test;

import com.qjy.interfaces.IHandle;
import com.qjy.service.BigFileReader;
import com.qjy.service.HandImpl;

/**
 * 
 * @author qijianyun
 *大文件读取
 */
public class BigFileReadTest {
	public static void main(String[] args) {
		IHandle handle = new HandImpl();
		BigFileReader.Builder builder = new BigFileReader.Builder("/Users/qijianyun/tempfile/qijy.txt",handle);
		builder.withTreahdSize(10)
			   .withCharset("utf-8")
			   .withBufferSize(1024*1024); 
		BigFileReader bigFileReader = builder.build();
		bigFileReader.start();
}
}
