package net.slowvic.patterns;

/**
 * 建造模式
 * <br>
 * 隐藏复杂对象内部零件装配的细节
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
 * 导演者角色，供客户端使用
 * <p>
 * 客户端只需提供必要的参数 <br>
 * 比如：写Email时，只需填入收件人，主题，内容
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
 * 抽象建造者
 */
abstract class AbstractBuilder {
	public abstract void buildPart1(String receiver);

	public abstract void buildPart2(String title);

	public abstract void buildPart3(String content);

	public abstract Email retrieveResult();
}

/**
 * 具体建造者
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
 * 电子邮件：具体产品类
 * <br>
 * 收件人receiver，主题title，内容content都是它的“零件”
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