package com.eng_hussein_khalaf066336.quranapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eng_hussein_khalaf066336.quranapp.Listener.SurahListener;
import com.eng_hussein_khalaf066336.quranapp.ViewModel.SurahViewModel;
import com.eng_hussein_khalaf066336.quranapp.adapter.SurahAdapter;
import com.eng_hussein_khalaf066336.quranapp.common.common;
import com.eng_hussein_khalaf066336.quranapp.model.Surah;
import com.eng_hussein_khalaf066336.quranapp.response.SurahResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    SurahAdapter surahAdapter;
    List<Surah> list;
    SurahViewModel surahViewModel;
    SurahListener surahListener;
    private Object SurahResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        if (getSupportActionBar() !=null)
        {
            getSupportActionBar().hide();
        }
        recyclerView=findViewById(R.id.surha_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        surahViewModel = new ViewModelProvider(this).get(SurahViewModel.class);

        surahViewModel.getSurah().observe(this, new Observer<SurahResponse>() {
            @Override
            public void onChanged(com.eng_hussein_khalaf066336.quranapp.response.SurahResponse surahResponse) {

                for (int i  = 0 ; i<surahResponse.getList().size();i++)
                {
                    list.add(new Surah(surahResponse.getList().get(i).getNumber()
                            ,String.valueOf(surahResponse.getList().get(i).getName())
                            ,String.valueOf(surahResponse.getList().get(i).getEnglishName())
                            ,String.valueOf(surahResponse.getList().get(i).getEnglishNameTranslation())
                            ,surahResponse.getList().get(i).getNumberOfAyahs()
                            ,String.valueOf(surahResponse.getList().get(i).getRevelationType())
                    ));
                    if (list.size() ==0)
                    {
                        return;
                    }

                        if (list.size() !=0)
                    {
                        surahAdapter=new SurahAdapter(getBaseContext(), list, new SurahListener() {
                            @Override
                            public void onSurahListener(int position) {
                                Intent intent = new Intent(MainActivity.this,SurahDetailActivity.class);
                                intent.putExtra(common.SURAH_NO,list.get(position).getNumber());
                                intent.putExtra(common.SURAH_NAME,list.get(position).getName());
                                intent.putExtra(common.SURAH_TOTAL_AYA,list.get(position).getNumberOfAyahs());
                                intent.putExtra(common.SURAH_TYPE,list.get(position).getRevelationType());
                                intent.putExtra(common.SURAH_TRANSLATION,list.get(position).getEnglishNameTranslation());
                                startActivity(intent);

                            }
                        });
                        recyclerView.setAdapter(surahAdapter);
                        surahAdapter.notifyDataSetChanged();
                    }

                }
            }});
    }

}
