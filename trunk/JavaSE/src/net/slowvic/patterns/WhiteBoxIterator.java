package net.slowvic.patterns;

/**
 * ���������ģʽ
 * <p>
 * �ۼ��������ⲿ�ṩ���������������ӽ����ṩ�α�
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
 * �ۼ����ṩ����Iterator�Ĺ�������
 */
abstract class Aggregate {
	public abstract Iterator createIterator();
}

/**
 * ����ۼ�
 * <p>
 * ʹ������ʵ�֣������ṩ��������getElement��size
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
 * ���������
 */
interface Iterator {
	// �α�ָ���һ��Ԫ��
	void first();

	// �α�ָ����һ��Ԫ��
	void next();

	// �Ƿ�ָ�����һ��Ԫ��
	boolean isDone();

	// ���ص�ǰԪ��
	Object currentItem();
}

class ConcreteIterator implements Iterator {
	private ConcreteAggre aggre;
	// �α�
	private int index = 0;
	// �ۼ�����
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