import java.io.*;

public class Name implements Serializable
{
    private String fname;
    private String lname;
    
    public Name(String f_name, String l_name)
    {
        this.fname = f_name;
        this.lname = l_name;
    }

    public void setFName(String name)
    {
        this.fname = name;
    }
    
    public String getFName()
    {
        return this.fname;
    }

    public void setLName(String name)
    {
        this.lname = name;
    }

    public String getLName()
    {
        return this.lname;
    }

    public String getFullName()
    {
        return this.fname + " " + this.lname;
    }
}