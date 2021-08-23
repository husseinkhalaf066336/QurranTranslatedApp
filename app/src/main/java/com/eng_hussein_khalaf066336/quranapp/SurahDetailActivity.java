package com.eng_hussein_khalaf066336.quranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eng_hussein_khalaf066336.quranapp.ViewModel.SurahDetailViewModel;
import com.eng_hussein_khalaf066336.quranapp.adapter.SurahDetailAdapter;
import com.eng_hussein_khalaf066336.quranapp.common.common;
import com.eng_hussein_khalaf066336.quranapp.model.SurahDetail;
import com.eng_hussein_khalaf066336.quranapp.response.SurahDetailResponse;

import java.util.ArrayList;
import java.util.List;

public class SurahDetailActivity extends AppCompatActivity implements DialogSettingsFragment.onClickListener {
    TextView surah_name,surah_translation,surah_type;
    int no;
    RecyclerView recyclerView;
    List <SurahDetail> list;
    SurahDetailAdapter adapter;
    SurahDetailViewModel surahDetailViewModel;

    Button button_setting;
    DialogSettingsFragment dialogSettingsFragment;
    Toolbar toolbar;

    private String lan;
    //private String hind="hindi_omari";
   // private String urdu="urdu_junagarhi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);

        surah_name=findViewById(R.id.surah_name);
        surah_translation=findViewById(R.id.surah_translation);
        surah_type=findViewById(R.id.surah_type);
        recyclerView= findViewById(R.id.surah_detail_rv);
      toolbar=findViewById(R.id.toolbar_home);

       setSupportActionBar(toolbar);

        no= getIntent().getIntExtra(common.SURAH_NO,0);

        surah_name.setText(getIntent().getStringExtra(common.SURAH_NAME));

        surah_translation.setText(getIntent().getStringExtra(common.SURAH_TRANSLATION));

        surah_type.setText(getIntent().getStringExtra(common.SURAH_TYPE)+
                ""+ getIntent().getIntExtra(common.SURAH_TOTAL_AYA,0)+"aya");

        recyclerView.setHasFixedSize(true);
        list=new ArrayList<>();
       SurahTranslation("english_hilali_khan",no);




    }
    public void SurahTranslation (String lan , int id )
    {
        if (list.size()>0)
        {
            list.clear();
        }

        surahDetailViewModel = new ViewModelProvider(this).get(SurahDetailViewModel.class);

        surahDetailViewModel.getSurahDetail(lan,id).observe(this, new Observer<SurahDetailResponse>() {
            @Override
            public void onChanged(SurahDetailResponse surahDetailResponse) {
                for (int  i = 0 ; i<surahDetailResponse.getList().size();i++)
                {
                    list.add(new SurahDetail(surahDetailResponse.getList().get(i).getId()
                            ,surahDetailResponse.getList().get(i).getSura()
                            ,surahDetailResponse.getList().get(i).getAya()
                            ,String.valueOf(surahDetailResponse.getList().get(i).getArabic_text())
                            ,String.valueOf(surahDetailResponse.getList().get(i).getTranslation())
                            ,String.valueOf(surahDetailResponse.getList().get(i).getFootnotes())
                    ));

                    if (list.size() != 0)
                    {
                        adapter=new SurahDetailAdapter(SurahDetailActivity.this,list);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                    if (list.size() ==0)
                    {
                        return;
                    }
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_surah_details,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_surah).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return true;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.setting_surah)
        {
            dialogSettingsFragment = DialogSettingsFragment.newInstance();
            dialogSettingsFragment.show(getSupportFragmentManager(),null);

        }
        return super.onOptionsItemSelected(item);


    }
    private void filter(String s) {
        ArrayList <SurahDetail> arrayList= new ArrayList<>();
        for (SurahDetail detail:list) {
            if (String.valueOf(detail.getId()).contains(s)
            || detail.getArabic_text().contains(s)
            || detail.getTranslation().contains(s))
            {
                arrayList.add(detail);
            }
            adapter.filter(arrayList);

        }

    }

    @Override
    public void onButtonSaveSettings(String s) {
        lan=s;
        SurahTranslation(lan,no);
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();

    }
}
