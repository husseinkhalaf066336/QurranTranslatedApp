package com.eng_hussein_khalaf066336.quranapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eng_hussein_khalaf066336.quranapp.R;
import com.eng_hussein_khalaf066336.quranapp.model.SurahDetail;
import com.eng_hussein_khalaf066336.quranapp.response.SurahDetailResponse;
import com.eng_hussein_khalaf066336.quranapp.response.SurahResponse;

import java.util.ArrayList;
import java.util.List;

public class SurahDetailAdapter extends RecyclerView.Adapter <SurahDetailAdapter.ViewHolder> {
    Context context;
    List  <SurahDetail> list;

    public SurahDetailAdapter(Context context, List<SurahDetail> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.surah_detail_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SurahDetail surahDetail= list.get(position);
        holder.aya_no.setText(String.valueOf(surahDetail.getAya()));
        holder.arabic_text.setText(surahDetail.getArabic_text());
        holder.translate.setText(surahDetail.getTranslation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void filter (ArrayList <SurahDetail> details)
    {
        list=details;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView aya_no , arabic_text,translate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            aya_no = itemView.findViewById(R.id.aya_no);
            arabic_text = itemView.findViewById(R.id.arabic_text);
            translate = itemView.findViewById(R.id.translation);
        }
    }
}
