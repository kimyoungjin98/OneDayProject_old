package com.callor.score.service;

public class LinesSerivce {

	public static String dLines(int length) {
		String dLine = "";
		for(int i = 0 ; i < length ; i++) {
			dLine+= "=";
		}
		return dLine;
	}
	
	public static String sLines(int length) {
		String sLine = "";
		for(int i = 0 ; i < length ; i++) {
			sLine+= "=";
		}
		return sLine;
	}
	
}
