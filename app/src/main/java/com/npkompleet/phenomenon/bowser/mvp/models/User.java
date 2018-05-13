
package com.npkompleet.phenomenon.bowser.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("fait_users_id")
    @Expose
    private String id;
    @SerializedName("fait_users_system_code")
    @Expose
    private String systemCode;
    @SerializedName("fait_users_userid")
    @Expose
    private String userId;
    @SerializedName("fait_users_password")
    @Expose
    private String password;
    @SerializedName("fait_users_email")
    @Expose
    private String email;
    @SerializedName("fait_users_phone")
    @Expose
    private String phone;
    @SerializedName("fait_users_lastname")
    @Expose
    private String lastName;
    @SerializedName("fait_users_firstname")
    @Expose
    private String firstName;
    @SerializedName("fait_users_groups_system_code")
    @Expose
    private String groupsSystemCode;
    @SerializedName("fait_users_picture")
    @Expose
    private String picture;
    @SerializedName("fait_users_companies_system_code")
    @Expose
    private String companiesSystemCode;
    @SerializedName("fait_users_locations_system_code")
    @Expose
    private String locationsSystemCode;
    @SerializedName("fait_users_status")
    @Expose
    private String status;

    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
            ;

    protected User(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.systemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.groupsSystemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.picture = ((String) in.readValue((String.class.getClassLoader())));
        this.companiesSystemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.locationsSystemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));

    }

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param lastName
     * @param picture
     * @param groupsSystemCode
     * @param companiesSystemCode
     * @param systemCode
     * @param id
     * @param email
     * @param firstName
     * @param phone
     * @param designationSystemCode
     * @param status
     * @param password
     * @param userId
     * @param locationsSystemCode
     */
    public User(String id, String systemCode, String userId, String password, String email, String phone, String lastName, String firstName, String groupsSystemCode, String picture, String companiesSystemCode, String locationsSystemCode, String status, String designationSystemCode) {
        super();
        this.id = id;
        this.systemCode = systemCode;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groupsSystemCode = groupsSystemCode;
        this.picture = picture;
        this.companiesSystemCode = companiesSystemCode;
        this.locationsSystemCode = locationsSystemCode;
        this.status = status;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGroupsSystemCode() {
        return groupsSystemCode;
    }

    public void setGroupsSystemCode(String groupsSystemCode) {
        this.groupsSystemCode = groupsSystemCode;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCompaniesSystemCode() {
        return companiesSystemCode;
    }

    public void setCompaniesSystemCode(String companiesSystemCode) {
        this.companiesSystemCode = companiesSystemCode;
    }

    public String getLocationsSystemCode() {
        return locationsSystemCode;
    }

    public void setLocationsSystemCode(String locationsSystemCode) {
        this.locationsSystemCode = locationsSystemCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(systemCode);
        dest.writeValue(userId);
        dest.writeValue(password);
        dest.writeValue(email);
        dest.writeValue(phone);
        dest.writeValue(lastName);
        dest.writeValue(firstName);
        dest.writeValue(groupsSystemCode);
        dest.writeValue(picture);
        dest.writeValue(companiesSystemCode);
        dest.writeValue(locationsSystemCode);
        dest.writeValue(status);

    }

    public int describeContents() {
        return 0;
    }

}