package model;

import service.Hotel_InfoService;

public class RoomTypes {
     private int roomId;
     private int hotelId;
     private String roomType;
     private int roomAmount;
     private int bedNumber;
     private String hasTv;
     private String hasMinibar;
     private String hasGameConsole;
     private double size;
     private String hasCashBox;
     private String hasProjection;
     private int stock;
     private Hotel_Info hotelInfo;

     public RoomTypes(){}

     public RoomTypes(int roomId, String roomType, int hotelId){
         this.roomId = roomId;
         this.roomType = roomType;
         this.hotelInfo = Hotel_InfoService.getHotelInfoById(hotelId);
     }

     public RoomTypes(int roomId, int hotelId, String roomType, int roomAmount, int bedNumber, String hasTv, String hasMinibar, String hasGameConsole, double size, String hasCashBox, String hasProjection, int stock) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.roomAmount = roomAmount;
        this.bedNumber = bedNumber;
        this.hasTv = hasTv;
        this.hasMinibar = hasMinibar;
        this.hasGameConsole = hasGameConsole;
        this.size = size;
        this.hasCashBox = hasCashBox;
        this.hasProjection = hasProjection;
        this.stock = stock;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getHasTv() {
        return hasTv;
    }

    public void setHasTv(String hasTv) {
        this.hasTv = hasTv;
    }

    public String getHasMinibar() {
        return hasMinibar;
    }

    public void setHasMinibar(String hasMinibar) {
        this.hasMinibar = hasMinibar;
    }

    public String getHasGameConsole() {
        return hasGameConsole;
    }

    public void setHasGameConsole(String hasGameConsole) {
        this.hasGameConsole = hasGameConsole;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getHasCashBox() {
        return hasCashBox;
    }

    public void setHasCashBox(String hasCashBox) {
        this.hasCashBox = hasCashBox;
    }

    public String getHasProjection() {
        return hasProjection;
    }

    public void setHasProjection(String hasProjection) {
        this.hasProjection = hasProjection;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Hotel_Info getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(Hotel_Info hotelInfo) {
        this.hotelInfo = hotelInfo;
    }
}
