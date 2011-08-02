package net.slowvic.patterns;

/**
 * ����ģʽ
 * <p>
 * �������������ɫ�������������ɫ������ί�ɸ�ִ���ߣ������������һ�ݼ�¼����Ҫʱ����ִ�г������ָ�����
 */
public class CommandPattern {
	public static void main(String[] args) {
		Receiver rev = new Receiver();
		Command command = new ConcreteCommand(rev);
		Invoker invoker = new Invoker(command);
		//��۴���ʥּ
		System.out.println("��ۣ�\"̫�׽��ǣ���ȥ���Ǻ�ͷ���Ͻ���\"");
		invoker.action();
	}
}

/**
 * ������
 * <p>
 * ���������action����ί�ɸ�����ִ��
 */
class Invoker {
	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	public void action() {
		System.out.println("̫�׽��ǣ�\"����ȥ�ٻ�\"");
		command.execute();
	}
}

/**
 * ��������
 */
interface Command {
	void execute();
}

/**
 * ��������
 * <p>
 * ���н����ߣ���ִ�ж���ί�ɸ�������ִ��
 */
class ConcreteCommand implements Command {
	private Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		System.out.println("ʥּ��\"����ս�ּ\"");
		receiver.action();
	}
}

/**
 * ������
 * <p>
 * ִ��һ������
 */
class Receiver {
	public Receiver() {

	}

	public void action() {
		System.out.println("����գ�\"�����ﷴ���������죡\"");
	}
}