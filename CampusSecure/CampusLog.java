import java.time.*;
import java.util.*;
import java.io.*;

public class CampusLog implements Serializable
{
    private ArrayList<Object> objectlist = new ArrayList<Object>();
    private DataManager dm = new DataManager();
    private ArrayList<User> userlist = new ArrayList<User>();
    private ArrayList<Pedestrian> pedestrianlist = new ArrayList<Pedestrian>();
    private ArrayList<Driver> driverlist = new ArrayList<Driver>();
    private ArrayList<KeyManager> keylist = new ArrayList<KeyManager>();

    public boolean checkCredentials(String password, String username, String type)
    {
        boolean result = false;
        for(User user: userlist)
        {
            if(user.authenPassword(password) == true)
            {
                if(user.authenUsername(username) == true)
                {
                    if(user.authenType(Type.valueOf(type.toUpperCase())) == true)
                    {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public void createUser(String fname, String lname, String uname, String pword, long id, String utype)
    {
        userlist.add(new User(fname, lname, uname, pword, id, utype));
    }

    public void createPedestrian(String fname, String lname, long endate, String entime, String purp)
    {
        pedestrianlist.add(new Pedestrian(fname, lname, endate, entime, purp));
    }

    public void createDriver(String fname, String lname, long endate, String entime, String purp, String lnum, String col, String mk, String mod)
    {
        driverlist.add(new Driver(fname, lname, endate, entime, purp, lnum, col, mk, mod));
    }

    public void createKey(String Keynum, String keyname, long keydate, String fname, String lname, int numkeys, String timeloaned, String keypurpose)
    {
        keylist.add(new KeyManager(Keynum, keyname, keydate, fname, lname, numkeys, timeloaned, keypurpose));
    }

   public void resetUser(String username, String attribute, String newvalue)
   {
       for(User user: userlist)
       {
           if(user.getUsername().equalsIgnoreCase(username))
           {
               user.updateUser(attribute, newvalue);
           }
       }
   }

   public int getDriverEntryNo()
   {
       int entry = 0;
        for(Driver driver: driverlist)
        {
            entry = driver.getEntryNo();
        }
        return entry;
   }

   public int getPedestrianEntryNo()
   {
       int entry = 0;
        for(Pedestrian pedestrian: pedestrianlist)
        {
            entry = pedestrian.getEntryNo();
        }
        return entry;
   }

   public int getKeyEntryNo()
   {
        int entry = 0;
        for(KeyManager key: keylist)
        {
            entry = key.getEntryNo();
        }
        return entry;
   }

   public void updateDriverExit(int entryNo, String time)
   {
       for(Driver driver: driverlist)
       {
           if(driver.getEntryNo() == entryNo)
           {
               driver.setExitTime(time);
           }
       }
   }

   public void updatePedestrianExit(int entryNo, String time)
   {
       for(Pedestrian pedestrian: pedestrianlist)
       {
           if(pedestrian.getEntryNo() == entryNo)
           {
               pedestrian.setExitTime(time);
           }
       }
   }

   public void updateKeyReturnTime(int entryNo, String time)
   {
        for(KeyManager key: keylist)
        {
            if(key.getEntryNo() == entryNo)
            {
                key.setReturnTime(time);
            }
        }
   }

   public void displayUsers()
   {
       for(User user: userlist)
       {
           System.out.println(user.toString());
       }
   }

   public void displayAllDrivers()
   {
        for(Driver driver: driverlist)
        {
            System.out.println(driver.toString());
        }
   }

   public void displayAllPedestrians()
   {
        for(Pedestrian pedestrian: pedestrianlist)
        {
            System.out.println(pedestrian.toString());
        }
   }

   public void displayAllKeys()
    {
        for(KeyManager key: keylist)
        {
            System.out.println(key.toString());
        }
   }

   public String displayDriverByDate(long start, long end)
    {
        String info = "";
        String startday = "" + start + "";
		int year = Integer.parseInt(startday.substring(0,4));
		int month = Integer.parseInt(startday.substring(4,6));
		int day = Integer.parseInt(startday.substring(6));
        String endday = "" + end + "";
		int year1 = Integer.parseInt(endday.substring(0,4));
		int month2 = Integer.parseInt(endday.substring(4,6));
		int day3 = Integer.parseInt(endday.substring(6));
        LocalDate startdate = LocalDate.of(year, month, day);
        LocalDate enddate = LocalDate.of(year1, month2, day3);
        LocalDate today = LocalDate.now();
        if(enddate.isAfter(today) == true)
        {
            System.out.println("Invalid Date!");
        }
        else if(enddate.isBefore(startdate) == true)
        {
            System.out.println("Invalid Date!");
        }
        else
        {
            long time = Duration.between(startdate.atStartOfDay(), enddate.atStartOfDay()).toDays();
            if(time == 30L)
            {
                while(startdate.isBefore(enddate) == true || startdate.toString().equals(enddate.toString()))
                {
                    for(Driver driver: driverlist)
                    {
                        String str = startdate.toString();
                        long ed = driver.getEntryDate();
                        String str2 = driver.toString(ed);
                        if(str2.equals(str))
                        {
                            info += driver.toString();
                        }
                    }
                    startdate = startdate.plusDays(1);
                }
            }
            else if(time > 30 || time < 30)
            {
                System.out.println("Invalid Period");
                System.out.println(time);
            }
        }
        return info;
    }

    public String displayPedestrianByDate(long start, long end)
    {
        String info = "";
        String startday = "" + start + "";
		int year = Integer.parseInt(startday.substring(0,4));
		int month = Integer.parseInt(startday.substring(4,6));
		int day = Integer.parseInt(startday.substring(6));
        String endday = "" + end + "";
		int year1 = Integer.parseInt(endday.substring(0,4));
		int month2 = Integer.parseInt(endday.substring(4,6));
		int day3 = Integer.parseInt(endday.substring(6));
        LocalDate startdate = LocalDate.of(year, month, day);
        LocalDate enddate = LocalDate.of(year1, month2, day3);
        LocalDate today = LocalDate.now();
        if(enddate.isAfter(today) == true)
        {
            System.out.println("Invalid Date!");
        }
        else if(enddate.isBefore(startdate) == true)
        {
            System.out.println("Invalid Date!");
        }
        else
        {
            long time = Duration.between(startdate.atStartOfDay(), enddate.atStartOfDay()).toDays();
            if(time == 30L)
            {
                while(startdate.isBefore(enddate) == true || startdate.toString().equals(enddate.toString()))
                {
                    for(Pedestrian pedestrian: pedestrianlist)
                    {
                        String str = startdate.toString();
                        long ed = pedestrian.getEntryDate();
                        String str2 = pedestrian.toString(ed);
                        if(str2.equals(str))
                        {
                            info += pedestrian.toString();
                        }
                    }
                    startdate = startdate.plusDays(1);
                }
            }
            else if(time > 30 || time < 30)
            {
                System.out.println("Invalid Period");
                System.out.println(time);
            }
        }
        return info;
    }

    public String displayKeysByDate(long start, long end)
    {
        String info = "";
        String startday = "" + start + "";
		int year = Integer.parseInt(startday.substring(0,4));
		int month = Integer.parseInt(startday.substring(4,6));
		int day = Integer.parseInt(startday.substring(6));
        String endday = "" + end + "";
		int year1 = Integer.parseInt(endday.substring(0,4));
		int month2 = Integer.parseInt(endday.substring(4,6));
		int day3 = Integer.parseInt(endday.substring(6));
        LocalDate startdate = LocalDate.of(year, month, day);
        LocalDate enddate = LocalDate.of(year1, month2, day3);
        LocalDate today = LocalDate.now();
        if(enddate.isAfter(today) == true)
        {
            System.out.println("Invalid Date!");
        }
        else if(enddate.isBefore(startdate) == true)
        {
            System.out.println("Invalid Date!");
        }
        else
        {
            long time = Duration.between(startdate.atStartOfDay(), enddate.atStartOfDay()).toDays();
            if(time == 30L)
            {
                while(startdate.isBefore(enddate) == true || startdate.toString().equals(enddate.toString()))
                {
                    for(KeyManager key: keylist)
                    {
                        String str = startdate.toString();
                        long ed = key.getKeyDate();
                        String str2 = key.toString(ed);
                        if(str2.equals(str))
                        {
                            info += key.toString();
                        }
                    }
                    startdate = startdate.plusDays(1);
                }
            }
            else if(time > 30 || time < 30)
            {
                System.out.println("Invalid Period");
                System.out.println(time);
            }
        }
        return info;
    }

    public ArrayList<User> getUserList()
    {
        return this.userlist;
    }

    public ArrayList<Driver> getDriverList()
    {
        return this.driverlist;
    }

    public ArrayList<Pedestrian> getPedestrianList()
    {
        return this.pedestrianlist;
    }

    public ArrayList<KeyManager> getKeyList()
    {
        return this.keylist;
    }

    public void saveRecordLists()
    {
        objectlist.add(getUserList());
        objectlist.add(getDriverList());
        objectlist.add(getPedestrianList());
        objectlist.add(getKeyList());
    }

    /**
	*This method is responsible for writing the the different lists to a file
	*@param filename collects the name of the file that the different lists will be saved to
	*/
	public void writeList(String filename)
	{
		dm.save(filename, this.objectlist);
    }

    public void writeUserList(String filename)
	{
		dm.saveUser(filename, this.userlist);
    }

    public void writeDriverList(String filename)
	{
		dm.saveDriver(filename, this.driverlist);
    }

    public void writePedestrianList(String filename)
	{
		dm.savePedestrian(filename, this.pedestrianlist);
    }

    public void writeKeyList(String filename)
	{
		dm.saveKey(filename, this.keylist);
    }
	
	/**
	*This method is responsible for reading the contact from a file
	*@param filename collects the name of the file that the contact list will be obtained from
	*/
	public void readList(String filename)
	{
		objectlist = dm.read(filename, this.objectlist);
    }

    public void readUserList(String filename)
	{
        ArrayList<User> users2 = new ArrayList<User>();
        users2 = dm.readUser(filename, users2);
        for(User user: users2)
        {
            String[] names = user.getName().split(" ");
            createUser(names[0], names[1], user.getUsername(), user.getPassword(), user.getID(), user.getType().toString());
        }
    }

    public void readDriverList(String filename)
	{
        ArrayList<Driver> drivers2 = new ArrayList<Driver>();
        drivers2 = dm.readDriver(filename, drivers2);
        for(Driver driver: drivers2)
        {
            String[] names = driver.getName().split(" ");
            createDriver(names[0], names[1], driver.getEntryDate(), driver.getEntryTime(), driver.getPurpose(), driver.getLicenseNum(), driver.getColor(), driver.getMake(), driver.getModel());
        }
        
    }

    public void readPedestrianList(String filename)
    {
        ArrayList<Pedestrian> peds2 = new ArrayList<Pedestrian>();
        peds2 = dm.readPedestrian(filename, peds2);
        for(Pedestrian ped: peds2)
        {
            String[] names = ped.getName().split(" ");
            createPedestrian(names[0], names[1], ped.getEntryDate(), ped.getEntryTime(), ped.getPurpose());
        }
    }

    public void readKeyList(String filename)
	{
        //ArrayList<KeyManager> keys2 = new ArrayList<KeyManager>();
        keylist = dm.readKey(filename, this.keylist);
		/*for(KeyManager key: keys2)
        {
            String[] names = key.getLoaneeName().split(" ");
            createUser(names[0], names[1], ped.getEntryDate(), ped.getEntryTime(), ped.getPurpose());
        }*/
    }

    public void getLists()
    {
        readUserList("UserInfo.txt");
        readDriverList("Driver.txt");
        readPedestrianList("PedestrianInfo.txt");
        readKeyList("KeyInfo.txt");
    } 

    public void saveLists()
    {
        writeUserList("UserInfo.txt");
        writeDriverList("Driver.txt");
        writePedestrianList("PedestrianInfo.txt");
        writeKeyList("KeyInfo.txt");
    }
}
