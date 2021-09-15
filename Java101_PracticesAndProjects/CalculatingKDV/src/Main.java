import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.print("Please, enter a money value : ");
		double money = scan.nextDouble();
		
		/*Variables about kdv*/
		int kdv;
		double rateKDV ;
		double withKDV ; /*Price with kdv*/
		
		
		
		if ( money > 0 && money < 1000) { 
			kdv = 18;
			rateKDV = (money * kdv) / 100;
			withKDV = rateKDV + money;
			
			System.out.println("Price without KDV : " + money);
			System.out.println("Price with KDV : " + withKDV);
			System.out.println("Rate of KDV : " + rateKDV);
			
		}else { /*Money > 1000 stiutaion*/
			kdv = 8;
			rateKDV = (money * kdv) / 100;
			withKDV = rateKDV + money;
			
			System.out.println("Price without KDV : " + money);
			System.out.println("Price with KDV : " + withKDV);
			System.out.println("Rate of KDV : " + rateKDV);
		}
	}

}
