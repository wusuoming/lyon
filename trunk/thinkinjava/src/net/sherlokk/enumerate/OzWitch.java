package net.sherlokk.enumerate;

public enum OzWitch {
	// 必须首先定义
	WEST("west"), EAST("east"), SOUTH("south"), NORTH("north");

	private String description;

	/**
	 * 只能为private或者不加任何访问修饰符<BR>
	 * 此构造方法只能内部访问，见上面定义处
	 * 
	 * @param description
	 */
	private OzWitch(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static void main(String[] args) {
		OzWitch west = OzWitch.WEST;
		System.out.println(west.getDescription());
	}
}
