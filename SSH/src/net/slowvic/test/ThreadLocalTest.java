package net.slowvic.test;

public class ThreadLocalTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			A a = new A();

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程t1:" + a.get());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			A a = new A();

			@Override
			public void run() {
				a.setInt(3);
				System.out.println("线程t2:" + a.get());
			}
		});
		t1.start();
		t2.start();
	}
}

class A {
	private static final ThreadLocal<Integer> share = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 5;
		}
	};
	
	/**private static final B share = new B();**/

	public void setInt(int i) {
		share.set(i);
	}

	public Integer get() {
		return share.get();
	}
}

class B {
	private Integer i;

	public void set(Integer i) {
		this.i = i;
	}

	public Integer get() {
		return i;
	}
}