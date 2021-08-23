package com.eng_hussein_khalaf066336.quranapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.DialogFragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Locale;


public class DialogSettingsFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match

   // private static final String ARG_option_checked = "OPTION_CHECKED";

    RadioGroup  radioGroup;
    RadioButton radioButton_english,radioButton_hindi,radioButton_Urdu,radioButton_french,
                radioButton_spanish,radioButton_turkish, radioButton_indonesian,radioButton_german,
                radioButton_chinese ,radioButton_albanian,radioButton_persian;

    private String selected_language;

    onClickListener onClickListener;

    // TODO: Rename and change types of parameters
    private String option;

    public DialogSettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onClickListener)
        {
            onClickListener= (DialogSettingsFragment.onClickListener) context;
        }
        else new RuntimeException("Please implement listener : onClickListener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onClickListener=null;
    }

    // TODO: Rename and change types and number of parameters
    public static DialogSettingsFragment newInstance() {

        DialogSettingsFragment fragment = new DialogSettingsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          View view=  inflater.inflate(R.layout.fragment_dailog_settings, container, false);
          return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);


        radioButton_english.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if (isChecked);
              selected_language="english_hilali_khan";

              onClickListener.onButtonSaveSettings(selected_language);
              dismiss();

          }
      });
        radioButton_hindi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="hindi_omari";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_Urdu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="urdu_junagarhi";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_french.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="french_montada";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_spanish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="spanish_montada_eu";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_turkish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="turkish_rwwad";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_indonesian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="indonesian_affairs";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_german.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="german_bubenheim";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_chinese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="chinese_makin";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_albanian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="albanian_nahi";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });
        radioButton_persian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked);
                selected_language="persian_ih";

                onClickListener.onButtonSaveSettings(selected_language);
                dismiss();

            }
        });

    }

    private void init(View view) {

        radioGroup= view.findViewById(R.id.translation1);
        radioButton_english= view.findViewById(R.id.fragment_dialog_rb_english);
        radioButton_hindi= view.findViewById(R.id.fragment_dialog_rb_hindi);
        radioButton_Urdu= view.findViewById(R.id.fragment_dialog_rb_Urdu);
        radioButton_french= view.findViewById(R.id.fragment_dialog_rb_french);
        radioButton_spanish= view.findViewById(R.id.fragment_dialog_rb_spanish);
        radioButton_turkish= view.findViewById(R.id.fragment_dialog_rb_turkish);
        radioButton_indonesian= view.findViewById(R.id.fragment_dialog_rb_indonesian);
        radioButton_german= view.findViewById(R.id.fragment_dialog_rb_german);
        radioButton_chinese= view.findViewById(R.id.fragment_dialog_rb_chinese);
        radioButton_albanian= view.findViewById(R.id.fragment_dialog_rb_albanian);
        radioButton_persian= view.findViewById(R.id.fragment_dialog_rb_persian);
    }

    @SuppressWarnings("deprecation")
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        Configuration conf = getResources().getConfiguration();
        conf.locale = myLocale;
        getResources().updateConfiguration(conf, dm);

        DialogSettingsFragment dialogSettingsFragment = DialogSettingsFragment.newInstance();
        dialogSettingsFragment.show(getFragmentManager(),null);
        dismiss();


       // Intent intent = new Intent(getBaseContext(),LoginActivity.class);
       // startActivity(intent);
       // finish();
    }

    public interface onClickListener
    {
        void onButtonSaveSettings(String  s );
    }
}
