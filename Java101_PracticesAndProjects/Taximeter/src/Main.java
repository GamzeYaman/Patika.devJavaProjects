import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double km , rateKM = 2.20;
		int minPrice = 20 , openingPrice  = 10;
		
		System.out.println("Hello!");
		System.out.print("Please, enter KM information : ");
		  km = scan.nextDouble();	
		  
		double price = openingPrice + (km * rateKM);
		
		if(price < minPrice) {
		
			System.out.println("Taxi price is 20TL.");
			
		}else {
			
			System.out.println("Taxi price is " + price + "TL.");
			
		}
	}
}
