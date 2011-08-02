package net.slowvic.patterns;

/**
 * 备忘录模式
 * <p>
 * 备忘录角色：<br>
 * A、将发起人(Organizer)对象的内部状态保存起来，可根据发起人的判断来决定存储多少内部状态<br>
 * B、保护其内容不被发起人之外的任何对象所读取<br>
 * 窄接口：只允许把备忘录对象传递给其他的对象，面向负责人(Caretaker)及其他非发起人角色<br>
 * 宽接口：允许读取所有数据，面向发起人角色
 * <p>
 * 发起人角色：<br>
 * A、创建一个包含当前内部状态的备忘录对象<br>
 * B、使用备忘录对象存储其内部状态
 * <p>
 * 负责人角色：<br>
 * A、保存备忘录对象<br>
 * B、不检查备忘录对象的内容
 */
public class Memento {
	public static void main(String[] args) {
		Organizer o = new Organizer();
		Caretaker c = new Caretaker();
		// 发起人状态为on
		o.setState("on");
		// 发起人创建备忘录，负责人保存创建的备忘录
		c.saveMemo(o.createMemo());
		// 发起人状态变更为off
		o.setState("off");
		// 发起人状态恢复到负责人保存的模式
		o.restoreMemo(c.retrieveMemo());
		System.out.println(o.getState());
	}
}

/**
 * 备忘录的窄接口
 * <p>
 * 此处仅是一个标识接口
 */
interface IMemo {

}

/**
 * 发起人角色
 */
class Organizer {
	// 发起人的状态
	private String state;

	// 获取状态
	public String getState() {
		return state;
	}

	// 设置状态
	public void setState(String state) {
		this.state = state;
	}

	// 工厂方法，创建带有窄接口的备忘录
	public IMemo createMemo() {
		return new Memo(state);
	}

	// 恢复到存储的备忘录状态
	public void restoreMemo(IMemo memo) {
		Memo aMemo = (Memo) memo;
		setState(aMemo.getState());
	}

	// 备忘录，使用内部类实现
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
 * 负责人角色
 */
class Caretaker {
	private IMemo memo;

	// 获取存储的备忘录
	public IMemo retrieveMemo() {
		return memo;
	}

	// 存储备忘录
	public void saveMemo(IMemo memo) {
		this.memo = memo;
	}
}