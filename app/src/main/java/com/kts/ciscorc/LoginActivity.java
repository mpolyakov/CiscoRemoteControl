package com.kts.ciscorc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.kts.ciscorc.data.ConnectionClass;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText mIpAddr;
    TextInputEditText mLogin;
    TextInputEditText mPassword;
    MaterialButton mButtonConnect;
    TextView mTextView;
    String connectionResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();

//        final ConnectionClass connectionClass = new ConnectionClass();

        mButtonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.ipAddress = mIpAddr.getText().toString();
                MainActivity.login = mLogin.getText().toString();
                MainActivity.password = mPassword.getText().toString();

                Intent intent = new Intent(LoginActivity.this, InfoActivity.class);
                startActivity(intent);

//                final Handler handler = new Handler();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ConnectionClass.disableSslVerification();
//                        final String response = ConnectionClass.connect(MainActivity.ipAddress, MainActivity.login, MainActivity.password);
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                mTextView.setText(response);
//                                if (response.equals("OK")){
//                                    //Intent
//                                    Intent intent = new Intent(LoginActivity.this, InfoActivity.class);
//                                    startActivity(intent);
////                    finish();
//                                }
//
//                            }
//                        });
//                    }
//                }).start();


            }
        });
    }

    private void initUI() {
        mIpAddr = findViewById(R.id.textInputIP);
        mLogin = findViewById(R.id.textInputLogin);
        mPassword = findViewById(R.id.textInputPassword);
        mButtonConnect = findViewById(R.id.material_button);
        mTextView = findViewById(R.id.textViewConnStatus);
    }


}
