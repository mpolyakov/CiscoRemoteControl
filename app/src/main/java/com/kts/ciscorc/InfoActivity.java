package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.kts.ciscorc.data.ConnectionClass;
import com.kts.ciscorc.data.model.status.StatusRequest;

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

    String resultXml;
    final MainPresenter presenter = MainPresenter.getInstance();


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
                switch (menuItem.getItemId()) {
                    case R.id.phonebook:
                        startActivity(new Intent(getApplicationContext(), PhonebookActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                        return true;
                    case R.id.info:
                        return true;
                    case R.id.dial:
                        startActivity(new Intent(getApplicationContext(), DialActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                        return true;
                }
                return false;
            }
        });

        textName = findViewById(R.id.textViewName);
        textStatus = findViewById(R.id.textViewStatus);
        textNumber = findViewById(R.id.textViewNumber);
        textIPaddress = findViewById(R.id.textViewIPaddress);
        textPlatformID = findViewById(R.id.textViewPlatformId);
        textSN = findViewById(R.id.textViewSN);
        textSoftware = findViewById(R.id.textViewSoftware);
        textEncryption = findViewById(R.id.textViewEncryption);
        textMultisite = findViewById(R.id.textViewMultisite);
        textRemoteMon = findViewById(R.id.textViewRemoteMon);

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                resultXml = ConnectionClass.methodGET(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), getString(R.string.getstatus));
                try {
                    JSONObject json = XML.toJSONObject(resultXml); // converts xml to json
                    final String jsonPrettyPrintString = json.toString(4); // json pretty print
                    Gson gsonStatus = new Gson();
                    final StatusRequest statusRequest = gsonStatus.fromJson(jsonPrettyPrintString, StatusRequest.class);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            displayInfo(statusRequest);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void displayInfo(StatusRequest statusRequest) {
        presenter.setCodecPlatform(statusRequest.getStatus().getSystemUnit().getProductId());
        if (statusRequest.getStatus().getSystemUnit().getState().getNumberOfActiveCalls().equals("0")) {
            textStatus.setText("Out of call");
        } else textStatus.setText("In a call");
        textPlatformID.setText(statusRequest.getStatus().getSystemUnit().getProductId());
        textSN.setText(statusRequest.getStatus().getSystemUnit().getHardware().getModule().getSerialNumber());
        textSoftware.setText(statusRequest.getStatus().getSystemUnit().getSoftware().getDisplayName());
        textEncryption.setText(statusRequest.getStatus().getSystemUnit().getSoftware().getOptionKeys().getEncryption());
        textMultisite.setText(statusRequest.getStatus().getSystemUnit().getSoftware().getOptionKeys().getMultiSite());
        textRemoteMon.setText(statusRequest.getStatus().getSystemUnit().getSoftware().getOptionKeys().getRemoteMonitoring());

        textName.setText(statusRequest.getStatus().getUserInterface().getContactInfo().getName());
        textNumber.setText(statusRequest.getStatus().getUserInterface().getContactInfo().getContactMethod().get(0).getNumber());

        textIPaddress.setText(statusRequest.getStatus().getNetwork().getIPv4().getAddress());




    }
}
