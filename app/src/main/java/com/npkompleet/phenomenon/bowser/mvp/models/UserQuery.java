package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by PHENOMENON on 4/20/2018.
 */


public  class UserQuery extends Query{

    public UserQuery(){
        super();
    }

    public class UserWhereValues extends QueryParameters.WhereValues {
        @SerializedName("fait_users_userid")
        @Expose
        private String faitUsersUserid;
        @SerializedName("fait_users_password")
        @Expose
        private String faitUsersPassword;

        /**
         * No args constructor for use in serialization
         *
         */
        public UserWhereValues() {
        }

        /**
         *
         * @param faitUsersPassword
         * @param faitUsersUserid
         */
        public UserWhereValues(String faitUsersUserid, String faitUsersPassword) {
            super();
            this.faitUsersUserid = faitUsersUserid;
            this.faitUsersPassword = faitUsersPassword;
        }

        public String getFaitUsersUserid() {
            return faitUsersUserid;
        }

        public void setFaitUsersUserid(String faitUsersUserid) {
            this.faitUsersUserid = faitUsersUserid;
        }

        public String getFaitUsersPassword() {
            return faitUsersPassword;
        }

        public void setFaitUsersPassword(String faitUsersPassword) {
            this.faitUsersPassword = faitUsersPassword;
        }

    }
}
