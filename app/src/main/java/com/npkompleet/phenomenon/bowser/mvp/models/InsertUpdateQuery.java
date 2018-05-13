package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertUpdateQuery {

    @SerializedName("table")
    @Expose
    private String table;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("whereValues")
    @Expose
    private QueryParameters.WhereValues whereValues;
    @SerializedName("valueArray")
    @Expose
    private QueryParameters.ValueArray valueArray;

    /**
     * No args constructor for use in serialization
     *
     */
    public InsertUpdateQuery() {
    }

    /**
     *
     * @param valueArray
     * @param table
     * @param whereValues
     */
    public InsertUpdateQuery(String table, QueryParameters.WhereValues whereValues, QueryParameters.ValueArray valueArray) {
        super();
        this.table = table;
        this.whereValues = whereValues;
        this.valueArray = valueArray;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public QueryParameters.WhereValues getWhereValues() {
        return whereValues;
    }

    public void setWhereValues(QueryParameters.WhereValues whereValues) {
        this.whereValues = whereValues;
    }

    public QueryParameters.ValueArray getValueArray() {
        return valueArray;
    }

    public void setValueArray(QueryParameters.ValueArray valueArray) {
        this.valueArray = valueArray;
    }

}
