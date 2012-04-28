package net.sherlokk.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedInputFile {
	public static void readFile(String filePath) throws IOException {
		// windows下，文本文件默认编码为ANSI，即GBK，因此需要转码
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath), "GBK"));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = in.readLine()) != null) {
			sb.append(line).append("\n");
		}
		in.close();
		System.out.println(sb.toString());
	}

	public static void writeFile(String content) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(
						"C:\\Documents and Settings\\xus\\桌面\\help.txt", true),
				"GBK"));
		out.append(content);
		out.close();
	}

	public static void main(String[] args) throws IOException {
		readFile("C:\\Documents and Settings\\xus\\桌面\\help.txt");
		writeFile("\n试试看");
	}
}
