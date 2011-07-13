package net.slowvic.lang.basic;
//静态导入
import static java.lang.System.out;

class Base
{
	private String pStr ;
	//如果只提供private构造器，则该类无法被继承
	public Base(String pStr)
	{
		this.pStr = pStr;
		out.println(this.pStr);
	}
}

public class BaseKnowledge extends Base
{
	public BaseKnowledge(String pStr)
	{
		super(pStr); //无法访问父类的private成员
	}
	
	public static void main(String[] args) throws Throwable
	{
		//位操作
		int a = 10;   //二进制表示 00001010
		out.println(a>>1); //out:5 右移一位相当于除以2 00000101
		out.println(a<<1); //out:20 左移一位相当于乘以2 00010010
		
		int b = -10; //二进制表示 10001010
		out.println(b>>1); //右移一位变成 10000101  注意 符号位不会跟着移动
		out.println(Integer.toBinaryString(b>>>1)); //out:2147483643 无论正负，在高位补0 注意没有<<<
		
		BaseKnowledge bk = new BaseKnowledge("1");
		bk.finalize();
		
		//System.getProperties().list(System.out);
		out.println(System.getProperty("user.name"));
		out.println(System.getProperty("file.encoding"));
	}

	
	//finalize方法，慎用！
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("BaseKnowledge对象被终结");
		super.finalize();
	}
}
