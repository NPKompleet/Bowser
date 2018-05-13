
package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAccess extends Parameters{

    @SerializedName("fait_users_userid")
    @Expose
    private String userId;
    @SerializedName("fait_users_password")
    @Expose
    private String userPassword;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserAccess() {
    }

    /**
     *
     * @param userPassword
     * @param userId
     */
    public UserAccess(String userId, String userPassword) {
        super();
        this.userId = userId;
        this.userPassword = userPassword;
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

}