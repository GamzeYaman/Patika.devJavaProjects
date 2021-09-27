import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter two numbers : ");
		System.out.print("Number 1 : ");
		  int n1 = scan.nextInt();
		System.out.print("Number 2 : ");
		  int n2 = scan.nextInt();
		  
		int i = 1 , ebob = 1;
		
		 while(i <= n1) {
			 if(n1 % i == 0 && n2 % i == 0) {
				 ebob = i;
			 }
			 
			 i++;
		 }
		 System.out.println("EBOB of " + n1 + " and " + n2 + " : " + ebob);
		
		 
	   int j = 1 , ekok = 1;
	      
	     /* while(j <= n1 * n2) {
	    	  if(n1 % j == 0 && n2 % j == 0) {
	    		  ekok = j;
	    		  break;
	    	  }
	    	  j++;
	      }*/
		 
		 int a = 1;
	        while (a <= n1 * n2) {
	            if (a % n1 == 0 && a % n2 == 0) {
	                ekok = a;
	                break;
	            }
	            a++;
	        }
	      System.out.println("EKOK of " + n1 + " and " + n2 + " : " + ekok);
	     
		 
		 
	}

}
