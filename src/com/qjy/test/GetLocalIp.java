package com.qjy.test;

import java.net.InetAddress;

public class GetLocalIp {
	public static void main(String[] args) {
		getLocalHost();
	}
	public static void getLocalHost() {
	    String crunchifyHost = null;
	    try {
	        crunchifyHost = InetAddress.getLocalHost().getCanonicalHostName();   // This line was throwing above exception
	    } catch (Exception e) {
	        throw new RuntimeException("Error. Failed to retrive crunchifyHost:" + e);
	    }
	    System.out.println(crunchifyHost);
	}
}
