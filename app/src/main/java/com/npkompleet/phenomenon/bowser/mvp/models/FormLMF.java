package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormLMF extends QueryParameters.ValueArray{

    @SerializedName("fait_form_lmf_users_system_code")
    @Expose
    private String faitFormLmfUsersSystemCode;
    @SerializedName("fait_form_lmf_system_code")
    @Expose
    private String faitFormLmfSystemCode;
    @SerializedName("fait_form_lmf_date")
    @Expose
    private String faitFormLmfDate;
    @SerializedName("fait_form_lmf_from_assets_storage_system_code")
    @Expose
    private String faitFormLmfFromAssetsStorageSystemCode;
    @SerializedName("fait_form_lmf_to_assets_storage_system_code")
    @Expose
    private String faitFormLmfToAssetsStorageSystemCode;
    @SerializedName("fait_form_lmf_product_type")
    @Expose
    private String faitFormLmfProductType;
    @SerializedName("fait_form_lmf_meter_start")
    @Expose
    private String faitFormLmfMeterStart;
    @SerializedName("fait_form_lmf_time_start")
    @Expose
    private String faitFormLmfTimeStart;
    @SerializedName("fait_form_lmf_meter_end")
    @Expose
    private String faitFormLmfMeterEnd;
    @SerializedName("fait_form_lmf_from_drain")
    @Expose
    private String faitFormLmfFromDrain;
    @SerializedName("fait_form_lmf_time_end")
    @Expose
    private String faitFormLmfTimeEnd;
    @SerializedName("fait_form_lmf_from_dip_start")
    @Expose
    private String faitFormLmfFromDipStart;
    @SerializedName("fait_form_lmf_from_dip_end")
    @Expose
    private String faitFormLmfFromDipEnd;
    @SerializedName("fait_form_lmf_from_dip_volume_start")
    @Expose
    private String faitFormLmfFromDipVolumeStart;
    @SerializedName("fait_form_lmf_from_dip_volume_end")
    @Expose
    private String faitFormLmfFromDipVolumeEnd;
    @SerializedName("fait_form_lmf_to_drain")
    @Expose
    private String faitFormLmfToDrain;
    @SerializedName("fait_form_lmf_to_dip_start")
    @Expose
    private String faitFormLmfToDipStart;
    @SerializedName("fait_form_lmf_to_dip_end")
    @Expose
    private String faitFormLmfToDipEnd;
    @SerializedName("fait_form_lmf_to_dip_volume_start")
    @Expose
    private String faitFormLmfToDipVolumeStart;
    @SerializedName("fait_form_lmf_to_dip_volume_end")
    @Expose
    private String faitFormLmfToDipVolumeEnd;
    @SerializedName("fait_form_lmf_comment")
    @Expose
    private String faitFormLmfComment;

    /**
     * No args constructor for use in serialization
     *
     */
    public FormLMF() {
    }

    /**
     *
     * @param faitFormLmfProductType
     * @param faitFormLmfFromDipStart
     * @param faitFormLmfComment
     * @param faitFormLmfToDrain
     * @param faitFormLmfToDipVolumeEnd
     * @param faitFormLmfTimeStart
     * @param faitFormLmfFromDipVolumeStart
     * @param faitFormLmfFromDipEnd
     * @param faitFormLmfFromDipVolumeEnd
     * @param faitFormLmfFromDrain
     * @param faitFormLmfUsersSystemCode
     * @param faitFormLmfMeterEnd
     * @param faitFormLmfFromAssetsStorageSystemCode
     * @param faitFormLmfToDipEnd
     * @param faitFormLmfSystemCode
     * @param faitFormLmfToDipVolumeStart
     * @param faitFormLmfDate
     * @param faitFormLmfTimeEnd
     * @param faitFormLmfToAssetsStorageSystemCode
     * @param faitFormLmfToDipStart
     * @param faitFormLmfMeterStart
     */
    public FormLMF(String faitFormLmfUsersSystemCode, String faitFormLmfSystemCode, String faitFormLmfDate, String faitFormLmfFromAssetsStorageSystemCode, String faitFormLmfToAssetsStorageSystemCode, String faitFormLmfProductType, String faitFormLmfMeterStart, String faitFormLmfTimeStart, String faitFormLmfMeterEnd, String faitFormLmfFromDrain, String faitFormLmfTimeEnd, String faitFormLmfFromDipStart, String faitFormLmfFromDipEnd, String faitFormLmfFromDipVolumeStart, String faitFormLmfFromDipVolumeEnd, String faitFormLmfToDrain, String faitFormLmfToDipStart, String faitFormLmfToDipEnd, String faitFormLmfToDipVolumeStart, String faitFormLmfToDipVolumeEnd, String faitFormLmfComment) {
        super();
        this.faitFormLmfUsersSystemCode = faitFormLmfUsersSystemCode;
        this.faitFormLmfSystemCode = faitFormLmfSystemCode;
        this.faitFormLmfDate = faitFormLmfDate;
        this.faitFormLmfFromAssetsStorageSystemCode = faitFormLmfFromAssetsStorageSystemCode;
        this.faitFormLmfToAssetsStorageSystemCode = faitFormLmfToAssetsStorageSystemCode;
        this.faitFormLmfProductType = faitFormLmfProductType;
        this.faitFormLmfMeterStart = faitFormLmfMeterStart;
        this.faitFormLmfTimeStart = faitFormLmfTimeStart;
        this.faitFormLmfMeterEnd = faitFormLmfMeterEnd;
        this.faitFormLmfFromDrain = faitFormLmfFromDrain;
        this.faitFormLmfTimeEnd = faitFormLmfTimeEnd;
        this.faitFormLmfFromDipStart = faitFormLmfFromDipStart;
        this.faitFormLmfFromDipEnd = faitFormLmfFromDipEnd;
        this.faitFormLmfFromDipVolumeStart = faitFormLmfFromDipVolumeStart;
        this.faitFormLmfFromDipVolumeEnd = faitFormLmfFromDipVolumeEnd;
        this.faitFormLmfToDrain = faitFormLmfToDrain;
        this.faitFormLmfToDipStart = faitFormLmfToDipStart;
        this.faitFormLmfToDipEnd = faitFormLmfToDipEnd;
        this.faitFormLmfToDipVolumeStart = faitFormLmfToDipVolumeStart;
        this.faitFormLmfToDipVolumeEnd = faitFormLmfToDipVolumeEnd;
        this.faitFormLmfComment = faitFormLmfComment;
    }

    public String getFaitFormLmfUsersSystemCode() {
        return faitFormLmfUsersSystemCode;
    }

    public void setFaitFormLmfUsersSystemCode(String faitFormLmfUsersSystemCode) {
        this.faitFormLmfUsersSystemCode = faitFormLmfUsersSystemCode;
    }

    public String getFaitFormLmfSystemCode() {
        return faitFormLmfSystemCode;
    }

    public void setFaitFormLmfSystemCode(String faitFormLmfSystemCode) {
        this.faitFormLmfSystemCode = faitFormLmfSystemCode;
    }

    public String getFaitFormLmfDate() {
        return faitFormLmfDate;
    }

    public void setFaitFormLmfDate(String faitFormLmfDate) {
        this.faitFormLmfDate = faitFormLmfDate;
    }

    public String getFaitFormLmfFromAssetsStorageSystemCode() {
        return faitFormLmfFromAssetsStorageSystemCode;
    }

    public void setFaitFormLmfFromAssetsStorageSystemCode(String faitFormLmfFromAssetsStorageSystemCode) {
        this.faitFormLmfFromAssetsStorageSystemCode = faitFormLmfFromAssetsStorageSystemCode;
    }

    public String getFaitFormLmfToAssetsStorageSystemCode() {
        return faitFormLmfToAssetsStorageSystemCode;
    }

    public void setFaitFormLmfToAssetsStorageSystemCode(String faitFormLmfToAssetsStorageSystemCode) {
        this.faitFormLmfToAssetsStorageSystemCode = faitFormLmfToAssetsStorageSystemCode;
    }

    public String getFaitFormLmfProductType() {
        return faitFormLmfProductType;
    }

    public void setFaitFormLmfProductType(String faitFormLmfProductType) {
        this.faitFormLmfProductType = faitFormLmfProductType;
    }

    public String getFaitFormLmfMeterStart() {
        return faitFormLmfMeterStart;
    }

    public void setFaitFormLmfMeterStart(String faitFormLmfMeterStart) {
        this.faitFormLmfMeterStart = faitFormLmfMeterStart;
    }

    public String getFaitFormLmfTimeStart() {
        return faitFormLmfTimeStart;
    }

    public void setFaitFormLmfTimeStart(String faitFormLmfTimeStart) {
        this.faitFormLmfTimeStart = faitFormLmfTimeStart;
    }

    public String getFaitFormLmfMeterEnd() {
        return faitFormLmfMeterEnd;
    }

    public void setFaitFormLmfMeterEnd(String faitFormLmfMeterEnd) {
        this.faitFormLmfMeterEnd = faitFormLmfMeterEnd;
    }

    public String getFaitFormLmfFromDrain() {
        return faitFormLmfFromDrain;
    }

    public void setFaitFormLmfFromDrain(String faitFormLmfFromDrain) {
        this.faitFormLmfFromDrain = faitFormLmfFromDrain;
    }

    public String getFaitFormLmfTimeEnd() {
        return faitFormLmfTimeEnd;
    }

    public void setFaitFormLmfTimeEnd(String faitFormLmfTimeEnd) {
        this.faitFormLmfTimeEnd = faitFormLmfTimeEnd;
    }

    public String getFaitFormLmfFromDipStart() {
        return faitFormLmfFromDipStart;
    }

    public void setFaitFormLmfFromDipStart(String faitFormLmfFromDipStart) {
        this.faitFormLmfFromDipStart = faitFormLmfFromDipStart;
    }

    public String getFaitFormLmfFromDipEnd() {
        return faitFormLmfFromDipEnd;
    }

    public void setFaitFormLmfFromDipEnd(String faitFormLmfFromDipEnd) {
        this.faitFormLmfFromDipEnd = faitFormLmfFromDipEnd;
    }

    public String getFaitFormLmfFromDipVolumeStart() {
        return faitFormLmfFromDipVolumeStart;
    }

    public void setFaitFormLmfFromDipVolumeStart(String faitFormLmfFromDipVolumeStart) {
        this.faitFormLmfFromDipVolumeStart = faitFormLmfFromDipVolumeStart;
    }

    public String getFaitFormLmfFromDipVolumeEnd() {
        return faitFormLmfFromDipVolumeEnd;
    }

    public void setFaitFormLmfFromDipVolumeEnd(String faitFormLmfFromDipVolumeEnd) {
        this.faitFormLmfFromDipVolumeEnd = faitFormLmfFromDipVolumeEnd;
    }

    public String getFaitFormLmfToDrain() {
        return faitFormLmfToDrain;
    }

    public void setFaitFormLmfToDrain(String faitFormLmfToDrain) {
        this.faitFormLmfToDrain = faitFormLmfToDrain;
    }

    public String getFaitFormLmfToDipStart() {
        return faitFormLmfToDipStart;
    }

    public void setFaitFormLmfToDipStart(String faitFormLmfToDipStart) {
        this.faitFormLmfToDipStart = faitFormLmfToDipStart;
    }

    public String getFaitFormLmfToDipEnd() {
        return faitFormLmfToDipEnd;
    }

    public void setFaitFormLmfToDipEnd(String faitFormLmfToDipEnd) {
        this.faitFormLmfToDipEnd = faitFormLmfToDipEnd;
    }

    public String getFaitFormLmfToDipVolumeStart() {
        return faitFormLmfToDipVolumeStart;
    }

    public void setFaitFormLmfToDipVolumeStart(String faitFormLmfToDipVolumeStart) {
        this.faitFormLmfToDipVolumeStart = faitFormLmfToDipVolumeStart;
    }

    public String getFaitFormLmfToDipVolumeEnd() {
        return faitFormLmfToDipVolumeEnd;
    }

    public void setFaitFormLmfToDipVolumeEnd(String faitFormLmfToDipVolumeEnd) {
        this.faitFormLmfToDipVolumeEnd = faitFormLmfToDipVolumeEnd;
    }

    public String getFaitFormLmfComment() {
        return faitFormLmfComment;
    }

    public void setFaitFormLmfComment(String faitFormLmfComment) {
        this.faitFormLmfComment = faitFormLmfComment;
    }

}
