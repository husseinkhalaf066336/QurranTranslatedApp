package com.eng_hussein_khalaf066336.quranapp.NetWork;

import com.eng_hussein_khalaf066336.quranapp.response.SurahDetailResponse;
import com.eng_hussein_khalaf066336.quranapp.response.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    @GET ("surah")
    Call <SurahResponse> getSurah ();

    @GET("sura/{language}/{id}")
    Call <SurahDetailResponse> getSurahDetail (@Path("language") String lan
    ,@Path("id")int surahId);
}
