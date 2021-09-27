import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String username , password;
		int option , amountOfMoney , right = 3;
		double balance = 11000;
		
		while(right > 0) {
			System.out.println("Hello, please enter your username and password : ");
			System.out.print("Username : ");
			  username = scan.next();
			System.out.print("Password : ");
			  password = scan.next();
			
			if(username.equals("Patika") && password.equals("dev123")) {
					System.out.println("Welcome your bank account. What do you want to do?");
					System.out.println("1.Investing Money" + "\n2.Taking Money" + "\n3.Balance Inquiry" + "\n4.Exit");
					System.out.print("Your Option : ");
					  option = scan.nextInt();
						
						switch(option) {
						case 1:
							System.out.print("Amount of Money : ");
							  amountOfMoney = scan.nextInt();
							balance += amountOfMoney;
							System.out.println("Your new balance : " + balance );
							break;
						
						case 2:
							System.out.print("Amount of Money : ");
							  amountOfMoney = scan.nextInt();
							
							if(amountOfMoney > balance) {
								System.out.println("Balance is not enough!");
							}else {
								System.out.println("The process is successful.");
								balance -= amountOfMoney;
								System.out.println("Your new balance : " + balance);
							}
							break;
							
						case 3:
							System.out.println("Your balance : " + balance);
							break;
						
						case 4:
							System.out.println("You have exited.");
							break;
						
						default:
							System.out.println("Please enter an available number between 1-4!");
						}				
						break;
			 }else {
			     right --;
				 System.out.println("Your informations is wrong!");
				 
				 
				 if(right == 0) {
					 System.out.println("Your account has blocked please make contact with the bank!");
				 }else {
					 System.out.println("You have last " + right + " right!");
				 }
			 }
		}
		
		 
		 
		
		
		}
	}


