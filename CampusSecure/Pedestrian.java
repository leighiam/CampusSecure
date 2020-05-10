import java.io.*;

public class Pedestrian extends Visitor implements Serializable
{
    private static int entries = 0;
    private int entryNo;

    public Pedestrian(String fname, String lname, long date, String entime, String purp)
    {
        super(fname, lname, date, entime, purp);
        entries++;
        this.entryNo = entries;
    }

    public int getEntryNo()
	{
        return this.entryNo;
    }

    public String getName()
    {
        return super.getName();
    }

    public long getEntryDate()
    {
        return super.getEntryDate();
    }

    public String getEntryTime()
    {
        return super.getEntryTime();
    }

    public void setExitTime(String time)
    {
        super.setExitTime(time);
    }

    public String getExitTime()
    {
        return super.getExitTime();
    }

    public String getPurpose()
    {
        return super.getPurpose();
    }

    public String toString()
    {
        String[] names = getName().split(" ");
        String record = "\nEntry#: " + super.toString(getEntryNo()) + "\tEntryDate: " + super.toString(getEntryDate()) + "\tFirstname: " +  names[0] + "\tLastname: " + names[1] + "\tPurpose: " + getPurpose() + "\tEntryTime: " + getEntryTime() + "\tExitTime: " + getExitTime();
        return record;
    }
}