package net.slowvic.datastructer.stack;

public class StackX {
	// 栈容量
	private int maxSize;
	// 容器
	private int[] arr;
	// 栈顶地址
	private int top;

	public StackX(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		top = -1; // 还没有数据，无栈顶
	}

	/**
	 * 压栈
	 * 
	 * @param value
	 */
	public void push(int value) {
		if (isFull()) {
			throw new IllegalStateException("栈已满，无法执行入栈操作.");
		} else {
			arr[++top] = value; //先移动栈顶，再加
		}
	}

	/**
	 * 出栈
	 * 
	 * @return
	 */
	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("栈为空，无法执行出栈操作.");
		} else {
			return arr[top--]; //先出，再移动栈顶
		}
	}

	/**
	 * 查看栈顶
	 * 
	 * @return
	 */
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("栈为空");
		} else {
			return arr[top];
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public static void main(String[] args) {
		StackX stack = new StackX(3);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.peek());
	}
}
