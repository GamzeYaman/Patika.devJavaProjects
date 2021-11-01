import java.util.Arrays;

public class Main {
	
	static boolean isFind(int[] arr , int value) {
		for(int i : arr) {
			if(i == value) {
				return true;
			}
		}
		
		return false;
	}



	public static void main(String[] args) {

		int[] list = {3, 7, 3, 3, 2, 8, 10, 21, 1, 33, 8, 1, 10, 12, 15, 12};
		int[] duplicate = new int[list.length];
		int startIndex = 0;
		
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list.length; j++) {
				if(i != j && list[i] == list[j]) {
					if(!isFind(duplicate, list[i]) && list[i] % 2 == 0 ) {
							duplicate[startIndex++] = list[i];
							break;
						}		
				}
			}
		}
		
		System.out.println(Arrays.toString(list));
		
		for (int value : duplicate) {
			if(value != 0) {
				System.out.println("Duplicate Items in Array : " + value);
			}
		}
		
	}

}
