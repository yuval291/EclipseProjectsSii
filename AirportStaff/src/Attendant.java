
public abstract class Attendant extends Staff{

	int seniority;
	String countryOfOrigin;
	
	public Attendant() {
		super();
	}
	
	public Attendant(String firstName, String lastName,int seniority,String countryOfOrigin) {
		super(firstName,lastName);
		this.seniority = seniority;
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public void showDetail() {
		super.showDetail();
		System.out.println("seniority: "+seniority);
		System.out.println("countryOfOrigin: "+countryOfOrigin);
	}
	
	public boolean ifExperience() {
		if(this.seniority>=5) {
			return true;
		}
		return false;
	}
}
