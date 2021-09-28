import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		  int n = scan.nextInt();
		
		  for (int x = 0; x <= n; x++) {

	            for (int y = 0; y <= x; y++) {
	                System.out.print(" ");
	            }
	            for (int z = 1; z < (2 * n) - (2 * x); z++) {
	                System.out.print("*");
	            }
	            System.out.println("");
	        }
	}
}
