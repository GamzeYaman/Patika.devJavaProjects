import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		  int n1 = scan.nextInt();
		
		System.out.print("Enter another number for calculating exponential : ");
		  int n2 = scan.nextInt();
		
		  int result = 1; 
		  
		for(int i = 1; i <= n2; i++) {
			result *= n1;
		}
		
		System.out.println(n1 + "**" + n2 + " : " + result);
				  
	}

}
