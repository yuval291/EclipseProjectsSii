
public class Main {
	public static void main(String[] args) {

		Guitar guitar = new Guitar( 5 ,"Martin CDE4","Martin","brown");
		Drum drum = new Drum("Jinbao-sp525", "Jinbao","black",95);
		Piano piano = new Piano("Ringway tg-8852", "Ringway", "white", 22);
		GrandPiano grandPiano = new GrandPiano(250, "Ringway tg-8885", "Ringway", "red", 30);
		
		System.out.println("--------------");
		guitar.display();
		guitar.makeSound();
		System.out.println("--------------");
		drum.display();
		drum.makeSound();
		System.out.println("--------------");
		piano.display();
		piano.makeSound();
		System.out.println("--------------");
		grandPiano.display();
		grandPiano.makeSound();
	}
}
