package com.npkompleet.phenomenon.bowser.mvp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserList {

    @SerializedName("userInfo")
    @Expose
    private List<UserInfo> userInfo = null;
    @SerializedName("totalUserCount")
    @Expose
    private int totalUserCount;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserList() {
    }

    /**
     *
     * @param message
     * @param status
     * @param totalUserCount
     * @param userInfo
     */
    public UserList(List<UserInfo> userInfo, int totalUserCount, String message, String status) {
        super();
        this.userInfo = userInfo;
        this.totalUserCount = totalUserCount;
        this.message = message;
        this.status = status;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }

    public int getTotalUserCount() {
        return totalUserCount;
    }

    public void setTotalUserCount(int totalUserCount) {
        this.totalUserCount = totalUserCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
