package com.npkompleet.phenomenon.bowser.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrintADI {

    @SerializedName("fait_locations_name")
    @Expose
    private String faitLocationsName;
    @SerializedName("fait_assets_storage_name")
    @Expose
    private String faitAssetsStorageName;
    @SerializedName("fait_assets_customer_name")
    @Expose
    private String faitAssetsCustomerName;
    @SerializedName("fait_form_adi_aircraft_no")
    @Expose
    private String faitFormAdiAircraftNo;
    @SerializedName("fait_form_adi_volume_sold")
    @Expose
    private String faitFormAdiVolumeSold;
    @SerializedName("fait_form_adi_date")
    @Expose
    private String faitFormAdiDate;
    @SerializedName("fait_form_adi_no")
    @Expose
    private String faitFormAdiNo;
    @SerializedName("fait_form_adi_aircraft_type")
    @Expose
    private String faitFormAdiAircraftType;
    @SerializedName("fait_form_adi_meter_start")
    @Expose
    private String faitFormAdiMeterStart;
    @SerializedName("fait_form_adi_meter_end")
    @Expose
    private String faitFormAdiMeterEnd;
    @SerializedName("fait_users_firstname")
    @Expose
    private String faitUsersFirstname;
    @SerializedName("fait_users_lastname")
    @Expose
    private String faitUsersLastname;
    @SerializedName("fait_form_adi_location")
    @Expose
    private String faitFormAdiLocation;
    @SerializedName("fait_form_adi_receiving_customer_name")
    @Expose
    private String faitFormAdiReceivingCustomerName;
    @SerializedName("fait_form_adi_park_time")
    @Expose
    private String faitFormAdiParkTime;
    @SerializedName("fait_form_adi_time_start")
    @Expose
    private String faitFormAdiTimeStart;
    @SerializedName("fait_form_adi_time_end")
    @Expose
    private String faitFormAdiTimeEnd;
    @SerializedName("fait_form_adi_product_type")
    @Expose
    private String faitFormAdiProductType;
    @SerializedName("fait_form_adi_package_type")
    @Expose
    private String faitFormAdiPackageType;
    @SerializedName("fait_form_adi_flight_from")
    @Expose
    private String faitFormAdiFlightFrom;
    @SerializedName("fait_form_adi_flight_to")
    @Expose
    private String faitFormAdiFlightTo;

    /**
     * No args constructor for use in serialization
     *
     */
    public PrintADI() {
    }

    /**
     *
     * @param faitUsersLastname
     * @param faitLocationsName
     * @param faitFormAdiFlightTo
     * @param faitFormAdiNo
     * @param faitAssetsCustomerName
     * @param faitFormAdiParkTime
     * @param faitFormAdiPackageType
     * @param faitFormAdiVolumeSold
     * @param faitFormAdiReceivingCustomerName
     * @param faitFormAdiTimeEnd
     * @param faitFormAdiDate
     * @param faitFormAdiMeterStart
     * @param faitUsersFirstname
     * @param faitFormAdiAircraftNo
     * @param faitFormAdiMeterEnd
     * @param faitFormAdiFlightFrom
     * @param faitFormAdiTimeStart
     * @param faitAssetsStorageName
     * @param faitFormAdiLocation
     * @param faitFormAdiAircraftType
     * @param faitFormAdiProductType
     */
    public PrintADI(String faitLocationsName, String faitAssetsStorageName, String faitAssetsCustomerName, String faitFormAdiAircraftNo, String faitFormAdiVolumeSold, String faitFormAdiDate, String faitFormAdiNo, String faitFormAdiAircraftType, String faitFormAdiMeterStart, String faitFormAdiMeterEnd, String faitUsersFirstname, String faitUsersLastname, String faitFormAdiLocation, String faitFormAdiReceivingCustomerName, String faitFormAdiParkTime, String faitFormAdiTimeStart, String faitFormAdiTimeEnd, String faitFormAdiProductType, String faitFormAdiPackageType, String faitFormAdiFlightFrom, String faitFormAdiFlightTo) {
        super();
        this.faitLocationsName = faitLocationsName;
        this.faitAssetsStorageName = faitAssetsStorageName;
        this.faitAssetsCustomerName = faitAssetsCustomerName;
        this.faitFormAdiAircraftNo = faitFormAdiAircraftNo;
        this.faitFormAdiVolumeSold = faitFormAdiVolumeSold;
        this.faitFormAdiDate = faitFormAdiDate;
        this.faitFormAdiNo = faitFormAdiNo;
        this.faitFormAdiAircraftType = faitFormAdiAircraftType;
        this.faitFormAdiMeterStart = faitFormAdiMeterStart;
        this.faitFormAdiMeterEnd = faitFormAdiMeterEnd;
        this.faitUsersFirstname = faitUsersFirstname;
        this.faitUsersLastname = faitUsersLastname;
        this.faitFormAdiLocation = faitFormAdiLocation;
        this.faitFormAdiReceivingCustomerName = faitFormAdiReceivingCustomerName;
        this.faitFormAdiParkTime = faitFormAdiParkTime;
        this.faitFormAdiTimeStart = faitFormAdiTimeStart;
        this.faitFormAdiTimeEnd = faitFormAdiTimeEnd;
        this.faitFormAdiProductType = faitFormAdiProductType;
        this.faitFormAdiPackageType = faitFormAdiPackageType;
        this.faitFormAdiFlightFrom = faitFormAdiFlightFrom;
        this.faitFormAdiFlightTo = faitFormAdiFlightTo;
    }

    public String getFaitLocationsName() {
        return faitLocationsName;
    }

    public void setFaitLocationsName(String faitLocationsName) {
        this.faitLocationsName = faitLocationsName;
    }

    public String getFaitAssetsStorageName() {
        return faitAssetsStorageName;
    }

    public void setFaitAssetsStorageName(String faitAssetsStorageName) {
        this.faitAssetsStorageName = faitAssetsStorageName;
    }

    public String getFaitAssetsCustomerName() {
        return faitAssetsCustomerName;
    }

    public void setFaitAssetsCustomerName(String faitAssetsCustomerName) {
        this.faitAssetsCustomerName = faitAssetsCustomerName;
    }

    public String getFaitFormAdiAircraftNo() {
        return faitFormAdiAircraftNo;
    }

    public void setFaitFormAdiAircraftNo(String faitFormAdiAircraftNo) {
        this.faitFormAdiAircraftNo = faitFormAdiAircraftNo;
    }

    public String getFaitFormAdiVolumeSold() {
        return faitFormAdiVolumeSold;
    }

    public void setFaitFormAdiVolumeSold(String faitFormAdiVolumeSold) {
        this.faitFormAdiVolumeSold = faitFormAdiVolumeSold;
    }

    public String getFaitFormAdiDate() {
        return faitFormAdiDate;
    }

    public void setFaitFormAdiDate(String faitFormAdiDate) {
        this.faitFormAdiDate = faitFormAdiDate;
    }

    public String getFaitFormAdiNo() {
        return faitFormAdiNo;
    }

    public void setFaitFormAdiNo(String faitFormAdiNo) {
        this.faitFormAdiNo = faitFormAdiNo;
    }

    public String getFaitFormAdiAircraftType() {
        return faitFormAdiAircraftType;
    }

    public void setFaitFormAdiAircraftType(String faitFormAdiAircraftType) {
        this.faitFormAdiAircraftType = faitFormAdiAircraftType;
    }

    public String getFaitFormAdiMeterStart() {
        return faitFormAdiMeterStart;
    }

    public void setFaitFormAdiMeterStart(String faitFormAdiMeterStart) {
        this.faitFormAdiMeterStart = faitFormAdiMeterStart;
    }

    public String getFaitFormAdiMeterEnd() {
        return faitFormAdiMeterEnd;
    }

    public void setFaitFormAdiMeterEnd(String faitFormAdiMeterEnd) {
        this.faitFormAdiMeterEnd = faitFormAdiMeterEnd;
    }

    public String getFaitUsersFirstname() {
        return faitUsersFirstname;
    }

    public void setFaitUsersFirstname(String faitUsersFirstname) {
        this.faitUsersFirstname = faitUsersFirstname;
    }

    public String getFaitUsersLastname() {
        return faitUsersLastname;
    }

    public void setFaitUsersLastname(String faitUsersLastname) {
        this.faitUsersLastname = faitUsersLastname;
    }

    public String getFaitFormAdiLocation() {
        return faitFormAdiLocation;
    }

    public void setFaitFormAdiLocation(String faitFormAdiLocation) {
        this.faitFormAdiLocation = faitFormAdiLocation;
    }

    public String getFaitFormAdiReceivingCustomerName() {
        return faitFormAdiReceivingCustomerName;
    }

    public void setFaitFormAdiReceivingCustomerName(String faitFormAdiReceivingCustomerName) {
        this.faitFormAdiReceivingCustomerName = faitFormAdiReceivingCustomerName;
    }

    public String getFaitFormAdiParkTime() {
        return faitFormAdiParkTime;
    }

    public void setFaitFormAdiParkTime(String faitFormAdiParkTime) {
        this.faitFormAdiParkTime = faitFormAdiParkTime;
    }

    public String getFaitFormAdiTimeStart() {
        return faitFormAdiTimeStart;
    }

    public void setFaitFormAdiTimeStart(String faitFormAdiTimeStart) {
        this.faitFormAdiTimeStart = faitFormAdiTimeStart;
    }

    public String getFaitFormAdiTimeEnd() {
        return faitFormAdiTimeEnd;
    }

    public void setFaitFormAdiTimeEnd(String faitFormAdiTimeEnd) {
        this.faitFormAdiTimeEnd = faitFormAdiTimeEnd;
    }

    public String getFaitFormAdiProductType() {
        return faitFormAdiProductType;
    }

    public void setFaitFormAdiProductType(String faitFormAdiProductType) {
        this.faitFormAdiProductType = faitFormAdiProductType;
    }

    public String getFaitFormAdiPackageType() {
        return faitFormAdiPackageType;
    }

    public void setFaitFormAdiPackageType(String faitFormAdiPackageType) {
        this.faitFormAdiPackageType = faitFormAdiPackageType;
    }

    public String getFaitFormAdiFlightFrom() {
        return faitFormAdiFlightFrom;
    }

    public void setFaitFormAdiFlightFrom(String faitFormAdiFlightFrom) {
        this.faitFormAdiFlightFrom = faitFormAdiFlightFrom;
    }

    public String getFaitFormAdiFlightTo() {
        return faitFormAdiFlightTo;
    }

    public void setFaitFormAdiFlightTo(String faitFormAdiFlightTo) {
        this.faitFormAdiFlightTo = faitFormAdiFlightTo;
    }

}