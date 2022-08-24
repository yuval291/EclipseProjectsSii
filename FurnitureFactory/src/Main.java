import java.util.Random;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		Product products[]= new Product[20];

		Random r = new Random();
		int max=3;
		int min=1;
		
		IntStream.range(0, 20).forEach(index -> {
			
			int directive = r.nextInt((max - min) + 1) + min;
			
			switch (directive) {
			case 1:
				products[index]=new Chair((Math.random()*20),
									  (Math.random()*20),
									  (Math.random()*20),
									  (Product.getColor()[(int) (Math.random()* (Product.getColor().length-1))]),
									  (int) ((Math.random()*4)+1));
				break;
			case 2:
				products[index]=new Bed((Math.random()*20),
						  (Math.random()*20),
						  (Math.random()*20),
						  (Product.getColor()[(int) (Math.random()* (Product.getColor().length-1))]),
						  (r.nextBoolean()));
				break;
			case 3:
				products[index]=new Table((Math.random()*20),
						  (Math.random()*20),
						  (Math.random()*20),
						  (Product.getColor()[(int) (Math.random()* (Product.getColor().length-1))]),
						  (int) ((Math.random()*10)+1));
				break;
			default:
				break;
			}
			
		});
		
		
		for (Product product : products) {
			product.display();
			product.draw();
			if(product instanceof Chair) {
				System.out.println("The number of legs: ");
				System.out.println(((Chair) product).getNumberOfLegs());
			}if(product instanceof Bed) {
				System.out.println("Is it a double bed? ");
				System.out.println(((Bed) product).isDoubleBed());
			}if(product instanceof Table) {
				System.out.println("seats: ");
				System.out.println(((Table) product).getNumberOfSeats());
			}
		}

	}
}
