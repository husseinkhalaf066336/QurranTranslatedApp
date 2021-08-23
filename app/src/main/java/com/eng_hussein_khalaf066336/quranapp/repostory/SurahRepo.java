package com.eng_hussein_khalaf066336.quranapp.repostory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eng_hussein_khalaf066336.quranapp.NetWork.Api;
import com.eng_hussein_khalaf066336.quranapp.NetWork.JsonPlaceHolderApi;
import com.eng_hussein_khalaf066336.quranapp.response.SurahResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahRepo {
    JsonPlaceHolderApi jsonPlaceHolderApi;

    public SurahRepo() {
        jsonPlaceHolderApi=Api.getRetrofit().create(JsonPlaceHolderApi.class);
    }

    public LiveData <SurahResponse> getSurah ()
    {
        final MutableLiveData <SurahResponse> data=new MutableLiveData<>();
        jsonPlaceHolderApi.getSurah().enqueue(new Callback<SurahResponse>() {
            @Override
            public void onResponse(Call<SurahResponse> call, Response<SurahResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SurahResponse> call, Throwable t) {
                data.setValue(null);

            }
        });
        return data;
    }
}
