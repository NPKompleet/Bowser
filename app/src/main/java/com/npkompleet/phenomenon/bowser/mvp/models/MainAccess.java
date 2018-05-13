package com.npkompleet.phenomenon.bowser.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHENOMENON on 3/12/2018.
 */

public class MainAccess {

    @SerializedName("table")
    @Expose
    private String table;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("parameters")
    @Expose
    private Parameters parameters;
    @SerializedName("values")
    @Expose
    private QueryParameters.ValueArray values;

    /**
     * No args constructor for use in serialization
     *
     */
    public MainAccess() {
    }

    public MainAccess(String table, String method, Parameters parameters) {
        super();
        this.table = table;
        this.method = method;
        this.parameters = parameters;
    }


    /**
     *
     * @param values
     * @param method
     * @param parameters
     * @param table
     */
    public MainAccess(String table, String method, Parameters parameters, QueryParameters.ValueArray values) {
        super();
        this.table = table;
        this.method = method;
        this.parameters = parameters;
        this.values = values;
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

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public QueryParameters.ValueArray getValues() {
        return values;
    }

    public void setValues(QueryParameters.ValueArray values) {
        this.values = values;
    }

}
