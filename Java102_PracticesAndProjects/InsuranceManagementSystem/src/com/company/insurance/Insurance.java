package com.company.insurance;

import java.util.Date;

public abstract class Insurance {

    private String insuranceName;
    private double insurancePrice;
    private Date beginingDate;
    private Date finishedDate;

    public abstract void calculateInsurance();

    public Insurance(String insuranceName, double insurancePrice, Date beginingDate, Date finishedDate) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.beginingDate = beginingDate;
        this.finishedDate = finishedDate;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getBeginingDate() {
        return beginingDate;
    }

    public void setBeginingDate(Date begginingDate) {
        this.beginingDate = begginingDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }
}
