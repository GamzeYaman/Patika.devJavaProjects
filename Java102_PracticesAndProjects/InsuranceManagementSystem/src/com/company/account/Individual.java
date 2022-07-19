package com.company.account;

import com.company.insurance.*;
import com.company.user.User;

import java.net.CacheRequest;
import java.util.Date;
import java.util.Scanner;

public class Individual extends Account{

    public Individual(User user) {
        super(user);
    }

    @Override
    public void addPolicy() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Sağlık Sigortası" + "\n2.Konut Sigortası" + "\n3.Araba Sigortası" + "\n4.Seyahat Sigortası");
        System.out.print("Lütfen eklemek istediğiniz poliçe numarasını giriniz: ");
        int option = scan.nextInt();

        Insurance insurance;
        switch(option){
            case 1:
                insurance = new HealthInsurance("Sağlık Sigortası", 1000, new Date(), new Date());
                this.getUser().getInsuranceArrayList().add(insurance);
                insurance.calculateInsurance();
                break;
            case 2:
                insurance = new ResidenceInsurance("Konut Sigortası", 1000, new Date(), new Date());
                this.getUser().getInsuranceArrayList().add(insurance);
                insurance.calculateInsurance();
                break;
            case 3:
                insurance = new CarInsurance("Araba Sigortası", 1000, new Date(), new Date());
                this.getUser().getInsuranceArrayList().add(insurance);
                insurance.calculateInsurance();
                break;
            case 4:
                insurance = new TravelInsurance("Seyahat Sigortası", 1000, new Date(), new Date());
                this.getUser().getInsuranceArrayList().add(insurance);
                insurance.calculateInsurance();
                break;
            default:
                System.out.println("Lütfen 1-3 arası rakam giriniz!");
        }
        System.out.println("Bireysel Poliçe Eklendi");
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getName().compareTo(o.getUser().getName());
    }
}
