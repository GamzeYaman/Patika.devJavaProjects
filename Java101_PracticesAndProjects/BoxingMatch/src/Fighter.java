
public class Fighter {

	String name;
	int health;
	int damage;
	int weight;
	int dodge; //blocklama yeteneði
	
	public Fighter(String name, int damage, int health, int weight, int dodge) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.weight = weight;
		if(dodge >= 0 && dodge <= 100) {
			this.dodge = dodge;
		}else {
			this.dodge = 0;
		}
	}
	
	public int hit(Fighter foe) {
		System.out.println(this.name + " hit to " + foe.name + " with " + this.damage + " damage.");
		if(isDodge()) {
			System.out.println(foe.name + " blocked the damage!");
			return foe.health;
		}
		if(foe.health - this.damage < 0) {
			return 0;
		}
		return foe.health - this.damage;
	}
	
	public boolean isDodge() {
		double randomNumber = Math.random() * 100;
		return randomNumber <= this.dodge;
	}
}
