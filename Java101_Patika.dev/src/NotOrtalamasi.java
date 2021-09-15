import java.util.Scanner;

public class NotOrtalamasi {

    public static void main(String[] args) {

// Deðiþkenler tanýmlandý ve veri giriþi için scanner kodu kullanýldý.     
    double mat, fiz, kim, tur, tar, muz;
    Scanner input = new Scanner(System.in);
  
// Kullanýcýdan not deðerleri alýnarak deðiþkenlere atandý.       
    System.out.print("Matematik notunuzu giriniz = ");
    mat = input.nextInt();

    System.out.print("Fizik notunuzu giriniz = ");
    fiz = input.nextInt();

    System.out.print("Kimya notunuzu giriniz = ");
    kim = input.nextInt();

    System.out.print("Türkçe notunuzu giriniz = ");
    tur = input.nextInt();

    System.out.print("Tarih notunuzu giriniz = ");
    tar = input.nextInt();

    System.out.print("Müzik notunuzu giriniz = ");
    muz = input.nextInt();

// Deðiþkenler ile iþlemler yapýlarak ortalama deðer hesaplandý.    
    double toplam = mat+fiz+kim+tur+tar+muz;
    double ortalama = toplam/6;
    
// Bulunan sonuç istenen koþul ile sorgulanarak ekrana yazdýrýldý.
    System.out.println("Ortamanýz = " + ortalama);
    boolean kosul1 = ortalama >= 50;
    System.out.println("Durum = " + (kosul1==true ? "Geçti" : "Kaldý"));
    
    }
}
