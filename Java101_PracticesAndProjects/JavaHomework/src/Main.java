import java.util.Scanner;

public class Main {
	
	static int minusFive(int number, boolean rPoint, int counter) {
		
		if(rPoint) {
			if(number > 0) {
				System.out.print(number + " ");
				counter ++;
				return minusFive(number - 5 , true, counter);
			}else {
				return minusFive(number, false, counter);
			}
		}else {
			System.out.print(number + " ");
			if(counter > 0) {
				counter --;
				return minusFive(number + 5, false, counter);
			}else {
				return 0;
			}
		}
		
		
		/*
		 if (dNoktasi) {
            if (n > 0) {
                System.out.print(n + " ");
                sayac++;
                return besCikar(n - 5, true, sayac);
            } else {
                return besCikar(n, false, sayac);
            }
        } else {
            System.out.print(n + " ");
            if (sayac > 0) {
                sayac--;
                return besCikar(n + 5, false, sayac);
            } else {
                return 0;
            }
        }*/
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number :");
		int number = scan.nextInt();
		
		System.out.println("------------------------");
		minusFive(number, true, 0);
		
		
	}

}
