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
		Organizer o = new Organizer();
		Caretaker c = new Caretaker();
		// ������״̬Ϊon
		o.setState("on");
		// �����˴�������¼�������˱��洴���ı���¼
		c.saveMemo(o.createMemo());
		// ������״̬���Ϊoff
		o.setState("off");
		// ������״̬�ָ��������˱����ģʽ
		o.restoreMemo(c.retrieveMemo());
		System.out.println(o.getState());
	}
}

/**
 * ����¼��խ�ӿ�
 * <p>
 * �˴�����һ����ʶ�ӿ�
 */
interface IMemo {

}

/**
 * �����˽�ɫ
 */
class Organizer {
	// �����˵�״̬
	private String state;

	// ��ȡ״̬
	public String getState() {
		return state;
	}

	// ����״̬
	public void setState(String state) {
		this.state = state;
	}

	// ������������������խ�ӿڵı���¼
	public IMemo createMemo() {
		return new Memo(state);
	}

	// �ָ����洢�ı���¼״̬
	public void restoreMemo(IMemo memo) {
		Memo aMemo = (Memo) memo;
		setState(aMemo.getState());
	}

	// ����¼��ʹ���ڲ���ʵ��
	protected class Memo implements IMemo {
		private String savedState;

		public Memo(String someState) {
			savedState = someState;
		}

		public String getState() {
			return savedState;
		}

		public void setState(String savedState) {
			this.savedState = savedState;
		}
	}
}

/**
 * �����˽�ɫ
 */
class Caretaker {
	private IMemo memo;

	// ��ȡ�洢�ı���¼
	public IMemo retrieveMemo() {
		return memo;
	}

	// �洢����¼
	public void saveMemo(IMemo memo) {
		this.memo = memo;
	}
}