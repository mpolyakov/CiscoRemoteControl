package com.kts.ciscorc.data;

import com.kts.ciscorc.R;

public class ImageSetter{

    public static int adviceImage(String description){
        switch (description){
            case ("Cisco Webex Room Kit"): return R.drawable.room_kit;
            case ("Cisco Webex Room Kit Mini"): return R.drawable.room_kit_mini;
            case ("Cisco Webex Codec Plus"): return R.drawable.room_kit_plus;
//            case ("Snow"): return R.drawable.snow192;
//            case ("Fog"): return R.drawable.icons8_fog_100;
            default: return R.drawable.room_kit;
        }
    }

}

