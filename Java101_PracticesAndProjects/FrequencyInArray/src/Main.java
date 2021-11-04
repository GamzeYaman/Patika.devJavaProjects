import java.util.Arrays;

public class Main {

	static boolean isFind(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {

	        int[] list = {10, 20, 20, 10, 10, 20, 5, 20};

	        int[] duplicate = new int[list.length];
	        int[] repetitive = new int[list.length];

	        int startIndex = 0;
	        int counter1 = 0;
	        int counter2 = 0;
	        int temp;


	        String lst1 = Arrays.toString(list);
	        System.out.println("Dizi : " + lst1);

	        while (counter1 < list.length) {
	            for (int i = 0; i < list.length - 1; i++) {
	                if (list[i] > list[i + 1]) {
	                    temp = list[i];
	                    list[i] = list[i + 1];
	                    list[i + 1] = temp;
	                }

	            }
	            counter1++;
	        }


	        for (int k : list) {
	            for (int i : list) {
	                if ((k == i)) {
	                    if (!isFind(duplicate, k)) {
	                        duplicate[startIndex++] = k;
	                    }
	                    break;
	                }

	            }
	        }


	        for (int x = 0; x < duplicate.length; x++) {
	            for (int i : list) {
	                if (duplicate[x] == i) {
	                    counter2++;
	                }
	            }
	            if (duplicate[x] != 0) {
	                repetitive[x] = counter2;
	                counter2 = 0;
	            }
	        }


	        System.out.println("Tekrar Sayıları");

	        for (int z = 0; z < list.length; z++) {
	            if(duplicate[z]!=0){
	                System.out.println(duplicate[z] + " sayısı " + repetitive[z] + " kere tekrar edildi.");
	            }
	        }
	}

}
