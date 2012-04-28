package net.sherlokk.io;

import java.io.File;

public class FileCounter {
	public static int countFile(File file) {
		int count = 0;
		if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			for (int i = 0; i < subFiles.length; i++) {
				count += countFile(subFiles[i]);
			}
		} else {
			count = 1;
		}
		return count;
	}

	public static void main(String[] args) {
		File file = new File("E:\\学习书籍\\书籍");
		System.out.println("共计" + countFile(file) + "个文件");
	}
}
