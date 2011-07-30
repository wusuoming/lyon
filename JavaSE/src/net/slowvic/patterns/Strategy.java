package net.slowvic.patterns;

/**
 * ����ģʽ
 * <p>
 * ע���װ���Ǳ仯���㷨
 */
public class Strategy {
	public static void main(String[] args) {
		Discount discount = new DownDiscount();
		Book book = new Book(discount);
		book.printAigoPrice(35);
	}
}

/**
 * ������ɫ
 * <p>
 * ���в��ԣ����������ۿ�
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
 * ������Խ�ɫ
 * <p>
 * �ۿ�
 */
interface Discount {
	double aigoPrice(double originPrice);
}

/**
 * ������Խ�ɫ
 * <p>
 * �ٷֱ��ۿ�
 */
class PercentDiscount implements Discount {
	@Override
	public double aigoPrice(double originPrice) {
		return originPrice * 0.7;
	}
}

/**
 * ������Խ�ɫ
 * <p>
 * �̶��ۿ�
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