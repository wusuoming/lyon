package net.slowvic.patterns;

/**
 * 原型模式
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
 * 熊猫类
 * <br>
 * 实现Cloneable接口，表明可调用clone方法复制
 * <br>
 * 注意Cloneable仅是一个标识接口
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
	/* clone()方法需要满足以下描述：
	 * x.clone() != x;
	 * x.clone().getClass() == x.getClass();
	 * x.clone.equals(x) == true;
	 * 第三点不是必须的，但强烈建议实现
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
	 * 关于equals和hashCode的实现原则请参考《effective java》
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
		sb.append("该熊猫目前").append(age).append("岁，身高").append(height)
				.append("厘米，体重").append(weight).append("公斤");
		return sb.toString();
	}
}