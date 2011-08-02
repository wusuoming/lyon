package net.slowvic.patterns;

/**
 * 备忘录模式
 * <p>
 * 备忘录角色：<br>
 * A、将发起人(Organizer)对象的内部状态保存起来，可根据发起人的判断来决定存储多少内部状态<br>
 * B、保护其内容不被发起人之外的任何对象所读取<br>
 * 窄接口：只允许把备忘录对象传递给其他的对象，面向负责人(Caretaker)及其他非发起人角色<br>
 * 宽接口：允许读取所有数据，面向发起人角色
 * <p>
 * 发起人角色：<br>
 * A、创建一个包含当前内部状态的备忘录对象<br>
 * B、使用备忘录对象存储其内部状态
 * <p>
 * 负责人角色：<br>
 * A、保存备忘录对象<br>
 * B、不检查备忘录对象的内容
 */
public class Memento {
	public static void main(String[] args) {

	}
}

class Organizer{
	private String state;
	
	public Organizer(){}
	
	public IMemo createMemo(){
		return new Memo(state);
	}
}