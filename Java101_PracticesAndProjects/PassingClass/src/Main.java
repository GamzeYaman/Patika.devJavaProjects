import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello! Please enter your notes.");
		
		/*Lessons' info*/
		System.out.print("Turkish : ");
		  double turkishNote = scan.nextDouble();
		System.out.print("Math : ");
		  double mathNote = scan.nextDouble();
		System.out.print("Physics : ");
		  double physicsNote = scan.nextDouble();
		System.out.print("Chemistry : ");
		  double chemistryNote = scan.nextDouble();
		System.out.print("Music : ");
		  double musicNote = scan.nextDouble();
		  
		  /*Checks that the notes are between 0 and 100 or not*/
		 if ((turkishNote > -1 && turkishNote < 101) && (mathNote > -1 && mathNote < 101) && (physicsNote > -1 && physicsNote < 101)
				 && (chemistryNote > -1 && chemistryNote < 101) && (musicNote > -1 && musicNote < 101)) {
			
			 double passMark = (turkishNote + mathNote + physicsNote + chemistryNote + musicNote) / 5 ;
			 
			 /*Checks that the pass mark is between 0 and 100 or not*/
			 if(passMark > -1 && passMark < 101) {
				 
				 /*Pass mark conditions*/
				 if(passMark < 55) {
					 System.out.println("You couldn't pass the class. Your point is " + passMark);
				 }
				 else if (passMark >= 55 && passMark <= 69) {
					 System.out.println("You passed the class with an average point. Your point is " + passMark);
				 }
				 else if (passMark >= 70 && passMark <= 84) {
					 System.out.println("You passed the class with a good point. Your point is " + passMark);
				 }
				 else {
					 System.out.println("You passed the class with a super point. Your point is " + passMark);
				 }
				 
			 }else { 
				 System.out.println(passMark + " >>>There is an error into lessons' point, please check it.");
			 }
			
		 } else { /*If the notes are bigger than 100  or lower than 0.*/
			 System.out.println("Please enter an available point between 1-100 !");	 
			 
		 }
		
	}
}
