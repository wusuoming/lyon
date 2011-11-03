package net.slowvic.model.bo;

import java.io.Serializable;

/**
 * 领域模型
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 7318742745681804997L;

	private String id;
	private String userId;
	private String title;
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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