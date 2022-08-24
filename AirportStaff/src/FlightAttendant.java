
public class FlightAttendant extends Attendant{
	
	String department;

	public FlightAttendant() {
		super();
	}

	public FlightAttendant(String firstName, String lastName,int seniority,String countryOfOrigin,String department) {
		super(firstName,lastName,seniority,countryOfOrigin);
		this.department = department;
	}
	
	public void showDetail() {
		super.showDetail();
		System.out.println("department: "+department);
	}

}
