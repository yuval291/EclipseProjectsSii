package src;


public class Drum extends MusicalInstruments {

	private int diameter;

	public Drum() {
		super();
	}

	public Drum(String model, String manufacturer, String color, int diameter) {
		super(model, manufacturer, color);
		setDiameter(diameter);
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		if ((diameter >= 0) && (diameter <= 100)) {
			this.diameter = diameter;
		}
	}

	public void display() {
		super.display();
		System.out.println("diameter: "+diameter);
	}
	
	public void makeSound () {
		super.makeSound();
		System.out.println("Making Drum sound");
	}

}
