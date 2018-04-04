package ru.ksenomorf.xyinizator;

import java.util.StringJoiner;

public class Xyinizator {
	static String glasniye = "аоуэиыеёяю";
	public static String performText(String text) {
		StringJoiner stringJoiner = new StringJoiner(" ");
		String[] textAsArgs = text.split(" ");
		
		for(String s : textAsArgs) {
			if(!(s.length() <= 4)) {
				String last3Chars = s.substring(s.length() - 4);
				String last3 = String.valueOf(last3Chars.charAt(0));
				
				boolean flag1 = isFirstLetterIsVowel(last3Chars);
				String cykaRegex = "-ху";
				if(!flag1) {
					cykaRegex += "я";
				}
				
				boolean flag2 = last3.equals("о");
				if(flag2) {
					StringBuffer buffer = new StringBuffer(last3Chars);
					buffer.setCharAt(0, 'ё');
					last3Chars = buffer.toString();
				}
				
				stringJoiner.add(s + cykaRegex + last3Chars);
			}else if(s.length() <= 4 && s.length() >= 2) {
				String last2Chars = s.substring(s.length() - 2);
				String cykaRegex = "-ху";
				
				boolean flag1 = isFirstLetterIsVowel(last2Chars);
				if(!flag1) cykaRegex += "ю";
				
				stringJoiner.add(s + cykaRegex + last2Chars);
			}
		}
		
		if(stringJoiner.length() == 0) return "text is empty ;("; else
		return stringJoiner.toString();
	}
	
	public static boolean isFirstLetterIsVowel(String inputStr) {
		return glasniye.indexOf(inputStr) != -1;
	}
}
