package net.slowvic.patterns;

/**
 * 命令模式
 * <p>
 * 调用者向命令角色发出请求，命令角色将请求委派给执行者，并保持请求的一份记录，必要时可以执行撤销、恢复操作
 */
public class CommandPattern {
	public static void main(String[] args) {
		Receiver rev = new Receiver();
		Command command = new ConcreteCommand(rev);
		Invoker invoker = new Invoker(command);
		//玉帝创建圣旨
		System.out.println("玉帝：\"太白金星，你去将那猴头招上界来\"");
		invoker.action();
	}
}

/**
 * 调用者
 * <p>
 * 持有命令，将action方法委派给命令执行
 */
class Invoker {
	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	public void action() {
		System.out.println("太白金星：\"臣速去速回\"");
		command.execute();
	}
}

/**
 * 抽象命令
 */
interface Command {
	void execute();
}

/**
 * 具体命令
 * <p>
 * 持有接收者，将执行动作委派给接收者执行
 */
class ConcreteCommand implements Command {
	private Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		System.out.println("圣旨：\"孙悟空接旨\"");
		receiver.action();
	}
}

/**
 * 接收者
 * <p>
 * 执行一个动作
 */
class Receiver {
	public Receiver() {

	}

	public void action() {
		System.out.println("孙悟空：\"俺老孙反了你这破天！\"");
	}
}