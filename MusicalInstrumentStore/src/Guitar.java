
public class Guitar extends MusicalInstruments {
	
	private int numStrings;
	
	public Guitar() {
		super();
	}

	public Guitar(int numStrings , String model, String manufacturer, String color) {
		super(model, manufacturer, color);
		setNumStrings(numStrings);
	}

	public int getNumStrings() {
		return numStrings;
	}
	
	public void setNumStrings(int numStrings) {
		if((numStrings>=4)&&(numStrings<=10)) {
			this.numStrings = numStrings;	
		}
	}
	
	public void display() {
		super.display();
		System.out.println("number of strings: "+numStrings);
	}
	
	public void makeSound () {
		super.makeSound();
		System.out.println("Making Guitar sound");
	}
	
	

}
