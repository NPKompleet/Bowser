
package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAccess {

    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("userPassword")
    @Expose
    private String userPassword;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserAccess() {
    }

    /**
     *
     * @param userId
     * @param userPassword
     * @param type
     */
    public UserAccess(String userId, String userPassword, String type) {
        super();
        this.userId = userId;
        this.userPassword = userPassword;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}