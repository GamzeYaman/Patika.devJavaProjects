import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		  int n = scan.nextInt();
		
		System.out.print("Enter another number : ");
		  int r = scan.nextInt();
		  
		int nf = 1 , rf = 1 , nrf = 1;
		
		// n factoriel : 
		for(int i = 1; i <= n; i++) {
			nf = nf * i;
		}
		
		// r factoriel :
		for(int j = 1; j <= r; j++) {
			rf = rf * j;
		}
		
		//(n-r) factoriel :
		for(int a = 1; a <= (n-r); a++) {
			nrf = nrf * a;
		}
		
		int combination = nf / (rf * nrf);
		System.out.println("Combination of " + n + " and " + r + " is " + combination);
	}

}
