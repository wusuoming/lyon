package net.slowvic.lang.basic;
//��̬����
import static java.lang.System.out;

class Base
{
	private String pStr ;
	//���ֻ�ṩprivate��������������޷����̳�
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
		super(pStr); //�޷����ʸ����private��Ա
	}
	
	public static void main(String[] args) throws Throwable
	{
		//λ����
		int a = 10;   //�����Ʊ�ʾ 00001010
		out.println(a>>1); //out:5 ����һλ�൱�ڳ���2 00000101
		out.println(a<<1); //out:20 ����һλ�൱�ڳ���2 00010010
		
		int b = -10; //�����Ʊ�ʾ 10001010
		out.println(b>>1); //����һλ��� 10000101  ע�� ����λ��������ƶ�
		out.println(Integer.toBinaryString(b>>>1)); //out:2147483643 �����������ڸ�λ��0 ע��û��<<<
		
		BaseKnowledge bk = new BaseKnowledge("1");
		bk.finalize();
		
		//System.getProperties().list(System.out);
		out.println(System.getProperty("user.name"));
		out.println(System.getProperty("file.encoding"));
	}

	
	//finalize���������ã�
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("BaseKnowledge�����ս�");
		super.finalize();
	}
}
