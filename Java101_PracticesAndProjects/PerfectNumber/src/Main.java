import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		  int number = scan.nextInt();
		 
		int sum = 0;
		for(int i = 1; i < number; i++) {
			if(number % i == 0) {
				sum += i;
			}
		}
		
		if(sum == number) {
			System.out.println(number + " is a perfect number.");
		}else {
			System.out.println(number + " isn't a perfect number.");
		}
	}

}
