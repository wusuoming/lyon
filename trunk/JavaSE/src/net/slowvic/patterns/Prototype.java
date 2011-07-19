package net.slowvic.patterns;

/**
 * ԭ��ģʽ
 */
public class Prototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		Panda p1 = new Panda(165, 80);
		p1.setAge(3);
		Panda p2 = (Panda) p1.clone();
		System.out.println(p2);
		System.out.println(p2.equals(p1));
	}
}

/**
 * ��è��
 * <br>
 * ʵ��Cloneable�ӿڣ������ɵ���clone��������
 * <br>
 * ע��Cloneable����һ����ʶ�ӿ�
 */
class Panda implements Cloneable {
	private int age;
	private double height;
	private double weight;

	public Panda(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	/* clone()������Ҫ��������������
	 * x.clone() != x;
	 * x.clone().getClass() == x.getClass();
	 * x.clone.equals(x) == true;
	 * �����㲻�Ǳ���ģ���ǿ�ҽ���ʵ��
	 */
	protected Object clone() throws CloneNotSupportedException {
		Panda panda = new Panda(height, weight);
		panda.setAge(age);
		return super.clone();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	/*
	 * ����equals��hashCode��ʵ��ԭ����ο���effective java��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Panda))
			return false;
		else {
			Panda p = (Panda) obj;
			return (p.age == age && p.height == height && p.weight == weight);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("����èĿǰ").append(age).append("�꣬���").append(height)
				.append("���ף�����").append(weight).append("����");
		return sb.toString();
	}
}