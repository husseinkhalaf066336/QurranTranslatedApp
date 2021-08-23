package com.eng_hussein_khalaf066336.quranapp.NetWork;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
  public static   Retrofit Instance;


    public static Retrofit getRetrofit() {
        if (Instance==null)
        {
            Instance=new Retrofit.Builder().baseUrl("http://api.alquran.cloud/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return Instance;
    }

    public static Retrofit getInstance ()
    {
        if (Instance != null)
        {
            Instance=null;
        }
        Instance = new Retrofit.Builder().baseUrl("https://quranenc.com/api/translation/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Instance;
    }
}
