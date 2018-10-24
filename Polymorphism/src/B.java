
public class B extends A {

	private int width;
	
	public B() {
		this(-1);
	}

	public B(int width) {
		super();
		this.width = width;
	}
	
	public B(String name, String color, int length, int width) {
		super(name, color, length);
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getArea() {
		return this.width * this.getLength();
	}

	@Override
	public String toString() {
		String s = super.toString();
		return s + " --- " + "B [width=" + width + "]";
	}
	
	
}
