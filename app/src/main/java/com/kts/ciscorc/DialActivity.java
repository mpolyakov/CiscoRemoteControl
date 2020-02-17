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
import com.kts.ciscorc.fragments.DtmfDialogFragment;
import com.kts.ciscorc.fragments.FragmentDial;
import com.kts.ciscorc.fragments.FragmentSelfView;

public class DialActivity extends AppCompatActivity {
    FragmentDial fragmentDial;
    FragmentSelfView fragmentSelfView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ToggleButton toggleButtonDial;
    ToggleButton toggleButtonSelfView;
    ToggleButton toggleButtonSV1, toggleButtonSV2, toggleButtonSV3, toggleButtonSV4, toggleButtonSV5, toggleButtonSV6, toggleButtonSV7, toggleButtonSV8, toggleButtonSV9;
    EditText dialNum;
    Spinner spinnerCallType, spinnerBandwidth;
    String selectedCallType,selectedBandwidht;

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
        toggleButtonDial.setChecked(true);
    }

    public void changeFragment2(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentSelfView);
        fragmentTransaction.commit();
        toggleButtonDial.setChecked(false);
        toggleButtonSelfView.setChecked(true);

    }


    public void acceptDial(View view) {
        selectedCallType = spinnerCallType.getSelectedItem().toString();
        selectedBandwidht = spinnerCallType.getSelectedItem().toString();

    }

    public void rejectDisconnect(View view) {
    }

    public void init(){
        fragmentDial = new FragmentDial();
        fragmentSelfView = new FragmentSelfView();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentDial);
        fragmentTransaction.commit();
        toggleButtonDial = findViewById(R.id.toggleDial);
        toggleButtonSelfView = findViewById(R.id.toggleSelfView);
        toggleButtonDial.setChecked(true);
        spinnerCallType = findViewById(R.id.spinner1);
        spinnerBandwidth = findViewById(R.id.spinner2);


        dialNum = findViewById(R.id.editTextDialNumber);

        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.appbar_gradient));
        }

    }

    public void requestDTMF(View view) {
        FragmentManager manager = getSupportFragmentManager();
        DtmfDialogFragment dtmfDialogFragment = new DtmfDialogFragment();
        dtmfDialogFragment.show(manager, "DTMF Dialog");
    }




//    private void getIncomingIntent(){
//        if (getIntent().hasExtra("address_of_remote_endpoint")){
//            String receivedNumer = getIntent().getStringExtra("address_of_remote_endpoint");
//            dialNum.setText(receivedNumer);
//        }
//    }
}
