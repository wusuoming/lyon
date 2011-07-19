package net.slowvic.patterns;

/**
 * ����ģʽ
 * <br>
 * ���ظ��Ӷ����ڲ����װ���ϸ��
 */
public class Builder {
	public static void main(String[] args) {
		Director d = new Director();
		Email e = d.construct("slowvic@gmail.com", "Hello",
				"What's up , buddy ?");
		System.out.println(e.getContent());
	}
}

/**
 * �����߽�ɫ�����ͻ���ʹ��
 * <p>
 * �ͻ���ֻ���ṩ��Ҫ�Ĳ��� <br>
 * ���磺дEmailʱ��ֻ�������ռ��ˣ����⣬����
 */
class Director {
	private AbstractBuilder builder;

	public Email construct(String receiver, String title, String content) {
		builder = new ConcreteBuilder();
		builder.buildPart1(receiver);
		builder.buildPart2(title);
		builder.buildPart3(content);
		return builder.retrieveResult();
	}
}

/**
 * ��������
 */
abstract class AbstractBuilder {
	public abstract void buildPart1(String receiver);

	public abstract void buildPart2(String title);

	public abstract void buildPart3(String content);

	public abstract Email retrieveResult();
}

/**
 * ���彨����
 */
class ConcreteBuilder extends AbstractBuilder {
	private Email email = new Email();

	@Override
	public void buildPart1(String receiver) {
		email.setReceiver(receiver);
	}

	@Override
	public void buildPart2(String title) {
		email.setTitle(title);
	}

	@Override
	public void buildPart3(String content) {
		email.setContent(content);
	}

	@Override
	public Email retrieveResult() {
		return email;
	}
}

/**
 * �����ʼ��������Ʒ��
 * <br>
 * �ռ���receiver������title������content�������ġ������
 */
class Email {
	private String receiver;
	private String title;
	private String content;

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}