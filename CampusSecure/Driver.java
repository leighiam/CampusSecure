import java.io.*;

public class Driver extends Visitor implements Serializable
{
    private Vehicle vehicle;
    private static int entries = 0;
    private int entryNo;
    
    public Driver(String fname, String lname, long date, String entime, String purp, String lnum, String col, String mk, String mod)
    {
        super(fname, lname, date, entime, purp);
        this.vehicle = new Vehicle(lnum, col, mk, mod);
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

    public String getLicenseNum()
    {
        return vehicle.getLicenseNum();
    }

    public String getColor()
    {
        return vehicle.getColor();
    }

    public String getMake()
    {
        return vehicle.getMake();
    }

    public String getModel()
    {
        return vehicle.getModel();
    }

    public String toString()
    {
        String[] names = getName().split(" ");
        String rec1 = "\nEntry#: " + super.toString(getEntryNo()) + "\tEntryDate: " + super.toString(getEntryDate()) + "\tFirstname: " +  names[0] + "\tLastname: " + names[1] + "\tPurpose: " + getPurpose() + "\tLicense#: " + getLicenseNum() + "\tCar-color: " + getColor(); 
        String rec2 = "\tCar-Make: " + getMake() + "\tModel: " + getModel() + "\tEntryTime: " + getEntryTime() + "\tExitTime: " + getExitTime();
        String record = rec1 + rec2;
        return record;
    }

    
}