package net.slowvic.patterns;

/**
 * 策略模式
 * <p>
 * 注意封装的是变化的算法
 */
public class Strategy {
	public static void main(String[] args) {
		Discount discount = new DownDiscount();
		Book book = new Book(discount);
		book.printAigoPrice(35);
	}
}

/**
 * 环境角色
 * <p>
 * 持有策略，比如书有折扣
 */
class Book {
	private Discount discount;

	public Book(Discount count) {
		discount = count;
	}

	public void printAigoPrice(double price) {
		System.out.println(discount.aigoPrice(price));
	}
}

/**
 * 抽象策略角色
 * <p>
 * 折扣
 */
interface Discount {
	double aigoPrice(double originPrice);
}

/**
 * 具体策略角色
 * <p>
 * 百分比折扣
 */
class PercentDiscount implements Discount {
	@Override
	public double aigoPrice(double originPrice) {
		return originPrice * 0.7;
	}
}

/**
 * 具体策略角色
 * <p>
 * 固定折扣
 */
class DownDiscount implements Discount {
	@Override
	public double aigoPrice(double originPrice) {
		if (originPrice > 20)
			return originPrice - 10;
		else if (originPrice > 10)
			return originPrice - 3;
		else
			return originPrice;
	}
}