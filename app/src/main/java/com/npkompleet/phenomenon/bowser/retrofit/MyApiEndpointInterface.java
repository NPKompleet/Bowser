package com.npkompleet.phenomenon.bowser.retrofit;

import com.npkompleet.phenomenon.bowser.mvp.models.ADIQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.Asset;
import com.npkompleet.phenomenon.bowser.mvp.models.Customer;
import com.npkompleet.phenomenon.bowser.mvp.models.InsertUpdateQuery;
import com.npkompleet.phenomenon.bowser.mvp.models.Location;
import com.npkompleet.phenomenon.bowser.mvp.models.MainAccess;
import com.npkompleet.phenomenon.bowser.mvp.models.PrintADI;
import com.npkompleet.phenomenon.bowser.mvp.models.PrintPTN;
import com.npkompleet.phenomenon.bowser.mvp.models.Query;
import com.npkompleet.phenomenon.bowser.mvp.models.Template;
import com.npkompleet.phenomenon.bowser.mvp.models.User;
import com.npkompleet.phenomenon.bowser.mvp.models.UserQuery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by PHENOMENON on 2/11/2018.
 */

public interface MyApiEndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    String BASE_URL= "http://197.210.12.72:8080/fait_test/mobileApi/";


    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<User>> loginUser(@Body UserQuery userQuery);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<Asset>> getAssets(@Body Query query);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<Location>> getLocations(@Body Query query);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<Customer>> getCustomers(@Body Query query);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<PrintADI>> getADIForms(@Body ADIQuery query);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<PrintPTN>> getPTNForms(@Body ADIQuery query);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<Template> getTemplate(@Body Query query);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<String>> insertADI(@Body InsertUpdateQuery insertQuery);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<String>> insertPTN(@Body InsertUpdateQuery insertQuery);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<String>> insertLMF(@Body InsertUpdateQuery insertQuery);

    @POST("http://197.210.12.72:8080/fait_test/mobileApi/")
    Call<List<User>> getUserList(@Body MainAccess access);
}
