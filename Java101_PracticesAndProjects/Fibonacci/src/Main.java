import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		  int number = scan.nextInt();
		
		int sum = 0 , n1 = 0 , n2 = 1;
		
		System.out.print(n1 + " " + n2);
		
		for(int i = 2; i <= number; i++) {
	
			sum = n1 + n2;
			System.out.print(" " + sum);
			n1 = n2;
			n2 =sum;
		}
	}

}
