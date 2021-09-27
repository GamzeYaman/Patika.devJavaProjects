import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number that is wanted to find its harmonic series : ");
		  int n = scan.nextInt();
		
		double sum = 0;
		
		for(int i = 1 ; i <= n ; i++) {
			sum += 1 / i;
		}
		
		System.out.println("The result is " + sum);
		
	}
}
