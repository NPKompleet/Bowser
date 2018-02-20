package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserListAccess {

    @SerializedName("countLimit")
    @Expose
    private int countLimit;
    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserListAccess() {
    }

    /**
     *
     * @param countLimit
     * @param type
     * @param offset
     */
    public UserListAccess(int countLimit, int offset, String type) {
        super();
        this.countLimit = countLimit;
        this.offset = offset;
        this.type = type;
    }

    public int getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(int countLimit) {
        this.countLimit = countLimit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
