package com.example.lenovo.thescient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rettrofitclient {
    private static final String BASE_URL = "https://scient.nitt.edu";
    private static Rettrofitclient mInstance;
    private Retrofit retrofit;
    private Rettrofitclient(){
        
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized Rettrofitclient getInstance(){
        if(mInstance==null)
        {
            mInstance=new Rettrofitclient();
        }
        return mInstance;
    }
    public Api getApi()
    {
        return retrofit.create(Api.class);
    }
}
