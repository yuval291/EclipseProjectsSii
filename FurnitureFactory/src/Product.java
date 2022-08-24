
public abstract class Product {
	
	private double length;
	private double width;
	private double height;
	private String color;
	
	public Product() {
		super();
	}

	public Product(double length, double width, double height, String color) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void display () {
		System.out.println("length: "+this.length);
		System.out.println("width: "+this.width);
		System.out.println("height: "+this.height);
		System.out.println("color: "+this.color);
	}
	
	public static String[] getColor() {
		String[] colors = {"red","blue","pink","brown"};
		return colors;
	}
	
	public void draw() {}
	
	

}
