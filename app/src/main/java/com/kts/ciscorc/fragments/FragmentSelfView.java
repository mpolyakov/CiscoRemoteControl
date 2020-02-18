package com.kts.ciscorc.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.kts.ciscorc.R;

public class FragmentSelfView extends Fragment {
    private ToggleButton toggleButtonSV1, toggleButtonSV2, toggleButtonSV3, toggleButtonSV4, toggleButtonSV5, toggleButtonSV6, toggleButtonSV7, toggleButtonSV8, toggleButtonSV9;
    private TextView textViewtest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_self_view, container, false);

        toggleButtonSV1 = v.findViewById(R.id.toggleSV1);
        toggleButtonSV2 = v.findViewById(R.id.toggleSV2);
        toggleButtonSV3 = v.findViewById(R.id.toggleSV3);
        toggleButtonSV4 = v.findViewById(R.id.toggleSV4);
        toggleButtonSV5 = v.findViewById(R.id.toggleSV5);
        toggleButtonSV6 = v.findViewById(R.id.toggleSV6);
        toggleButtonSV7 = v.findViewById(R.id.toggleSV7);
        toggleButtonSV8 = v.findViewById(R.id.toggleSV8);
        toggleButtonSV9 = v.findViewById(R.id.toggleSV9);
        textViewtest = v.findViewById(R.id.textViewtest);

        toggleButtonSV1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV1.isChecked()){
                    setSelfView("UpperLeft");
                    setTButtons(toggleButtonSV1);
                    textViewtest.setText("UpperLeft");
                } else {
                    toggleButtonSV1.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None1");
                }

            }
        });

        toggleButtonSV2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV2.isChecked()){
                    setSelfView("UpperCenter");
                    setTButtons(toggleButtonSV2);
                    textViewtest.setText("UpperCenter");
                } else {
                    toggleButtonSV2.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None2");
                }
            }
        });

        toggleButtonSV3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV3.isChecked()){
                    setSelfView("UpperRight");
                    setTButtons(toggleButtonSV3);
                    textViewtest.setText("UpperRight");
                } else {
                    toggleButtonSV3.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None3");
                }
            }
        });

        toggleButtonSV4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV4.isChecked()){
                    setSelfView("CenterLeft");
                    setTButtons(toggleButtonSV4);
                    textViewtest.setText("CenterLeft");
                } else {
                    toggleButtonSV4.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None4");
                }
            }
        });

        toggleButtonSV5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV5.isChecked()){
                    setFullScreenSelfView();
                    setTButtons(toggleButtonSV5);
                    textViewtest.setText("FullscreenMode:");
                } else {
                    toggleButtonSV5.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None5");
                }
            }
        });

        toggleButtonSV6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV6.isChecked()){
                    setSelfView("CenterRight");
                    setTButtons(toggleButtonSV6);
                    textViewtest.setText("CenterRight");
                } else {
                    toggleButtonSV6.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None6");
                }
            }
        });

        toggleButtonSV7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV7.isChecked()){
                    setSelfView("LowerLeft");
                    setTButtons(toggleButtonSV7);
                    textViewtest.setText("LowerLeft");
                } else {
                    toggleButtonSV7.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None7");
                }
            }
        });

        toggleButtonSV8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        toggleButtonSV9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleButtonSV9.isChecked()){
                    setSelfView("LowerRight");
                    setTButtons(toggleButtonSV9);
                    textViewtest.setText("LowerRight");
                } else {
                    toggleButtonSV9.setChecked(false);
                    removeSelfView();
                    textViewtest.setText("None9");
                }
            }
        });

        return v;
    }

    private void setFullScreenSelfView() {

    }

    private void removeSelfView() {

    }

    private void setSelfView(String position) {

    }

    private void setTButtons(ToggleButton tb){
        toggleButtonSV1.setChecked(false);
        toggleButtonSV2.setChecked(false);
        toggleButtonSV3.setChecked(false);
        toggleButtonSV4.setChecked(false);
        toggleButtonSV5.setChecked(false);
        toggleButtonSV6.setChecked(false);
        toggleButtonSV7.setChecked(false);
        toggleButtonSV9.setChecked(false);
        tb.setChecked(true);
    }

}
