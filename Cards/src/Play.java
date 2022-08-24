import java.util.Random;
import java.util.stream.IntStream;

public class Play {

	public static void main(String[] args) {

		Card[] cards = new Card[3];

		BlueCard blueCard = new BlueCard();
		GreenCard greenCard = new GreenCard();
		Card card = new Card();

		cards[0] = blueCard;
		cards[1] = greenCard;
		cards[2] = card;

		int player1 = 100;
		int player2 = 100;

		Random r = new Random();
		int max = 2;
		int min = 0;
		int[] cardAttend = new int[3];

		for (int i = 0; i < 5; i++) {
			int choice1 = r.nextInt((max - min) + 1) + min;
			player1 = cards[choice1].doMagic(player1);
			cardAttend[choice1]++;

			int choice2 = r.nextInt((max - min) + 1) + min;
			player2 = cards[choice2].doMagic(player2);
			cardAttend[choice2]++;
		}

		System.out.println("player1: " + player1);
		System.out.println("player2: " + player2);

		if (player1 > player2) {
			System.out.println("player1 WIN");
		} else {
			System.out.println("player2 WIN");
		}

		System.out.println("blueCard attend: " + cardAttend[0]);
		System.out.println("greenCard attend: " + cardAttend[1]);
		System.out.println("Card attend: " + cardAttend[2]);

	}
}
