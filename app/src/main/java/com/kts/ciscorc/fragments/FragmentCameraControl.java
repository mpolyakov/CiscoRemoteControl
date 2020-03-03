package com.kts.ciscorc.fragments;

import android.media.MediaPlayer;
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
    private ImageButton imageButtonCamUp, imageButtonCamLeft, imageButtonCamRight, imageButtonCamDown, imageButtonZoomIn, imageButtonZoomOut;
    private Switch aSwitch;
    final MainPresenter presenter = MainPresenter.getInstance();
    private MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_camera_control, container, false);

        mp = MediaPlayer.create(getContext(), R.raw.clickb5);

        imageButtonCamUp = v.findViewById(R.id.imageButton2);
        imageButtonCamLeft = v.findViewById(R.id.imageButton4);
        imageButtonCamRight = v.findViewById(R.id.imageButton6);
        imageButtonCamDown = v.findViewById(R.id.imageButton8);
        imageButtonZoomIn = v.findViewById(R.id.imageButton3);
        imageButtonZoomOut = v.findViewById(R.id.imageButton9);

        aSwitch = v.findViewById(R.id.switchSpeakerTrack);

        if ((ConnectionClass.allCodecsWithSpeakerTrack.contains(presenter.getCodecPlatform()))){
            aSwitch.setEnabled(true);
            aSwitch.setChecked(true);
            imageButtonCamUp.setEnabled(false);
            imageButtonCamLeft.setEnabled(false);
            imageButtonCamRight.setEnabled(false);
            imageButtonCamDown.setEnabled(false);
            imageButtonZoomIn.setEnabled(false);
            imageButtonZoomOut.setEnabled(false);
        } else{
            aSwitch.setEnabled(false);
            aSwitch.setChecked(false);
            imageButtonCamUp.setEnabled(true);
            imageButtonCamLeft.setEnabled(true);
            imageButtonCamRight.setEnabled(true);
            imageButtonCamDown.setEnabled(true);
            imageButtonZoomIn.setEnabled(true);
            imageButtonZoomOut.setEnabled(true);
        }


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    switchOnSpeakerTrack();
//                    aSwitch.setTextOn("SpeakerTrack mode");
                    imageButtonCamUp.setEnabled(false);
                    imageButtonCamLeft.setEnabled(false);
                    imageButtonCamRight.setEnabled(false);
                    imageButtonCamDown.setEnabled(false);
                    imageButtonZoomIn.setEnabled(false);
                    imageButtonZoomOut.setEnabled(false);

                } else{
                    switchOffSpeakerTrack();
//                    aSwitch.setTextOff("Manual mode");
                    imageButtonCamUp.setEnabled(true);
                    imageButtonCamLeft.setEnabled(true);
                    imageButtonCamRight.setEnabled(true);
                    imageButtonCamDown.setEnabled(true);
                    imageButtonZoomIn.setEnabled(true);
                    imageButtonZoomOut.setEnabled(true);

                }
            }
        });

        imageButtonCamUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                imageButtonCamUp.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraTiltUp);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(250);
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

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                imageButtonCamUp.setEnabled(true);
            }
        });

        imageButtonCamLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                imageButtonCamLeft.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraPanLeft);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(250);
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

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                imageButtonCamLeft.setEnabled(true);
            }
        });

        imageButtonCamRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                imageButtonCamRight.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraPanRight);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(250);
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

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                imageButtonCamRight.setEnabled(true);
            }

        });

        imageButtonCamDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                imageButtonCamDown.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraTiltDown);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(250);
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

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                imageButtonCamDown.setEnabled(true);
            }
        });

        imageButtonZoomIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                imageButtonZoomIn.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraZoomIn);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraZoomStop);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                imageButtonZoomIn.setEnabled(true);
            }
        });

        imageButtonZoomOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                imageButtonZoomOut.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraZoomOut);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String body = getString(R.string.cameraZoomStop);
                        ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
                    }
                }).start();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                imageButtonZoomOut.setEnabled(true);
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

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                String body = getString(R.string.speakerTrackActivate);
                ConnectionClass.methodPOST(presenter.getIpAddress(), presenter.getLogin(), presenter.getPassword(), body);
            }
        }).start();

    }


}
