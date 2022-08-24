
public class Passenger extends Staff{
	 
	String numPassport;

	public Passenger() {
		super();
	}

	public Passenger(String firstName, String lastName,String numPassport) {
		super(firstName,lastName);
		this.numPassport = numPassport;
	}
	
	public void showDetail() {
		super.showDetail();
		System.out.println("numPassport: "+numPassport);
	}
}
