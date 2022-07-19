package com.company.account;

import com.company.insurance.HealthInsurance;
import com.company.insurance.Insurance;
import com.company.insurance.ResidenceInsurance;
import com.company.insurance.TravelInsurance;
import com.company.user.User;

import java.util.Date;
import java.util.Scanner;

public class Enterprise extends Account{

    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addPolicy(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Sağlık Sigortası" + "\n2.Konut Sigortası" +"\n3.Seyahat Sigortası");
        System.out.print("Lütfen eklemek istediğiniz poliçe numarasını giriniz: ");
        int option = scan.nextInt();

        Insurance insurance;

        switch(option){
            case 1:
                insurance = new HealthInsurance("Sağlık Sigortası", 5000, new Date(), new Date());
                this.getUser().getInsuranceArrayList().add(insurance);
                insurance.calculateInsurance();
                break;
            case 2:
                insurance = new ResidenceInsurance("Konut Sigortası", 1000, new Date(), new Date());
                this.getUser().getInsuranceArrayList().add(insurance);
                insurance.calculateInsurance();
                break;
            case 3:
                insurance = new TravelInsurance("Seyahat Sigortası", 1000, new Date(), new Date());
                this.getUser().getInsuranceArrayList().add(insurance);
                insurance.calculateInsurance();
                break;
            default:
                System.out.println("Lütfen 1-3 arası rakam giriniz!");
        }

        System.out.println("Kurumsal Poliçe Eklendi");
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getName().compareTo(o.getUser().getName());
    }
}
