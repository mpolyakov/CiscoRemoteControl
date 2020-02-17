package com.kts.ciscorc.data.model;

public class ChooseImage {
    private String platformImage;

    public static String getPlatformImage(String platformId) {

        switch (platformId){
            case  "Cisco Webex Board 55": return "Cisco Webex Board 55";
            case  "Cisco Webex Board 55S": return "Cisco Webex Board 55S";
            case  "Cisco Webex Board 70": return "Cisco Webex Board 70";
            case  "Cisco Webex Board 70S": return "Cisco Webex Board 70S";
            case  "Cisco Webex Board 85S": return "Cisco Webex Board 85S";
            case  "Cisco Webex Codec Plus": return "Cisco Webex Codec Plus";
            case  "Cisco Webex Codec Pro": return "Cisco Webex Codec Pro";
            case  "Cisco TelePresence DX70": return "Cisco TelePresence DX70";
            case  "Cisco Webex DX80": return "Cisco Webex DX80";
            case  "Cisco TelePresence MX200 G2": return "Cisco TelePresence MX200 G2";
            case  "Cisco TelePresence MX300 G2": return "Cisco TelePresence MX300 G2";
            case  "Cisco TelePresence MX700": return "Cisco TelePresence MX700";
            case  "Cisco TelePresence MX700 SpeakerTrack": return "Cisco TelePresence MX700 SpeakerTrack";
            case  "Cisco TelePresence MX800": return "Cisco TelePresence MX800";
            case  "Cisco TelePresence MX800 SpeakerTrack": return "Cisco TelePresence MX800 SpeakerTrack";
            case  "Cisco TelePresence MX800 Dual": return "Cisco TelePresence MX800 Dual";
            case  "Cisco Webex Room Kit": return "Cisco Webex Room Kit";
            case  "Cisco Webex Room Kit Mini": return "Cisco Webex Room Kit Mini";
            case  "Cisco Webex Room 55": return "Cisco Webex Room 55";
            case  "Cisco Webex Room 55 Dual": return "Cisco Webex Room 55 Dual";
            case  "Cisco Webex Room 70 Dual": return "Cisco Webex Room 70 Dual";
            case  "Cisco Webex Room 70 Dual G2": return "Cisco Webex Room 70 Dual G2";
            case  "Cisco Webex Room 70 Single": return "Cisco Webex Room 70 Single";
            case  "Cisco Webex Room 70 Single G2": return "Cisco Webex Room 70 Single G2";
            case  "Cisco TelePresence SX10": return "Cisco TelePresence SX10";
            case  "Cisco TelePresence SX20": return "Cisco TelePresence SX20";
            case  "Cisco TelePresence SX80": return "Cisco TelePresence SX80";
        }

        return "defaultImage";
    }
}
