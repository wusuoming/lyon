package net.slowvic.patterns;

/**
 * 责任链模式
 * <p>
 * 一个简单的例子<br>
 * 如果没有下家则处理请求，否则往下传递
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
 * 抽象角色
 * <p>
 * 持有下家的引用
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
 * 具体角色
 * <p>
 * 判定是否将责任传递给下家
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
			System.out.printf("我是%s号，我将是你永远的噩梦，记住我的名字吧！", id);
		}
	}
}