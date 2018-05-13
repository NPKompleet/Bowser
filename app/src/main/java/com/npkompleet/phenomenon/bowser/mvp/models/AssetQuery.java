package com.npkompleet.phenomenon.bowser.mvp.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssetQuery extends Query {
    public AssetQuery(){
        super();
        this.setMainTable("fait_assets_storage");
    }

    public class WhereValues extends QueryParameters.WhereValues{

        @SerializedName("fait_assets_storage_locations_system_code")
        @Expose
        private String faitAssetsStorageLocationsSystemCode;
        @SerializedName("fait_assets_storage_status")
        @Expose
        private String faitAssetsStorageStatus;
        @SerializedName("fait_assets_storage_type")
        @Expose
        private String faitAssetsStorageType;

        /**
         * No args constructor for use in serialization
         *
         */
        public WhereValues() {
        }

        /**
         *
         * @param faitAssetsStorageStatus
         * @param faitAssetsStorageLocationsSystemCode
         * @param //faitAssetsStorageType
         */
        public WhereValues(String faitAssetsStorageLocationsSystemCode, String faitAssetsStorageStatus/*, @Nullable String faitAssetsStorageType*/) {
            super();
            this.faitAssetsStorageLocationsSystemCode = faitAssetsStorageLocationsSystemCode;
            this.faitAssetsStorageStatus = faitAssetsStorageStatus;
            this.faitAssetsStorageType = faitAssetsStorageType;
        }

        public String getFaitAssetsStorageLocationsSystemCode() {
            return faitAssetsStorageLocationsSystemCode;
        }

        public void setFaitAssetsStorageLocationsSystemCode(String faitAssetsStorageLocationsSystemCode) {
            this.faitAssetsStorageLocationsSystemCode = faitAssetsStorageLocationsSystemCode;
        }

        public String getFaitAssetsStorageStatus() {
            return faitAssetsStorageStatus;
        }

        public void setFaitAssetsStorageStatus(String faitAssetsStorageStatus) {
            this.faitAssetsStorageStatus = faitAssetsStorageStatus;
        }

        public String getFaitAssetsStorageType() {
            return faitAssetsStorageType;
        }

        public void setFaitAssetsStorageType(String faitAssetsStorageType) {
            this.faitAssetsStorageType = faitAssetsStorageType;
        }

    }
}
