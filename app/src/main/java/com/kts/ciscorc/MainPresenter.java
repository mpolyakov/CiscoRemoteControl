package com.kts.ciscorc;

public final class MainPresenter {
    public static MainPresenter instance = null;
    private String ipAddress;
    private String login;
    private String password;
    private String codecPlatform;
    private String dialNumber;

    public static MainPresenter getInstance() {
        if (instance == null){
            instance = new MainPresenter();
        }
        return instance;
    }


    public String getDialNumber() {
        return dialNumber;
    }

    public void setDialNumber(String dialNumber) {
        this.dialNumber = dialNumber;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodecPlatform() {
        return codecPlatform;
    }

    public void setCodecPlatform(String codecPlatform) {
        this.codecPlatform = codecPlatform;
    }

}
