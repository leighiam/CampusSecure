package campussecure.log;

import campussecure.data.DataManager;
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
    private ArrayList<SchoolMember> schoolList = new ArrayList<SchoolMember>();
    private ArrayList<DormVisitor> dormlist = new ArrayList<DormVisitor>();
    private ArrayList<Report> reportlist = new ArrayList<Report>();

    public boolean checkCredentials(String password, String username, String type)
    {
        boolean result = false;
        for(User user: userlist)
        {
            if(user.authenPassword(password) == true)
            {
                if(user.authenUsername(username) == true)
                {
                    if(user.authenType(UserType.valueOf(type.toUpperCase())) == true)
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

    public void createKey(String Keynum, String keyname, long keydate, String fname, String lname, String timeloaned, String keypurpose)
    {
        Name name = new Name(fname, lname);
        int numkeys = getNumKeys(name.getFullName());
        int entryNo = keylist.size() + 1;
        keylist.add(new KeyManager(Keynum, keyname, keydate, fname, lname, numkeys, timeloaned, keypurpose, entryNo));
    }

    public void createSchoolMember(String fname, String lname, String type, long id, long date, String lnum, String col, String mk, String mod)
    {
        schoolList.add(new SchoolMember(fname, lname, type, id, date, lnum, col, mk, mod));
    }

    public void createDormVisitor(String fname, String lname, long endate, String entime, String purp, long vtorID, String vteefname, String vteelname,long vteeID)
    {
        dormlist.add(new DormVisitor(fname, lname, endate, entime, purp, vtorID, vteefname, vteelname, vteeID));
    }

    public void createReport(String fname, String lname, String utype, long uid, String reportInfo, String rtype, String timeperiod)
    {
        int entrynum = reportlist.size() + 1;
        reportlist.add(new Report(fname, lname, utype, uid, reportInfo, rtype, timeperiod));
        reportlist.get(reportlist.size() - 1).setEntryNo(entrynum);
        System.out.println(fname + lname);
    }

    public int getNumKeys(String name)
    {
        int c = 1;
        for(KeyManager key: keylist)
        {
            if(name.equals(key.getLoaneeName()))
            {
                c+=1;
            }
        }
        return c;
    }

    public boolean isRegistered(String lnum)
    {
        boolean response = false;
        for(SchoolMember sm: schoolList)
        {
            if(lnum.equals(sm.getLicenseNum(lnum)))
            {
                response = true;
            }
        }
        return response;
    }

    public long getUserID(String username)
    {
        long response = 0L;
        for(User user: userlist)
        {
            if(username.equals(user.getUsername()))
            {
                response = user.getID();
            }
        }
        return response;
    }

    public String getUserFName(String username)
    {
        String response = "";
        for(User user: userlist)
        {
            if(username.equals(user.getUsername()))
            {
                String[] name = user.getName().split(" ");
                String fname = name[0];
                response = fname;
            }
        }
        return response;
    }

    public String getUserLName(String username)
    {
        String response = "";
        for(User user: userlist)
        {
            if(username.equals(user.getUsername()))
            {
                String[] name = user.getName().split(" ");
                String lname = name[1];
                response = lname;
            }
        }
        return response;
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

    public void deleteUser(long id)
    {
        for(int i = 0; i < userlist.size(); i++)
        {
            if(id == userlist.get(i).getID())
            {
                userlist.remove(i);
            }
        }
    } 

    public void deregisterVehicle(String lnum)
    {
        for(int i = 0; i < schoolList.size(); i++)
        {
            ArrayList<Vehicle> vec = schoolList.get(i).getVehicleList();
            for(int x = 0; x < vec.size(); x++)
            {
                if(lnum.equals(vec.get(x).getLicenseNum()))
                {
                    schoolList.get(i).deregisterVehicle(lnum);
                }
            }
        }
    }

    public void deleteSchoolMember(long id)
    {
        for(int i = 0; i < schoolList.size(); i++) 
        {
            if(id == schoolList.get(i).getID())
            {
                schoolList.remove(i);
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

    public int getDormVisitorEntryNo()
    {
        int entry = 0;
        for(DormVisitor dormVisitor: dormlist)
        {
            entry = dormVisitor.getEntryNo();
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

    public void updateDormVisitorExit(int entryNo, String time)
    {
        for(DormVisitor dormVisitor: dormlist)
        {
            if(dormVisitor.getEntryNo() == entryNo)
            {
                dormVisitor.setExitTime(time);
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

    public void addVehicle(long id, String lnum, String col, String mk, String mod)
    {
        for(SchoolMember sm: schoolList)
        {
            if(id == sm.getID())
            {
                sm.addVehicle(lnum, col, mk, mod);
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

    public void displayAllDormVisitors()
    {
        for(DormVisitor dormVisitor: dormlist)
        {
            System.out.println(dormVisitor.toString());
        }
    }

    public void displayAllSchoolMembers()
    {
        for(SchoolMember schoolMember: schoolList)
        {
            System.out.println(schoolMember.toString());
        }
    }

    public void viewAllReports()
    {
        for(Report report: reportlist)
        {
                System.out.println(report.toString());
        }
    }

    public void viewReport(String rtype, int entrynum)
    {
        for(Report report: reportlist)
        {
            if(rtype.equals(report.getReportType()+""))
            {
                if(entrynum == report.getEntryNo())
                {
                    System.out.println(report.toString());
                }
                else
                {
                    System.out.println("Report does not exist");
                }
            }
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

    public String displayDormVisitorByDate(long start, long end)
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
                    for(DormVisitor dormVisitor: dormlist)
                    {
                        String str = startdate.toString();
                        long ed = dormVisitor.getEntryDate();
                        String str2 = dormVisitor.toString(ed);
                        if(str2.equals(str))
                        {
                            info += dormVisitor.toString();
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

    public ArrayList<DormVisitor> getDormList()
    {
        return this.dormlist;
    }

    public ArrayList<SchoolMember> getSchoolList()
    {
        return this.schoolList;
    }

    public ArrayList<Report> getReportList()
    {
        return this.reportlist;
    }

    public void saveRecordLists()
    {
        objectlist.add(getUserList());
        objectlist.add(getDriverList());
        objectlist.add(getPedestrianList());
        objectlist.add(getKeyList());
        objectlist.add(getDormList());
        objectlist.add(getSchoolList());
        objectlist.add(getReportList());
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

    public void writeDormList(String filename)
    {
        dm.saveDormVisitor(filename, this.dormlist);
    }

    public void writeSchoolList(String filename)
    {
        dm.saveSchoolMember(filename, this.schoolList);
    }

    public void writeReportList(String filename)
    {
        dm.saveReport(filename, this.reportlist);
    }

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
            String exit = driver.getExitTime();
            createDriver(names[0], names[1], driver.getEntryDate(), driver.getEntryTime(), driver.getPurpose(), driver.getLicenseNum(), driver.getColor(), driver.getMake(), driver.getModel());
            driverlist.get(driverlist.size()-1).setExitTime(exit);
        }
        
    }

    public void readPedestrianList(String filename)
    {
        ArrayList<Pedestrian> peds2 = new ArrayList<Pedestrian>();
        peds2 = dm.readPedestrian(filename, peds2);
        for(Pedestrian ped: peds2)
        {
            String[] names = ped.getName().split(" ");
            String exit = ped.getExitTime();
            createPedestrian(names[0], names[1], ped.getEntryDate(), ped.getEntryTime(), ped.getPurpose());
            pedestrianlist.get(pedestrianlist.size()-1).setExitTime(exit);
        }
    }

    public void readKeyList(String filename)
    {
        this.keylist = dm.readKeys(filename, this.keylist);
    }

    public void readDormList(String filename)
    {
        ArrayList<DormVisitor> dorm2 = new ArrayList<DormVisitor>();
        dorm2 = dm.readDormVisitor(filename, dorm2);
        for(DormVisitor dv: dorm2)
        {
            String[] names = dv.getName().split(" ");
            String[] names2 = dv.getVisiteeName().split(" ");
            String exit = dv.getExitTime();
            createDormVisitor(names[0], names[1], dv.getEntryDate(), dv.getEntryTime(), dv.getPurpose(), dv.getVisitorID(), names2[0], names2[1], dv.getVisiteeID());
            dormlist.get(dormlist.size()-1).setExitTime(exit);
        }
    }

    public void readSchoolList(String filename)
    {
        ArrayList<SchoolMember> school2 = new ArrayList<SchoolMember>();
        school2 = dm.readSchoolMember(filename, school2);
        for(SchoolMember sm: school2)
        {
            String[] names = sm.getName().split(" ");
            Vehicle[] vehicles = sm.getVehicleList().toArray(new Vehicle[sm.getVehicleList().size()]);
            String lnum = vehicles[0].getLicenseNum();
            String col = vehicles[0].getColor();
            String mk = vehicles[0].getMake();
            String mod = vehicles[0].getModel();
            createSchoolMember(names[0], names[1], sm.getType().toString(), sm.getID(), sm.getRegistryDate(), lnum, col, mk, mod);
            if(vehicles.length > 1)
            {
                for(int i = 1; i < vehicles.length; i++)
                {
                    schoolList.get(schoolList.size()-1).addVehicle(vehicles[i].getLicenseNum(), vehicles[i].getColor(), vehicles[i].getMake(), vehicles[i].getModel());
                }
            }
        }
    }

    public void readReportList(String filename)
    {
        
        this.reportlist = dm.readReport(filename, reportlist);
    }

    public void getLists()
    {
        readUserList("UserInfo.txt");
        readDriverList("Driver.txt");
        readPedestrianList("PedestrianInfo.txt");
        readKeyList("Keyinfo.txt");
        readDormList("DormInfo.txt");
        readSchoolList("MemberInfo.txt");
        readReportList("ReportInfo.txt");
    } 

    public void saveLists()
    {
        writeUserList("UserInfo.txt");
        writeDriverList("Driver.txt");
        writePedestrianList("PedestrianInfo.txt");
        writeKeyList("Keyinfo.txt");
        writeDormList("DormInfo.txt");
        writeSchoolList("MemberInfo.txt");
        writeReportList("ReportInfo.txt");
    }
}
