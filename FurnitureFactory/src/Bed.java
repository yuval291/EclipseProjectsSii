
public class Bed extends Product{

	private boolean doubleBed;

	public Bed() {
		super();
	}

	public Bed(double length, double width, double height, String color ,boolean doubleBed) {
		super( length,  width,  height,  color );
		this.doubleBed = doubleBed;
	}
	
	public void display () {
		super.display();
		System.out.println("doubleBed: "+this.doubleBed);
	}
	
	public void draw() {
		System.out.println("   ||");
		System.out.println("   ||                   ||");
		System.out.println("||/||___                ||");
		System.out.println("|| /`   )____________||_/|");
		System.out.println("||/___ //_/_/_/_/_/_/||/ |");
		System.out.println("||(___)/_/_/_/_/_/_/_||  |");
		System.out.println("||     |_|_|_|_|_|_|_|| /|");
		System.out.println("||     | | | | | | | ||/||");
		System.out.println("||~~~~~~~~~~~~~~~~~~~||");
		System.out.println("||                   ||");

	}

	public boolean isDoubleBed() {
		return doubleBed;
	}

	public void setDoubleBed(boolean doubleBed) {
		this.doubleBed = doubleBed;
	}
	
	
	
	
}
