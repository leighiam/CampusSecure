import java.io.*;

public class Visitor implements Serializable
{
    private long entrydate;
    private Name name;
    private String enttime;
    private String exittime;
    private String purpose;

    public Visitor(String fname, String lname, long entdate, String entime, String purp)
    {
        this.name = new Name(fname, lname);
        this.entrydate = entdate;
        this.enttime = entime; 
        this.purpose = purp;
    }

    public String getName()
    {
        return this.name.getFullName();
    }

    public long getEntryDate()
    {
        return this.entrydate;
    }

    public String getEntryTime()
    {
        return this.enttime;
    }

    public void setExitTime(String time)
    {
        this.exittime = time;
    }

    public String getExitTime()
    {
        return this.exittime;
    }

    public String getPurpose()
    {
        return this.purpose;
    }

    public String toString(int record)
    {
        String newrecord = ""+record+"";
        return newrecord;
    }

    public String toString(long record)
    {
        String newrec = ""+record+"";
        String newrecord = newrec.substring(0,4) + "-" + newrec.substring(4,6) + "-" + newrec.substring(6);
        return newrecord;
    }
}