package net.slowvic.thinkinjava;
/**
 * 
 * @author xus
 * �������ڲ�����ʵ�ֻص�
 */
public class CallBack
{
	public static void main(String[] args)
	{
		Printer p = new Printer();
		p.setCallBack(new ICallBack(){ //�����ڲ��࣬����ÿ��ʵ�ֲ�һ����ҵ���߼�
			@Override
			public void print()
			{
				System.out.println("һ������һ���������׸�");
			}
		});
		p.execute();
	}
}

//�ص��ӿ�
abstract class ICallBack
{
	abstract void print();
}

//APIʵ����
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
		 * �̶��㷨
		 */
		cb.print(); //�����ʵ��
		/**
		 * �̶��㷨
		 */
	}
}