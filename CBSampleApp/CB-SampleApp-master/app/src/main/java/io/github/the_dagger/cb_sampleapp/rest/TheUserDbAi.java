package io.github.the_dagger.cb_sampleapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Karan on 04-02-2017.
 */

public class TheUserDbAi {
    public UserClient getUserClient() {
        String BASE_URL = "https://api.github.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(UserClient.class);
    }
}
