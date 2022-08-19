
public abstract class BattleLocation extends Location{

	protected Obstacle obstacle;
	protected String itemAward;
	public BattleLocation(Player player, String name, Obstacle obstacle, String itemAward) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.itemAward = itemAward;
	}
	
	//savaþma alaný
	public boolean getLocation() {
		int obsCount = obstacle.ObstacleCount();
		System.out.println("You are at " + this.name + " now.");
		System.out.println("Be Careful! There are "+ obsCount + " "+ obstacle.getName() + " in hear.");
		System.out.print("<F>ight or <R>un : ");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		if(selCase.equals("F")) {
			if(combat(obsCount)) {
				System.out.println("You have cleaned enemy in " + this.getName());
				if(this.itemAward.equals("Food") && player.getInventory().isFood() == false) {
					System.out.println("You have win " + this.itemAward);
					player.getInventory().setFood(true);
				}
				if(this.itemAward.equals("Firewood") && player.getInventory().isFirewood() == false){
					System.out.println("You have win " + this.itemAward);
					player.getInventory().setFirewood(true);
				}
				if(this.itemAward.equals("Water") && player.getInventory().isWater() == false) {
					 System.out.println("You have win " + this.itemAward);
					 player.getInventory().setWater(true);
				}
				
				return true;
			}else {
				System.out.println("You have died.");
				return false;
			}
		}
		
		return true;

	}
	
	public boolean combat(int obsCount) {
		for(int i = 0 ; i < obsCount ; i++) {
		    int defObstacleHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
		while(player.getHealth() > 0 && obstacle.getHealth() > 0) {
			System.out.print("<H>it or <R>un : "); 
			String selCase = scan.next();
			selCase = selCase.toUpperCase();
			if(selCase.equals("H")) {
				System.out.println("You hit!");
				obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
				afterHit();
				if(obstacle.getHealth() > 0) {
					player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInventory().getArmor()));
					afterHit();	
				}
				
			}else {
				return false;
			}
			
			if(obstacle.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("You have killed all enemies...");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Your new money amount :" + player.getMoney());
				obstacle.setHealth(defObstacleHealth);
			}
		}
		 return true;
	}
		return false;
	}
	
	public void playerStats() {
		System.out.println("Player Features >>>");
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.getTotalDamage());
		System.out.println("Money: " + player.getMoney());
		if(player.getInventory().getDamage() > 0) {
			System.out.println("Weapon: " + player.getInventory().getWeaponName());
		}
		if(player.getInventory().getDamage() > 0) {
			System.out.println("Armor: " + player.getInventory().getArmorName());
		}
		System.out.println("----------------------------------------------------------");
	
	}
	
	public void enemyStats() {
		System.out.println( obstacle.getName() + "Features >>>");
		System.out.println("Health: " + obstacle.getHealth());
		System.out.println("Damage: " + obstacle.getDamage());
		System.out.println("Award: " + obstacle.getAward());
	}
	
	public void afterHit() {
		System.out.println(player.getName() + " Health : " + player.getHealth());
		System.out.println(obstacle.getName() + " Health : " + obstacle.getHealth());
		System.out.println();
	}
}
