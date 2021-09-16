import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*Variables*/
		double pricePear = 2.14 , priceApple = 3.67 , priceTomato = 1.11 , priceBanana = 0.95 , priceAubergine = 5 ;
		
		/*Taking info about kilogram*/
		System.out.print("What is the kilogram of pear?");
		  double kiloPear = scan.nextDouble(); 
		  
        System.out.print("What is the kilogram of apple?");
          double kiloApple = scan.nextDouble();
        
        System.out.print("What is the kilogram of tomato?");
          double kiloTomato = scan.nextDouble();
        
        System.out.print("What is the kilogram of banana?");
          double kiloBanana = scan.nextDouble();
        
        System.out.print("What is the kilogram of aubergine?");
          double kiloAubergine = scan.nextDouble();
          
        /*Total price calculating*/
        double totalPrice = (pricePear * kiloPear) + (priceApple * kiloApple) + (priceTomato + kiloTomato) + (priceBanana * kiloBanana) + (priceAubergine * kiloAubergine);
        
        System.out.println("Total price of your shopping is " + totalPrice);
	}

}
