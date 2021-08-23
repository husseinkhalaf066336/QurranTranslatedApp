package com.eng_hussein_khalaf066336.quranapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.eng_hussein_khalaf066336.quranapp.repostory.SurahDetailRepo;
import com.eng_hussein_khalaf066336.quranapp.response.SurahDetailResponse;

public class SurahDetailViewModel extends ViewModel {
    SurahDetailRepo surahDetailRepo;

    public SurahDetailViewModel() {
        surahDetailRepo=new SurahDetailRepo();
    }
    public LiveData <SurahDetailResponse>  getSurahDetail (String lan , int id)
    {
        return surahDetailRepo.getSurahDetail(lan,id);
    }
}
