
public class Match {

	Fighter fighter1;
	Fighter fighter2;
	int maxWeight;
	int minWeight;
	
	public Match(Fighter fighter1 , Fighter fighter2, int maxWeight, int minWeight) {
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.maxWeight = maxWeight;
		this.minWeight = minWeight;
	}
	
	public void run(){
		if(isCheck()) {
			while(this.fighter1.health > 0 && this.fighter2.health > 0) {
				System.out.println("!New Round!");
				/*this.fighter2.health = fighter1.hit(this.fighter2);
				if(isWin()) {
					break;
				}
								
				this.fighter1.health = this.fighter2.hit(fighter1);
				if(isWin()) {
					break;
				}*/
				
				if(isFirst() == 0) { //enemy is fighter2
					this.fighter2.health = fighter1.hit(this.fighter2);
					if(isWin()) {
						break;
					}
					this.fighter1.health = this.fighter2.hit(fighter1);
					if(isWin()) {
						break;
						}
				}else { // enemy is fighter1
					this.fighter1.health = this.fighter2.hit(fighter1);
					if(isWin()) {
						break;
				    }
					this.fighter2.health = fighter1.hit(this.fighter2);
					if(isWin()) {
						break;
					}
				}
				System.out.println(this.fighter2.name + " 's remain health : " + this.fighter2.health);
				System.out.println(this.fighter1.name + " 's remain health : " + this.fighter1.health);

				System.out.println("*********");
				
			}
			
		}else {
			System.out.println("Weights of two fighter aren't balance!");
		}
	}


	public boolean isCheck() {
		return (this.fighter1.weight >= minWeight && this.fighter1.weight <= maxWeight) 
				&& (this.fighter2.weight >= minWeight && this.fighter2.weight <= maxWeight);
	}
	
	public int isFirst(){ // %50 chance for starting to match first
		double number = Math.random();
		if(number <= 100 && number >= 0) {
			if(number <= 50) {
				return 0;
			}else {
				return 1;
			}
		}
		
		return 1;
	}
	public boolean isWin() {
		if(this.fighter1.health == 0) {
			System.out.println(this.fighter2.name + " win :)");
			return true;
		}
		
		if(this.fighter2.health == 0) {
			System.out.println(this.fighter1.name + " win :)");
			return true;
		}
		
		return false;
	}



}
