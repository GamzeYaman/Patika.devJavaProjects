import java.util.Scanner;

public class NotOrtalamasi {

    public static void main(String[] args) {

// De�i�kenler tan�mland� ve veri giri�i i�in scanner kodu kullan�ld�.     
    double mat, fiz, kim, tur, tar, muz;
    Scanner input = new Scanner(System.in);
  
// Kullan�c�dan not de�erleri al�narak de�i�kenlere atand�.       
    System.out.print("Matematik notunuzu giriniz = ");
    mat = input.nextInt();

    System.out.print("Fizik notunuzu giriniz = ");
    fiz = input.nextInt();

    System.out.print("Kimya notunuzu giriniz = ");
    kim = input.nextInt();

    System.out.print("T�rk�e notunuzu giriniz = ");
    tur = input.nextInt();

    System.out.print("Tarih notunuzu giriniz = ");
    tar = input.nextInt();

    System.out.print("M�zik notunuzu giriniz = ");
    muz = input.nextInt();

// De�i�kenler ile i�lemler yap�larak ortalama de�er hesapland�.    
    double toplam = mat+fiz+kim+tur+tar+muz;
    double ortalama = toplam/6;
    
// Bulunan sonu� istenen ko�ul ile sorgulanarak ekrana yazd�r�ld�.
    System.out.println("Ortaman�z = " + ortalama);
    boolean kosul1 = ortalama >= 50;
    System.out.println("Durum = " + (kosul1==true ? "Ge�ti" : "Kald�"));
    
    }
}
