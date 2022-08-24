
public class MusicalInstruments {

	private String model;
	private String manufacturer;
	private String color;

	public MusicalInstruments(String model, String manufacturer, String color) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
	}

	public MusicalInstruments() {
		super();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void display() {
		System.out.println("model: "+model);
		System.out.println("manufacturer: "+manufacturer);
		System.out.println("color: "+color);
	}
	
	public void makeSound () {
		System.out.println("A musical instrument makes a sound");
	}

}
