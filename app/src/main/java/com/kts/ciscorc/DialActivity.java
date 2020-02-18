package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.kts.ciscorc.data.ConnectionClass;
import com.kts.ciscorc.data.model.phonebook.PhonebookRequest;
import com.kts.ciscorc.fragments.DtmfDialogFragment;
import com.kts.ciscorc.fragments.FragmentCameraControl;
import com.kts.ciscorc.fragments.FragmentDial;
import com.kts.ciscorc.fragments.FragmentSelfView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class DialActivity extends AppCompatActivity {
    FragmentDial fragmentDial;
    FragmentSelfView fragmentSelfView;
    FragmentCameraControl fragmentCameraControl;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ToggleButton toggleButtonDial, toggleButtonSelfView, toggleButtonCamera;
    MaterialButton volDecrease, volIncrease;
    EditText dialNum;
    Spinner spinnerCallType, spinnerBandwidth;
    String selectedCallType, selectedBandwidht;
    String resultXml;
    final Handler handler = new Handler();
    final MainPresenter presenter = MainPresenter.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        init();

        //Инициализация меню
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Устанавливаем отмеченный пункт меню
        bottomNavigationView.setSelectedItemId(R.id.dial);

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
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                        return true;
                    case R.id.dial:
                        return true;
                }
                return false;
            }
        });
    }


    public void changeFragment1(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentDial);
        fragmentTransaction.commit();
        toggleButtonSelfView.setChecked(false);
        toggleButtonCamera.setChecked(false);
        toggleButtonDial.setChecked(true);
    }

    public void changeFragment2(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentSelfView);
        fragmentTransaction.commit();
        toggleButtonDial.setChecked(false);
        toggleButtonCamera.setChecked(false);
        toggleButtonSelfView.setChecked(true);
    }

    public void changeFragment3(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentCameraControl);
        fragmentTransaction.commit();
        toggleButtonDial.setChecked(false);
        toggleButtonSelfView.setChecked(false);
        toggleButtonCamera.setChecked(true);
    }


    public void acceptDial(View view) {
        selectedCallType = spinnerCallType.getSelectedItem().toString();
        selectedBandwidht = spinnerCallType.getSelectedItem().toString();
        final String[] arr = selectedBandwidht.split(" ");

        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.dialPart1)
                        + dialNum.getText().toString()
                        + getString(R.string.dialPart2)
                        + selectedCallType
                        + getString(R.string.dialPart3)
                        + arr[0] + getString(R.string.dialPart4);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }

    public void rejectDisconnect(View view) {
    }

    public void init() {
        fragmentDial = new FragmentDial();
        fragmentSelfView = new FragmentSelfView();
        fragmentCameraControl = new FragmentCameraControl();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentDial);
        fragmentTransaction.commit();
        toggleButtonDial = findViewById(R.id.toggleDial);
        toggleButtonSelfView = findViewById(R.id.toggleSelfView);
        toggleButtonCamera = findViewById(R.id.toggleCameraControl);
        toggleButtonDial.setChecked(true);
        spinnerCallType = findViewById(R.id.spinner1);
        spinnerBandwidth = findViewById(R.id.spinner2);
        volDecrease = findViewById(R.id.btnVolumeDown);
        volIncrease = findViewById(R.id.btnVolumeUP);


        dialNum = findViewById(R.id.editTextDialNumber);

        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.appbar_gradient));
        }

    }

    public void requestDTMF(View view) {
        FragmentManager manager = getSupportFragmentManager();
        DtmfDialogFragment dtmfDialogFragment = new DtmfDialogFragment();
        dtmfDialogFragment.show(manager, "DTMF Dialog");
    }

    public void volumeIncrease(View view) {
        volIncrease.setEnabled(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.volumeIncrease);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volIncrease.setEnabled(true);
    }

    public void volumeDecrease(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.volumeDecrease);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }

    public void volumeToggleMute(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.volumeToggleMute);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }

    public void micOn(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.micOn);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }

    public void micOff(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.micOff);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }

    public void startShare(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.startShare);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }

    public void stopShare(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.stopShare);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }


//    private void getIncomingIntent(){
//        if (getIntent().hasExtra("address_of_remote_endpoint")){
//            String receivedNumer = getIntent().getStringExtra("address_of_remote_endpoint");
//            dialNum.setText(receivedNumer);
//        }
//    }
}
