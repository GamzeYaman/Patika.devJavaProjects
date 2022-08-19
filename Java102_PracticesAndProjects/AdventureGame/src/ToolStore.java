
public class ToolStore extends NormalLocation {
	
	public ToolStore(Player player) {
		super(player,"ToolStore");
		
	}


	public boolean getLocation() {
		System.out.println("Money : " + player.getMoney());
		System.out.println("1. Weapons");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		System.out.print("Your choice : ");
		int selectTool = scan.nextInt();
		int selectedItemID;
		
		switch (selectTool) {
			case 1:
				selectedItemID = weaponMenu();
				buyWeapon(selectedItemID);
				break;
		   default:
			   selectedItemID = armorMenu();
			   buyArmor(selectedItemID);
			   break;
		}
		
		return true;
	}
	
	public int weaponMenu() {
		System.out.println("1. Gun  < Price: 10 - Damage: 2 >");
		System.out.println("2. Sword < Price: 35 - Damage: 3 >");
		System.out.println("3. Rifle < Price: 15 - Damage: 7 > ");
		System.out.println("4. Exit");
		System.out.print("What do you want to buy? >>");
		int selectedWeaponID = scan.nextInt();
		return selectedWeaponID;
	}
	
	public int armorMenu() {
		System.out.println("1. Light <Price: 15 -  Blocking: 1>");
		System.out.println("2. Medium <Price: 25 - Blocking: 3>");
		System.out.println("3. Heavy <Price: 40 - Blocking: 5>");
		System.out.println("4. Exit");
		System.out.print("What do you want to buy? >> ");
		int selectedArmorID = scan.nextInt();
		return selectedArmorID;
	}
	
	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String weaponName = null;
		
		switch(itemID) {
		case 1: 
			weaponName = "Gun";
			price = 10;
			damage = 2;
			break;
			
		case 2: 
			weaponName = "Sword";
			price = 35;
			damage = 3;
			break;
		
		case 3:
			weaponName = "Rifle";
			price = 15;
			damage = 7;
			break;
		case 4:
			System.out.println("Exiting...");
			break;
		default:
		System.out.println("Invalid process!");
		}
		
		if(price > 0) {
		if(player.getMoney() >= price) {
			player.getInventory().setDamage(damage);
			player.getInventory().setWeaponName(weaponName);
			player.setMoney(player.getMoney() - price);
			
			System.out.println("You have bought " + weaponName + " . " + " Your new damage : " + player.getTotalDamage());
		    System.out.println("Available Balance : " + player.getMoney());
		}else {
			System.out.println("There is no enough money.");
		}
		}
		
	}

	public void buyArmor(int itemID) {
		int blocking = 0 , price = 0;
		String armorType = null;
		
    	switch(itemID){
    	case 1:
    		armorType = "Light";
    		price = 15;
    		blocking = 1;
    		break;
 
    	case 2:
    		armorType = "Medium";
    		price =25;
    		blocking = 3;
    		break;
    		
    	case 3:
    		armorType = "Heavy";
    		price = 40;
    	    blocking = 5;
    	    break;
    	case 4:
    		System.out.println("Exiting...");
    		break;
    	default:
    		System.out.println("Invalid Process!");
		}
    	
    	if(price > 0) {
    		if(player.getMoney() >= price) {
    			player.getInventory().setArmor(blocking);
    			player.getInventory().setArmorName(armorType);
    			player.setMoney(player.getMoney() - price);
    		System.out.println("You have bought " + armorType +" " + "Your blocking damage is " + player.getInventory().getArmor());
    		System.out.println("Available Balance :" + player.getMoney());	
    		}
    		else {
    			System.out.println("There is no enough money.");
    		}
    	}
	}
}
