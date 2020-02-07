package com.kts.ciscorc.data.model.systemunit;

public class Software
{
    private OptionKeys OptionKeys;

    private String Version;

    private String DisplayName;

    private String ReleaseDate;

    private String Name;

    public OptionKeys getOptionKeys ()
    {
        return OptionKeys;
    }

    public void setOptionKeys (OptionKeys OptionKeys)
    {
        this.OptionKeys = OptionKeys;
    }

    public String getVersion ()
    {
        return Version;
    }

    public void setVersion (String Version)
    {
        this.Version = Version;
    }

    public String getDisplayName ()
    {
        return DisplayName;
    }

    public void setDisplayName (String DisplayName)
    {
        this.DisplayName = DisplayName;
    }

    public String getReleaseDate ()
    {
        return ReleaseDate;
    }

    public void setReleaseDate (String ReleaseDate)
    {
        this.ReleaseDate = ReleaseDate;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [OptionKeys = "+OptionKeys+", Version = "+Version+", DisplayName = "+DisplayName+", ReleaseDate = "+ReleaseDate+", Name = "+Name+"]";
    }
}