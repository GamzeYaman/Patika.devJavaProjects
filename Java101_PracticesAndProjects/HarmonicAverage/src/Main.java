
public class Main {
	
	public static void main(String[] args) {
		
		int numbers[] = {1, 2, 3, 4, 5};
		double sum = 0;
		double totalHarmonic;
		
		for(int i = 0; i < numbers.length; i++) {
			sum = sum + 1.0/numbers[i];
		}
		
		totalHarmonic = (numbers.length / sum) ;
		
		System.out.println("Harmonic average of items in array : "  + totalHarmonic);
		
		
		
		
	}

}
