import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.println("Please, enter sides of triangle : ");
		
		/*Sides of Triangle*/
		System.out.print("a : ");
		  double a = scan.nextDouble();
		
		System.out.print("b : ");
		  double b = scan.nextDouble();
		  
		System.out.print("c : ");
		  double c = scan.nextDouble();
		  
		/*Height of Triangle*/
		  
		double u = (a+b+c)/2;
		
		/*Informations of Triangle*/
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Informations of Triangle");
		System.out.println("Side of a : " + a );
		System.out.println("Side of b : " + b );
		System.out.println("Side of c : " + c );
		System.out.println("Height of Triangle : " + u );
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		
		/*Calculating Field*/
		double field = u * ((u - a) * (u - b) * (u - c));
		System.out.println("The field of tringle is " + field);
		
	}
}
