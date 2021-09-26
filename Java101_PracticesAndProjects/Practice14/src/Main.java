import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please, enter a number :");
		  int number = scan.nextInt();
		

		  System.out.println("Multiples of 4 ");
		  for(int i = 1; i <= number; i*=4) {
			  System.out.print(i + ",");
		}
		  System.out.println("\n");
		  System.out.println("Multiples of 5 ");
		  for(int i = 1; i <= number; i*=5) {
			  System.out.print(i + ",");
		}
	}
}
