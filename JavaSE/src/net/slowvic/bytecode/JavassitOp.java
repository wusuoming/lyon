package net.slowvic.bytecode;

import java.io.FileOutputStream;
import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class JavassitOp {
	public static void main(String[] args) throws NotFoundException,
			CannotCompileException, IOException {
		ClassPool pool = ClassPool.getDefault();
		CtClass ctClass = pool.get(Bird.class.getName());
		ctClass.setSuperclass(pool.get(Animal.class.getName()));
		//ctClass.writeFile();
		byte[] buffer = ctClass.toBytecode();
		FileOutputStream fw = new FileOutputStream("D:/1.txt");
		fw.write(buffer);
	}
}
