package com.example.riva.translationapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public class Translate extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        final Spinner from_lang_spinner = (Spinner) findViewById(R.id.from_lang);
        final Spinner to_lang_spinner = (Spinner) findViewById(R.id.to_lang);
        final Spinner from_phrase_spinner = (Spinner) findViewById(R.id.from_phrase);
        final Spinner to_phrase_spinner = (Spinner) findViewById(R.id.to_phrase);

        from_lang_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("hi");
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
        switch(lang)
        {
            case "English":
                ArrayList<String> english_phrases = new ArrayList<String>();
                english_phrases.add("hello");
                english_phrases.add("how much?");
                english_phrases.add("please");
                english_phrases.add("thank you");
                english_phrases.add("goodbye");

                ArrayAdapter<String> english=new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line,english_phrases);
                spinner.setAdapter(english);

                break;

            case "Spanish":
                ArrayList<String> spanish_phrases = new ArrayList<String>();
                spanish_phrases.add("hola");
                spanish_phrases.add("cuánto?");
                spanish_phrases.add("por favor");
                spanish_phrases.add("gracias");
                spanish_phrases.add("adiós");


                ArrayAdapter<String> spanish=new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line,spanish_phrases);
                spinner.setAdapter(spanish);

                break;

            case "Mandarin":
                ArrayList<String> chinese_phrases = new ArrayList<String>();
                chinese_phrases.add("??");
                chinese_phrases.add("???");
                chinese_phrases.add("?");
                chinese_phrases.add("??");
                chinese_phrases.add("??");

                ArrayAdapter<String> chinese=new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line,chinese_phrases);
                spinner.setAdapter(chinese);

                break;
        }
        spinner.setSelection(phrase_position);
    }

    private void changeFromPhase() {}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_translate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
