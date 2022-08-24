
public class Main {

	public static void main(String[] args) {
		
		Test1 t1 = new Test1();
		Test1 t2 = new Test1();
		
		Thread tt1 =new Thread(t1);
		Thread tt2 =new Thread(t2);
		
		tt1.start();
		tt2.start();
		
		try {
			Thread.sleep(1000);
			t1.printList();
			t2.printList();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
