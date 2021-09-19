import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.println("Could you please enter the temperature value?");
		  double temperature = scan.nextDouble();
		  
		String result;
		
		boolean condition1 = (temperature <= 5);
		boolean condition2 = (temperature > 5) && (temperature <= 15);
		boolean condition3 = (temperature > 15) && (temperature <= 25);
		boolean condition4 = (temperature > 25);
		
		result = condition1 ? "You can do skiing." :
			     condition2 ? "You can go to cinema." :
			     condition3 ? "You can have a picnic." :
			     condition4 ? "You can swim."  : "You can sleep" ;
		
		System.out.println(result);
			
			
	
		  
	}
}
