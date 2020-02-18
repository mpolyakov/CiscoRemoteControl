package com.kts.ciscorc.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.kts.ciscorc.MainPresenter;
import com.kts.ciscorc.R;

public class FragmentDial extends Fragment {
    EditText dialNum;
    Spinner spinnerCallType, spinnerBandwidth;
    final MainPresenter presenter = MainPresenter.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout  = inflater.inflate(R.layout.fragment_dial, container, false);

        dialNum = layout.findViewById(R.id.editTextDialNumber);
        dialNum.setText(presenter.getDialNumber());

        spinnerCallType = layout.findViewById(R.id.spinner1);
        spinnerBandwidth = layout.findViewById(R.id.spinner2);

        presenter.setDialNumber(null);

        return layout;
    }


}
