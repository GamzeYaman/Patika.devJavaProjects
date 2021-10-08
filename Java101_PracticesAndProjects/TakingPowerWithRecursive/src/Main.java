import java.util.Scanner;

public class Main {

	static int exponent(int base , int exponent) {
		
		if(exponent != 0) {
			return base * exponent(base, exponent - 1);
		}else {
			return 1;
		}
		
	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int base , exponent , result;
		
		System.out.print("Enter base : ");
		base = scan.nextInt();
		System.out.print("Enter exponent : ");
		exponent = scan.nextInt();
		
		result = exponent(base, exponent);
		System.out.println("Result : " + result);
				
	}

}
