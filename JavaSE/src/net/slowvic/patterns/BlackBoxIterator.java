package net.slowvic.patterns;

/**
 * 黑箱迭代子模式
 * <p>
 * 聚集向客户端提供窄接口，向Iterator提供宽接口<br>
 * Iterator是聚集的内部类
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
 * 具体聚集类
 * <p>
 * 使用内部类来向客户端提供迭代操作
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