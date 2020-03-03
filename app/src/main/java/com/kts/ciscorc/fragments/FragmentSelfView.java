package com.kts.ciscorc.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.kts.ciscorc.MainPresenter;
import com.kts.ciscorc.R;
import com.kts.ciscorc.data.ConnectionClass;

public class FragmentSelfView extends Fragment {
    private ToggleButton toggleButtonSV1, toggleButtonSV2, toggleButtonSV3, toggleButtonSV4, toggleButtonSV5, toggleButtonSV6, toggleButtonSV7, toggleButtonSV8, toggleButtonSV9;
    final MainPresenter presenter = MainPresenter.getInstance();
    private MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mp = MediaPlayer.create(getContext(), R.raw.clickb5);
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

        toggleButtonSV1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV1.isChecked()){
                    setSelfView("UpperLeft");
                    setTButtons(toggleButtonSV1);
                } else {
                    toggleButtonSV1.setChecked(false);
                    removeSelfView();
                }

            }
        });

        toggleButtonSV2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV2.isChecked()){
                    setSelfView("UpperCenter");
                    setTButtons(toggleButtonSV2);
                } else {
                    toggleButtonSV2.setChecked(false);
                    removeSelfView();
                }
            }
        });

        toggleButtonSV3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV3.isChecked()){
                    setSelfView("UpperRight");
                    setTButtons(toggleButtonSV3);
                } else {
                    toggleButtonSV3.setChecked(false);
                    removeSelfView();
                }
            }
        });

        toggleButtonSV4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV4.isChecked()){
                    setSelfView("CenterLeft");
                    setTButtons(toggleButtonSV4);
                } else {
                    toggleButtonSV4.setChecked(false);
                    removeSelfView();
                }
            }
        });

        toggleButtonSV5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV5.isChecked()){
                    setSelfViewFullscreen();
                    setTButtons(toggleButtonSV5);
                } else {
                    toggleButtonSV5.setChecked(false);
                    removeSelfView();
                }
            }
        });

        toggleButtonSV6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV6.isChecked()){
                    setSelfView("CenterRight");
                    setTButtons(toggleButtonSV6);
                } else {
                    toggleButtonSV6.setChecked(false);
                    removeSelfView();
                }
            }
        });

        toggleButtonSV7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV7.isChecked()){
                    setSelfView("LowerLeft");
                    setTButtons(toggleButtonSV7);
                } else {
                    toggleButtonSV7.setChecked(false);
                    removeSelfView();
                }
            }
        });

        toggleButtonSV8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        toggleButtonSV9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                if (toggleButtonSV9.isChecked()){
                    setSelfView("LowerRight");
                    setTButtons(toggleButtonSV9);
                } else {
                    toggleButtonSV9.setChecked(false);
                    removeSelfView();
                }
            }
        });

        return v;
    }

    private void removeSelfView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.removeSelfView);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();

    }

    private void setSelfView(final String position) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.setSelfViewPart1) + position + getString(R.string.setSelfViewPart2);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();

    }

    private void setSelfViewFullscreen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.setSelfViewFullscreen);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();

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
