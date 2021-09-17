import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.print("Please, enter number 1 : ");
		  double n1 = scan.nextDouble();
		
		System.out.print("Please, enter number 2 : ");
		  double n2 = scan.nextDouble();
		  
		
		int sum = 1 , extraction = 2 , multiplication = 3 , division = 4;
		
		System.out.println( "1. Sum " + "\n" + "2. Extraction " + "\n" + "3. Multiplication " + "\n" + "4. Division ");
		System.out.println("Please, select an option.");
		  int select = scan.nextInt();
		
		  
	   switch(select) {
	      case 1 : 
	    	  double result1 = n1 + n2 ;
	    	  System.out.println("Sum : " + result1);
	    	  break;
	    	  
	      case 2 :
	    	  double result2 = n1 - n2;
	    	  System.out.println("Extraction : " + result2);
	    	  break;
	    
	      case 3 :
	    	  double result3 = n1 * n2;
	    	  System.out.println("Multiplication : " + result3);
	    	  break;
	    	  
	      case 4 :
	    	  if(n1 == 0 || n2 == 0) {
	    		  System.out.println("Division : " + 0);
	    	  }else {
	    		  double result4 = n1 / n2;
		    	  System.out.println("Division : " + result4);  
	    	  }
	    	  break;
	    	  
	      default:
	    	  System.out.println("Please select an option between 1 - 4");
	   }
		
		
	}
}
