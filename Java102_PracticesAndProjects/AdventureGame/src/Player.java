import java.util.Scanner;

public class Player {

	private int damage,health,money,rHealht;
	private String name, cName;
	private Inventory inventory;
	
	Scanner scan = new Scanner(System.in);
	
	//constructor
	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
		}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int healthy) {
		this.health = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public int getrHealht() {
		return rHealht;
	}

	public void setrHealht(int rHealht) {
		this.rHealht = rHealht;
	}

	
	public void selectCha() {
		switch(chaMenu()) {
		
		case 1 : 
			initPlayer("Samuray", 5, 21, 15 );
			break;
	
		case 2 :
			initPlayer("Okçu", 7, 18, 20);
			break;
			
		case 3 :
			initPlayer("Þovalye", 8, 24, 5);
			break;
			
		default :  //olurda karakter þeçilmezsse oyun buga girmemesi için default olarak samuray karakteri ayarlandý
		    initPlayer("Samuray", 5, 21, 15);
			break;
		}
		
		System.out.println("Your character = " + " " + "Character Name : " + getcName() + " , "
		                    + "Damage : " + getDamage() + " , "
		                    + "Health : " + getHealth() + " , "
		                    + "Money : " + getMoney());
	}
	
	public int chaMenu() {
		System.out.println("Please select a character: ");
		System.out.println("1: Samuray >>>" + " Damage: 5 , Health: 21 , Money: 15 ");
		System.out.println("2: Okçu >>>" + " Damage: 7 , Health: 18 , Money: 20");
		System.out.println("3: Þovalye >>>" + " Damage: 8 , Health: 24 , Money: 5");
		
		System.out.print("Your choice:");
		int chaID = scan.nextInt();
		
		while(chaID < 1 || chaID >3) {
			System.out.print("Please enter a valid number : ");
			chaID = scan.nextInt();
		}
		
		return chaID;
	}
	public int getTotalDamage() {
		return this.getDamage() + this.getInventory().getDamage();
	}
	public void initPlayer(String cName, int damage, int health, int money) {
		setcName(cName);
		setDamage(damage);
		setHealth(health);
		setMoney(money);
		setrHealht(health);
	}
	
	
	
}
