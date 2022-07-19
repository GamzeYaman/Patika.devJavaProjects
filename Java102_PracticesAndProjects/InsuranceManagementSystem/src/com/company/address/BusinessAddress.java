package com.company.address;

import com.company.user.User;

public class BusinessAddress implements Address<BusinessAddress>{

    private int addressId;
    private String cityName;
    private String districtName;
    private String neighborhoodName;
    private String streetName;

    public BusinessAddress(int addressId, String cityName, String districtName, String neighborhoodName, String streetName){
        this.addressId = addressId;
        this.cityName = cityName;
        this.districtName = districtName;
        this.neighborhoodName = neighborhoodName;
        this.streetName = streetName;
    }

    @Override
    public void showAddressInfo() {
        System.out.println("İş Addresi :");
        System.out.println((this.addressId + 1) + ": " + this.neighborhoodName + " mahallesi " + this.streetName + " sokak " + this.districtName + " / " + this.cityName);
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }


}
