package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kts.ciscorc.data.ConnectionClass;

public class PhonebookActivity extends AppCompatActivity {
    TextView textView;
    String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);

        //Инициализация меню
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Устанавливаем отмеченный пункт меню
        bottomNavigationView.setSelectedItemId(R.id.phonebook);

        //Обработчик ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.phonebook:
                        return true;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dial:
                        startActivity(new Intent(getApplicationContext(), DialActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        textView = findViewById(R.id.textViewPhonebook);

        final Handler handler = new Handler();
        new Thread(new Runnable() {

            @Override
            public void run() {
                resultText = ConnectionClass.getPhonebook(MainActivity.ipAddress, MainActivity.login, MainActivity.password);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(resultText);
                    }
                });
            }
        }).start();


    }
}
