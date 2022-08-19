package model;

import service.Hotel_InfoService;
import service.RoomTypesService;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerTc;
    private String customerPhone;
    private String customerMail;
    private int hotelId;
    private int roomId;
    private double roomPrice;
    private Hotel_Info hotelInfo;
    private RoomTypes roomTypes;

    public Customer(int customerId, String customerName, String customerTc, String customerPhone, String customerMail, int hotelId, int roomId, double roomPrice) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerTc = customerTc;
        this.customerPhone = customerPhone;
        this.customerMail = customerMail;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.roomPrice = roomPrice;
        this.hotelInfo = Hotel_InfoService.getHotelInfoById(hotelId);
        this.roomTypes = RoomTypesService.getRoomTypesById(roomId);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTc() {
        return customerTc;
    }

    public void setCustomerTc(String customerTc) {
        this.customerTc = customerTc;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Hotel_Info getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(Hotel_Info hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    public RoomTypes getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(RoomTypes roomTypes) {
        this.roomTypes = roomTypes;
    }
}