import java.util.*;
import java.io.*;

public class SchoolMember implements Serializable
{
    private Name name;
    private ArrayList<Vehicle> vehicleList;
    private MemberType type;
    private long regDate;
    
    public SchoolMember(String fname, String lname, String type, long date, String lnum, String col, String mk, String mod)
    {
        this.name = new Name(fname, lname);
        this.type = MemberType.valueOf(type.toUpperCase());
        this.regDate = date;
        vehicleList.add(new Vehicle(lnum, col, mk, mod));

    }
    
    public String getName()
    {
        return name.getFullName();
    }

    public MemberType getType()
    {
        return this.type();
    }

    public long getRegistryDate()
    {
        return this.date;
    }

    public void addVehicle(String lnum, String col, String mk, String mod)
    {
        vehicleList.add(new Vehicle(lnum, col, mk, mod));
    }

    public ArrayList<Vehicle> getVehicleList()
    {
        return this.vehicleList();
    }

    public String getVehicles()
    {
        for(Vehicle vehicle: vehicleList)
        {
            return vehicle.toString();
        }
    }

    public String toString(long record)
    {
        String newrecord = ""+record+"";
        return newrecord;
    }

    public String toString()
    {
        String[] names = getName().split(" ");
        String record = "\tFirstname: " +  names[0] + "\tLastname: " + names[1] + getType() + toString(getRegistryDate()) + "\n" + getVehicles;
    }
}