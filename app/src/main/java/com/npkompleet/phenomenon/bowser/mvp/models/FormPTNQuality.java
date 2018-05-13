package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormPTNQuality extends QueryParameters.ValueArray{

    @SerializedName("fait_users_system_code")
    @Expose
    private String faitUsersSystemCode;
    @SerializedName("fait_form_ptn_system_code")
    @Expose
    private String faitFormPtnSystemCode;
    @SerializedName("fait_form_ptn_quality_date")
    @Expose
    private String faitFormPtnQualityDate;
    @SerializedName("fait_form_ptn_quality_batch_no")
    @Expose
    private String faitFormPtnQualityBatchNo;
    @SerializedName("fait_form_ptn_quality_temperature")
    @Expose
    private String faitFormPtnQualityTemperature;
    @SerializedName("fait_form_ptn_quality_specific_gravity")
    @Expose
    private String faitFormPtnQualitySpecificGravity;
    @SerializedName("fait_form_ptn_quality_colour")
    @Expose
    private String faitFormPtnQualityColour;
    @SerializedName("fait_form_ptn_quality_test_for_water")
    @Expose
    private String faitFormPtnQualityTestForWater;
    @SerializedName("fait_form_ptn_quality_product_last_carried")
    @Expose
    private String faitFormPtnQualityProductLastCarried;
    @SerializedName("fait_form_ptn_quality_comment")
    @Expose
    private String faitFormPtnQualityComment;

    /**
     * No args constructor for use in serialization
     *
     */
    public FormPTNQuality() {
    }

    /**
     *
     * @param faitFormPtnQualityDate
     * @param faitFormPtnSystemCode
     * @param faitFormPtnQualityComment
     * @param faitFormPtnQualityTemperature
     * @param faitFormPtnQualityBatchNo
     * @param faitFormPtnQualityTestForWater
     * @param faitFormPtnQualityProductLastCarried
     * @param faitFormPtnQualityColour
     * @param faitUsersSystemCode
     * @param faitFormPtnQualitySpecificGravity
     */
    public FormPTNQuality(String faitUsersSystemCode, String faitFormPtnSystemCode, String faitFormPtnQualityDate, String faitFormPtnQualityBatchNo, String faitFormPtnQualityTemperature, String faitFormPtnQualitySpecificGravity, String faitFormPtnQualityColour, String faitFormPtnQualityTestForWater, String faitFormPtnQualityProductLastCarried, String faitFormPtnQualityComment) {
        super();
        this.faitUsersSystemCode = faitUsersSystemCode;
        this.faitFormPtnSystemCode = faitFormPtnSystemCode;
        this.faitFormPtnQualityDate = faitFormPtnQualityDate;
        this.faitFormPtnQualityBatchNo = faitFormPtnQualityBatchNo;
        this.faitFormPtnQualityTemperature = faitFormPtnQualityTemperature;
        this.faitFormPtnQualitySpecificGravity = faitFormPtnQualitySpecificGravity;
        this.faitFormPtnQualityColour = faitFormPtnQualityColour;
        this.faitFormPtnQualityTestForWater = faitFormPtnQualityTestForWater;
        this.faitFormPtnQualityProductLastCarried = faitFormPtnQualityProductLastCarried;
        this.faitFormPtnQualityComment = faitFormPtnQualityComment;
    }

    public String getFaitUsersSystemCode() {
        return faitUsersSystemCode;
    }

    public void setFaitUsersSystemCode(String faitUsersSystemCode) {
        this.faitUsersSystemCode = faitUsersSystemCode;
    }

    public String getFaitFormPtnSystemCode() {
        return faitFormPtnSystemCode;
    }

    public void setFaitFormPtnSystemCode(String faitFormPtnSystemCode) {
        this.faitFormPtnSystemCode = faitFormPtnSystemCode;
    }

    public String getFaitFormPtnQualityDate() {
        return faitFormPtnQualityDate;
    }

    public void setFaitFormPtnQualityDate(String faitFormPtnQualityDate) {
        this.faitFormPtnQualityDate = faitFormPtnQualityDate;
    }

    public String getFaitFormPtnQualityBatchNo() {
        return faitFormPtnQualityBatchNo;
    }

    public void setFaitFormPtnQualityBatchNo(String faitFormPtnQualityBatchNo) {
        this.faitFormPtnQualityBatchNo = faitFormPtnQualityBatchNo;
    }

    public String getFaitFormPtnQualityTemperature() {
        return faitFormPtnQualityTemperature;
    }

    public void setFaitFormPtnQualityTemperature(String faitFormPtnQualityTemperature) {
        this.faitFormPtnQualityTemperature = faitFormPtnQualityTemperature;
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

    public String getFaitFormPtnQualityComment() {
        return faitFormPtnQualityComment;
    }

    public void setFaitFormPtnQualityComment(String faitFormPtnQualityComment) {
        this.faitFormPtnQualityComment = faitFormPtnQualityComment;
    }

}
