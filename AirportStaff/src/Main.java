
public class Main {

	public static void main(String[] args) {
		
		Pilot p = new Pilot("zvi","yamin",2589565,8);
		FlightAttendant fa = new FlightAttendant("yosi","shukron",3,"israel","akonomi");
		GroundAttendant ga= new GroundAttendant("dekel","yosef",9,"rosia","mazcira");
		Passenger ps = new Passenger("ariel","raz","541515566");
		
		
		p.showDetail();
		
		System.out.println("---------------");	
		fa.showDetail();
		System.out.println(fa.ifExperience());
		
		System.out.println("---------------");	
		ga.showDetail();
		System.out.println(ga.ifExperience());	
		
		System.out.println("---------------");
		ps.showDetail();
	}
}
