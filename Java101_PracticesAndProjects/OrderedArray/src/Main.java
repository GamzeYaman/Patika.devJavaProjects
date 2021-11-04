import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter length of array : "); 
		int arrayLength = scan.nextInt();
		int number, starting = 0;
		int[] array = new int[arrayLength];
		
		System.out.println("Enter items of array >>");
		for(int i = 0; i < arrayLength; i++) {
			System.out.print("Enter a number : ");
			number = scan.nextInt();
			array[i] = number;
		}
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
