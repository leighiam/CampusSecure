package campussecure.log;

import java.util.*;
import java.io.*;

public class SchoolMember implements Serializable
{
    private static final long serialVersionUID = 9111125002187666886L;
    private Name name;
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private MemberType type;
    private long regDate;
    private long id;
    
    public SchoolMember(String fname, String lname, String type, long id, long date, String lnum, String col, String mk, String mod)
    {
        this.name = new Name(fname, lname);
        this.type = MemberType.valueOf(type.toUpperCase());
        this.id = id;
        this.regDate = date;
        this.vehicleList.add(new Vehicle(lnum, col, mk, mod));

    }
    
    public String getName()
    {
        return name.getFullName();
    }

    public MemberType getType()
    {
        return this.type;
    }

    public long getRegistryDate()
    {
        return this.regDate;
    }

    public void addVehicle(String lnum, String col, String mk, String mod)
    {
        vehicleList.add(new Vehicle(lnum, col, mk, mod));
    }

    public ArrayList<Vehicle> getVehicleList()
    {
        return this.vehicleList;
    }

    public String getVehicles()
    {
        String response = "";
        for(Vehicle vehicle: vehicleList)
        {
            response += vehicle.toString() + "\n";
        }
        return response;
    }

    public String getLicenseNum(String lnum)
    {
        String response = "";
        for(Vehicle vehicle: vehicleList)
        {
            if(lnum.equals(vehicle.getLicenseNum()))
            {
                response = vehicle.getLicenseNum();
            }
        }
        return response;
    }

    public long getID()
    {
        return this.id;
    }

    public void deregisterVehicle(String lnum)
    {
        for(int i  = 0; i < vehicleList.size(); i++)
        {
            if(lnum.equals(vehicleList.get(i).getLicenseNum()));
            {
                vehicleList.remove(i);
            }
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
        String record = "\tFirstname: " +  names[0] + "\tLastname: " + names[1] + getType() + toString(getRegistryDate()) + "\tID#: " + toString(getID()) + "\n" + getVehicles();
        return record;
    }
}