package net.slowvic.concurrency;

public class ReentrantSync {
	public static void main(String[] args) {
		Widget widget = new LoginWidget();
		widget.doSomeThing();
	}
}

class Widget {
	public synchronized void doSomeThing() {
		System.out.println("@#%^");
	}
}

class LoginWidget extends Widget {
	public synchronized void doSomeThing() {
		System.out.println("&&Y@#");
		// 如果synchronized不是可重入的，这里会变成死锁
		super.doSomeThing();
	}
}