package model;

import java.sql.Date;

public class HotelPeriod {
    private int periodId;
    private int hotelId;
    private Date firstPeriodStart;
    private Date firstPeriodEnd;
    private Date secondPeriodStart;
    private Date secondPeriodEnd;

    public HotelPeriod(int periodId, int hotelId, Date firstPeriodStart, Date firstPeriodEnd, Date secondPeriodStart, Date secondPeriodEnd) {
        this.periodId = periodId;
        this.hotelId = hotelId;
        this.firstPeriodStart = firstPeriodStart;
        this.firstPeriodEnd = firstPeriodEnd;
        this.secondPeriodStart = secondPeriodStart;
        this.secondPeriodEnd = secondPeriodEnd;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Date getFirstPeriodStart() {
        return firstPeriodStart;
    }

    public void setFirstPeriodStart(Date firstPeriodStart) {
        this.firstPeriodStart = firstPeriodStart;
    }

    public Date getFirstPeriodEnd() {
        return firstPeriodEnd;
    }

    public void setFirstPeriodEnd(Date firstPeriodEnd) {
        this.firstPeriodEnd = firstPeriodEnd;
    }

    public Date getSecondPeriodStart() {
        return secondPeriodStart;
    }

    public void setSecondPeriodStart(Date secondPeriodStart) {
        this.secondPeriodStart = secondPeriodStart;
    }

    public Date getSecondPeriodEnd() {
        return secondPeriodEnd;
    }

    public void setSecondPeriodEnd(Date secondPeriodEnd) {
        this.secondPeriodEnd = secondPeriodEnd;
    }
}
