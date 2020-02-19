package com.kts.ciscorc.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.kts.ciscorc.MainPresenter;
import com.kts.ciscorc.R;
import com.kts.ciscorc.data.ConnectionClass;

public class DtmfDialogFragment extends DialogFragment {
    final MainPresenter presenter = MainPresenter.getInstance();
    private EditText dtmf;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_dtmf, null);

        dtmf = v.findViewById(R.id.editTextDTMF);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(v)
                .setTitle("Enter DTMF")
                // Add action buttons
                .setPositiveButton(R.string.senddtmf, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // senddtmf ...
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String body = getString(R.string.dtmfStringPart1) + dtmf.getText().toString() + getString(R.string.dtmfStringPart2) ;
                                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                            }
                        }).start();

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DtmfDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }


}
