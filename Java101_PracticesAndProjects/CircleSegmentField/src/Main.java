import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*Variables of Circle Segment*/
		double r , a , pi = 3.14;
		
		/*Taking informations from user*/
		System.out.print("Enter Radius : ");
		  r = scan.nextDouble();
		
		System.out.print("Enter Central Angle : ");
		  a = scan.nextDouble();
		 
		/*The Formula*/
		 double field = (pi * (r*r) *a) / 360;
		 
		/*Informations of Circle Segment*/
		 System.out.println("----------------------------------------------------------------------------------");
		 System.out.println("The Informations ");
		 System.out.println("The radius : " + r);
		 System.out.println("The central angle : " + a);
		 System.out.println("-----------------------------------------------------------------------------------");
		 
		 System.out.println("The field of circle segment is " + field);
	}
}
