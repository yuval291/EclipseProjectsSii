
public class Pilot extends Staff{
	
	int licenseNumber;
	int yearsOfExperience;
	
	public Pilot() {
		super();
	}

	public Pilot(String firstName, String lastName,int licenseNumber, int yearsOfExperience) {
		super(firstName,lastName);
		this.licenseNumber = licenseNumber;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	public void showDetail() {
		super.showDetail();
		System.out.println("licenseNumber: "+licenseNumber);
		System.out.println("yearsOfExperience: "+yearsOfExperience);
	}
	
}
