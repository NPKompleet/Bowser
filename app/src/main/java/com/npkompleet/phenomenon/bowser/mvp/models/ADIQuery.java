package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ADIQuery {

    @SerializedName("mainTable")
    @Expose
    private String mainTable="fait_form_adi";
    @SerializedName("method")
    @Expose
    private String method="adiList";
    @SerializedName("selectValues")
    @Expose
    private String selectValues= "";
    @SerializedName("whereValues")
    @Expose
    private String whereValues;
    @SerializedName("joinArrayParameters")
    @Expose
    private String joinArrayParameters="";
    @SerializedName("wherein")
    @Expose
    private String wherein="";
    @SerializedName("limit")
    @Expose
    private int limit=0;
    @SerializedName("ordersBy")
    @Expose
    private String ordersBy="";

    /**
     * No args constructor for use in serialization
     *
     */
    public ADIQuery() {
        super();
    }

    /**
     *
     * @param limit
     * @param mainTable
     * @param selectValues
     * @param method
     * @param wherein
     * @param ordersBy
     * @param joinArrayParameters
     * @param whereValues
     */
    public ADIQuery(String mainTable, String method, String selectValues, String whereValues, String joinArrayParameters, String wherein, int limit, String ordersBy) {
        super();
        this.mainTable = mainTable;
        this.method = method;
        this.selectValues = selectValues;
        this.whereValues = whereValues;
        this.joinArrayParameters = joinArrayParameters;
        this.wherein = wherein;
        this.limit = limit;
        this.ordersBy = ordersBy;
    }

    public String getMainTable() {
        return mainTable;
    }

    public void setMainTable(String mainTable) {
        this.mainTable = mainTable;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSelectValues() {
        return selectValues;
    }

    public void setSelectValues(String selectValues) {
        this.selectValues = selectValues;
    }

    public String getWhereValues() {
        return whereValues;
    }

    public void setWhereValues(String whereValues) {
        this.whereValues = whereValues;
    }

    public String getJoinArrayParameters() {
        return joinArrayParameters;
    }

    public void setJoinArrayParameters(String joinArrayParameters) {
        this.joinArrayParameters = joinArrayParameters;
    }

    public String getWherein() {
        return wherein;
    }

    public void setWherein(String wherein) {
        this.wherein = wherein;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrdersBy() {
        return ordersBy;
    }

    public void setOrdersBy(String ordersBy) {
        this.ordersBy = ordersBy;
    }

}