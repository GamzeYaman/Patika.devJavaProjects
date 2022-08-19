import java.util.Scanner;

public class Game {

	Player player;
	Location location;
	   
	 Scanner scan = new Scanner(System.in);
	 
	public void login() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to adventure game.");
		
		System.out.print("Please enter your name :");
		String playerName = scan.nextLine();
		
		player = new Player(playerName);
		player.selectCha();
		
		start();
	}
	
	public void start() {
		while(true) {
		System.out.println("============================");
		System.out.println("Please select a place : ");
		System.out.println("1. Safety Home => This place is safe , there is no enemy.");
		System.out.println("2. Cave => You can come across with zombies.");
		System.out.println("3. Forest => You can come across with vampires.");
		System.out.println("4. River => You can come across with bears.");
		System.out.println("5. Store => You can buy gun and armor.");
		System.out.println("Your Choice:");
		int selectLoc = scan.nextInt();		
		
		  while(selectLoc < 1 || selectLoc > 5) {
			  System.out.println("Please enter a valid number :");
			  selectLoc = scan.nextInt();
		  }
		  
		  switch(selectLoc) {
		  case 1:
			  location = new SafetyHouse(player);
			  break;
		  case 2:
			  location = new Cave(player);
			  break;
		  case 3:
			  location = new Forest(player);
			  break;
		  case 4:
			  location = new River(player);
			  break;
		  case 5:
			  location = new ToolStore(player);
			  break;
		  default :
			  location = new SafetyHouse(player);
		  }
		
		  if(!location.getLocation()) {
			  //getLocationdan dönen eðer false ise oyunu bitir
			  System.out.println("Gameover...");
			  break;
		  }
		}
		
	}
}
