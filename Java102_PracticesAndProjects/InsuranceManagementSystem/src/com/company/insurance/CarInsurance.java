package com.company.insurance;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String insuranceName, double insurancePrice, Date beginingDate, Date finishedDate) {
        super(insuranceName, insurancePrice, beginingDate, finishedDate);
    }

    @Override
    public void calculateInsurance() {
        System.out.println("Araba sigortası hesaplandı.");
    }
}
