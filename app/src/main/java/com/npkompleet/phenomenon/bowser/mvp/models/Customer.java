package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("fait_assets_customer_id")
    @Expose
    private String faitAssetsCustomerId;
    @SerializedName("fait_assets_customer_system_code")
    @Expose
    private String faitAssetsCustomerSystemCode;
    @SerializedName("fait_assets_customer_name")
    @Expose
    private String faitAssetsCustomerName;
    @SerializedName("fait_assets_customer_phone")
    @Expose
    private String faitAssetsCustomerPhone;
    @SerializedName("fait_assets_customer_email")
    @Expose
    private String faitAssetsCustomerEmail;
    @SerializedName("fait_assets_customer_address")
    @Expose
    private String faitAssetsCustomerAddress;
    @SerializedName("fait_assets_customer_status")
    @Expose
    private String faitAssetsCustomerStatus;

    /**
     * No args constructor for use in serialization
     *
     */
    public Customer() {
    }

    /**
     *
     * @param faitAssetsCustomerId
     * @param faitAssetsCustomerEmail
     * @param faitAssetsCustomerPhone
     * @param faitAssetsCustomerAddress
     * @param faitAssetsCustomerName
     * @param faitAssetsCustomerSystemCode
     * @param faitAssetsCustomerStatus
     */
    public Customer(String faitAssetsCustomerId, String faitAssetsCustomerSystemCode, String faitAssetsCustomerName, String faitAssetsCustomerPhone, String faitAssetsCustomerEmail, String faitAssetsCustomerAddress, String faitAssetsCustomerStatus) {
        super();
        this.faitAssetsCustomerId = faitAssetsCustomerId;
        this.faitAssetsCustomerSystemCode = faitAssetsCustomerSystemCode;
        this.faitAssetsCustomerName = faitAssetsCustomerName;
        this.faitAssetsCustomerPhone = faitAssetsCustomerPhone;
        this.faitAssetsCustomerEmail = faitAssetsCustomerEmail;
        this.faitAssetsCustomerAddress = faitAssetsCustomerAddress;
        this.faitAssetsCustomerStatus = faitAssetsCustomerStatus;
    }

    public String getFaitAssetsCustomerId() {
        return faitAssetsCustomerId;
    }

    public void setFaitAssetsCustomerId(String faitAssetsCustomerId) {
        this.faitAssetsCustomerId = faitAssetsCustomerId;
    }

    public String getFaitAssetsCustomerSystemCode() {
        return faitAssetsCustomerSystemCode;
    }

    public void setFaitAssetsCustomerSystemCode(String faitAssetsCustomerSystemCode) {
        this.faitAssetsCustomerSystemCode = faitAssetsCustomerSystemCode;
    }

    public String getFaitAssetsCustomerName() {
        return faitAssetsCustomerName;
    }

    public void setFaitAssetsCustomerName(String faitAssetsCustomerName) {
        this.faitAssetsCustomerName = faitAssetsCustomerName;
    }

    public String getFaitAssetsCustomerPhone() {
        return faitAssetsCustomerPhone;
    }

    public void setFaitAssetsCustomerPhone(String faitAssetsCustomerPhone) {
        this.faitAssetsCustomerPhone = faitAssetsCustomerPhone;
    }

    public String getFaitAssetsCustomerEmail() {
        return faitAssetsCustomerEmail;
    }

    public void setFaitAssetsCustomerEmail(String faitAssetsCustomerEmail) {
        this.faitAssetsCustomerEmail = faitAssetsCustomerEmail;
    }

    public String getFaitAssetsCustomerAddress() {
        return faitAssetsCustomerAddress;
    }

    public void setFaitAssetsCustomerAddress(String faitAssetsCustomerAddress) {
        this.faitAssetsCustomerAddress = faitAssetsCustomerAddress;
    }

    public String getFaitAssetsCustomerStatus() {
        return faitAssetsCustomerStatus;
    }

    public void setFaitAssetsCustomerStatus(String faitAssetsCustomerStatus) {
        this.faitAssetsCustomerStatus = faitAssetsCustomerStatus;
    }

}
