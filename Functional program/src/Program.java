
public class Program {
	
	public static void main(String[] args) {
		MyFunctionalIfc myIfc = new MyFunctionalIfc() {

			@Override
			public void foo() {
				System.out.println("Hello world");
			}
			
		};
		
		MyFunctionalIfc myIfc1 =()->{
			System.out.println("Hello world11");
		};
	}

}
