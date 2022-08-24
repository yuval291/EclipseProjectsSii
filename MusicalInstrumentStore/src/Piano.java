
public class Piano extends MusicalInstruments {

	private int Keyboards;

	public Piano() {
		super();
	}

	public Piano(String model, String manufacturer, String color, int keyboards) {
		super(model, manufacturer, color);
		setKeyboards(keyboards);
	}

	public int getKeyboards() {
		return Keyboards;
	}

	public void setKeyboards(int keyboards) {
		if ((20 < keyboards) && (keyboards < 200)) {
			Keyboards = keyboards;
		}
	}

	public void display() {
		super.display();
		System.out.println("number of Keyboards: "+Keyboards);
	}
	
	public void makeSound () {
		super.makeSound();
		System.out.println("Making Piano sound");
	}

}
