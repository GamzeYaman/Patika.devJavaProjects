import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*Variables*/
		double kg , h;
		
		/*Taking info abut people*/
		System.out.println("Hello!");
		System.out.print("Please, enter your height : ");
		  h = scan.nextDouble();
		
		System.out.print("Please, enter your kilo : ");
		  kg = scan.nextDouble();
		  
		/*Formula*/
		double bmi = kg / (h * h);
		
		System.out.print("Your Body Mass Index is " + bmi);
		
	}
}
