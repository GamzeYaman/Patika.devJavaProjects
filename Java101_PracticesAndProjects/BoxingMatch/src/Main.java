
public class Main {

	public static void main(String[] args) {

		Fighter fighter1 = new Fighter("Aslan", 10 , 120 , 75, 30);
		Fighter fighter2 = new Fighter("Kaplan" , 10 , 130 , 77, 40);
	
		Match round1 = new Match(fighter1, fighter2, 80, 60);
		round1.run();
	}

}
