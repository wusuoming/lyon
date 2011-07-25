package net.slowvic.patterns;

/**
 * 代理模式
 * <p>
 * 与装饰模式的区别在于代理强调对被代理对象的控制，而装饰模式强调的是功能增强
 * <p>
 * 保护代理：对使用被代理对象的权限进行检查<br>
 * 智能引用代理：对使用次数进行统计<br>
 * 虚拟代理：延迟加载
 */
public class Proxy {
	public static void main(String[] args) {
		Subject s = new ProxySubject();
		s.request();
	}
}

/**
 * 抽象主题角色，为[被]代理角色提供共同接口
 */
abstract class Subject {
	// 共同的方法
	abstract void request();
}

/**
 * 真实主题角色
 */
class RealSubject extends Subject {
	public RealSubject() {

	}

	@Override
	void request() {
		System.out.println("发出请求");
	}
}

/**
 * 代理角色
 * <p>
 * 持有真实主题角色的引用，将方法调用委派给真实主题角色，但进行了前后拦截
 */
class ProxySubject extends Subject {
	private RealSubject rs;

	public ProxySubject() {
		rs = new RealSubject();
	}

	public ProxySubject(RealSubject rs) {
		this.rs = rs;
	}

	public void preRequest() {
		System.out.println("发出请求前");
	}

	@Override
	void request() {
		preRequest();
		rs.request();
		postRequest();
	}

	public void postRequest() {
		System.out.println("发出请求后");
	}
}