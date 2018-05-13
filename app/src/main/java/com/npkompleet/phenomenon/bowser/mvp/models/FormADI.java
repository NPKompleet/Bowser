
package com.npkompleet.phenomenon.bowser.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormADI extends QueryParameters.ValueArray /*implements Parcelable*/
/*
{

    @SerializedName("fait_form_adi_id")
    @Expose
    private String faitFormAdiId;
    @SerializedName("fait_form_adi_system_code")
    @Expose
    private String faitFormAdiSystemCode;
    @SerializedName("fait_form_adi_no")
    @Expose
    private String faitFormAdiNo;
    @SerializedName("fait_form_adi_date")
    @Expose
    private String faitFormAdiDate;
    @SerializedName("fait_form_adi_location")
    @Expose
    private String faitFormAdiLocation;
    @SerializedName("fait_form_adi_assets_customer_system_code")
    @Expose
    private String faitFormAdiAssetsCustomerSystemCode;
    @SerializedName("fait_form_adi_flight_from")
    @Expose
    private String faitFormAdiFlightFrom;
    @SerializedName("fait_form_adi_flight_to")
    @Expose
    private String faitFormAdiFlightTo;
    @SerializedName("fait_form_adi_aircraft_no")
    @Expose
    private String faitFormAdiAircraftNo;
    @SerializedName("fait_form_adi_aircraft_type")
    @Expose
    private String faitFormAdiAircraftType;
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
    @SerializedName("fait_form_adi_meter_end")
    @Expose
    private String faitFormAdiMeterEnd;
    @SerializedName("fait_form_adi_volume_sold")
    @Expose
    private String faitFormAdiVolumeSold;
    @SerializedName("fait_form_adi_time_start")
    @Expose
    private String faitFormAdiTimeStart;
    @SerializedName("fait_form_adi_time_end")
    @Expose
    private String faitFormAdiTimeEnd;
    @SerializedName("fait_form_adi_comment")
    @Expose
    private String faitFormAdiComment;
    @SerializedName("fait_form_adi_receiving_customer_name")
    @Expose
    private String faitFormAdiReceivingCustomerName;
    @SerializedName("fait_form_adi_receiving_customer_signature")
    @Expose
    private String faitFormAdiReceivingCustomerSignature;
    @SerializedName("fait_form_adi_assets_storage_system_code")
    @Expose
    private String faitFormAdiAssetsStorageSystemCode;
    @SerializedName("fait_form_adi_status")
    @Expose
    private String faitFormAdiStatus;
    @SerializedName("fait_form_adi_users_system_code")
    @Expose
    private String faitFormAdiUsersSystemCode;
    @SerializedName("fait_form_adi_users_signature")
    @Expose
    private String faitFormAdiUsersSignature;
    @SerializedName("fait_form_adi_park_time")
    @Expose
    private String faitFormAdiParkTime;
    @SerializedName("fait_form_adi_aircraft_mass_start")
    @Expose
    private String faitFormAdiAircraftMassStart;
    @SerializedName("fait_form_adi_aircraft_mass_end")
    @Expose
    private String faitFormAdiAircraftMassEnd;
    @SerializedName("fait_form_adi_loss_between_aircraft_meter_and_bowser_meter")
    @Expose
    private String faitFormAdiLossBetweenAircraftMeterAndBowserMeter;
    @SerializedName("fait_form_adi_timestamp")
    @Expose
    private String faitFormAdiTimestamp;
    @SerializedName("fait_form_adi_sage_id")
    @Expose
    private String faitFormAdiSageId;
    public final static Parcelable.Creator<FormADI> CREATOR = new Creator<FormADI>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FormADI createFromParcel(Parcel in) {
            return new FormADI(in);
        }

        public FormADI[] newArray(int size) {
            return (new FormADI[size]);
        }

    }
            ;

    protected FormADI(Parcel in) {
        this.faitFormAdiId = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiSystemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiNo = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiDate = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiAssetsCustomerSystemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiFlightFrom = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiFlightTo = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiAircraftNo = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiAircraftType = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiProductType = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiPackageType = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiSpecificGravity = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiTemperature = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiMeterStart = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiMeterEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiVolumeSold = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiTimeStart = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiTimeEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiComment = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiReceivingCustomerName = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiReceivingCustomerSignature = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiAssetsStorageSystemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiUsersSystemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiUsersSignature = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiParkTime = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiAircraftMassStart = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiAircraftMassEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiLossBetweenAircraftMeterAndBowserMeter = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiTimestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.faitFormAdiSageId = ((String) in.readValue((String.class.getClassLoader())));
    }

    */
/**
     * No args constructor for use in serialization
     *
     *//*

    public FormADI() {
    }

    */
/**
     *
     * @param faitFormAdiLossBetweenAircraftMeterAndBowserMeter
     * @param faitFormAdiFlightTo
     * @param faitFormAdiSpecificGravity
     * @param faitFormAdiTimestamp
     * @param faitFormAdiPackageType
     * @param faitFormAdiVolumeSold
     * @param faitFormAdiSageId
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
     * @param faitFormAdiStatus
     * @param faitFormAdiAircraftMassEnd
     * @param faitFormAdiReceivingCustomerName
     * @param faitFormAdiDate
     * @param faitFormAdiTemperature
     * @param faitFormAdiTimeEnd
     * @param faitFormAdiAssetsStorageSystemCode
     * @param faitFormAdiAircraftMassStart
     * @param faitFormAdiUsersSignature
     * @param faitFormAdiUsersSystemCode
     * @param faitFormAdiTimeStart
     * @param faitFormAdiLocation
     * @param faitFormAdiId
     * @param faitFormAdiReceivingCustomerSignature
     * @param faitFormAdiProductType
     *//*

    public FormADI(String faitFormAdiId, String faitFormAdiSystemCode, String faitFormAdiNo, String faitFormAdiDate, String faitFormAdiLocation, String faitFormAdiAssetsCustomerSystemCode, String faitFormAdiFlightFrom, String faitFormAdiFlightTo, String faitFormAdiAircraftNo, String faitFormAdiAircraftType, String faitFormAdiProductType, String faitFormAdiPackageType, String faitFormAdiSpecificGravity, String faitFormAdiTemperature, String faitFormAdiMeterStart, String faitFormAdiMeterEnd, String faitFormAdiVolumeSold, String faitFormAdiTimeStart, String faitFormAdiTimeEnd, String faitFormAdiComment, String faitFormAdiReceivingCustomerName, String faitFormAdiReceivingCustomerSignature, String faitFormAdiAssetsStorageSystemCode, String faitFormAdiStatus, String faitFormAdiUsersSystemCode, String faitFormAdiUsersSignature, String faitFormAdiParkTime, String faitFormAdiAircraftMassStart, String faitFormAdiAircraftMassEnd, String faitFormAdiLossBetweenAircraftMeterAndBowserMeter, String faitFormAdiTimestamp, String faitFormAdiSageId) {
        super();
        this.faitFormAdiId = faitFormAdiId;
        this.faitFormAdiSystemCode = faitFormAdiSystemCode;
        this.faitFormAdiNo = faitFormAdiNo;
        this.faitFormAdiDate = faitFormAdiDate;
        this.faitFormAdiLocation = faitFormAdiLocation;
        this.faitFormAdiAssetsCustomerSystemCode = faitFormAdiAssetsCustomerSystemCode;
        this.faitFormAdiFlightFrom = faitFormAdiFlightFrom;
        this.faitFormAdiFlightTo = faitFormAdiFlightTo;
        this.faitFormAdiAircraftNo = faitFormAdiAircraftNo;
        this.faitFormAdiAircraftType = faitFormAdiAircraftType;
        this.faitFormAdiProductType = faitFormAdiProductType;
        this.faitFormAdiPackageType = faitFormAdiPackageType;
        this.faitFormAdiSpecificGravity = faitFormAdiSpecificGravity;
        this.faitFormAdiTemperature = faitFormAdiTemperature;
        this.faitFormAdiMeterStart = faitFormAdiMeterStart;
        this.faitFormAdiMeterEnd = faitFormAdiMeterEnd;
        this.faitFormAdiVolumeSold = faitFormAdiVolumeSold;
        this.faitFormAdiTimeStart = faitFormAdiTimeStart;
        this.faitFormAdiTimeEnd = faitFormAdiTimeEnd;
        this.faitFormAdiComment = faitFormAdiComment;
        this.faitFormAdiReceivingCustomerName = faitFormAdiReceivingCustomerName;
        this.faitFormAdiReceivingCustomerSignature = faitFormAdiReceivingCustomerSignature;
        this.faitFormAdiAssetsStorageSystemCode = faitFormAdiAssetsStorageSystemCode;
        this.faitFormAdiStatus = faitFormAdiStatus;
        this.faitFormAdiUsersSystemCode = faitFormAdiUsersSystemCode;
        this.faitFormAdiUsersSignature = faitFormAdiUsersSignature;
        this.faitFormAdiParkTime = faitFormAdiParkTime;
        this.faitFormAdiAircraftMassStart = faitFormAdiAircraftMassStart;
        this.faitFormAdiAircraftMassEnd = faitFormAdiAircraftMassEnd;
        this.faitFormAdiLossBetweenAircraftMeterAndBowserMeter = faitFormAdiLossBetweenAircraftMeterAndBowserMeter;
        this.faitFormAdiTimestamp = faitFormAdiTimestamp;
        this.faitFormAdiSageId = faitFormAdiSageId;
    }

    public String getFaitFormAdiId() {
        return faitFormAdiId;
    }

    public void setFaitFormAdiId(String faitFormAdiId) {
        this.faitFormAdiId = faitFormAdiId;
    }

    public String getFaitFormAdiSystemCode() {
        return faitFormAdiSystemCode;
    }

    public void setFaitFormAdiSystemCode(String faitFormAdiSystemCode) {
        this.faitFormAdiSystemCode = faitFormAdiSystemCode;
    }

    public String getFaitFormAdiNo() {
        return faitFormAdiNo;
    }

    public void setFaitFormAdiNo(String faitFormAdiNo) {
        this.faitFormAdiNo = faitFormAdiNo;
    }

    public String getFaitFormAdiDate() {
        return faitFormAdiDate;
    }

    public void setFaitFormAdiDate(String faitFormAdiDate) {
        this.faitFormAdiDate = faitFormAdiDate;
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

    public String getFaitFormAdiAircraftNo() {
        return faitFormAdiAircraftNo;
    }

    public void setFaitFormAdiAircraftNo(String faitFormAdiAircraftNo) {
        this.faitFormAdiAircraftNo = faitFormAdiAircraftNo;
    }

    public String getFaitFormAdiAircraftType() {
        return faitFormAdiAircraftType;
    }

    public void setFaitFormAdiAircraftType(String faitFormAdiAircraftType) {
        this.faitFormAdiAircraftType = faitFormAdiAircraftType;
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

    public String getFaitFormAdiMeterEnd() {
        return faitFormAdiMeterEnd;
    }

    public void setFaitFormAdiMeterEnd(String faitFormAdiMeterEnd) {
        this.faitFormAdiMeterEnd = faitFormAdiMeterEnd;
    }

    public String getFaitFormAdiVolumeSold() {
        return faitFormAdiVolumeSold;
    }

    public void setFaitFormAdiVolumeSold(String faitFormAdiVolumeSold) {
        this.faitFormAdiVolumeSold = faitFormAdiVolumeSold;
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

    public String getFaitFormAdiAssetsStorageSystemCode() {
        return faitFormAdiAssetsStorageSystemCode;
    }

    public void setFaitFormAdiAssetsStorageSystemCode(String faitFormAdiAssetsStorageSystemCode) {
        this.faitFormAdiAssetsStorageSystemCode = faitFormAdiAssetsStorageSystemCode;
    }

    public String getFaitFormAdiStatus() {
        return faitFormAdiStatus;
    }

    public void setFaitFormAdiStatus(String faitFormAdiStatus) {
        this.faitFormAdiStatus = faitFormAdiStatus;
    }

    public String getFaitFormAdiUsersSystemCode() {
        return faitFormAdiUsersSystemCode;
    }

    public void setFaitFormAdiUsersSystemCode(String faitFormAdiUsersSystemCode) {
        this.faitFormAdiUsersSystemCode = faitFormAdiUsersSystemCode;
    }

    public String getFaitFormAdiUsersSignature() {
        return faitFormAdiUsersSignature;
    }

    public void setFaitFormAdiUsersSignature(String faitFormAdiUsersSignature) {
        this.faitFormAdiUsersSignature = faitFormAdiUsersSignature;
    }

    public String getFaitFormAdiParkTime() {
        return faitFormAdiParkTime;
    }

    public void setFaitFormAdiParkTime(String faitFormAdiParkTime) {
        this.faitFormAdiParkTime = faitFormAdiParkTime;
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

    public String getFaitFormAdiLossBetweenAircraftMeterAndBowserMeter() {
        return faitFormAdiLossBetweenAircraftMeterAndBowserMeter;
    }

    public void setFaitFormAdiLossBetweenAircraftMeterAndBowserMeter(String faitFormAdiLossBetweenAircraftMeterAndBowserMeter) {
        this.faitFormAdiLossBetweenAircraftMeterAndBowserMeter = faitFormAdiLossBetweenAircraftMeterAndBowserMeter;
    }

    public String getFaitFormAdiTimestamp() {
        return faitFormAdiTimestamp;
    }

    public void setFaitFormAdiTimestamp(String faitFormAdiTimestamp) {
        this.faitFormAdiTimestamp = faitFormAdiTimestamp;
    }

    public String getFaitFormAdiSageId() {
        return faitFormAdiSageId;
    }

    public void setFaitFormAdiSageId(String faitFormAdiSageId) {
        this.faitFormAdiSageId = faitFormAdiSageId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(faitFormAdiId);
        dest.writeValue(faitFormAdiSystemCode);
        dest.writeValue(faitFormAdiNo);
        dest.writeValue(faitFormAdiDate);
        dest.writeValue(faitFormAdiLocation);
        dest.writeValue(faitFormAdiAssetsCustomerSystemCode);
        dest.writeValue(faitFormAdiFlightFrom);
        dest.writeValue(faitFormAdiFlightTo);
        dest.writeValue(faitFormAdiAircraftNo);
        dest.writeValue(faitFormAdiAircraftType);
        dest.writeValue(faitFormAdiProductType);
        dest.writeValue(faitFormAdiPackageType);
        dest.writeValue(faitFormAdiSpecificGravity);
        dest.writeValue(faitFormAdiTemperature);
        dest.writeValue(faitFormAdiMeterStart);
        dest.writeValue(faitFormAdiMeterEnd);
        dest.writeValue(faitFormAdiVolumeSold);
        dest.writeValue(faitFormAdiTimeStart);
        dest.writeValue(faitFormAdiTimeEnd);
        dest.writeValue(faitFormAdiComment);
        dest.writeValue(faitFormAdiReceivingCustomerName);
        dest.writeValue(faitFormAdiReceivingCustomerSignature);
        dest.writeValue(faitFormAdiAssetsStorageSystemCode);
        dest.writeValue(faitFormAdiStatus);
        dest.writeValue(faitFormAdiUsersSystemCode);
        dest.writeValue(faitFormAdiUsersSignature);
        dest.writeValue(faitFormAdiParkTime);
        dest.writeValue(faitFormAdiAircraftMassStart);
        dest.writeValue(faitFormAdiAircraftMassEnd);
        dest.writeValue(faitFormAdiLossBetweenAircraftMeterAndBowserMeter);
        dest.writeValue(faitFormAdiTimestamp);
        dest.writeValue(faitFormAdiSageId);
    }

    public int describeContents() {
        return 0;
    }

}*/
{

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
