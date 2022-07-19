package com.company.insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String insuranceName, double insurancePrice, Date beginingDate, Date finishedDate) {
        super(insuranceName, insurancePrice, beginingDate, finishedDate);
    }

    @Override
    public void calculateInsurance() {
        System.out.println("Konut sigortası hesaplandı.");

    }
}
