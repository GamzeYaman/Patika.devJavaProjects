package com.company.insurance;

import java.util.Date;

public class TravelInsurance extends Insurance{
    public TravelInsurance(String insuranceName, double insurancePrice, Date beginingDate, Date finishedDate) {
        super(insuranceName, insurancePrice, beginingDate, finishedDate);
    }

    @Override
    public void calculateInsurance() {
        System.out.println("Seyahat sigortası hesaplandı.");
    }
}
