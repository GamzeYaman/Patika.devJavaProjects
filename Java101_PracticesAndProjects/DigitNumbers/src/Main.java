import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		  int number = scan.nextInt();
		
		int sum = 0;
		
		while(number != 0) {
			sum += (number % 10);
			number = number / 10;
		}
		
		System.out.println("The sum of " + number + "'s digits is " + sum);
		 
	}

}
