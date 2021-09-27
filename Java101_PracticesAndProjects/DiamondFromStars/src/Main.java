import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		  int n = scan.nextInt();
		
		for(int i = 0; i <= n ; i++) {
			for (int j = 0; j < (n - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
            
		}
		
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
