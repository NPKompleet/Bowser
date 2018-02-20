
package com.npkompleet.phenomenon.bowser.mvp.models;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo implements Parcelable {
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("userFirstName")
    @Expose
    private String userFirstName;
    @SerializedName("userLastName")
    @Expose
    private String userLastName;
    @SerializedName("userEmail")
    @Expose
    private String userEmail;
    @SerializedName("userPhone")
    @Expose
    private String userPhone;
    @SerializedName("userPicture")
    @Expose
    private String userPicture;
    @SerializedName("userPrivilege")
    @Expose
    private List<String> userPrivilege = null;
    @SerializedName("userGroup")
    @Expose
    private List<String> userGroup = null;
    @SerializedName("userStatus")
    @Expose
    private String userStatus;
    public final static Parcelable.Creator<UserInfo> CREATOR = new Creator<UserInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        public UserInfo[] newArray(int size) {
            return (new UserInfo[size]);
        }

    };

    protected UserInfo(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.userFirstName = ((String) in.readValue((String.class.getClassLoader())));
        this.userLastName = ((String) in.readValue((String.class.getClassLoader())));
        this.userEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.userPhone = ((String) in.readValue((String.class.getClassLoader())));
        this.userPicture = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.userPrivilege, (java.lang.String.class.getClassLoader()));
        in.readList(this.userGroup, (java.lang.String.class.getClassLoader()));
        this.userStatus = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserInfo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public List<String> getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(List<String> userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    public List<String> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(List<String> userGroup) {
        this.userGroup = userGroup;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(userFirstName);
        dest.writeValue(userLastName);
        dest.writeValue(userEmail);
        dest.writeValue(userPhone);
        dest.writeValue(userPicture);
        dest.writeList(userPrivilege);
        dest.writeList(userGroup);
        dest.writeValue(userStatus);
    }

    public int describeContents() {
        return 0;
    }

}
