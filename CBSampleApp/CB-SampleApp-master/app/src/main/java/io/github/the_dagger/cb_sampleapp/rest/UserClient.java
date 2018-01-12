package io.github.the_dagger.cb_sampleapp.rest;

import io.github.the_dagger.cb_sampleapp.model.UserList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Karan on 04-02-2017.
 */

public interface UserClient {

    @GET("search/users?q=karan")
    Call<UserList> getUserList();
}
