
public class Table extends Product {

	private int numberOfSeats;

	public Table() {
		super();
	}

	public Table(double length, double width, double height, String color, int numberOfSeats) {
		super(length, width, height, color);
		this.numberOfSeats = numberOfSeats;
	}

	public void display() {
		super.display();
		System.out.println("numberOfSeats: " + this.numberOfSeats);
	}

	public void draw() {
		System.out.println("   =====================");
		System.out.println("  /                   /");
		System.out.println(" /                   /|");
		System.out.println("===================== |");
		System.out.println(" | |               |  |");
		System.out.println(" | |               |  |");
		System.out.println(" | |               |  |");
		System.out.println(" |                 |");
		System.out.println(" |                 |");
		System.out.println(" |                 |");
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	
}
