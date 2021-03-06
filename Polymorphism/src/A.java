
public class A {

	private String name;
	private String color;
	private int length;
	
	public A() {
		this("", "None", -1);
	}
	
	public A(String name, String color, int length) {
		this.name = name;
		this.color = color;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "A [name=" + name + ", color=" + color + ", length=" + length + "]";
	}
}
