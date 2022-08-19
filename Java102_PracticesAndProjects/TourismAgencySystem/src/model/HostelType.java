package model;

public class HostelType {
    private int hostelTypeId;
    private int hotelId;
    private String ultraAllIn;
    private String allIn;
    private String roomBreakfast;
    private String fullPension;
    private String halfPension;
    private String onlyBed;
    private String fullCreditNotAlcohol;

    public HostelType(){}

    public HostelType(int hostelTypeId, int hotelId, String ultraAllIn, String allIn, String roomBreakfast, String fullPension, String halfPension, String onlyBed, String fullCreditNotAlcohol) {
        this.hostelTypeId = hostelTypeId;
        this.hotelId = hotelId;
        this.ultraAllIn = ultraAllIn;
        this.allIn = allIn;
        this.roomBreakfast = roomBreakfast;
        this.fullPension = fullPension;
        this.halfPension = halfPension;
        this.onlyBed = onlyBed;
        this.fullCreditNotAlcohol = fullCreditNotAlcohol;
    }

    public int getHostelTypeId() {
        return hostelTypeId;
    }

    public void setHostelTypeId(int hostelTypeId) {
        this.hostelTypeId = hostelTypeId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getUltraAllIn() {
        return ultraAllIn;
    }

    public void setUltraAllIn(String ultraAllIn) {
        this.ultraAllIn = ultraAllIn;
    }

    public String getAllIn() {
        return allIn;
    }

    public void setAllIn(String allIn) {
        this.allIn = allIn;
    }

    public String getRoomBreakfast() {
        return roomBreakfast;
    }

    public void setRoomBreakfast(String roomBreakfast) {
        this.roomBreakfast = roomBreakfast;
    }

    public String getFullPension() {
        return fullPension;
    }

    public void setFullPension(String fullPension) {
        this.fullPension = fullPension;
    }

    public String getHalfPension() {
        return halfPension;
    }

    public void setHalfPension(String halfPension) {
        this.halfPension = halfPension;
    }

    public String getOnlyBed() {
        return onlyBed;
    }

    public void setOnlyBed(String onlyBed) {
        this.onlyBed = onlyBed;
    }

    public String getFullCreditNotAlcohol() {
        return fullCreditNotAlcohol;
    }

    public void setFullCreditNotAlcohol(String fullCreditNotAlcohol) {
        this.fullCreditNotAlcohol = fullCreditNotAlcohol;
    }
}
