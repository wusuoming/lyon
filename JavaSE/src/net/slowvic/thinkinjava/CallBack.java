package net.slowvic.thinkinjava;
/**
 * 
 * @author xus
 * 用匿名内部类来实现回调
 */
public class CallBack
{
	public static void main(String[] args)
	{
		Printer p = new Printer();
		p.setCallBack(new ICallBack(){ //匿名内部类，可以每次实现不一样的业务逻辑
			@Override
			public void print()
			{
				System.out.println("一二三四一二三四像首歌");
			}
		});
		p.execute();
	}
}

//回调接口
abstract class ICallBack
{
	abstract void print();
}

//API实现类
class Printer
{
	private ICallBack cb;
	
	public void setCallBack(ICallBack cb)
	{
		this.cb = cb;
	}
	
	public void execute()
	{
		/**
		 * 固定算法
		 */
		cb.print(); //由外界实现
		/**
		 * 固定算法
		 */
	}
}