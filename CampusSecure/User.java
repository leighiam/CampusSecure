import java.io.*;

public class User implements Serializable
{
    private Name name;
    private String username;
    private String password;
    private long idNum;
    private Type type;

    public User(String fname, String lname, String uname, String pword, long id, String utype)
    {
        this.name = new Name(fname, lname);
        this.username = uname;
        this.password = pword;
        this.idNum = id;
        this.type = Type.valueOf(utype.toUpperCase());
    }

    public void setFirstName(String fname)
    {
        name.setFName(fname);
    }

    public void setLastName(String lname)
    {
        name.setLName(lname);
    }

    public String getName()
    {
        return name.getFullName();
    }

    public void setUsername(String name)
    {
        this.username = name;
    }

    public String getUsername()
    {
        return this.username;   
    }

    public void setIDNum(long id)
    {
        this.idNum = id;
    }

    public long getID()
    {
        return this.idNum;
    }

    public void setPassword(String pword)
    {
        this.password = pword;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setType(String utype)
    {
        this.type = Type.valueOf(utype);
    }

    public Type getType()
    {
        return this.type;
    }

    public boolean authenUsername(String username)
	{
		boolean result  = false;
		if(getUsername().equals(username))
		{
			result = true;
		}
		return result;
	}
	
	public boolean authenPassword(String password)
	{
		boolean result  = false;
		if(getPassword().equals(password))
		{
			result = true;
		}
		return result;
    }
    
    public boolean authenType(Type type)
    {
        boolean result = false;
        if(getType() == type)
		{
			result = true;
		}
		return result;
    }

    public void updateUser(String attribute, String newvalue)
    {
        if(attribute.equalsIgnoreCase("firstname"))
        {
            setFirstName(newvalue);
        }
        else if(attribute.equalsIgnoreCase("lastname"))
        { 
            setLastName(newvalue);
        }
        else if(attribute.equalsIgnoreCase("username"))
        {
            setUsername(newvalue);
        }
        else if(attribute.equalsIgnoreCase("password"))
        {
            setPassword(newvalue);
        }
        else if(attribute.equalsIgnoreCase("id"))
        {
            long id = Long.parseLong(newvalue);
            setIDNum(id);
        }
    }

    public String toString(long record)
    {
        String newrecord = ""+record+"";
        return newrecord;
    }

    /*public String[] displayAllUsers()
    {
        String[] userarray = new String[6];
        String[] names = getName().split(" ");
        userarray[0] = names[0];
        userarray[1] = names[1];
        userarray[2] = this.getUsername();
        userarray[3] = this.getPassword();
        userarray[4] = toString(this.getID());
        userarray[5] = this.getType();
        return userarray;
    }*/

    public String toString()
    {
        String[] names = getName().split(" ");
        //System.out.println(names.length);
        String record = "ID#: " + toString(getID()) + "\tFirstname: " +  names[0] + "\tLastname: " + names[1] + "\tUsername: " + getUsername() + "\tPassword: " + getPassword() + "\tType: " + getType(); 
        return record+ "\n";
    }
}