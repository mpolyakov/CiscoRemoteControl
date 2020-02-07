package com.kts.ciscorc.data.model.systemunit;

public class OptionKeys
{
    private String MultiSite;

    private String RemoteMonitoring;

    private String Encryption;

    public String getMultiSite ()
    {
        return MultiSite;
    }

    public void setMultiSite (String MultiSite)
    {
        this.MultiSite = MultiSite;
    }

    public String getRemoteMonitoring ()
    {
        return RemoteMonitoring;
    }

    public void setRemoteMonitoring (String RemoteMonitoring)
    {
        this.RemoteMonitoring = RemoteMonitoring;
    }

    public String getEncryption ()
    {
        return Encryption;
    }

    public void setEncryption (String Encryption)
    {
        this.Encryption = Encryption;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [MultiSite = "+MultiSite+", RemoteMonitoring = "+RemoteMonitoring+", Encryption = "+Encryption+"]";
    }
}