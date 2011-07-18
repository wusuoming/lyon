package net.slowvic.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BaiduReder {
	public static void main(String[] args) throws IOException{
		URL baidu = new URL("http://www.baidu.com");
		URLConnection conn = baidu.openConnection();
		//尽量使用Reader来读取，它是基于Unicode的，使用InputStream可能会乱码
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String temp = null;
		while((temp = br.readLine())!=null){
			System.out.println(temp);
		}
	}
}
