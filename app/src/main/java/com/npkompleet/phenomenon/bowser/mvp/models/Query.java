package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query {

    @SerializedName("mainTable")
    @Expose
    private String mainTable;
    @SerializedName("method")
    @Expose
    private String method= "search";
    @SerializedName("selectValues")
    @Expose
    private String selectValues = "";
    @SerializedName("whereValues")
    @Expose
    private QueryParameters.WhereValues whereValues = new QueryParameters.WhereValues();
    @SerializedName("joinArrayParameters")
    @Expose
    private QueryParameters.JoinArrayParameters joinArrayParameters = new QueryParameters.JoinArrayParameters();
    @SerializedName("wherein")
    @Expose
    private QueryParameters.Wherein wherein = new QueryParameters.Wherein();
    @SerializedName("limit")
    @Expose
    private String limit="";
    @SerializedName("ordersBy")
    @Expose
    private QueryParameters.OrdersBy ordersBy= new QueryParameters.OrdersBy();

    /**
     * No args constructor for use in serialization
     *
     */
    public Query() {}

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
    public Query(String mainTable, String method, String selectValues, QueryParameters.WhereValues whereValues, QueryParameters.JoinArrayParameters joinArrayParameters, QueryParameters.Wherein wherein, String limit, QueryParameters.OrdersBy ordersBy) {
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

    public QueryParameters.WhereValues getWhereValues() {
        return whereValues;
    }

    public void setWhereValues(QueryParameters.WhereValues whereValues) {
        this.whereValues = whereValues;
    }

    public QueryParameters.JoinArrayParameters getJoinArrayParameters() {
        return joinArrayParameters;
    }

    public void setJoinArrayParameters(QueryParameters.JoinArrayParameters joinArrayParameters) {
        this.joinArrayParameters = joinArrayParameters;
    }

    public QueryParameters.Wherein getWherein() {
        return wherein;
    }

    public void setWherein(QueryParameters.Wherein wherein) {
        this.wherein = wherein;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public QueryParameters.OrdersBy getOrdersBy() {
        return ordersBy;
    }

    public void setOrdersBy(QueryParameters.OrdersBy ordersBy) {
        this.ordersBy = ordersBy;
    }




}






