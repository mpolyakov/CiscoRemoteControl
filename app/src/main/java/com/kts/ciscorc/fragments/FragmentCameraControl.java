package com.kts.ciscorc.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.kts.ciscorc.MainPresenter;
import com.kts.ciscorc.R;
import com.kts.ciscorc.data.ConnectionClass;

public class FragmentCameraControl extends Fragment {
    ImageButton imageButtonCamUp, imageButtonCamLeft, imageButtonCamRight, imageButtonCamDown;
    Switch aSwitch;
    final MainPresenter presenter = MainPresenter.getInstance();
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_camera_control, container, false);

        imageButtonCamUp = v.findViewById(R.id.imageButton2);
        imageButtonCamLeft = v.findViewById(R.id.imageButton4);
        imageButtonCamRight = v.findViewById(R.id.imageButton6);
        imageButtonCamDown = v.findViewById(R.id.imageButton8);

        aSwitch = v.findViewById(R.id.switchSpeakerTrack);
        textView = v.findViewById(R.id.textViewtestwdwd);

        if ((presenter.getCodecPlatform().equals("Cisco Webex Room Kit"))
                ||(presenter.getCodecPlatform().equals("Cisco Webex Room Kit Mini"))
                ||(presenter.getCodecPlatform().equals("Cisco Webex Codec Plus"))
                ||(presenter.getCodecPlatform().equals("Cisco Webex Room 55"))){
            aSwitch.setEnabled(true);
            imageButtonCamUp.setEnabled(false);
            imageButtonCamLeft.setEnabled(false);
            imageButtonCamRight.setEnabled(false);
            imageButtonCamDown.setEnabled(false);
        } else{
            aSwitch.setEnabled(false);
            imageButtonCamUp.setEnabled(true);
            imageButtonCamLeft.setEnabled(true);
            imageButtonCamRight.setEnabled(true);
            imageButtonCamDown.setEnabled(true);
        }


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if (isChecked){
                    switchOnSpeakerTrack();
                    textView.setText("ST on");
                    aSwitch.setTextOn("SpeakerTrack mode");
                    imageButtonCamUp.setEnabled(false);
                    imageButtonCamLeft.setEnabled(false);
                    imageButtonCamRight.setEnabled(false);
                    imageButtonCamDown.setEnabled(false);
                } else{
                    switchOffSpeakerTrack();
                    textView.setText("ST off");
                    aSwitch.setTextOff("Manual mode");
                    imageButtonCamUp.setEnabled(true);
                    imageButtonCamLeft.setEnabled(true);
                    imageButtonCamRight.setEnabled(true);
                    imageButtonCamDown.setEnabled(true);
                }
            }
        });

        imageButtonCamUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText("Up");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraTiltUp);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraTiltStop);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();


            }
        });

        imageButtonCamLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText("Left");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraPanLeft);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraPanStop);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();
            }
        });

        imageButtonCamRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText("Right");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraPanRight);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraPanStop);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();
            }

        });

        imageButtonCamDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText("Down");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraTiltDown);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraTiltStop);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

            }
        });


        return v;
    }



    private void switchOffSpeakerTrack() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.speakerTrackDeactivate);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();
    }

    private void switchOnSpeakerTrack() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.speakerTrackModeAuto);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.speakerTrackActivate);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();

    }


}
