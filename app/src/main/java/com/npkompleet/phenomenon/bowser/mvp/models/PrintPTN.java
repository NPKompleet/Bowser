package com.npkompleet.phenomenon.bowser.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrintPTN {

    @SerializedName("fait_form_ptn_delivery_date")
    @Expose
    private String faitFormPtnDeliveryDate;
    @SerializedName("fait_form_ptn_no")
    @Expose
    private String faitFormPtnNo;
    @SerializedName("fait_form_ptn_quantity_received_by_meter")
    @Expose
    private String faitFormPtnQuantityReceivedByMeter;
    @SerializedName("fait_form_ptn_loading_station")
    @Expose
    private String faitFormPtnLoadingStation;
    @SerializedName("fait_form_ptn_waybill_no")
    @Expose
    private String faitFormPtnWaybillNo;
    @SerializedName("fait_form_ptn_meter_start")
    @Expose
    private String faitFormPtnMeterStart;
    @SerializedName("fait_form_ptn_transporter")
    @Expose
    private String faitFormPtnTransporter;
    @SerializedName("fait_form_ptn_truck_no")
    @Expose
    private String faitFormPtnTruckNo;
    @SerializedName("fait_form_ptn_meter_end")
    @Expose
    private String faitFormPtnMeterEnd;
    @SerializedName("fait_users_lastname")
    @Expose
    private String faitUsersLastname;
    @SerializedName("fait_users_firstname")
    @Expose
    private String faitUsersFirstname;
    @SerializedName("fait_locations_name")
    @Expose
    private String faitLocationsName;
    @SerializedName("fait_form_ptn_driver_name")
    @Expose
    private String faitFormPtnDriverName;
    @SerializedName("fait_form_ptn_loader_name")
    @Expose
    private String faitFormPtnLoaderName;
    @SerializedName("fait_assets_storage_name")
    @Expose
    private String faitAssetsStorageName;
    @SerializedName("fait_form_ptn_quantity")
    @Expose
    private String faitFormPtnQuantity;
    @SerializedName("fait_form_ptn_product_type")
    @Expose
    private String faitFormPtnProductType;
    @SerializedName("fait_form_ptn_loading_date")
    @Expose
    private String faitFormPtnLoadingDate;
    @SerializedName("fait_form_ptn_quality_specific_gravity")
    @Expose
    private String faitFormPtnQualitySpecificGravity;
    @SerializedName("fait_form_ptn_quality_colour")
    @Expose
    private String faitFormPtnQualityColour;
    @SerializedName("fait_form_ptn_quality_temperature")
    @Expose
    private String faitFormPtnQualityTemperature;
    @SerializedName("fait_form_ptn_quality_batch_no")
    @Expose
    private String faitFormPtnQualityBatchNo;
    @SerializedName("fait_form_ptn_quality_test_for_water")
    @Expose
    private String faitFormPtnQualityTestForWater;
    @SerializedName("fait_form_ptn_quality_product_last_carried")
    @Expose
    private String faitFormPtnQualityProductLastCarried;
    @SerializedName("fait_form_ptn_quality_date")
    @Expose
    private String faitFormPtnQualityDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public PrintPTN() {
    }

    /**
     *
     * @param faitFormPtnQualityTemperature
     * @param faitLocationsName
     * @param faitFormPtnQuantity
     * @param faitFormPtnProductType
     * @param faitFormPtnQualityProductLastCarried
     * @param faitFormPtnDriverName
     * @param faitFormPtnTransporter
     * @param faitFormPtnTruckNo
     * @param faitUsersFirstname
     * @param faitFormPtnQualityBatchNo
     * @param faitFormPtnLoaderName
     * @param faitFormPtnLoadingDate
     * @param faitFormPtnLoadingStation
     * @param faitUsersLastname
     * @param faitFormPtnWaybillNo
     * @param faitFormPtnMeterEnd
     * @param faitFormPtnNo
     * @param faitFormPtnDeliveryDate
     * @param faitFormPtnQuantityReceivedByMeter
     * @param faitFormPtnQualityTestForWater
     * @param faitFormPtnQualityColour
     * @param faitFormPtnQualitySpecificGravity
     * @param faitFormPtnQualityDate
     * @param faitFormPtnMeterStart
     * @param faitAssetsStorageName
     */
    public PrintPTN(String faitFormPtnDeliveryDate, String faitFormPtnNo, String faitFormPtnQuantityReceivedByMeter, String faitFormPtnLoadingStation, String faitFormPtnWaybillNo, String faitFormPtnMeterStart, String faitFormPtnTransporter, String faitFormPtnTruckNo, String faitFormPtnMeterEnd, String faitUsersLastname, String faitUsersFirstname, String faitLocationsName, String faitFormPtnDriverName, String faitFormPtnLoaderName, String faitAssetsStorageName, String faitFormPtnQuantity, String faitFormPtnProductType, String faitFormPtnLoadingDate, String faitFormPtnQualitySpecificGravity, String faitFormPtnQualityColour, String faitFormPtnQualityTemperature, String faitFormPtnQualityBatchNo, String faitFormPtnQualityTestForWater, String faitFormPtnQualityProductLastCarried, String faitFormPtnQualityDate) {
        super();
        this.faitFormPtnDeliveryDate = faitFormPtnDeliveryDate;
        this.faitFormPtnNo = faitFormPtnNo;
        this.faitFormPtnQuantityReceivedByMeter = faitFormPtnQuantityReceivedByMeter;
        this.faitFormPtnLoadingStation = faitFormPtnLoadingStation;
        this.faitFormPtnWaybillNo = faitFormPtnWaybillNo;
        this.faitFormPtnMeterStart = faitFormPtnMeterStart;
        this.faitFormPtnTransporter = faitFormPtnTransporter;
        this.faitFormPtnTruckNo = faitFormPtnTruckNo;
        this.faitFormPtnMeterEnd = faitFormPtnMeterEnd;
        this.faitUsersLastname = faitUsersLastname;
        this.faitUsersFirstname = faitUsersFirstname;
        this.faitLocationsName = faitLocationsName;
        this.faitFormPtnDriverName = faitFormPtnDriverName;
        this.faitFormPtnLoaderName = faitFormPtnLoaderName;
        this.faitAssetsStorageName = faitAssetsStorageName;
        this.faitFormPtnQuantity = faitFormPtnQuantity;
        this.faitFormPtnProductType = faitFormPtnProductType;
        this.faitFormPtnLoadingDate = faitFormPtnLoadingDate;
        this.faitFormPtnQualitySpecificGravity = faitFormPtnQualitySpecificGravity;
        this.faitFormPtnQualityColour = faitFormPtnQualityColour;
        this.faitFormPtnQualityTemperature = faitFormPtnQualityTemperature;
        this.faitFormPtnQualityBatchNo = faitFormPtnQualityBatchNo;
        this.faitFormPtnQualityTestForWater = faitFormPtnQualityTestForWater;
        this.faitFormPtnQualityProductLastCarried = faitFormPtnQualityProductLastCarried;
        this.faitFormPtnQualityDate = faitFormPtnQualityDate;
    }

    public String getFaitFormPtnDeliveryDate() {
        return faitFormPtnDeliveryDate;
    }

    public void setFaitFormPtnDeliveryDate(String faitFormPtnDeliveryDate) {
        this.faitFormPtnDeliveryDate = faitFormPtnDeliveryDate;
    }

    public String getFaitFormPtnNo() {
        return faitFormPtnNo;
    }

    public void setFaitFormPtnNo(String faitFormPtnNo) {
        this.faitFormPtnNo = faitFormPtnNo;
    }

    public String getFaitFormPtnQuantityReceivedByMeter() {
        return faitFormPtnQuantityReceivedByMeter;
    }

    public void setFaitFormPtnQuantityReceivedByMeter(String faitFormPtnQuantityReceivedByMeter) {
        this.faitFormPtnQuantityReceivedByMeter = faitFormPtnQuantityReceivedByMeter;
    }

    public String getFaitFormPtnLoadingStation() {
        return faitFormPtnLoadingStation;
    }

    public void setFaitFormPtnLoadingStation(String faitFormPtnLoadingStation) {
        this.faitFormPtnLoadingStation = faitFormPtnLoadingStation;
    }

    public String getFaitFormPtnWaybillNo() {
        return faitFormPtnWaybillNo;
    }

    public void setFaitFormPtnWaybillNo(String faitFormPtnWaybillNo) {
        this.faitFormPtnWaybillNo = faitFormPtnWaybillNo;
    }

    public String getFaitFormPtnMeterStart() {
        return faitFormPtnMeterStart;
    }

    public void setFaitFormPtnMeterStart(String faitFormPtnMeterStart) {
        this.faitFormPtnMeterStart = faitFormPtnMeterStart;
    }

    public String getFaitFormPtnTransporter() {
        return faitFormPtnTransporter;
    }

    public void setFaitFormPtnTransporter(String faitFormPtnTransporter) {
        this.faitFormPtnTransporter = faitFormPtnTransporter;
    }

    public String getFaitFormPtnTruckNo() {
        return faitFormPtnTruckNo;
    }

    public void setFaitFormPtnTruckNo(String faitFormPtnTruckNo) {
        this.faitFormPtnTruckNo = faitFormPtnTruckNo;
    }

    public String getFaitFormPtnMeterEnd() {
        return faitFormPtnMeterEnd;
    }

    public void setFaitFormPtnMeterEnd(String faitFormPtnMeterEnd) {
        this.faitFormPtnMeterEnd = faitFormPtnMeterEnd;
    }

    public String getFaitUsersLastname() {
        return faitUsersLastname;
    }

    public void setFaitUsersLastname(String faitUsersLastname) {
        this.faitUsersLastname = faitUsersLastname;
    }

    public String getFaitUsersFirstname() {
        return faitUsersFirstname;
    }

    public void setFaitUsersFirstname(String faitUsersFirstname) {
        this.faitUsersFirstname = faitUsersFirstname;
    }

    public String getFaitLocationsName() {
        return faitLocationsName;
    }

    public void setFaitLocationsName(String faitLocationsName) {
        this.faitLocationsName = faitLocationsName;
    }

    public String getFaitFormPtnDriverName() {
        return faitFormPtnDriverName;
    }

    public void setFaitFormPtnDriverName(String faitFormPtnDriverName) {
        this.faitFormPtnDriverName = faitFormPtnDriverName;
    }

    public String getFaitFormPtnLoaderName() {
        return faitFormPtnLoaderName;
    }

    public void setFaitFormPtnLoaderName(String faitFormPtnLoaderName) {
        this.faitFormPtnLoaderName = faitFormPtnLoaderName;
    }

    public String getFaitAssetsStorageName() {
        return faitAssetsStorageName;
    }

    public void setFaitAssetsStorageName(String faitAssetsStorageName) {
        this.faitAssetsStorageName = faitAssetsStorageName;
    }

    public String getFaitFormPtnQuantity() {
        return faitFormPtnQuantity;
    }

    public void setFaitFormPtnQuantity(String faitFormPtnQuantity) {
        this.faitFormPtnQuantity = faitFormPtnQuantity;
    }

    public String getFaitFormPtnProductType() {
        return faitFormPtnProductType;
    }

    public void setFaitFormPtnProductType(String faitFormPtnProductType) {
        this.faitFormPtnProductType = faitFormPtnProductType;
    }

    public String getFaitFormPtnLoadingDate() {
        return faitFormPtnLoadingDate;
    }

    public void setFaitFormPtnLoadingDate(String faitFormPtnLoadingDate) {
        this.faitFormPtnLoadingDate = faitFormPtnLoadingDate;
    }

    public String getFaitFormPtnQualitySpecificGravity() {
        return faitFormPtnQualitySpecificGravity;
    }

    public void setFaitFormPtnQualitySpecificGravity(String faitFormPtnQualitySpecificGravity) {
        this.faitFormPtnQualitySpecificGravity = faitFormPtnQualitySpecificGravity;
    }

    public String getFaitFormPtnQualityColour() {
        return faitFormPtnQualityColour;
    }

    public void setFaitFormPtnQualityColour(String faitFormPtnQualityColour) {
        this.faitFormPtnQualityColour = faitFormPtnQualityColour;
    }

    public String getFaitFormPtnQualityTemperature() {
        return faitFormPtnQualityTemperature;
    }

    public void setFaitFormPtnQualityTemperature(String faitFormPtnQualityTemperature) {
        this.faitFormPtnQualityTemperature = faitFormPtnQualityTemperature;
    }

    public String getFaitFormPtnQualityBatchNo() {
        return faitFormPtnQualityBatchNo;
    }

    public void setFaitFormPtnQualityBatchNo(String faitFormPtnQualityBatchNo) {
        this.faitFormPtnQualityBatchNo = faitFormPtnQualityBatchNo;
    }

    public String getFaitFormPtnQualityTestForWater() {
        return faitFormPtnQualityTestForWater;
    }

    public void setFaitFormPtnQualityTestForWater(String faitFormPtnQualityTestForWater) {
        this.faitFormPtnQualityTestForWater = faitFormPtnQualityTestForWater;
    }

    public String getFaitFormPtnQualityProductLastCarried() {
        return faitFormPtnQualityProductLastCarried;
    }

    public void setFaitFormPtnQualityProductLastCarried(String faitFormPtnQualityProductLastCarried) {
        this.faitFormPtnQualityProductLastCarried = faitFormPtnQualityProductLastCarried;
    }

    public String getFaitFormPtnQualityDate() {
        return faitFormPtnQualityDate;
    }

    public void setFaitFormPtnQualityDate(String faitFormPtnQualityDate) {
        this.faitFormPtnQualityDate = faitFormPtnQualityDate;
    }

}