package net.slowvic.patterns;

/**
 * ����¼ģʽ
 * <p>
 * ����¼��ɫ��<br>
 * A����������(Organizer)������ڲ�״̬�����������ɸ��ݷ����˵��ж��������洢�����ڲ�״̬<br>
 * B�����������ݲ���������֮����κζ�������ȡ<br>
 * խ�ӿڣ�ֻ����ѱ���¼���󴫵ݸ������Ķ�����������(Caretaker)�������Ƿ����˽�ɫ<br>
 * ��ӿڣ������ȡ�������ݣ��������˽�ɫ
 * <p>
 * �����˽�ɫ��<br>
 * A������һ��������ǰ�ڲ�״̬�ı���¼����<br>
 * B��ʹ�ñ���¼����洢���ڲ�״̬
 * <p>
 * �����˽�ɫ��<br>
 * A�����汸��¼����<br>
 * B������鱸��¼���������
 */
public class Memento {
	public static void main(String[] args) {

	}
}

class Organizer{
	private String state;
	
	public Organizer(){}
	
	public IMemo createMemo(){
		return new Memo(state);
	}
}