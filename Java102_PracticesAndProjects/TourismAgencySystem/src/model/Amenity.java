package model;

public class Amenity {
    private int amenityId;
    private int hotelId;
    private String freeParking;
    private String freeWifi;
    private String swimmingPool;
    private String fitnessCenter;
    private String hotelConcierge;
    private String spa;
    private String roomService;

    public Amenity(){}

    public Amenity(int amenityId, int hotelId, String freeParking, String freeWifi, String swimmingPool, String fitnessCenter, String hotelConcierge, String spa, String roomService) {
        this.amenityId = amenityId;
        this.hotelId = hotelId;
        this.freeParking = freeParking;
        this.freeWifi = freeWifi;
        this.swimmingPool = swimmingPool;
        this.fitnessCenter = fitnessCenter;
        this.hotelConcierge = hotelConcierge;
        this.spa = spa;
        this.roomService = roomService;
    }

    public int getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(int amenityId) {
        this.amenityId = amenityId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getFreeParking() {
        return freeParking;
    }

    public void setFreeParking(String freeParking) {
        this.freeParking = freeParking;
    }

    public String getFreeWifi() {
        return freeWifi;
    }

    public void setFreeWifi(String freeWifi) {
        this.freeWifi = freeWifi;
    }

    public String getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(String swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public String getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(String fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public String getHotelConcierge() {
        return hotelConcierge;
    }

    public void setHotelConcierge(String hotelConcierge) {
        this.hotelConcierge = hotelConcierge;
    }

    public String getSpa() {
        return spa;
    }

    public void setSpa(String spa) {
        this.spa = spa;
    }

    public String getRoomService() {
        return roomService;
    }

    public void setRoomService(String roomService) {
        this.roomService = roomService;
    }
}
