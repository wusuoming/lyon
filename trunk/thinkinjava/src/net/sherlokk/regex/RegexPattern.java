package net.sherlokk.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(ab)?c+");
		Matcher matcher = pattern.matcher("abcabcabc");
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
}
