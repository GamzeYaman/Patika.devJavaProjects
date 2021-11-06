
public class Main {
	
	static void transpoze(int[][] arr) {
		
		int[][] transpoze = new int[arr[0].length][arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				transpoze[j][i] = arr[i][j];
			}
		}
		
		System.out.println("Transpoze : ");
		for(int[] matris : transpoze) {
			for(int x = 0; x < transpoze[0].length; x++) {
				System.out.print(matris[x]);
				System.out.print("\t");
			}			
			System.out.println();
		}
		
	}

	public static void main(String[] args) {

		int[][] list = {{1, 2, 3} , {4, 5, 6}};
		
		System.out.println("Matris : ");
		for(int[] matris : list) {
			for(int i = 0; i < list[0].length; i++) {
				System.out.print(matris[i]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		transpoze(list);
	}

}
