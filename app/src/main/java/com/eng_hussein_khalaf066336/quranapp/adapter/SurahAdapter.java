package com.eng_hussein_khalaf066336.quranapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eng_hussein_khalaf066336.quranapp.Listener.SurahListener;
import com.eng_hussein_khalaf066336.quranapp.R;
import com.eng_hussein_khalaf066336.quranapp.model.Surah;

import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter <SurahAdapter.ViewHolder> {
   private Context context;
   private List <Surah> list;
   private SurahListener surahListener;

    public SurahAdapter(Context context, List<Surah> list , SurahListener surahListener) {
        this.context = context;
        this.list = list;
        this.surahListener=surahListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.surah_layout,parent,false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.surah_number.setText(String.valueOf(list.get(position).getNumber()));
        holder.surah_arabicName.setText(list.get(position).getName());
        holder.surah_englishName.setText(list.get(position).getEnglishName());
        holder.surah_totalAya.setText("Aya : " +list.get(position).getNumberOfAyahs());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView surah_number,surah_arabicName,surah_englishName,surah_totalAya;
        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            surah_number=itemView.findViewById(R.id.shrah_number);
            surah_arabicName=itemView.findViewById(R.id.arabic_name);
            surah_englishName=itemView.findViewById(R.id.english_name);
            surah_totalAya=itemView.findViewById(R.id.totalAya);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surahListener.onSurahListener(getAdapterPosition());
                }
            });

        }
    }
}
