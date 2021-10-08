import java.util.Scanner;

public class Main {
	
	static int prime(int number , int i){
		
		if(i < number) {
			if(number % i != 0) {
				return (prime(number , ++i));
			}else {
				return 0;
			}
		}
		
		return 1;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number :");
		int number = scan.nextInt();
		
		if(prime(number, 2) == 1) {
			System.out.println(number + " is a prime number.");
		}else {
			System.out.println(number + " isn't a prime number.");
		}
		
	}

}
