package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.kts.ciscorc.data.ConnectionClass;
import com.kts.ciscorc.data.model.status.StatusRequest;
import com.kts.ciscorc.dbase.NoteAdapter;
import com.kts.ciscorc.dbase.NoteDataReader;
import com.kts.ciscorc.dbase.NoteDataSource;

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

    private NoteDataSource notesDataSource;
    private NoteDataReader noteDataReader;
    private NoteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.appbar_gradient));
        }

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


        initDataSource();

        textName = findViewById(R.id.textViewName);
        textStatus = findViewById(R.id.textViewStatus);
//        textNumber = findViewById(R.id.textViewNumber);
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
                            addElement(statusRequest);

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void displayInfo(StatusRequest statusRequest) {

        String ipAddress = null;
        try {
            ipAddress = statusRequest.getStatus().getNetwork().getIPv4().getAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textIPaddress.setText(ipAddress);

        String platformID = null;
        try {
            platformID = statusRequest.getStatus().getSystemUnit().getProductId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textPlatformID.setText(platformID);
        presenter.setCodecPlatform(platformID);

        String softwareName = null;
        try {
            softwareName = statusRequest.getStatus().getSystemUnit().getSoftware().getDisplayName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textSoftware.setText(softwareName);

        String numActiveCalls = null;
        try {
            numActiveCalls = statusRequest.getStatus().getSystemUnit().getState().getNumberOfActiveCalls();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (numActiveCalls.equals("0")) {
            textStatus.setText("Out of call");
        } else textStatus.setText("In a call");

        String sn = null;
        try {
            sn = statusRequest.getStatus().getSystemUnit().getHardware().getModule().getSerialNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textSN.setText(sn);

        String encrypt = null;
        try {
            encrypt = statusRequest.getStatus().getSystemUnit().getSoftware().getOptionKeys().getEncryption();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textEncryption.setText(encrypt);

        String multisite = null;
        try {
            multisite = statusRequest.getStatus().getSystemUnit().getSoftware().getOptionKeys().getMultiSite();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textMultisite.setText(multisite);

        String remMon = null;
        try {
            remMon = statusRequest.getStatus().getSystemUnit().getSoftware().getOptionKeys().getRemoteMonitoring();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textRemoteMon.setText(remMon);

        String name = null;
        try {
            name = statusRequest.getStatus().getUserInterface().getContactInfo().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textName.setText(name);

//        String number = null;
//        try {
//            number = statusRequest.getStatus().getUserInterface().getContactInfo().getContactMethod().getNumber();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        textNumber.setText(number);


    }

    private void addElement(StatusRequest request) {
        notesDataSource.addNote(request.getStatus().getUserInterface().getContactInfo().getName(), presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), request.getStatus().getSystemUnit().getProductId());
        dataUpdated();
    }

    private void dataUpdated() {
        noteDataReader.Refresh();
    }

    private void initDataSource() {
        notesDataSource = new NoteDataSource(getApplicationContext());
        notesDataSource.open();
        noteDataReader = notesDataSource.getNoteDataReader();
    }


}
