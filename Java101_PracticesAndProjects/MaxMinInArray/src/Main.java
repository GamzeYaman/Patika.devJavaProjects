import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
				
		int[] list1 = {56, 34, 1, 8, 101, -2, -33};
        String list = Arrays.toString(list1);
        System.out.println("Dizi : " + list);


        int min = list1[0];
        int max = list1[0];

        for (int i = 0; i < list1.length; i++) {
            if (max < list1[i]) {
                max = list1[i];
            }
        }

        for (int i = 0; i < list1.length; i++) {
            if (min > list1[i]) {
                min = list1[i];
            }
        }

        System.out.println("Minimum De�er " + min);
        System.out.println("Maximum De�er " + max);

        int[] list2 = {15,12,788,1,-1,-778,2,0};

        Scanner input = new Scanner(System.in);
        int deger;

        String liste = Arrays.toString(list2);
        System.out.println("Dizi : " + liste);

        System.out.print("Girilen Say� : ");
        deger = input.nextInt();

        for (int j : list2) {
            if (j > deger) {
                if (j <= max) {
                    max = j;
                }
            }
        }

        for (int j : list2) {
            if (j < deger) {
                if (j >= min) {
                    min = j;
                }
            }
        }

        System.out.println("Girilen say�dan k���k en yak�n say� : " + min);
        System.out.println("Girilen say�dan b�y�k en yak�n say� : " + max);

	}

}
