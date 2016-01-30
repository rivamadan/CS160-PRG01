package com.example.riva.translationapp;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class Translate extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        final Spinner from_lang_spinner = (Spinner) findViewById(R.id.from_lang);
        final Spinner to_lang_spinner = (Spinner) findViewById(R.id.to_lang);

        int spinnerLayout;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spinnerLayout = R.layout.spinner_layout_land;
        } else {
            spinnerLayout =  R.layout.spinner_layout;
        }

        ArrayAdapter<CharSequence> lang_adapter = ArrayAdapter.createFromResource(this,
                R.array.language_choices, spinnerLayout);
        lang_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_lang_spinner.setAdapter(lang_adapter);
        to_lang_spinner.setAdapter(lang_adapter);

        final Spinner from_phrase_spinner = (Spinner) findViewById(R.id.from_phrase);
        final Spinner to_phrase_spinner = (Spinner) findViewById(R.id.to_phrase);

        to_lang_spinner.setSelection(1);

        from_lang_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String from_lang = (String) parent.getItemAtPosition(position);
                int phrase_position = to_phrase_spinner.getSelectedItemPosition();
                changeLang(from_lang, from_phrase_spinner, phrase_position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        to_lang_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String to_lang = parent.getSelectedItem().toString();
                int phrase_position = from_phrase_spinner.getSelectedItemPosition();
                changeLang(to_lang, to_phrase_spinner, phrase_position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        from_phrase_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to_phrase_spinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        to_phrase_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from_phrase_spinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void changeLang(String lang, Spinner spinner, int phrase_position){
        int spinnerLayout;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spinnerLayout = R.layout.spinner_layout_land;
        } else {
            spinnerLayout =  R.layout.spinner_layout;
        }

        switch(lang)
        {
            case "English":
                ArrayAdapter<CharSequence> english_adapter = ArrayAdapter.createFromResource(this,
                        R.array.english_phrases, spinnerLayout);
                english_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(english_adapter);

                break;

            case "Spanish":
                ArrayAdapter<CharSequence> spanish_adapter = ArrayAdapter.createFromResource(this,
                        R.array.spanish_phrases,spinnerLayout);
                spanish_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spanish_adapter);

                break;

            case "Mandarin":
                ArrayAdapter<CharSequence> chinese_adapter = ArrayAdapter.createFromResource(this,
                        R.array.chinese_phrases, spinnerLayout);
                chinese_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(chinese_adapter);

                break;
        }
        spinner.setSelection(phrase_position);
    }

    private void changeFromPhase() {}
}
