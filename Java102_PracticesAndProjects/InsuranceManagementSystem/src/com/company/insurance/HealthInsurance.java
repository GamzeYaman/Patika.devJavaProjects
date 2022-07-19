package com.company.insurance;

import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance(String insuranceName, double insurancePrice, Date beginingDate, Date finishedDate) {
        super(insuranceName, insurancePrice, beginingDate, finishedDate);
    }

    @Override
    public void calculateInsurance() {
        System.out.println("Sağlık sigortası hesaplandı.");
    }
}
