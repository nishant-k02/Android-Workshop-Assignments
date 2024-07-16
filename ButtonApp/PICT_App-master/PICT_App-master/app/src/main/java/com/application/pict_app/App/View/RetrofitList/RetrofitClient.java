package com.application.pict_app.App.View.RetrofitList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private Api myApi;
    private Retrofit retrofit;

    private RetrofitClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
        myApi =retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public Api getMyApi() {
        return myApi;
    }
}
