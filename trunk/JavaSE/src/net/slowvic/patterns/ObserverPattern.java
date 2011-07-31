package net.slowvic.patterns;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * <p>
 * 观察者继承Observer接口，并实现其update方法
 */
public class ObserverPattern implements Observer {
	public static void main(String[] args) {
		BeObserved bo = new BeObserved();
		Observer op1 = new ObserverPattern("1");
		Observer op2 = new ObserverPattern("2");
		bo.addObserver(op1);
		bo.addObserver(op2);
		bo.change();
	}

	private String id;

	public ObserverPattern(String id) {
		this.id = id;
	}

	@Override
	/**
	 * Observable:被观察对象<br>
	 * Object:被观察对象传递过来的参数
	 */
	public void update(Observable arg0, Object arg1) {
		String msg = (String) arg1;
		System.out.printf("我是%s号，邮件已收到，主题为'%s'%n", id, msg);
	}
}

/**
 * 被观察对象
 * <p>
 * 继承Observable抽象类<br>
 * 持有Observer接口的一个聚集，发出通知时，需标明状态改变和发出通知
 */
class BeObserved extends Observable {
	public void change() {
		System.out.println("请查收邮件");
		// 标记状态改变
		setChanged();
		// 发出通知
		notifyObservers("集合地点变更通知");
	}
}