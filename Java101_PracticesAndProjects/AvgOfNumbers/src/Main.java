import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Hello, enter a number : ");
		  int number = scan.nextInt();
		
		int sum = 0 , count = 0 , avg = 0;
		
		
		for(int i = 0; i < number; i++) {
			if(i % 3 == 0 && i % 4 == 0) {
				if(i == 0) continue;
				sum += i;
				count++;
			}
		}
		
		avg = sum / count;
		System.out.println("Average of numbers that is divisible without remainder with 3 and 4 is " + avg);
	}
	

}
