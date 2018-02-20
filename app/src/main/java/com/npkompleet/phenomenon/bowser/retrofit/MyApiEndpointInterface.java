package com.npkompleet.phenomenon.bowser.retrofit;

import com.npkompleet.phenomenon.bowser.mvp.models.Session;
import com.npkompleet.phenomenon.bowser.mvp.models.User;
import com.npkompleet.phenomenon.bowser.mvp.models.UserAccess;
import com.npkompleet.phenomenon.bowser.mvp.models.UserList;
import com.npkompleet.phenomenon.bowser.mvp.models.UserListAccess;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by PHENOMENON on 2/11/2018.
 */

public interface MyApiEndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    String BASE_URL= "https://virtualloto.com/mobileApi/";

    /*@GET("users/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("users/new")
    Call<User> createUser(@Body User user);
    */

    @POST("https://virtualloto.com/mobileApi")
    Call<User> loginUser(@Body UserAccess access);

    @POST("https://virtualloto.com/mobileApi")
    Call<UserList> getUserList(@Body UserListAccess access);
}
