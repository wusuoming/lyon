package net.slowvic.patterns;

/**
 * ���������ģʽ
 * <p>
 * �ۼ���ͻ����ṩխ�ӿڣ���Iterator�ṩ��ӿ�<br>
 * Iterator�Ǿۼ����ڲ���
 */
public class BlackBoxIterator {
	public static void main(String[] args) {
		Aggregate ca = new ConcreteAggregate();
		Iterator itr = ca.createIterator();
		while (!itr.isDone()) {
			String animal = (String) itr.currentItem();
			System.out.println(animal);
			itr.next();
		}
	}
}

/**
 * ����ۼ���
 * <p>
 * ʹ���ڲ�������ͻ����ṩ��������
 */
class ConcreteAggregate extends Aggregate {
	private String[] animals = new String[] { "goat", "tiger", "wolf", "lion",
			"monkey" };

	@Override
	public Iterator createIterator() {
		return new InnerInterator();
	}

	private class InnerInterator implements Iterator {
		private int index = 0;

		@Override
		public void first() {
			index = 0;
		}

		@Override
		public void next() {
			if (index < animals.length) {
				index++;
			}
		}

		@Override
		public boolean isDone() {
			return index == animals.length;
		}

		@Override
		public Object currentItem() {
			return animals[index];
		}

	}
}