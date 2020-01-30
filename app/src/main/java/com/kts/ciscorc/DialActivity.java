package com.kts.ciscorc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kts.ciscorc.fragments.FragmentDial;
import com.kts.ciscorc.fragments.FragmentSelfView;

public class DialActivity extends AppCompatActivity {
    FragmentDial fragmentDial;
    FragmentSelfView fragmentSelfView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);


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
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.dial:
                        return true;
                }
                return false;
            }
        });

        fragmentDial = new FragmentDial();
        fragmentSelfView = new FragmentSelfView();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentDial);
        fragmentTransaction.commit();

    }

    public void changeFragment1(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentDial);
        fragmentTransaction.commit();
    }

    public void changeFragment2(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragmentSelfView);
        fragmentTransaction.commit();
    }
}
