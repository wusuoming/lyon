package net.slowvic.patterns;

/**
 * 白箱迭代子模式
 * <p>
 * 聚集自身向外部提供操作方法，迭代子仅仅提供游标
 */
public class WhiteBoxIterator {
	public static void main(String[] args) {
		ConcreteAggre ca = new ConcreteAggre();
		Iterator itr = new ConcreteIterator(ca);
		while (!itr.isDone()) {
			String animal = (String) itr.currentItem();
			System.out.println(animal);
			itr.next();
		}
	}
}

/**
 * 聚集需提供创建Iterator的工厂方法
 */
abstract class Aggregate {
	public abstract Iterator createIterator();
}

/**
 * 具体聚集
 * <p>
 * 使用数组实现，自身提供操作方法getElement和size
 */
class ConcreteAggre extends Aggregate {
	private String[] animals = new String[] { "goat", "tiger", "wolf", "lion",
			"monkey" };

	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}

	public Object getElement(int index) {
		if (index < animals.length && index > -1) {
			return animals[index];
		} else {
			return null;
		}
	}

	public int size() {
		return animals.length;
	}
}

/**
 * 抽象迭代子
 */
interface Iterator {
	// 游标指向第一个元素
	void first();

	// 游标指向下一个元素
	void next();

	// 是否指向最后一个元素
	boolean isDone();

	// 返回当前元素
	Object currentItem();
}

class ConcreteIterator implements Iterator {
	private ConcreteAggre aggre;
	// 游标
	private int index = 0;
	// 聚集容量
	private int size = 0;

	public ConcreteIterator(ConcreteAggre aggre) {
		this.aggre = aggre;
		index = 0;
		size = aggre.size();
	}

	@Override
	public void first() {
		index = 0;
	}

	@Override
	public void next() {
		if (index < size) {
			index++;
		}
	}

	@Override
	public boolean isDone() {
		return index == size;
	}

	@Override
	public Object currentItem() {
		return aggre.getElement(index);
	}
}