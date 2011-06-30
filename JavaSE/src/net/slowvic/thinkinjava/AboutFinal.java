package net.slowvic.thinkinjava;

/*
 * static final 必须在声明时初始化
 * final 可以在声明时，也可以在构造器中进行初始化
 * 当final修饰的是对象时，仅仅表示对象引用不可变，并不表示对象本身不可变
 * final修饰参数时，该参数在方法内部拥有和以上相同的限制
 */
public class AboutFinal
{
	public static final int DATA_OF_MONTH = 1;
	
	public AboutFinal(String s,int i)
	{
		init(s,i);
	}
	
	private void init(final String s,final int i)
	{
		//! s = s.substring(0,s.length()-1); 无法通过编译
		//! i++; 无法通过编译
	}
}
