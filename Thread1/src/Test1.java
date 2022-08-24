import java.util.ArrayList;
import java.util.stream.IntStream;

public class Test1 implements Runnable {

	ArrayList<Double> randomNumbers;
	
	@Override
	public void run() {
		
		randomNumbers = new ArrayList<Double>();
		IntStream.range(0, 10).forEach(index -> {
			System.out.println(Math.random()*10);
			randomNumbers.add(Math.random()*10);
		});
		
	}
	
	public void printList() {
		System.out.println(randomNumbers);
	}
}
