
public class Chair extends Product {

	private int numberOfLegs;

	public Chair() {
		super();
	}

	public Chair(double length, double width, double height, String color, int numberOfLegs) {
		super(length, width, height, color);
		this.numberOfLegs = numberOfLegs;
	}

	public void display() {
		super.display();
		System.out.println("numberOfLegs: " + this.numberOfLegs);
	}

	public void draw() {
		System.out.println("  i______i");
		System.out.println("  I______I");
		System.out.println("  I      I");
		System.out.println("  I______I");
		System.out.println(" /      /I");
		System.out.println("(______( I");
		System.out.println("I I    I I");
		System.out.println("I      I");

	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
	
	

}
