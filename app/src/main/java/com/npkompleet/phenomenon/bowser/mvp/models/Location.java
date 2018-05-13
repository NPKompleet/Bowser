package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("fait_locations_id")
    @Expose
    private String faitLocationsId;
    @SerializedName("fait_locations_system_code")
    @Expose
    private String faitLocationsSystemCode;
    @SerializedName("fait_locations_name")
    @Expose
    private String faitLocationsName;
    @SerializedName("fait_locations_phone")
    @Expose
    private String faitLocationsPhone;
    @SerializedName("fait_locations_email")
    @Expose
    private String faitLocationsEmail;
    @SerializedName("fait_locations_address")
    @Expose
    private String faitLocationsAddress;
    @SerializedName("fait_locations_status")
    @Expose
    private String faitLocationsStatus;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param faitLocationsAddress
     * @param faitLocationsName
     * @param faitLocationsSystemCode
     * @param faitLocationsStatus
     * @param faitLocationsId
     * @param faitLocationsEmail
     * @param faitLocationsPhone
     */
    public Location(String faitLocationsId, String faitLocationsSystemCode, String faitLocationsName, String faitLocationsPhone, String faitLocationsEmail, String faitLocationsAddress, String faitLocationsStatus) {
        super();
        this.faitLocationsId = faitLocationsId;
        this.faitLocationsSystemCode = faitLocationsSystemCode;
        this.faitLocationsName = faitLocationsName;
        this.faitLocationsPhone = faitLocationsPhone;
        this.faitLocationsEmail = faitLocationsEmail;
        this.faitLocationsAddress = faitLocationsAddress;
        this.faitLocationsStatus = faitLocationsStatus;
    }

    public String getFaitLocationsId() {
        return faitLocationsId;
    }

    public void setFaitLocationsId(String faitLocationsId) {
        this.faitLocationsId = faitLocationsId;
    }

    public String getFaitLocationsSystemCode() {
        return faitLocationsSystemCode;
    }

    public void setFaitLocationsSystemCode(String faitLocationsSystemCode) {
        this.faitLocationsSystemCode = faitLocationsSystemCode;
    }

    public String getFaitLocationsName() {
        return faitLocationsName;
    }

    public void setFaitLocationsName(String faitLocationsName) {
        this.faitLocationsName = faitLocationsName;
    }

    public String getFaitLocationsPhone() {
        return faitLocationsPhone;
    }

    public void setFaitLocationsPhone(String faitLocationsPhone) {
        this.faitLocationsPhone = faitLocationsPhone;
    }

    public String getFaitLocationsEmail() {
        return faitLocationsEmail;
    }

    public void setFaitLocationsEmail(String faitLocationsEmail) {
        this.faitLocationsEmail = faitLocationsEmail;
    }

    public String getFaitLocationsAddress() {
        return faitLocationsAddress;
    }

    public void setFaitLocationsAddress(String faitLocationsAddress) {
        this.faitLocationsAddress = faitLocationsAddress;
    }

    public String getFaitLocationsStatus() {
        return faitLocationsStatus;
    }

    public void setFaitLocationsStatus(String faitLocationsStatus) {
        this.faitLocationsStatus = faitLocationsStatus;
    }

}
