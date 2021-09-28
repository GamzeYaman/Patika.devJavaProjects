
public class Main {

	public static void main(String[] args) {

		System.out.println("Prime numbers between 1 and 100 : \n");
		
		int count = 0;
		
		for(int i = 2; i <= 100 ; i++) {
		
			for(int j = 1; j<=i; j++){
			    
			    if(i % j == 0){
			    	count++;
			    }
			}
			
			if(count == 2) {
				System.out.print(i + ",");
				count = 0;
			}else {
				count = 0;
			}
		}
		
		
	}

}
