package net.slowvic.patterns;

/**
 * ״̬ģʽ
 * <p>
 * ����״̬����װΪֻ����Ϊ�Ĳ�ͬ����
 */
public class StatePattern {
	public static void main(String[] args) {
		Bell bell = new Bell();
		// �ı�״̬����Ϊ�����ı�
		bell.setState(new DuoState());
		bell.knock();
		bell.setState(new RuiState());
		bell.knock();
		bell.setState(new MiState());
		bell.knock();
	}
}

// ������ɫ
class Bell {
	private State state;

	public void setState(State state) {
		this.state = state;
	}

	public void knock() {
		state.knock();
	}
}

/**
 * ����״̬
 */
interface State {
	void knock();
}

/**
 * ����״̬
 */
class DuoState implements State {
	@Override
	public void knock() {
		System.out.println("��");
	}
}

/**
 * ����״̬
 */
class RuiState implements State {
	@Override
	public void knock() {
		System.out.println("��");
	}
}

/**
 * ����״̬
 */
class MiState implements State {
	@Override
	public void knock() {
		System.out.println("��");
	}
}