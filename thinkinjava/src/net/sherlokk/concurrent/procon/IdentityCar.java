package net.sherlokk.concurrent.procon;

public class IdentityCar {
	private String id;

	public IdentityCar(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "car(" + id + ")";
	}

	public void waxed() {
		System.out.println(this + "打蜡");
	}

	public void buffered() {
		System.out.println(this + "抛光");
	}
}
