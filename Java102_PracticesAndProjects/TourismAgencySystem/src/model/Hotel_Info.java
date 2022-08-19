package model;

public class Hotel_Info {
    private int hotelId;
    private String hotelName;
    private String hotelMail;
    private String hotelPhoneNumber;
    private String city;
    private String district;
    private String hotelAddress;
    private int hotelStar;

    public Hotel_Info(){}

    public Hotel_Info(int hotelId, String hotelName, String hotelMail, String hotelPhoneNumber, String city, String district, String hotelAddress, int hotelStar) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelMail = hotelMail;
        this.hotelPhoneNumber = hotelPhoneNumber;
        this.city = city;
        this.district = district;
        this.hotelAddress = hotelAddress;
        this.hotelStar = hotelStar;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelMail() {
        return hotelMail;
    }

    public void setHotelMail(String hotelMail) {
        this.hotelMail = hotelMail;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public int getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(int hotelStar) {
        this.hotelStar = hotelStar;
    }
}
