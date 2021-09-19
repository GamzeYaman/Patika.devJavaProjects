import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		/*Taking flying info from user*/
	    System.out.println("Hello!");
	    System.out.println("Could you please enter the distance(KM) ?");
	      double distance = scan.nextDouble();
	    System.out.println("Could you please neter your age?");
	      int age = scan.nextInt();
	    System.out.println("Could you please select flying type?" + "\n1.One Way" + "\n2.Round Trip");
	      int flyingType = scan.nextInt();
	     
	    /*Variables*/
	    double distancePrice = 0.10;
	    double discount, discountPrice = 0 , discountAge, totalPrice;
	    
	     
	    if(distance <= 0) { /*Controlling an available distance value, so distance cannot be negative.*/
	    	System.out.println("You have entered wrong data!");
	    	
	    }else {
	    	double normalPrice = distance * distancePrice; 
	    	
	    	if(age < 0) { /*Controlling an available age value, so age cannot be negative.*/
	    		System.out.println("You have entered wrong data!");
	    		
	    	}else { /*Calculating discount price acoording to ages*/
	    		if(age < 12) {
	    			discount = 0.50;
	    			discountAge = normalPrice * discount;
	    			discountPrice = normalPrice - discountAge;
	    		}
	    		else if(age >= 12 && age <= 24) {
	    			discount = 0.10;
	    			discountAge = normalPrice * discount;
	    			discountPrice = normalPrice - discountAge;
	    		}
	    		else if(age > 24 && age < 65) {
	    			discount = 0;
	    			discountAge = normalPrice * discount;
	    			discountPrice = normalPrice - discountAge;
	    		}
	    		else if(age >= 65) {
	    			discount = 0.30;
	    			discountAge = normalPrice * discount;
	    			discountPrice = normalPrice - discountAge;
	    		}
	    		
	    		
	    		switch(flyingType) { /*Calculating the total price with discount of flying type. */
	    	      case 1:
	    	    	  totalPrice = discountPrice;
	    	    	  System.out.println("Total Price : " + totalPrice);
	    	    	  break;
	    	    	  
	    	      case 2 :
	    	    	  double discountFlyingType = 0.20;
	    	    	  double priceFlyingType = discountPrice * discountFlyingType;
	    	    	  totalPrice = (discountPrice - priceFlyingType) * 2;
	    	    	  System.out.println("Total Price : " + totalPrice);
	    	    	  break;
	    	    	  
	    	      default:
	    	    	  System.out.println("Invalid number. Please select 1 or 2!");
	    	    }
	    	}
	    		
	    }
	
	}
}
