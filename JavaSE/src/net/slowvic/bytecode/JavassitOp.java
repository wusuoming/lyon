package net.slowvic.bytecode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.Loader;
import javassist.NotFoundException;

public class JavassitOp {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        method3(pool);
    }

    public static void method3(ClassPool pool) throws Exception {
        CtClass cc = pool.get("net.slowvic.bytecode.Bird");
        Loader loader = new Loader(pool);
        cc.setSuperclass(pool.get("net.slowvic.bytecode.Animal"));
        Object o = loader.loadClass("net.slowvic.bytecode.Bird").newInstance();
        System.out.println(o);
    }

    public static void method2(ClassPool pool) throws NotFoundException,
        IOException, CannotCompileException {
        CtClass cc = pool.makeClass("Point");
        cc.writeFile();
    }

    public static void method01() throws NotFoundException,
        CannotCompileException, IOException, FileNotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get(Bird.class.getName());
        ctClass.setSuperclass(pool.get(Animal.class.getName()));
        ctClass.writeFile(); // 在当前项目目录下按全路径名生成目录和class文件
        byte[] buffer = ctClass.toBytecode(); // 转成二进制数据
        FileOutputStream fw = new FileOutputStream("D:/1.class");
        fw.write(buffer);
    }
}
