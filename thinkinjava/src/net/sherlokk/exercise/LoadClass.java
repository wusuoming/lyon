package net.sherlokk.exercise;

public class LoadClass {
	static class Candy {
		static {
			System.out.println("加载Candy类");
		}
	}

	static class Gum {
		static {
			System.out.println("加载Gum类");
		}
	}

	static class Cookie {
		static {
			System.out.println("加载Cookie类");
		}
		
		Cookie(){
			System.out.println("Cookie类被初始化了");
		}
	}

	public static void main(String[] args) {
		new Candy();
		try {
			Class.forName("net.sherlokk.jvm.LoadClass.Gum");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到Gum类");
		}
		new Cookie();
		new Cookie();
	}
}
