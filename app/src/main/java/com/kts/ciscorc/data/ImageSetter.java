package com.kts.ciscorc.data;

import com.kts.ciscorc.R;

public class ImageSetter{

    public static int adviceImage(String description){
        switch (description){
//            case ("Cisco Webex Room Kit"): return R.drawable.room_kit;
//            case ("Cisco Webex Room Kit Mini"): return R.drawable.room_kit_mini;
//            case ("Cisco Webex Codec Plus"): return R.drawable.room_kit_plus;

            case  "Cisco Webex Board 55": return R.drawable.webex_board_55;
            case  "Cisco Webex Board 55S": return R.drawable.webex_board_55;
            case  "Cisco Webex Board 70": return R.drawable.webex_board_55;
            case  "Cisco Webex Board 70S": return R.drawable.webex_board_55;
            case  "Cisco Webex Board 85S": return R.drawable.webex_board_55;
            case  "Cisco Webex Codec Plus": return R.drawable.room_kit_plus;
            case  "Cisco Webex Codec Pro": return R.drawable.codec_pro;
            case  "Cisco TelePresence DX70": return R.drawable.dx70;
            case  "Cisco Webex DX80": return R.drawable.dx80;
            case  "Cisco TelePresence MX200 G2": return R.drawable.mx200g2;
            case  "Cisco TelePresence MX300 G2": return R.drawable.mx300g2;
            case  "Cisco TelePresence MX700": return R.drawable.mx700;
            case  "Cisco TelePresence MX700 SpeakerTrack": return R.drawable.mx700spktrck;
            case  "Cisco TelePresence MX800": return R.drawable.mx800;
            case  "Cisco TelePresence MX800 SpeakerTrack": return R.drawable.mx800spktrck;
            case  "Cisco TelePresence MX800 Dual": return R.drawable.mx800dual;
            case  "Cisco Webex Room Kit": return R.drawable.room_kit;
            case  "Cisco Webex Room Kit Mini": return R.drawable.room_kit_mini;
            case  "Cisco Webex Room 55": return R.drawable.room55;
            case  "Cisco Webex Room 55 Dual": return R.drawable.room55dual;
            case  "Cisco Webex Room 70 Dual": return R.drawable.room70dual;
            case  "Cisco Webex Room 70 Dual G2": return R.drawable.room70dual;
            case  "Cisco Webex Room 70 Single": return R.drawable.room70;
            case  "Cisco Webex Room 70 Single G2": return R.drawable.room70;
            case  "Cisco TelePresence SX10": return R.drawable.sx10;
            case  "Cisco TelePresence SX20": return R.drawable.sx20;
            case  "Cisco TelePresence SX80": return R.drawable.sx80;


            default: return R.drawable.codec_pro;
        }
    }

}

