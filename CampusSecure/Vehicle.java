import java.io.*;

public class Vehicle implements Serializable
{
    private String license_num;
    private String color;
    private String make;
    private String model;

    public Vehicle(String lnum, String col, String mk, String mod)
    {
        this.license_num = lnum;
        this.color = col;
        this.make = mk;
        this.model = mod;
    }

    public void setLicenseNum(String lnum)
    {
        this.license_num = lnum;
    }

    public String getLicenseNum()
    {
        return this.license_num;
    }

    public void setColor(String col)
    {
        this.color = col;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setMake(String mk)
    {
        this.make = mk;
    }

    public String getMake()
    {
        return this.make;
    }

    public void setModel(String mod)
    {
        this.model = mod;
    }

    public String getModel()
    {
        return this.model;
    }

    public String toString()
    {
        String record = "\tLicense#: " + getLicenseNum() + "\tCar-color: " + getColor() + "\tCar-Make: " + getMake() + "\tModel: " + getModel();
        return record;
    }
}