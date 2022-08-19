
public class SafetyHouse extends NormalLocation{
	
	public SafetyHouse(Player player) {
		super(player, "Safety House");
	}
	
	public boolean getLocation() {
		player.setHealth(player.getrHealht());
		System.out.println("Now, you're in Safety House.");
		System.out.println("Your health was fulled.");
		return true;
	}

}
