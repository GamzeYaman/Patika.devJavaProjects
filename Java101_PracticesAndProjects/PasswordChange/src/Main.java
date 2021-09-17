import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*Existing informations*/
		String userName = "PurpleWorld";
		String password = "bp16bts13*";
		
		System.out.println("Hello, Purple world! Please enter the password!");
		System.out.print("Password : ");
		 String passwd = scan.next();
		
		 /*Controlling password*/
		if (passwd.equals(password)) {
			System.out.println("Welcome your world :)");
			
		}else {
			System.out.println("Your password is wrong. Did you forget it, do you want to create a new one?");
			
			int yes = 1;
			int no = 2;
			System.out.println("1.Yes" + "\n" + "2.No");
			System.out.print("Your Option : ");
			  int select = scan.nextInt();
			  
			  switch(select) {
			     case 1 : /*Changing password proccess*/
			    	  System.out.print("Please enter a new password : ");
					    String newPassword = scan.next();
					    
					    if(newPassword.equals(password)) {
					    	System.out.println("The password wasn't be created.Your new password doesn't have to same with old one.Please create different one.");
					    	
					    }else{
					    	System.out.println("The password was created.");
					    	password = newPassword;
					    } 
					   break;
				
			     case 2 : 
			    	 System.out.println("You are useing your existing password.");
			    	 break;
			     
			     default :
			    	 System.out.println("Please select an option between  1 and 2 !");
			  }
			 
		}
		
		
	}
}
