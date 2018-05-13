package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Template {

    @SerializedName("websiteLink")
    @Expose
    private String websiteLink;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("logo2")
    @Expose
    private String logo2;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("footer")
    @Expose
    private String footer;

    /**
     * No args constructor for use in serialization
     *
     */
    public Template() {
    }

    /**
     *
     * @param footer
     * @param logo
     * @param websiteLink
     * @param name
     * @param logo2
     * @param header
     */
    public Template(String websiteLink, String logo, String logo2, String name, String header, String footer) {
        super();
        this.websiteLink = websiteLink;
        this.logo = logo;
        this.logo2 = logo2;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo2() {
        return logo2;
    }

    public void setLogo2(String logo2) {
        this.logo2 = logo2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

}
