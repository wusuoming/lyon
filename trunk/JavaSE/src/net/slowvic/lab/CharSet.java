package net.slowvic.lab;

import java.io.UnsupportedEncodingException;

public class CharSet {
    public static void main(String[] args) throws UnsupportedEncodingException{
        String utf = "我来了";
        byte[] utfBytes = utf.getBytes("UTF-8");
        printBytes(utfBytes);
        String gbk = new String(utf.getBytes("UTF-8"),"gbk");
        byte[] gbkBytes = gbk.getBytes("gbk");
        printBytes(gbkBytes);
        String iso = new String(utf.getBytes("UTF-8"),"iso8859-1");
        byte[] isoBytes = iso.getBytes("iso8859-1");
        printBytes(isoBytes);
    }
    
    public static void printBytes(byte[] bytes){
        for(int i=0;i<bytes.length;i++){
            System.out.print(bytes[i]+" ");
        }
        System.out.println();
    }
}
