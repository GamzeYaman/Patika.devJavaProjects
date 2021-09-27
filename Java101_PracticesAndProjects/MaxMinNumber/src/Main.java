import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many number will you enter? ");
		  int number = scan.nextInt();
		
		int i = 0 , bigNumber = 0 , n , smallNumber = 0;
		while(i < number) {
			System.out.print("Enter a number : ");
			   n = scan.nextInt();
			
			if (n > bigNumber) {
				bigNumber = n;
			}
			
			if(n < smallNumber || n < bigNumber) {
				smallNumber = n;
			}
			
			i++;
		}
		System.out.println("Max number is " + bigNumber);
		System.out.println("Min number is " + smallNumber);
	}

}
