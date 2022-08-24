
public class Staff {
	
	String firstName;
	String lastName;
		
	public Staff() {
		super();
	}

	public Staff(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void showDetail() {
		System.out.println("firstName: "+firstName);
		System.out.println("lastName: "+lastName);
	}
	
	

}
