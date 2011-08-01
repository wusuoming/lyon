package net.slowvic.patterns;

/**
 * ������ģʽ
 * <p>
 * һ���򵥵�����<br>
 * ���û���¼��������󣬷������´���
 */
public class ChainOfResp {
	public static void main(String[] args) {
		Handler han1 = new ConcreteHandler("1");
		Handler han2 = new ConcreteHandler("2");
		Handler han3 = new ConcreteHandler("3");
		Handler han4 = new ConcreteHandler("4");
		han1.setSuccessor(han4);
		han4.setSuccessor(han2);
		han2.setSuccessor(han3);
		han1.handleRequest();
	}
}

/**
 * �����ɫ
 * <p>
 * �����¼ҵ�����
 */
abstract class Handler {
	private Handler successor;

	public Handler getSuccessor() {
		return successor;
	}

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	abstract void handleRequest();
}

/**
 * �����ɫ
 * <p>
 * �ж��Ƿ����δ��ݸ��¼�
 */
class ConcreteHandler extends Handler {
	private String id;

	public ConcreteHandler(String id) {
		this.id = id;
	}

	@Override
	void handleRequest() {
		Handler handle = getSuccessor();
		if (handle != null) {
			handle.handleRequest();
		} else {
			System.out.printf("����%s�ţ��ҽ�������Զ��ج�Σ���ס�ҵ����ְɣ�", id);
		}
	}
}