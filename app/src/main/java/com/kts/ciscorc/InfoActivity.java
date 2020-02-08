package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.kts.ciscorc.data.ConnectionClass;
import com.kts.ciscorc.data.model.systemunit.SystemUnitRequest;

import org.json.XML;
import org.json.*;


public class InfoActivity extends AppCompatActivity {
    TextView textName;
    TextView textStatus;
    TextView textNumber;
    TextView textIPaddress;
    TextView textPlatformID;
    TextView textSN;
    TextView textSoftware;
    TextView textEncryption;
    TextView textMultisite;
    TextView textRemoteMon;

    String resultText, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final MainPresenter presenter = MainPresenter.getInstance();

        //Инициализация меню
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Устанавливаем отмеченный пункт меню
        bottomNavigationView.setSelectedItemId(R.id.info);

        //Обработчик ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.phonebook:
                        startActivity(new Intent(getApplicationContext(), PhonebookActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.info:
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

        textName = findViewById(R.id.textView1);
//        textStatus = findViewById(R.id.textViewStatus);
//        textNumber = findViewById(R.id.textViewNumber);
//        textIPaddress = findViewById(R.id.textViewIPaddress);
//        textPlatformID = findViewById(R.id.textViewPlatformId);
//        textSN = findViewById(R.id.textViewSN);
//        textSoftware = findViewById(R.id.textViewSoftware);
//        textEncryption = findViewById(R.id.textViewEncryption);
//        textMultisite = findViewById(R.id.textViewMultisite);
//        textRemoteMon = findViewById(R.id.textViewRemoteMon);

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                resultText = ConnectionClass.methodGET(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), "/getxml?location=/Status/SystemUnit");
                try {
                    JSONObject json = XML.toJSONObject(resultText); // converts xml to json
                    final String jsonPrettyPrintString = json.toString(4); // json pretty print

                    Gson gson = new Gson();
                    final SystemUnitRequest systemUnitRequest = gson.fromJson(jsonPrettyPrintString, SystemUnitRequest.class);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
//                        displayInfo(systemUnitRequest);
                            textName.setText(systemUnitRequest.getStatus().getSystemUnit().getProductId());
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

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

    private void displayInfo(SystemUnitRequest systemUnitRequest) {
        textName.setText(systemUnitRequest.getStatus().getSystemUnit().getProductId());
//        textSN.setText(systemUnitRequest.getStatus().getSystemUnit().getHardware().getModule().getSerialNumber());

    }
}
