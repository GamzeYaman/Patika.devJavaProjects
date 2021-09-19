import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello, could you please enter three numbers?");
		System.out.print("n1 : ");
		  int n1 = scan.nextInt();
		System.out.print("n2 : ");
		  int n2 = scan.nextInt();
		System.out.print("n3 : ");
		  int n3 = scan.nextInt();
		 
		if(n1 < n2 && n1 < n3) {
			   if(n2 < n3) {
				   System.out.println(n1 + "<" +  n2 + "<" + n3);
			   }else {
				   System.out.println(n1 + "<" +  n3 + "<" + n2);
			   }
		}
		else if(n2 < n1 && n2 < n3) {
			   if(n1 < n3) {
				   System.out.println(n2 + "<" +  n1 + "<" + n3);
			   }else {
				   System.out.println(n2 + "<" +  n3 + "<" + n1);
			   }		
		}
		else {
			   if(n1 < n2) {
				   System.out.println(n3 + "<" +  n1 + "<" + n2);
			   }else {
				   System.out.println(n3 + "<" +  n2 + "<" + n1);
			   }
		}
	}
}
