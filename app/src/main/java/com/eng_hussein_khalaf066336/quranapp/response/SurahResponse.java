package com.eng_hussein_khalaf066336.quranapp.response;

import com.eng_hussein_khalaf066336.quranapp.model.Surah;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurahResponse {
    @SerializedName("data")
    List <Surah> list;


    public List<Surah> getList() {
        return list;
    }

    public void setList(List<Surah> list) {
        this.list = list;
    }
}
