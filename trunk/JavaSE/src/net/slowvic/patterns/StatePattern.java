package net.slowvic.patterns;

/**
 * 状态模式
 * <p>
 * 将“状态”封装为只有行为的不同子类
 */
public class StatePattern {
	public static void main(String[] args) {
		Bell bell = new Bell();
		// 改变状态，行为发生改变
		bell.setState(new DuoState());
		bell.knock();
		bell.setState(new RuiState());
		bell.knock();
		bell.setState(new MiState());
		bell.knock();
	}
}

// 环境角色
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
 * 抽象状态
 */
interface State {
	void knock();
}

/**
 * 具体状态
 */
class DuoState implements State {
	@Override
	public void knock() {
		System.out.println("哆");
	}
}

/**
 * 具体状态
 */
class RuiState implements State {
	@Override
	public void knock() {
		System.out.println("瑞");
	}
}

/**
 * 具体状态
 */
class MiState implements State {
	@Override
	public void knock() {
		System.out.println("咪");
	}
}