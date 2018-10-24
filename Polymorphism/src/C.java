
public class C extends B {

	private int height;
	
	public C() {
		this(-1);
	}

	public C(int height) {
		super();
		this.height = height;
	}

	public C(String name, String color, int length, int width, int height) {
		super(name, color, length, width);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public int getVolume() {
		return this.height * this.getLength() * this.getWidth();
	}

	@Override
	public String toString() {
		String s = super.toString();
		return  s + " --- " + "C [height=" + height + "]";
	}
	
	
	
	
}
