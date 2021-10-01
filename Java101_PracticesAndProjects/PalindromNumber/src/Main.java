
public class Main {

	static boolean isPalindrom(int n) {
		int number = n , reverseNumber = 0 , lastNumber;
		
		while(number != 0) {
			lastNumber = number % 10;
			reverseNumber = (reverseNumber * 0) + lastNumber;
			number /= 10;
		}
		
		if(reverseNumber == n) {
			System.out.println(n + " is a palindrom number.");
		}else {
			System.out.println(n + " is not a palindrom number.");
		}
		
		return true;
	}
	public static void main(String[] args) {

		isPalindrom(789);
	}

}
