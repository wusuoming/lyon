package net.slowvic.lang.concurrency;

/**import java.util.Random; */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ���̼߳�����ɵ������Ƿ�Ϊż�������ǣ��������̶߳�ִ�����
 */
public class EvenChecker implements Runnable {
	private IntGen generator;

	public EvenChecker(IntGen generator) {
		this.generator = generator;
	}

	@Override
	public void run() {
		while (!generator.isCancered()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(Thread.currentThread() + ":" + val
						+ " is not even");
				generator.cancer();
			}
		}
	}

	public static void test(IntGen gen, int count) {
		System.out.println("print control-c to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			// �����̹߳���һ��IntGen���ᷢ����Դ����
			exec.execute(new EvenChecker(gen));
		}
		exec.shutdown();
	}

	public static void main(String[] args) {
		
		/**
		test(new IntGen() {

			@Override
			public synchronized int next() {
				//ע��ʹ��ͬ�����Ĳ�ͬ
				return new Random().nextInt(100);
			}
		}, 5);
		**/

		test(new IntGen() {

			private int currEvenVal = 0;

			@Override
			public int next() {
				//�������synchronized���η����������ѭ����ȥ
				//++����������ԭ���ԣ���˲���������ӡ��1��2��3
				++currEvenVal;
				++currEvenVal;
				return currEvenVal;
			}

		}, 10);
	}
}

/**
 * cancered����boolean�������Ĳ�������ԭ���ԡ�Ϊ�˱�֤�����ԣ���������Ϊvolatile���͡�
 * ԭ���Բ����ܱ�֤�����Ŀ����ԣ������ܱ�֤�������һ���ᱻд������
 */
abstract class IntGen {
	private volatile boolean cancered = false;

	// �������һ������
	public abstract int next();

	public void cancer() {
		cancered = true;
	}

	public boolean isCancered() {
		return cancered;
	}
}