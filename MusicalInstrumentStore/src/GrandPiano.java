
public class GrandPiano extends Piano {

	private int length;

	public GrandPiano() {
		super();
	}

	public GrandPiano(int length, String model, String manufacturer, String color, int keyboards) {
		super(model, manufacturer, color, keyboards);
		setLength(length);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if ((length >= 0) && (length <= 300)) {
			this.length = length;
		}
	}

	public void display() {
		super.display();
		System.out.println("length: "+length);
	}
	
	@Override
	public void makeSound () {
		System.out.println("Making Grand Piano sound");
	}

}
