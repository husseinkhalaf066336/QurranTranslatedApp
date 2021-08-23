package com.eng_hussein_khalaf066336.quranapp.response;

import com.eng_hussein_khalaf066336.quranapp.model.SurahDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurahDetailResponse {
    @SerializedName("result")
    private List <SurahDetail> list;

    public List<SurahDetail> getList() {
        return list;
    }

    public void setList(List<SurahDetail> list) {
        this.list = list;
    }
}
