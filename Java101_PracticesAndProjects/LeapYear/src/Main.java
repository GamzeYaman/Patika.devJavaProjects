
import java.util.Scanner;

public class Main {
		
		public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Please, enter a year : ");
			int year = scan.nextInt();
			
			int remainderHundred , remainderFour , leapYear;
			remainderHundred = year % 100;
			remainderFour = year % 4;
			
			if(remainderFour == 0) {
				
				if(remainderHundred == 0) {
				     leapYear = year % 400;
				     
				     if(leapYear == 0) {
				    	 System.out.println(year + " is a leap year.");
				     }else {
				    	 System.out.println(year + " is not a leap year.");
				     }
				}
				else {
					System.out.println(year + " is a leap year.");
				}
			}
			else {
				System.out.println(year + " is not a leap year.");
			}
		}

	}
