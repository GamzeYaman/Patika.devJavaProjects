import java.util.Scanner;

public class Main {
	
	static boolean isPalindromic(String word) {
		String reverseWord = "";
		
		for(int i  = word.length() - 1; i >= 0; i--) {
			reverseWord += word.charAt(i);
		}
		
		if(reverseWord.equals(word)) {
			return true;
	    }else {
			return false;
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); 
		System.out.print("Enter a word : ");
		String word = scan.next();
		
		if(isPalindromic(word)) {
			System.out.println(word + " is a palindromic word.");
		}else {
			System.out.println(word + " isn't a palindromic word.");
		}
	}

}
