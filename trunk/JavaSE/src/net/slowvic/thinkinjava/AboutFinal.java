package net.slowvic.thinkinjava;

/*
 * static final ����������ʱ��ʼ��
 * final ����������ʱ��Ҳ�����ڹ������н��г�ʼ��
 * ��final���ε��Ƕ���ʱ��������ʾ�������ò��ɱ䣬������ʾ�������ɱ�
 * final���β���ʱ���ò����ڷ����ڲ�ӵ�к�������ͬ������
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
		//! s = s.substring(0,s.length()-1); �޷�ͨ������
		//! i++; �޷�ͨ������
	}
}
