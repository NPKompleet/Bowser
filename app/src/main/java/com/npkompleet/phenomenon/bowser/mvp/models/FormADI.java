
package com.npkompleet.phenomenon.bowser.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormADI extends QueryParameters.ValueArray {

    @SerializedName("fait_form_adi_users_system_code")
    @Expose
    private String faitFormAdiUsersSystemCode;
    @SerializedName("fait_form_adi_system_code")
    @Expose
    private String faitFormAdiSystemCode;
    @SerializedName("fait_form_adi_date")
    @Expose
    private String faitFormAdiDate;
    @SerializedName("fait_form_adi_park_time")
    @Expose
    private String faitFormAdiParkTime;
    @SerializedName("fait_form_adi_no")
    @Expose
    private String faitFormAdiNo;
    @SerializedName("fait_form_adi_assets_storage_system_code")
    @Expose
    private String faitFormAdiAssetsStorageSystemCode;
    @SerializedName("fait_form_adi_location")
    @Expose
    private String faitFormAdiLocation;
    @SerializedName("fait_form_adi_assets_customer_system_code")
    @Expose
    private String faitFormAdiAssetsCustomerSystemCode;
    @SerializedName("fait_form_adi_aircraft_type")
    @Expose
    private String faitFormAdiAircraftType;
    @SerializedName("fait_form_adi_aircraft_no")
    @Expose
    private String faitFormAdiAircraftNo;
    @SerializedName("fait_form_adi_flight_from")
    @Expose
    private String faitFormAdiFlightFrom;
    @SerializedName("fait_form_adi_flight_to")
    @Expose
    private String faitFormAdiFlightTo;
    @SerializedName("fait_form_adi_product_type")
    @Expose
    private String faitFormAdiProductType;
    @SerializedName("fait_form_adi_package_type")
    @Expose
    private String faitFormAdiPackageType;
    @SerializedName("fait_form_adi_specific_gravity")
    @Expose
    private String faitFormAdiSpecificGravity;
    @SerializedName("fait_form_adi_temperature")
    @Expose
    private String faitFormAdiTemperature;
    @SerializedName("fait_form_adi_meter_start")
    @Expose
    private String faitFormAdiMeterStart;
    @SerializedName("fait_form_adi_time_start")
    @Expose
    private String faitFormAdiTimeStart;
    @SerializedName("fait_form_adi_meter_end")
    @Expose
    private String faitFormAdiMeterEnd;
    @SerializedName("fait_form_adi_time_end")
    @Expose
    private String faitFormAdiTimeEnd;
    @SerializedName("fait_form_adi_aircraft_mass_start")
    @Expose
    private String faitFormAdiAircraftMassStart;
    @SerializedName("fait_form_adi_aircraft_mass_end")
    @Expose
    private String faitFormAdiAircraftMassEnd;
    @SerializedName("fait_form_adi_comment")
    @Expose
    private String faitFormAdiComment;
    @SerializedName("fait_form_adi_receiving_customer_name")
    @Expose
    private String faitFormAdiReceivingCustomerName;
    @SerializedName("fait_form_adi_receiving_customer_signature")
    @Expose
    private String faitFormAdiReceivingCustomerSignature;

    /**
     * No args constructor for use in serialization
     *
     */
    public FormADI() {
    }

    /**
     *
     * @param faitFormAdiFlightTo
     * @param faitFormAdiSpecificGravity
     * @param faitFormAdiPackageType
     * @param faitFormAdiMeterStart
     * @param faitFormAdiAircraftNo
     * @param faitFormAdiComment
     * @param faitFormAdiMeterEnd
     * @param faitFormAdiFlightFrom
     * @param faitFormAdiAircraftType
     * @param faitFormAdiAssetsCustomerSystemCode
     * @param faitFormAdiNo
     * @param faitFormAdiSystemCode
     * @param faitFormAdiParkTime
     * @param faitFormAdiAircraftMassEnd
     * @param faitFormAdiReceivingCustomerName
     * @param faitFormAdiAssetsStorageSystemCode
     * @param faitFormAdiDate
     * @param faitFormAdiTemperature
     * @param faitFormAdiTimeEnd
     * @param faitFormAdiAircraftMassStart
     * @param faitFormAdiUsersSystemCode
     * @param faitFormAdiTimeStart
     * @param faitFormAdiReceivingCustomerSignature
     * @param faitFormAdiLocation
     * @param faitFormAdiProductType
     */
    public FormADI(String faitFormAdiUsersSystemCode, String faitFormAdiSystemCode, String faitFormAdiDate, String faitFormAdiParkTime, String faitFormAdiNo, String faitFormAdiAssetsStorageSystemCode, String faitFormAdiLocation, String faitFormAdiAssetsCustomerSystemCode, String faitFormAdiAircraftType, String faitFormAdiAircraftNo, String faitFormAdiFlightFrom, String faitFormAdiFlightTo, String faitFormAdiProductType, String faitFormAdiPackageType, String faitFormAdiSpecificGravity, String faitFormAdiTemperature, String faitFormAdiMeterStart, String faitFormAdiTimeStart, String faitFormAdiMeterEnd, String faitFormAdiTimeEnd, String faitFormAdiAircraftMassStart, String faitFormAdiAircraftMassEnd, String faitFormAdiComment, String faitFormAdiReceivingCustomerName, String faitFormAdiReceivingCustomerSignature) {
        super();
        this.faitFormAdiUsersSystemCode = faitFormAdiUsersSystemCode;
        this.faitFormAdiSystemCode = faitFormAdiSystemCode;
        this.faitFormAdiDate = faitFormAdiDate;
        this.faitFormAdiParkTime = faitFormAdiParkTime;
        this.faitFormAdiNo = faitFormAdiNo;
        this.faitFormAdiAssetsStorageSystemCode = faitFormAdiAssetsStorageSystemCode;
        this.faitFormAdiLocation = faitFormAdiLocation;
        this.faitFormAdiAssetsCustomerSystemCode = faitFormAdiAssetsCustomerSystemCode;
        this.faitFormAdiAircraftType = faitFormAdiAircraftType;
        this.faitFormAdiAircraftNo = faitFormAdiAircraftNo;
        this.faitFormAdiFlightFrom = faitFormAdiFlightFrom;
        this.faitFormAdiFlightTo = faitFormAdiFlightTo;
        this.faitFormAdiProductType = faitFormAdiProductType;
        this.faitFormAdiPackageType = faitFormAdiPackageType;
        this.faitFormAdiSpecificGravity = faitFormAdiSpecificGravity;
        this.faitFormAdiTemperature = faitFormAdiTemperature;
        this.faitFormAdiMeterStart = faitFormAdiMeterStart;
        this.faitFormAdiTimeStart = faitFormAdiTimeStart;
        this.faitFormAdiMeterEnd = faitFormAdiMeterEnd;
        this.faitFormAdiTimeEnd = faitFormAdiTimeEnd;
        this.faitFormAdiAircraftMassStart = faitFormAdiAircraftMassStart;
        this.faitFormAdiAircraftMassEnd = faitFormAdiAircraftMassEnd;
        this.faitFormAdiComment = faitFormAdiComment;
        this.faitFormAdiReceivingCustomerName = faitFormAdiReceivingCustomerName;
        this.faitFormAdiReceivingCustomerSignature = faitFormAdiReceivingCustomerSignature;
    }

    public String getFaitFormAdiUsersSystemCode() {
        return faitFormAdiUsersSystemCode;
    }

    public void setFaitFormAdiUsersSystemCode(String faitFormAdiUsersSystemCode) {
        this.faitFormAdiUsersSystemCode = faitFormAdiUsersSystemCode;
    }

    public String getFaitFormAdiSystemCode() {
        return faitFormAdiSystemCode;
    }

    public void setFaitFormAdiSystemCode(String faitFormAdiSystemCode) {
        this.faitFormAdiSystemCode = faitFormAdiSystemCode;
    }

    public String getFaitFormAdiDate() {
        return faitFormAdiDate;
    }

    public void setFaitFormAdiDate(String faitFormAdiDate) {
        this.faitFormAdiDate = faitFormAdiDate;
    }

    public String getFaitFormAdiParkTime() {
        return faitFormAdiParkTime;
    }

    public void setFaitFormAdiParkTime(String faitFormAdiParkTime) {
        this.faitFormAdiParkTime = faitFormAdiParkTime;
    }

    public String getFaitFormAdiNo() {
        return faitFormAdiNo;
    }

    public void setFaitFormAdiNo(String faitFormAdiNo) {
        this.faitFormAdiNo = faitFormAdiNo;
    }

    public String getFaitFormAdiAssetsStorageSystemCode() {
        return faitFormAdiAssetsStorageSystemCode;
    }

    public void setFaitFormAdiAssetsStorageSystemCode(String faitFormAdiAssetsStorageSystemCode) {
        this.faitFormAdiAssetsStorageSystemCode = faitFormAdiAssetsStorageSystemCode;
    }

    public String getFaitFormAdiLocation() {
        return faitFormAdiLocation;
    }

    public void setFaitFormAdiLocation(String faitFormAdiLocation) {
        this.faitFormAdiLocation = faitFormAdiLocation;
    }

    public String getFaitFormAdiAssetsCustomerSystemCode() {
        return faitFormAdiAssetsCustomerSystemCode;
    }

    public void setFaitFormAdiAssetsCustomerSystemCode(String faitFormAdiAssetsCustomerSystemCode) {
        this.faitFormAdiAssetsCustomerSystemCode = faitFormAdiAssetsCustomerSystemCode;
    }

    public String getFaitFormAdiAircraftType() {
        return faitFormAdiAircraftType;
    }

    public void setFaitFormAdiAircraftType(String faitFormAdiAircraftType) {
        this.faitFormAdiAircraftType = faitFormAdiAircraftType;
    }

    public String getFaitFormAdiAircraftNo() {
        return faitFormAdiAircraftNo;
    }

    public void setFaitFormAdiAircraftNo(String faitFormAdiAircraftNo) {
        this.faitFormAdiAircraftNo = faitFormAdiAircraftNo;
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

    public String getFaitFormAdiSpecificGravity() {
        return faitFormAdiSpecificGravity;
    }

    public void setFaitFormAdiSpecificGravity(String faitFormAdiSpecificGravity) {
        this.faitFormAdiSpecificGravity = faitFormAdiSpecificGravity;
    }

    public String getFaitFormAdiTemperature() {
        return faitFormAdiTemperature;
    }

    public void setFaitFormAdiTemperature(String faitFormAdiTemperature) {
        this.faitFormAdiTemperature = faitFormAdiTemperature;
    }

    public String getFaitFormAdiMeterStart() {
        return faitFormAdiMeterStart;
    }

    public void setFaitFormAdiMeterStart(String faitFormAdiMeterStart) {
        this.faitFormAdiMeterStart = faitFormAdiMeterStart;
    }

    public String getFaitFormAdiTimeStart() {
        return faitFormAdiTimeStart;
    }

    public void setFaitFormAdiTimeStart(String faitFormAdiTimeStart) {
        this.faitFormAdiTimeStart = faitFormAdiTimeStart;
    }

    public String getFaitFormAdiMeterEnd() {
        return faitFormAdiMeterEnd;
    }

    public void setFaitFormAdiMeterEnd(String faitFormAdiMeterEnd) {
        this.faitFormAdiMeterEnd = faitFormAdiMeterEnd;
    }

    public String getFaitFormAdiTimeEnd() {
        return faitFormAdiTimeEnd;
    }

    public void setFaitFormAdiTimeEnd(String faitFormAdiTimeEnd) {
        this.faitFormAdiTimeEnd = faitFormAdiTimeEnd;
    }

    public String getFaitFormAdiAircraftMassStart() {
        return faitFormAdiAircraftMassStart;
    }

    public void setFaitFormAdiAircraftMassStart(String faitFormAdiAircraftMassStart) {
        this.faitFormAdiAircraftMassStart = faitFormAdiAircraftMassStart;
    }

    public String getFaitFormAdiAircraftMassEnd() {
        return faitFormAdiAircraftMassEnd;
    }

    public void setFaitFormAdiAircraftMassEnd(String faitFormAdiAircraftMassEnd) {
        this.faitFormAdiAircraftMassEnd = faitFormAdiAircraftMassEnd;
    }

    public String getFaitFormAdiComment() {
        return faitFormAdiComment;
    }

    public void setFaitFormAdiComment(String faitFormAdiComment) {
        this.faitFormAdiComment = faitFormAdiComment;
    }

    public String getFaitFormAdiReceivingCustomerName() {
        return faitFormAdiReceivingCustomerName;
    }

    public void setFaitFormAdiReceivingCustomerName(String faitFormAdiReceivingCustomerName) {
        this.faitFormAdiReceivingCustomerName = faitFormAdiReceivingCustomerName;
    }

    public String getFaitFormAdiReceivingCustomerSignature() {
        return faitFormAdiReceivingCustomerSignature;
    }

    public void setFaitFormAdiReceivingCustomerSignature(String faitFormAdiReceivingCustomerSignature) {
        this.faitFormAdiReceivingCustomerSignature = faitFormAdiReceivingCustomerSignature;
    }

}
