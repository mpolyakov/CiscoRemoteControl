package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.kts.ciscorc.data.ConnectionClass;
import com.kts.ciscorc.data.model.phonebook.Contact;
import com.kts.ciscorc.data.model.phonebook.PhonebookRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;

import java.util.ArrayList;

public class PhonebookActivity extends AppCompatActivity {
    TextView textView;
    String resultXml;
    private ArrayList<String> mPhonebNames = new ArrayList<>();
    private ArrayList<String> mPhonebNumbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);
        final MainPresenter presenter = MainPresenter.getInstance();

        //Инициализация меню
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Устанавливаем отмеченный пункт меню
        bottomNavigationView.setSelectedItemId(R.id.phonebook);

        //Обработчик ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.phonebook:
                        return true;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.dial:
                        startActivity(new Intent(getApplicationContext(), DialActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                }
                return false;
            }
        });

        final Handler handler = new Handler();
        new Thread(new Runnable() {

            @Override
            public void run() {
                String body = getString(R.string.bodyPhonebook);
                resultXml = ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                JSONObject json = null; // converts xml to json
                try {
                    json = XML.toJSONObject(resultXml);
                    final String jsonPrettyPrintString = json.toString(4); // json pretty print
                    Gson gson = new Gson();
                    final PhonebookRequest phonebookRequest = gson.fromJson(jsonPrettyPrintString, PhonebookRequest.class);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            fillPhonebook(phonebookRequest);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void fillPhonebook(PhonebookRequest phonebookRequest) {
        for (Contact note : phonebookRequest.getCommand().getPhonebookSearchResult().getContact()) {
            mPhonebNames.add(Jsoup.parse(note.getName()).text());
            mPhonebNumbers.add(note.getContactMethod().getNumber());
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.phonebook_recyclerview);
        RecyclerViewAdapterPhonebook adapterPhonebook = new RecyclerViewAdapterPhonebook(this, mPhonebNames, mPhonebNumbers);
        recyclerView.setAdapter(adapterPhonebook);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
