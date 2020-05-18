import java.io.*;

public class DormVisitor extends Visitor implements Serializable
{
    private static int entries = 0;
    private int entryNo;
    private long visitorIDNum;
    private Name visiteeName;
    private long visiteeIDNum;

    public DormVisitor(String fname, String lname, long date, String entime, String purp, long vtorID, String vteefname, String vteelname, long vteeID)
    {
        super(fname, lname, date, entime, purp);
        this.visitorIDNum = vtorID;
        this.visiteeName = new Name(vteefname, vteelname);
        this.visiteeIDNum = vteeID;
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

    public long getVisitorID()
    {
        return this.visitorIDNum;
    }

    public String getVisiteeName()
    {
        return this.visiteeName.getFullName();
    }

    public long getVisiteeID()
    {
        return this.visiteeIDNum;
    }

    public String toString()
    {
        String[] names = getName().split(" ");
        String[] names2 = getVisiteeName().split(" ");
        String rec1 = "\nEntry#: " + super.toString(getEntryNo()) + "\tEntryDate: " + super.toString(getEntryDate()) + "\tFirstname: " +  names[0] + "\tLastname: " + names[1] + "\tPurpose: " + getPurpose(); 
        String rec2 = "\tVisitor ID#: " + getVisitorID() + "Visitee Firstname: " + names2[0] + "Visitee Lastname: " + names2[1] + "\tVisitee ID#: " + getVisiteeID() + "\tEntryTime: " + getEntryTime() + "\tExitTime: " + getExitTime();
        String record = rec1 + rec2;
        return record;
    }
}