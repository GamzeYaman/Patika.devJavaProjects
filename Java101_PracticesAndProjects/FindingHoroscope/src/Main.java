import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Hangi ay do�dunuz?");
		  int m = scan.nextInt();
		System.out.println("Hangi g�n do�dunuz?");
		  int d = scan.nextInt();
		  
		  if (m == 1 && d >= 22) {
	            System.out.println("Kova Burcu");
	        } else if (d == 1){
	            System.out.println("O�lak Burcu");
	        }

	        if (m == 2 && d >= 20) {
	            System.out.println("Bal�k Burcu");
	        } else if (m == 2){
	            System.out.println("Kova Burcu");
	        }

	        if (m == 3 && d >= 21) {
	            System.out.println("Ko� Burcu");
	        } else if (m == 3){
	            System.out.println("Bal�k Burcu");
	        }

	        if (m == 4 && d >= 21) {
	            System.out.println("Bo�a Burcu");
	        } else if (m == 4){
	            System.out.println("Ko� Burcu");
	        }

	        if (m == 5 && d >= 22) {
	            System.out.println("ikizler Burcu");
	        } else if (m == 5){
	            System.out.println("Bo�a Burcu");
	        }

	        if (m == 6 && d >= 23) {
	            System.out.println("Yenge� Burcu");
	        } else if (m == 6){
	            System.out.println("ikizler Burcu");
	        }

	        if (m == 7 && d >= 23) {
	            System.out.println("Aslan Burcu");
	        } else if (m == 7){
	            System.out.println("yenge� Burcu");
	        }

	        if (m == 8 && d >= 23) {
	            System.out.println("Ba�ak Burcu");
	        } else if (m == 8){
	            System.out.println("Aslan Burcu");
	        }

	        if (m == 9 && d >= 23) {
	            System.out.println("Terazi Burcu");
	        } else if (m == 9){
	            System.out.println("Ba�ak Burcu");
	        }

	        if (m == 10 && d >= 20) {
	            System.out.println("Akrep Burcu");
	        } else if (m == 10){
	            System.out.println("Terazi Burcu");
	        }

	        if (m == 11 && d >= 20) {
	            System.out.println("Yay Burcu");
	        } else if (m == 11){
	            System.out.println("Akrep Burcu");
	        }

	        if (m == 12 && d >= 20) {
	            System.out.println("O�lak Burcu");
	        } else if (m == 12){
	            System.out.println("Yay Burcu");
	        }
	}
}
