package com.npkompleet.phenomenon.bowser.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Asset {

    @SerializedName("fait_assets_storage_id")
    @Expose
    private String faitAssetsStorageId;
    @SerializedName("fait_assets_storage_system_code")
    @Expose
    private String faitAssetsStorageSystemCode;
    @SerializedName("fait_assets_storage_locations_system_code")
    @Expose
    private String faitAssetsStorageLocationsSystemCode;
    @SerializedName("fait_assets_storage_name")
    @Expose
    private String faitAssetsStorageName;
    @SerializedName("fait_assets_storage_type")
    @Expose
    private String faitAssetsStorageType;
    @SerializedName("fait_assets_storage_status")
    @Expose
    private String faitAssetsStorageStatus;
    @SerializedName("fait_assets_storage_sage_id")
    @Expose
    private String faitAssetsStorageSageId;

    /**
     * No args constructor for use in serialization
     */
    public Asset() {
    }

    /**
     * @param faitAssetsStorageStatus
     * @param faitAssetsStorageSageId
     * @param faitAssetsStorageLocationsSystemCode
     * @param faitAssetsStorageName
     * @param faitAssetsStorageSystemCode
     * @param faitAssetsStorageId
     * @param faitAssetsStorageType
     */
    public Asset(String faitAssetsStorageId, String faitAssetsStorageSystemCode, String faitAssetsStorageLocationsSystemCode, String faitAssetsStorageName, String faitAssetsStorageType, String faitAssetsStorageStatus, String faitAssetsStorageSageId) {
        super();
        this.faitAssetsStorageId = faitAssetsStorageId;
        this.faitAssetsStorageSystemCode = faitAssetsStorageSystemCode;
        this.faitAssetsStorageLocationsSystemCode = faitAssetsStorageLocationsSystemCode;
        this.faitAssetsStorageName = faitAssetsStorageName;
        this.faitAssetsStorageType = faitAssetsStorageType;
        this.faitAssetsStorageStatus = faitAssetsStorageStatus;
        this.faitAssetsStorageSageId = faitAssetsStorageSageId;
    }

    public String getFaitAssetsStorageId() {
        return faitAssetsStorageId;
    }

    public void setFaitAssetsStorageId(String faitAssetsStorageId) {
        this.faitAssetsStorageId = faitAssetsStorageId;
    }

    public String getFaitAssetsStorageSystemCode() {
        return faitAssetsStorageSystemCode;
    }

    public void setFaitAssetsStorageSystemCode(String faitAssetsStorageSystemCode) {
        this.faitAssetsStorageSystemCode = faitAssetsStorageSystemCode;
    }

    public String getFaitAssetsStorageLocationsSystemCode() {
        return faitAssetsStorageLocationsSystemCode;
    }

    public void setFaitAssetsStorageLocationsSystemCode(String faitAssetsStorageLocationsSystemCode) {
        this.faitAssetsStorageLocationsSystemCode = faitAssetsStorageLocationsSystemCode;
    }

    public String getFaitAssetsStorageName() {
        return faitAssetsStorageName;
    }

    public void setFaitAssetsStorageName(String faitAssetsStorageName) {
        this.faitAssetsStorageName = faitAssetsStorageName;
    }

    public String getFaitAssetsStorageType() {
        return faitAssetsStorageType;
    }

    public void setFaitAssetsStorageType(String faitAssetsStorageType) {
        this.faitAssetsStorageType = faitAssetsStorageType;
    }

    public String getFaitAssetsStorageStatus() {
        return faitAssetsStorageStatus;
    }

    public void setFaitAssetsStorageStatus(String faitAssetsStorageStatus) {
        this.faitAssetsStorageStatus = faitAssetsStorageStatus;
    }

    public String getFaitAssetsStorageSageId() {
        return faitAssetsStorageSageId;
    }

    public void setFaitAssetsStorageSageId(String faitAssetsStorageSageId) {
        this.faitAssetsStorageSageId = faitAssetsStorageSageId;
    }

}