
public class GroundAttendant extends Attendant{
	
	 String landRole;

	public GroundAttendant() {
		super();
	}

	public GroundAttendant(String firstName, String lastName,int seniority,String countryOfOrigin, String landRole) {
		super(firstName,lastName,seniority,countryOfOrigin);
		this.landRole = landRole;
	}
	 
	public void showDetail() {
		super.showDetail();
		System.out.println("landRole: "+landRole);
	}
}
