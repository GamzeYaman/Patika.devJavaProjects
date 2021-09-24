import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int i = 0 , sum = 0;
		
		while(i % 2 != 1) {
			System.out.println("Please, enter a number:");
			   i = scan.nextInt();
			
			if(i % 2 == 0 && i % 4 == 0) { // The numbers that are even and divisible with 4.
				sum =+ i;
			}
		}
		
		System.out.println("Sum of numbers that are even and divisible with 4 is " +  sum);
	}

}
