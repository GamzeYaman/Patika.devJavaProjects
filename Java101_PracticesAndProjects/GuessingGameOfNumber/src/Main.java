import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Random random = new Random();
		int number = random.nextInt(100);
		
		int right = 0, selected;
		boolean isWin = false;
		
		while(right < 5) {
			System.out.print("Enter your guess : ");
			selected = scan.nextInt();
			
			if(selected < 100 && selected > 0) {
				if(selected == number) {
					isWin = true;
					break;
				}else if(selected < number) {
					right++;
					if(right < 5) {
						System.out.println("Try again and increase your guessing number please!");
						System.out.println("Your residual right : " + (5 - right));
					}
					else{
						break;
					}

				}else if(selected > number) {
					right++;
					if(right < 5) {
						System.out.println("Try again and decrease your guesssing number please!");
						System.out.println("Your residual right : " + (5 - right));
					}
					else{
						break;
					}
				}
			}else {
				System.out.println("Please, enter a number between 0 - 100!");
				break;
			}
					
		}
		
		if(isWin == true) {
			System.out.println("Congrats :) Correct number! You win :)");
		}
		else{
			System.out.println("OMG You don't have any rights, so you lose :( The number was " + number);
		}
		
	}

}
