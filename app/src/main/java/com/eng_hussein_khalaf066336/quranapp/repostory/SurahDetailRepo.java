package com.eng_hussein_khalaf066336.quranapp.repostory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eng_hussein_khalaf066336.quranapp.NetWork.Api;
import com.eng_hussein_khalaf066336.quranapp.NetWork.JsonPlaceHolderApi;
import com.eng_hussein_khalaf066336.quranapp.response.SurahDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahDetailRepo {
    JsonPlaceHolderApi jsonPlaceHolderApi;
    public SurahDetailRepo ()
    {
        jsonPlaceHolderApi= Api.getInstance().create(JsonPlaceHolderApi.class);
    }
    public LiveData <SurahDetailResponse> getSurahDetail (String lan , int id)
    {
        final MutableLiveData <SurahDetailResponse> data = new MutableLiveData<>();

        jsonPlaceHolderApi.getSurahDetail(lan,id).enqueue(new Callback<SurahDetailResponse>() {
            @Override
            public void onResponse(Call<SurahDetailResponse> call, Response<SurahDetailResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SurahDetailResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
