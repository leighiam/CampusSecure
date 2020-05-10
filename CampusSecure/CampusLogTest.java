import java.time.*;
import java.util.*;
import java.io.*;

public class CampusLogTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        CampusLog log = new CampusLog();
        /*log.readUserList("UserInfo.txt");
        log.readDriverList("Driver.txt");
        log.readPedestrianList("PedestrianInfo.txt");
        log.readKeyList("KeyInfo.txt");*/
        log.getLists();
        ArrayList<User> userlist = new ArrayList<User>();
        //ArrayList<Driver> driverlist = new ArrayList<Driver>();
        //ArrayList<Pedestrian> pedlist = new ArrayList<Pedestrian>();

        //ArrayList<User> userlist1 = new ArrayList<User>();
        
        userlist = log.getUserList();
        /*User user = new User("p", "m", "t", "c", 0L, "ADMIN");
        User user2 = new User("q", "n", "s", "d", 1L, "STANDARD");
        User user3 = new User("s", "b", "f", "q", 2L, "GUEST");

        log.createDriver("Lucy", "Hale", 20190926L, "12:00 P.M.", "Meeting with campus director", "AB1234", "Blue", "Honda", "Fit");
        log.createDriver("Charles", "Spellman", 20190930L, "1:00 A.M.", "Dance recital", "SB1234", "Purple", "Mercedes Benz", "GWagon");
        log.createDriver("Satire", "Rainfall", 20190825L, "08:00 P.M.", "Computer class", "5436PG", "Black", "BMW", "X6");

        log.createPedestrian("Brenda", "Song", 20191012L, "04:00 A.M.", "Dropoff");
        log.createPedestrian("Lucy", "Hale", 20191015L, "12:00 P.M.", "Meeting with campus director");
        log.createPedestrian("Harry", "Styles", 20191127, "02:15 P.M.", "Concert");

        log.createKey("E100", "Lab", 20191017L, "Terry", "Silver", 1, "08:00 A.M.", "For COMP1126");
        log.createKey("C201", "Classroom1", 20190927L, "Alia", "Winter", 2, "09:00 A.M.", "For COMP2140");
        log.createKey("C202", "MacLab", 20191120L, "Skai", "Braedon", 5, "02:00 P.M.", "For MDIA2003");

        userlist.add(user);
        userlist.add(user2);
        userlist.add(user3);
        System.out.println(user.toString());*/
        //log.displayUsers();
        if(userlist.isEmpty() == true)
        {
            log.createUser("roofs", "poof", "admin", "admin", 0L, "ADMIN");
            //userlist1 = log.getUserList();
            //log.getUserNames();
            //System.out.println(userlist1.size());
            System.out.println("Welcome\n\nPlease login as Admin");
            System.out.println("Username: ");
            String username = input.nextLine();
            System.out.println("Password: ");
            String password = input.nextLine();
            String type = "admin";
            log.displayUsers();
            if(log.checkCredentials(password, username, type) == true)
            {
                System.out.println("R - Reset user info\nC - Create new user\nG - Generate Report");
                String ans = input.nextLine();
                if(ans.equalsIgnoreCase("r"))
                {
                    System.out.println("Firstname: ");
                    String fname = input.nextLine();
                    log.resetUser(type, "firstname", fname);
                    System.out.println("Lastname: ");
                    String lname = input.nextLine();
                    log.resetUser(type, "lastname", lname);
                    System.out.println("Username: ");
                    String uname = input.nextLine();
                    log.resetUser(type, "username", uname);
                    System.out.println("Password: ");
                    String pword = input.nextLine();
                    log.resetUser(type, "password", pword);
                    System.out.println("ID#: ");
                    String id = input.next();
                    log.resetUser(type, "id", id);
                    log.displayUsers();
                }
                else if(ans.equalsIgnoreCase("c"))
                {
                    System.out.println("Firstname: ");
                    String fname1 = input.nextLine();
                    System.out.println("Lastname: ");
                    String lname1 = input.nextLine();
                    System.out.println("Username: ");
                    String uname1 = input.nextLine();
                    System.out.println("Password: ");
                    String pword1 = input.nextLine();
                    System.out.println("ID#: ");
                    long id1 = Long.parseLong(input.nextLine());
                    System.out.println("Type: ");
                    String ty1 = input.next();
                    log.createUser(fname1, lname1, uname1, pword1, id1, ty1);
                    log.displayUsers();
                }
                else if(ans.equalsIgnoreCase("g"))
                {
                    System.out.println("Start date: 'yyyymmdd'");
                    long start = Long.parseLong(input.nextLine());
                    System.out.println("End date: 'yyyymmdd'");
                    long end = Long.parseLong(input.nextLine());
                    System.out.println("K - Keys\nD - Drivers\nP - Pedestrians");
                    String response = input.next();
                    if(response.equalsIgnoreCase("k"))
                    {
                        System.out.println(log.displayKeysByDate(start, end));
                    }
                    else if(response.equalsIgnoreCase("d"))
                    {
                        System.out.println(log.displayDriverByDate(start, end));
                    }
                    else if(response.equalsIgnoreCase("p"))
                    {
                        System.out.println(log.displayPedestrianByDate(start, end));
                    }
                }
            }
            else
            {
                System.out.println("\nInvalid Credentials!");
            } 
        }
        else if(userlist.isEmpty() == false)
        {
            System.out.println("\n\nPlease choose user mode");
            System.out.println("Select user type\n\nA - ADMIN\nS - STANDARD\nG - GUEST");
            String ans1 = input.nextLine();
            if(ans1.equalsIgnoreCase("a"))
            {
                System.out.println("Username: ");
                String username = input.nextLine();
                System.out.println("Password: ");
                String password = input.nextLine();
                System.out.println("Type: ");
                String type = input.nextLine();
                if(log.checkCredentials(password, username, type) == true)
                {
                    System.out.println("R - Reset user info\nC - Create new user\nG - Generate Report");
                    String ans = input.nextLine();
                    if(ans.equalsIgnoreCase("r"))
                    {
                        System.out.println("Firstname: ");
                        String fname = input.nextLine();
                        log.resetUser(type, "firstname", fname);
                        System.out.println("Lastname: ");
                        String lname = input.nextLine();
                        log.resetUser(type, "lastname", lname);
                        System.out.println("Username: ");
                        String uname = input.nextLine();
                        log.resetUser(type, "username", uname);
                        System.out.println("Password: ");
                        String pword = input.nextLine();
                        log.resetUser(type, "password", pword);
                        System.out.println("ID#: ");
                        String id = input.next();
                        log.resetUser(type, "id", id);
                    }
                    else if(ans.equalsIgnoreCase("c"))
                    {
                        System.out.println("Firstname: ");
                        String fname = input.nextLine();
                        System.out.println("Lastname: ");
                        String lname = input.nextLine();
                        System.out.println("Username: ");
                        String uname = input.nextLine();
                        System.out.println("Password: ");
                        String pword = input.nextLine();
                        System.out.println("ID#: ");
                        long id = Long.parseLong(input.nextLine());
                        System.out.println("Type: ");
                        String ty = input.next();
                        log.createUser(fname, lname, uname, pword, id, ty);
                    }
                    else if(ans.equalsIgnoreCase("g"))
                    {
                        System.out.println("Start date: 'yyyymmdd'");
                        long start = Long.parseLong(input.nextLine());
                        System.out.println("End date: 'yyyymmdd'");
                        long end = Long.parseLong(input.nextLine());
                        System.out.println("K - Keys\nD - Drivers\nP - Pedestrians");
                        String response = input.next();
                        if(response.equalsIgnoreCase("k"))
                        {
                            System.out.println(log.displayKeysByDate(start, end));
                        }
                        else if(response.equalsIgnoreCase("d"))
                        {
                            System.out.println(log.displayDriverByDate(start, end));
                        }
                        else if(response.equalsIgnoreCase("p"))
                        {
                            System.out.println(log.displayPedestrianByDate(start, end));
                        }
                    }
                }
                else
                {
                    System.out.println("\nInvalid Credentials!");
                }
            }
            else if(ans1.equalsIgnoreCase("s"))
            {
                System.out.println("Username: ");
                String username = input.nextLine();
                System.out.println("Password: ");
                String password = input.nextLine();
                System.out.println("Type: ");
                String type = input.nextLine();
                if(log.checkCredentials(password, username, type) == true)
                {
                    System.out.println("\nK - Keys\nD - Driver\nP - Pedestrian");
                    String ans2 = input.nextLine();
                    if(ans2.equalsIgnoreCase("k"))
                    {
                        System.out.println("C - Create Record\nU - Update Record");
                        String response4 = input.nextLine();
                        if(response4.equalsIgnoreCase("c"))
                        {
                            System.out.println("Enter Key info\n");
                            System.out.println("Entry Date: 'HH:MM A.M./P.M.'");
                            long entdate = Long.parseLong(input.nextLine());
                            System.out.println("Key#: ");
                            String keynum = input.nextLine();
                            System.out.println("Key Name: ");
                            String keyname = input.nextLine();
                            System.out.println("Loanee Firstname: ");
                            String lfname = input.nextLine();
                            System.out.println("Loanee Lastname: ");
                            String llname = input.nextLine();
                            System.out.println("Number of keys loaned");
                            int numkeysloaned = Integer.parseInt(input.nextLine());
                            System.out.println("Time loaned: ");
                            String timeloaned = input.nextLine();
                            System.out.println("Purpose: ");
                            String purp = input.next();
                            log.createKey(keynum, keyname, entdate, lfname, llname, numkeysloaned, timeloaned, purp);
                            log.updateKeyReturnTime(log.getKeyEntryNo(), "");
                            log.displayAllKeys();
                        }
                        else if(response4.equalsIgnoreCase("u"))
                        {
                            System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                            String exit = input.nextLine();
                            System.out.println("Entry number:");
                            int entnum = Integer.parseInt(input.next());
                            log.updateKeyReturnTime(entnum, exit);
                            log.displayAllKeys();
                        }
                    }
                    else if(ans2.equalsIgnoreCase("d"))
                    {
                        System.out.println("C - Create Record\nU - Update Record");
                        String response2 = input.nextLine();
                        if(response2.equalsIgnoreCase("c"))
                        {
                            System.out.println("Enter Driver info\n");
                            System.out.println("Firstname:");
                            String fname = input.nextLine();
                            System.out.println("Lastname:");
                            String lname = input.nextLine();
                            System.out.println("EntryDate: ('yyyymmdd')");
                            long date = Long.parseLong(input.nextLine());
                            System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                            String timein = input.nextLine();
                            System.out.println("Purpose of visit:");
                            String purpose = input.nextLine();
                            System.out.println("License#:");
                            String lnum = input.nextLine();
                            System.out.println("Color:");
                            String color = input.nextLine();
                            System.out.println("Make:");
                            String make = input.nextLine();
                            System.out.println("Model:");
                            String model = input.next();
                            log.createDriver(fname, lname, date, timein, purpose, lnum, color, make, model);
                            log.updateDriverExit(log.getDriverEntryNo(), "");
                            log.displayAllDrivers();
                        }
                        else if(response2.equalsIgnoreCase("u"))
                        {
                            System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                            String exit = input.nextLine();
                            System.out.println("Entry number:");
                            int entnum = Integer.parseInt(input.next());
                            log.updateDriverExit(entnum, exit);
                            log.displayAllDrivers();
                        }
                    }
                    else if(ans2.equalsIgnoreCase("p"))
                    {
                        System.out.println("C - Create Record\nU - Update Record");
                        String response3 = input.nextLine();
                        if(response3.equalsIgnoreCase("c"))
                        {
                            //System.out.println("C - Create Record\nUpdate Record");
                            System.out.println("Enter pedestrian info");
                            System.out.println("Firstname:");
                            String fname = input.nextLine();
                            System.out.println("Lastname:");
                            String lname = input.nextLine();
                            System.out.println("EntryDate: ('yyyymmdd')");
                            long date = Long.parseLong(input.nextLine());
                            System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                            String timein = input.nextLine();
                            System.out.println("Purpose of visit:");
                            String purpose = input.next();
                            log.createPedestrian(fname, lname, date, timein, purpose);
                            log.updatePedestrianExit(log.getPedestrianEntryNo(), "");
                            log.displayAllPedestrians();
                        }
                        else if(response3.equalsIgnoreCase("u"))
                        {
                            
                            System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                            String exit = input.nextLine();
                            System.out.println("Entry number:");
                            int entnum = Integer.parseInt(input.next());
                            log.updatePedestrianExit(entnum, exit);
                            log.displayAllPedestrians();
                        }
                    }  
                }
                else
                {
                    System.out.println("\nInvalid Credentials");
                }
            }
            else if(ans1.equalsIgnoreCase("g"))
            {
                System.out.println("Username: ");
                String username = input.nextLine();
                System.out.println("Password: ");
                String password = input.nextLine();
                System.out.println("Type: ");
                String type = input.nextLine();
                if(log.checkCredentials(password, username, type) == true)
                {
                    System.out.println("Start date: 'yyyymmdd'");
                    long start = Long.parseLong(input.nextLine());
                    System.out.println("End date: 'yyyymmdd'");
                    long end = Long.parseLong(input.nextLine());
                    System.out.println("K - Keys\nD - Drivers\nP - Pedestrians");
                    String response = input.next();
                    if(response.equalsIgnoreCase("k"))
                    {
                        System.out.println(log.displayKeysByDate(start, end));
                    }
                    else if(response.equalsIgnoreCase("d"))
                    {
                        System.out.println(log.displayDriverByDate(start, end));
                    }
                    else if(response.equalsIgnoreCase("p"))
                    {
                        System.out.println(log.displayPedestrianByDate(start, end));
                    }
                }
                else
                {
                    System.out.println("\nInvalid Credentials");
                }
            }
        }
        /*log.writeUserList("UserInfo.txt");
        log.writeDriverList("Driver.txt");
        log.writePedestrianList("PedestrianInfo.txt");
        log.writeKeyList("KeyInfo.txt");*/
        log.saveLists();
        System.out.println("\n\nAite Bye!");
    }
}