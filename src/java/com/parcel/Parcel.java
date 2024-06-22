package com.parcel;

/**
 *
 * @author Group 9
 */

import java.sql.Date;

public class Parcel {
    
    private String noTracking, parcelStatus;
    private String parcelWeight, parcelPrice, studid;
    private Date arrivedDate;

    
    public String getStudid() {
        return studid;
    }

    public String getNoTracking() {
        return noTracking;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public String getParcelWeight() {
        return parcelWeight;
    }

    public String getParcelPrice() {
        return parcelPrice;
    }

    public Date getArrivedDate() {
        return arrivedDate;
    }

    
    public void setStudid(String studid) {
        this.studid = studid;
    }
    
    public void setNoTracking(String noTracking) {
        this.noTracking = noTracking;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public void setParcelWeight(String parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public void setParcelPrice(String parcelPrice) {
        this.parcelPrice = parcelPrice;
    }

    public void setArrivedDate(Date arrivedDate) {
        this.arrivedDate = arrivedDate;
    }   
}