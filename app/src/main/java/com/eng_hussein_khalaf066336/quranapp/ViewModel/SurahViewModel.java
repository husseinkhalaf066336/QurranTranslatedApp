package com.eng_hussein_khalaf066336.quranapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.eng_hussein_khalaf066336.quranapp.repostory.SurahRepo;
import com.eng_hussein_khalaf066336.quranapp.response.SurahResponse;

public class SurahViewModel  extends ViewModel {
    SurahRepo surahRepo;

    public SurahViewModel() {
        surahRepo=new SurahRepo();
    }
  public   LiveData  <SurahResponse> getSurah()
    {
        return surahRepo.getSurah();
    }
}
