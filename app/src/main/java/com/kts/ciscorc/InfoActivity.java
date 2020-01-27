package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kts.ciscorc.data.ConnectionClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Collectors;

public class InfoActivity extends AppCompatActivity {
    TextView textView;
    String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Инициализация меню
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Устанавливаем отмеченный пункт меню
        bottomNavigationView.setSelectedItemId(R.id.info);

        //Обработчик ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.phonebook:
                        startActivity(new Intent(getApplicationContext(), PhonebookActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.info:
                        return true;
                    case R.id.dial:
                        startActivity(new Intent(getApplicationContext(), DialActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        textView = findViewById(R.id.textViewInfo);

        final Handler handler = new Handler();
        new Thread(new Runnable() {

            @Override
            public void run() {
                resultText = ConnectionClass.getSystemInfo(MainActivity.ipAddress, MainActivity.login, MainActivity.password);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(resultText);
                    }
                });
            }
        }).start();





//        try {
//            final URL uri = new URL("http://10.65.26.10/getxml?location=/Status/SystemUnit");
//            final Handler handler = new Handler();
//
//            new Thread(new Runnable() {
//                @RequiresApi(api = Build.VERSION_CODES.O)
//                @Override
//                public void run() {
//                    try {
//                        HttpURLConnection urlConnection;
//                        urlConnection = (HttpURLConnection) uri.openConnection();
//
//                        String encoded = Base64.getEncoder().encodeToString(("operator:password").getBytes(StandardCharsets.UTF_8));  //Java 8
//                        urlConnection.setRequestProperty("Authorization", "Basic "+encoded);
//                        urlConnection.setRequestMethod("GET");
//                        urlConnection.setConnectTimeout(10000);
//                        urlConnection.connect();
//
//                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                        final String result = in.lines().collect(Collectors.joining("\n"));
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setText(result);
//                                Log.d("auth", result); //Смотрим, что получаем в качестве результата result
//                            }
//                        });
//                    } catch (ProtocolException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

    }
}
