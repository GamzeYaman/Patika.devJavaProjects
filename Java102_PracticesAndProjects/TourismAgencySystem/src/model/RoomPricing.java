package model;

public class RoomPricing {
    private int priceId;
    private int hotelId;
    private int roomId;
    private int pensionId;
    private double firstPeriodAdultPrice;
    private double firstPeriodKidPrice;
    private double secondPeriodAdultPrice;
    private double secondPeriodKidPrice;

    public RoomPricing(){}

    public RoomPricing(int priceId, int hotelId, int roomId, int pensionId, double firstPeriodAdultPrice, double firstPeriodKidPrice, double secondPeriodAdultPrice, double secondPeriodKidPrice) {
        this.priceId = priceId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.pensionId = pensionId;
        this.firstPeriodAdultPrice = firstPeriodAdultPrice;
        this.firstPeriodKidPrice = firstPeriodKidPrice;
        this.secondPeriodAdultPrice = secondPeriodAdultPrice;
        this.secondPeriodKidPrice = secondPeriodKidPrice;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
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

    public int getPensionId() {
        return pensionId;
    }

    public void setPensionId(int pensionId) {
        this.pensionId = pensionId;
    }

    public double getFirstPeriodAdultPrice() {
        return firstPeriodAdultPrice;
    }

    public void setFirstPeriodAdultPrice(double firstPeriodAdultPrice) {
        this.firstPeriodAdultPrice = firstPeriodAdultPrice;
    }

    public double getFirstPeriodKidPrice() {
        return firstPeriodKidPrice;
    }

    public void setFirstPeriodKidPrice(double firstPeriodKidPrice) {
        this.firstPeriodKidPrice = firstPeriodKidPrice;
    }

    public double getSecondPeriodAdultPrice() {
        return secondPeriodAdultPrice;
    }

    public void setSecondPeriodAdultPrice(double secondPeriodAdultPrice) {
        this.secondPeriodAdultPrice = secondPeriodAdultPrice;
    }

    public double getSecondPeriodKidPrice() {
        return secondPeriodKidPrice;
    }

    public void setSecondPeriodKidPrice(double secondPeriodKidPrice) {
        this.secondPeriodKidPrice = secondPeriodKidPrice;
    }
}
