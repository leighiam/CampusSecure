import java.time.*;
import java.util.*;
import java.io.*;

public class TextUI
{
    private CampusLog log;
    private Scanner input;
    private Scanner input2;
    private Scanner input3;
    private Scanner input4;
    private Scanner input5;
    private Scanner input6;
    private Scanner input7;
    private Scanner input8;
    private Scanner input9;
    private Scanner input10;
    private Scanner input11;
    ArrayList<User> userlist = new ArrayList<User>();

    public TextUI()
    {
        this.log = new CampusLog();
        input = new Scanner(System.in);
		input2 = new Scanner(System.in);
		input3 = new Scanner(System.in);
		input4 = new Scanner(System.in);
        input5 = new Scanner(System.in);
        input6 = new Scanner(System.in);
        input7 = new Scanner(System.in);
        input8 = new Scanner(System.in);
        input9 = new Scanner(System.in);
        input10 = new Scanner(System.in);
        input11 = new Scanner(System.in);
        welcomeMessage();
        logMenu();
    }

    public void welcomeMessage()
	{
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *        Welcome to Campus Secure         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* *                                         * *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *\n");
        log.getLists();
        userlist = log.getUserList();
    }

    public void goodbyeMessage()
    {
        System.out.println("* * * * * * * *");
        System.out.println("* * * * * * * *");
        System.out.println("* * * * * * * *");
        System.out.println("* *         * *");
        System.out.println("* *   BYE!  * *");
        System.out.println("* *         * *");
        System.out.println("* * * * * * * *");
        System.out.println("* * * * * * * *");
        System.out.println("* * * * * * * *");
    }
    
    public String signInMenu()
    {
        String answer = "";
        if(userlist.isEmpty() == true)
        {
            log.createUser("roofs", "poof", "admin", "admin", 0L, "ADMIN");
            System.out.println("\n\nPlease login as Admin");
            answer = "a";
        }
        else if(userlist.isEmpty() == false)
        {
            System.out.println("Select user type\n\nA - ADMIN\nPS - POSTSECURITY\nSS - SECURITYSUPERVISOR\nCD - CAMPUSDIRECTOR\nCP - CAMPUSPOLICE\nE - End Session");
            answer = input.next();
        }
        return answer;
    }

    public String adminMenu()
    {
        System.out.println("U - Update User\nC - Create User\nD - Delete User\nV - View Users\nL - Logout");
        String answer1 = input.next();
        return answer1;
    }

    public String psMenu()
    {
        System.out.println("\nK - Keys\nD - Driver\nP - Pedestrian\nDV - DormVisitor \nL - Logout");
        String answer2 = input.next();
        return answer2;
    }

    public String ssMenu()
    {
        System.out.println("\nK - Keys\nD - Driver\nP - Pedestrian\nDV - Dorm Visitor\nG - Generate Report\nV - View Report\nL - Logout");
        String answer3 = input.next();
        return answer3;
    }  

    public String cdMenu()
    {
        System.out.println("\nG - Generate Report\nV - View Report\nVA - View All Reports\nL - Logout");
        String answer4 = input.next();
        return answer4;
    }
    
    public String cpMenu()
    {
        System.out.println("\nR - Register School Member\nD - Deregister School Member\nA - Add Vehicle\nDV - Delete Vehicle\nVS -View School Members\nG - Generate Report\nV - View Report\nL - Logout");
        String answer5 = input.next();
        return answer5;
    }

    
    public String recordMenu()
    {
        System.out.println("C - Create Record\nU - Update Record\nV - View records\nL - Logout");
        String answer6 = input.next();
        return answer6;
    }

    public String updateMenu()
    {
        System.out.println("First Name: - update first name");
        System.out.println("Last Name: - update lastname");
		System.out.println("Username: - update username");
		System.out.println("Password: - update password");
        System.out.println("L - Logout");
		String answer7 = input.next();
		return answer7;
    }

    public void logMenu()
    {
        boolean session = true;
        String options = signInMenu();
        int x = 0;
        int y = 0;

        if(options.equalsIgnoreCase("a"))
        {
            while(x < 3)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                String type = "admin";
                if(log.checkCredentials(password, username, type) == true)
                {     
                    String options1 = adminMenu();
                    while(session)
                    {
                        if(options1.equalsIgnoreCase("u"))
                        {
                            String response = updateMenu();
                            if(response.equalsIgnoreCase("firstname"))
                            {
                                System.out.println("Firstname: ");
                                String fname = input2.nextLine();
                                System.out.println("Username: ");
                                String name = input2.nextLine();
                                log.resetUser(name, "firstname", fname);
                                log.displayUsers();
                            }
                            else if(response.equalsIgnoreCase("lastname"))
                            {
                                System.out.println("Lastname: ");
                                String lname = input2.nextLine();
                                System.out.println("Username: ");
                                String name = input2.nextLine();
                                log.resetUser(name, "lastname", lname);
                                log.displayUsers();
                            }
                            else if(response.equalsIgnoreCase("username"))
                            {
                                System.out.println("Username: ");
                                String uname = input2.nextLine();
                                System.out.println("Old Username: ");
                                String name = input2.nextLine();
                                log.resetUser(name, "username", uname);
                                log.displayUsers();
                            }
                            else if(response.equalsIgnoreCase("password"))
                            {
                                System.out.println("Password: ");
                                String pword = input2.nextLine();
                                System.out.println("Username: ");
                                String name = input2.nextLine();
                                log.resetUser(name, "password", pword);
                                log.displayUsers();
                            }
                        }
                        else if(options1.equalsIgnoreCase("c"))
                        {   
                            System.out.flush();
                            System.out.println("Firstname: ");
                            String fname = input3.nextLine();
                            System.out.println("Lastname: ");
                            String lname = input3.nextLine();
                            System.out.println("Username: ");
                            String uname = input3.nextLine();
                            System.out.println("Password: ");
                            String pword = input3.nextLine();
                            System.out.println("ID#: ");
                            long id = Long.parseLong(input2.nextLine());
                            System.out.println("User Type: ");
                            String ty = input3.nextLine();
                            log.createUser(fname, lname, uname, pword, id, ty);
                            log.displayUsers();
                        }
                        else if(options1.equalsIgnoreCase("v"))
                        {
                            log.displayUsers();
                        }
                        else if(options1.equalsIgnoreCase("d"))
                        {
                            System.out.println("ID#: ");
                            long id = Long.parseLong(input4.nextLine());
                            log.deleteUser(id);
                        }
                        else if(options1.equalsIgnoreCase("l"))
                        {
                            log.saveLists();
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                        }
                        options1 = adminMenu();
                    }
                }
                else if(log.checkCredentials(password, username, type) == false)
                {
                    x++;
                    if(x <= 2)
                    {
                        System.out.println("\nInvalid Credentials!");
                    }
                    else if(x == 2)
                    {
                        System.out.println("\nFinal Attempt!");
                    }
                }
            }
            System.out.println("No more attempts!\n\n\n\n");
            log.saveLists();
            goodbyeMessage();
            session = false;
            System.exit(0);
        }
        else if(options.equalsIgnoreCase("ps"))
        {
            while(x < 3)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                String type = "postsecurity";
                if(log.checkCredentials(password, username, type) == true)
                {
                    while(session)
                    {
                        String options3 = psMenu();
                        if(options3.equalsIgnoreCase("k"))
                        {
                            String options4 = recordMenu();
                            if(options4.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter Key info\n");
                                System.out.println("Entry Date: ('yyyymmdd')");
                                long entdate = Long.parseLong(input2.nextLine());
                                System.out.println("Key#: ");
                                String keynum = input2.nextLine();
                                System.out.println("Key Name: ");
                                String keyname = input2.nextLine();
                                System.out.println("Loanee Firstname: ");
                                String lfname = input2.nextLine();
                                System.out.println("Loanee Lastname: ");
                                String llname = input2.nextLine();
                                System.out.println("Time loaned: 'HH:MM A.M./P.M.'");
                                String timeloaned = input2.nextLine();
                                System.out.println("Purpose: ");
                                String purp = input2.nextLine();
                                log.createKey(keynum, keyname, entdate, lfname, llname, timeloaned, purp);
                                log.updateKeyReturnTime(log.getKeyEntryNo(), "");
                                log.displayAllKeys();
                            }
                            else if(options4.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input3.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input3.nextLine());
                                log.updateKeyReturnTime(entnum, exit);
                                log.displayAllKeys();
                            }
                            else if(options4.equalsIgnoreCase("v"))
                            {
                                log.displayAllKeys();
                            }
                            else if(options4.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options3.equalsIgnoreCase("d"))
                        {
                            String options5 = recordMenu();
                            if(options5.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter Driver info\n");
                                System.out.println("Firstname:");
                                String fname = input5.nextLine();
                                System.out.println("Lastname:");
                                String lname = input5.nextLine();
                                System.out.println("EntryDate: ('yyyymmdd')");
                                long date = Long.parseLong(input5.nextLine());
                                System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                                String timein = input5.nextLine();
                                System.out.println("Purpose of visit:");
                                String purpose = input5.nextLine();
                                System.out.println("License#:");
                                String lnum = input5.nextLine();
                                System.out.println("Color:");
                                String color = input5.nextLine();
                                System.out.println("Make:");
                                String make = input5.nextLine();
                                System.out.println("Model:");
                                String model = input5.nextLine();
                                log.createDriver(fname, lname, date, timein, purpose, lnum, color, make, model);
                                log.updateDriverExit(log.getDriverEntryNo(), "");
                                log.displayAllDrivers();
                            }
                            else if(options5.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input4.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input4.nextLine());
                                log.updateDriverExit(entnum, exit);
                                log.displayAllDrivers();
                            }
                            else if(options5.equalsIgnoreCase("v"))
                            {
                                log.displayAllDrivers();
                            }
                            else if(options5.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options3.equalsIgnoreCase("p"))
                        {
                            String options6 = recordMenu();
                            if(options6.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter pedestrian info");
                                System.out.println("Firstname:");
                                String fname = input6.nextLine();
                                System.out.println("Lastname:");
                                String lname = input6.nextLine();
                                System.out.println("EntryDate: ('yyyymmdd')");
                                long date = Long.parseLong(input6.nextLine());
                                System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                                String timein = input6.nextLine();
                                System.out.println("Purpose of visit:");
                                String purpose = input6.nextLine();
                                log.createPedestrian(fname, lname, date, timein, purpose);
                                log.updatePedestrianExit(log.getPedestrianEntryNo(), "");
                                log.displayAllPedestrians();
                            }
                            else if(options6.equalsIgnoreCase("u"))
                            {
                                
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input7.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input7.nextLine());
                                log.updatePedestrianExit(entnum, exit);
                                log.displayAllPedestrians();
                            }
                            else if(options6.equalsIgnoreCase("v"))
                            {
                                log.displayAllPedestrians();
                            }
                            else if(options6.equalsIgnoreCase("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                session = false;
                                System.exit(0);
                            } 
                        }
                        else if(options3.equalsIgnoreCase("dv"))
                        {
                            String options7 = recordMenu();
                            if(options7.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter Dorm Visitor info\n");
                                System.out.println("Firstname:");
                                String fname = input8.nextLine();
                                System.out.println("Lastname:");
                                String lname = input8.nextLine();
                                System.out.println("EntryDate: ('yyyymmdd')");
                                long date = Long.parseLong(input8.nextLine());
                                System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                                String timein = input8.nextLine();
                                System.out.println("Purpose of visit:");
                                String purpose = input8.nextLine();
                                System.out.println("Visitor ID#:");
                                long vtorid = Long.parseLong(input8.nextLine());
                                System.out.println("Visitee Firstname:");
                                String vfname = input8.nextLine();
                                System.out.println("Visitee Lastname:");
                                String vlname = input8.nextLine();
                                System.out.println("Visitee ID#:");
                                long vteeid = Long.parseLong(input8.nextLine());
                                log.createDormVisitor(fname, lname, date, timein, purpose, vtorid, vfname, vlname, vteeid);
                                log.updateDormVisitorExit(log.getDormVisitorEntryNo(), "");
                                log.displayAllDormVisitors();
                            }
                            else if(options7.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input9.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input9.nextLine());
                                log.updateDormVisitorExit(entnum, exit);
                                log.displayAllDormVisitors();
                            }
                            else if(options7.equalsIgnoreCase("v"))
                            {
                                log.displayAllDormVisitors();
                            }
                            else if(options7.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        } 
                        else if(options3.equalsIgnoreCase("l"))
                        {
                            log.saveLists();
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                        } 
                        options3 = psMenu();
                    }
                }
                else if(log.checkCredentials(password, username, type) == false)
                {
                    x++;
                    if(x <= 2)
                    {
                        System.out.println("\nInvalid Credentials!");
                    }
                    else if(x == 2)
                    {
                        System.out.println("\nFinal Attempt!");
                    }
                }
            }
            System.out.println("No more attempts!\n\n\n\n");
            log.saveLists();
            goodbyeMessage();
            System.exit(0);
        }
        else if(options.equalsIgnoreCase("ss"))
        {
            while(x < 3)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                String type = "securitysupervisor";
                if(log.checkCredentials(password, username, type) == true)
                {
                    while(session)
                    {
                        String options8 = ssMenu();
                        if(options8.equalsIgnoreCase("k"))
                        {
                            String options9 = recordMenu();
                            if(options9.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter Key info\n");
                                System.out.println("Entry Date: ('yyyymmdd')");
                                long entdate = Long.parseLong(input2.nextLine());
                                System.out.println("Key#: ");
                                String keynum = input2.nextLine();
                                System.out.println("Key Name: ");
                                String keyname = input2.nextLine();
                                System.out.println("Loanee Firstname: ");
                                String lfname = input2.nextLine();
                                System.out.flush();
                                System.out.println("Loanee Lastname: ");
                                String llname = input2.nextLine();
                                System.out.println("Time loaned: 'HH:MM A.M./P.M.'");
                                String timeloaned = input2.nextLine();
                                System.out.println("Purpose: ");
                                String purp = input2.nextLine();
                                log.createKey(keynum, keyname, entdate, lfname, llname, timeloaned, purp);
                                log.updateKeyReturnTime(log.getKeyEntryNo(), "");
                                log.displayAllKeys();
                            }
                            else if(options9.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input3.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input3.nextLine());
                                log.updateKeyReturnTime(entnum, exit);
                                log.displayAllKeys();
                            }
                            else if(options9.equalsIgnoreCase("v"))
                            {
                                log.displayAllKeys();
                            }
                            else if(options9.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options8.equalsIgnoreCase("d"))
                        {
                            String options10 = recordMenu();
                            if(options10.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter Driver info\n");
                                System.out.println("Firstname:");
                                String fname = input5.nextLine();
                                System.out.println("Lastname:");
                                String lname = input5.nextLine();
                                System.out.println("EntryDate: ('yyyymmdd')");
                                long date = Long.parseLong(input5.nextLine());
                                System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                                String timein = input5.nextLine();
                                System.out.println("Purpose of visit:");
                                String purpose = input5.nextLine();
                                System.out.println("License#:");
                                String lnum = input5.nextLine();
                                System.out.println("Color:");
                                String color = input5.nextLine();
                                System.out.println("Make:");
                                String make = input5.nextLine();
                                System.out.println("Model:");
                                String model = input5.nextLine();
                                log.createDriver(fname, lname, date, timein, purpose, lnum, color, make, model);
                                log.updateDriverExit(log.getDriverEntryNo(), "");
                                log.displayAllDrivers();
                            }
                            else if(options10.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input4.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input4.nextLine());
                                log.updateDriverExit(entnum, exit);
                                log.displayAllDrivers();
                            }
                            else if(options10.equalsIgnoreCase("v"))
                            {
                                log.displayAllDrivers();
                            }
                            else if(options10.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options8.equalsIgnoreCase("p"))
                        {
                            String options11 = recordMenu();
                            if(options11.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter pedestrian info");
                                System.out.println("Firstname:");
                                String fname = input6.nextLine();
                                System.out.println("Lastname:");
                                String lname = input6.nextLine();
                                System.out.println("EntryDate: ('yyyymmdd')");
                                long date = Long.parseLong(input6.nextLine());
                                System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                                String timein = input6.nextLine();
                                System.out.println("Purpose of visit:");
                                String purpose = input6.nextLine();
                                log.createPedestrian(fname, lname, date, timein, purpose);
                                log.updatePedestrianExit(log.getPedestrianEntryNo(), "");
                                log.displayAllPedestrians();
                            }
                            else if(options11.equalsIgnoreCase("u"))
                            {
                                
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input7.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input7.nextLine());
                                log.updatePedestrianExit(entnum, exit);
                                log.displayAllPedestrians();
                            }
                            else if(options11.equalsIgnoreCase("v"))
                            {
                                log.displayAllPedestrians();
                            }
                            else if(options11.equalsIgnoreCase("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                session = false;
                                System.exit(0);
                            } 
                        }
                        else if(options8.equalsIgnoreCase("dv"))
                        {
                            String options12 = recordMenu();
                            if(options12.equalsIgnoreCase("c"))
                            {
                                System.out.println("Enter Dorm Visitor info\n");
                                System.out.println("Firstname:");
                                String fname = input8.nextLine();
                                System.out.println("Lastname:");
                                String lname = input8.nextLine();
                                System.out.println("EntryDate: ('yyyymmdd')");
                                long date = Long.parseLong(input5.nextLine());
                                System.out.println("EntryTime: 'HH:MM P.M./A.M.'");
                                String timein = input8.nextLine();
                                System.out.println("Purpose of visit:");
                                String purpose = input8.nextLine();
                                System.out.println("Visitor ID#:");
                                long vtorid = Long.parseLong(input8.nextLine());
                                System.out.println("Visitee Firstname:");
                                String vfname = input8.nextLine();
                                System.out.println("Visitee Lastname:");
                                String vlname = input8.nextLine();
                                System.out.println("Visitee ID#:");
                                long vteeid = Long.parseLong(input8.nextLine());
                                log.createDormVisitor(fname, lname, date, timein, purpose, vtorid, vfname, vlname, vteeid);
                                log.updateDormVisitorExit(log.getDormVisitorEntryNo(), "");
                                log.displayAllDormVisitors();
                            }
                            else if(options12.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input9.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input9.nextLine());
                                log.updateDormVisitorExit(entnum, exit);
                                log.displayAllDormVisitors();;
                            }
                            else if(options12.equalsIgnoreCase("v"))
                            {
                                log.displayAllDormVisitors();
                            }
                            else if(options12.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options8.equalsIgnoreCase("g"))
                        {
                            System.out.flush();
                            System.out.println("Start date: 'yyyymmdd'");
                            long start = Long.parseLong(input10.nextLine());
                            System.out.println("End date: 'yyyymmdd'");
                            long end = Long.parseLong(input10.nextLine());
                            String options13 = psMenu();
                            if(options13.equalsIgnoreCase("k"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "key";
                                String timeperiod = start + "" + end;
                                String info = log.displayKeysByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options13.equalsIgnoreCase("d"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "driver";
                                String timeperiod = start + "" + end;
                                String info = log.displayDriverByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options13.equalsIgnoreCase("p"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "pedestrian";
                                String timeperiod = start + "" + end;
                                String info = log.displayPedestrianByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options13.equalsIgnoreCase("dv"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                System.out.println(fname);
                                String lname = log.getUserLName(username);
                                System.out.println(fname);
                                String rtype = "dormvisitor";
                                String timeperiod = start + "" + end;
                                System.out.println(timeperiod);
                                String info = log.displayDormVisitorByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options13.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        } 
                        else if(options8.equalsIgnoreCase("v"))
                        {
                            String options14 = psMenu();
                            if(options14.equalsIgnoreCase("k"))
                            {
                                //String rtype = "KEY";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options14.equalsIgnoreCase("d"))
                            {
                                //String rtype = "DRIVER";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options14.equalsIgnoreCase("p"))
                            {
                                //String rtype = "PEDESTRIAN";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options14.equalsIgnoreCase("dv"))
                            {
                                //String rtype = "DORMVISITOR";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options14.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options8.equalsIgnoreCase("l"))
                        {
                            log.saveLists();
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                        } 
                        options8 = ssMenu();
                    }
                }
                else if(log.checkCredentials(password, username, type) == false)
                {
                    x++;
                    if(x <= 2)
                    {
                        System.out.println("\nInvalid Credentials!");
                    }
                    else if(x == 2)
                    {
                        System.out.println("\nFinal Attempt!");
                    }
                }
            }
            System.out.println("No more attempts!\n\n\n\n");
            log.saveLists();
            goodbyeMessage();
            System.exit(0);
        }
        else if(options.equalsIgnoreCase("cd"))
        {
            while(x < 3)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                String type = "campusdirector";
                if(log.checkCredentials(password, username, type) == true)
                {
                    while(session)
                    {
                        String options15 = cdMenu();
                        if(options15.equalsIgnoreCase("g"))
                        {
                            System.out.println("Start date: 'yyyymmdd'");
                            long start = Long.parseLong(input10.nextLine());
                            System.out.println("End date: 'yyyymmdd'");
                            long end = Long.parseLong(input10.nextLine());
                            String options16 = psMenu();
                            if(options16.equalsIgnoreCase("k"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "key";
                                String timeperiod = start + "" + end;
                                String info = log.displayKeysByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options16.equalsIgnoreCase("d"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "driver";
                                String timeperiod = start + "" + end;
                                String info = log.displayDriverByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options16.equalsIgnoreCase("p"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "pedestrian";
                                String timeperiod = start + "" + end;
                                String info = log.displayPedestrianByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options16.equalsIgnoreCase("dv"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "dormvisitor";
                                String timeperiod = start + "" + end;
                                String info = log.displayDormVisitorByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options16.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        } 
                        else if(options15.equalsIgnoreCase("v"))
                        {
                            String options17 = psMenu();
                            if(options17.equalsIgnoreCase("k"))
                            {
                                //String rtype = "KEY";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options17.equalsIgnoreCase("d"))
                            {
                                //String rtype = "DRIVER";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options17.equalsIgnoreCase("p"))
                            {
                                //String rtype = "PEDESTRIAN";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options17.equalsIgnoreCase("dv"))
                            {
                                //String rtype = "DORMVISITOR";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options17.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options15.equalsIgnoreCase("va"))
                        {
                            log.viewAllReports();
                        }
                        else if(options15.equalsIgnoreCase("l"))
                        {
                            log.saveLists();
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                        }
                        options15 = cdMenu();
                    }
                }
                else if(log.checkCredentials(password, username, type) == false)
                {
                    x++;
                    if(x <= 2)
                    {
                        System.out.println("\nInvalid Credentials!");
                    }
                    else if(x == 2)
                    {
                        System.out.println("\nFinal Attempt!");
                    }
                }
            }
            System.out.println("No more attempts!\n\n\n\n");
            log.saveLists();
            goodbyeMessage();
            session = false;
            System.exit(0);
        }
        else if(options.equalsIgnoreCase("cp"))
        {
            while(x < 3)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                String type = "campuspolice";
                if(log.checkCredentials(password, username, type) == true)
                {
                    while(session)
                    {
                        String options18 = cpMenu();
                        if(options18.equalsIgnoreCase("r"))
                        {
                            System.out.println("Enter Driver info\n");
                            System.out.println("Firstname:");
                            String fname = input5.nextLine();
                            System.out.println("Lastname:");
                            String lname = input5.nextLine();
                            System.out.println("School Member Type: ");
                            String stype = input5.nextLine();
                            System.out.println("ID#: ");
                            long id = Long.parseLong(input5.nextLine());
                            System.out.println("Registration Date: ('yyyymmdd')");
                            long date = Long.parseLong(input5.nextLine());
                            System.out.println("License#:");
                            String lnum = input5.nextLine();
                            System.out.println("Color:");
                            String color = input5.nextLine();
                            System.out.println("Make:");
                            String make = input5.nextLine();
                            System.out.println("Model:");
                            String model = input5.nextLine();
                            log.createSchoolMember(fname, lname, stype, id, date, lnum, color, make, model);
                            log.displayAllSchoolMembers();
                        }
                        else if(options18.equalsIgnoreCase("a"))
                        {
                            System.out.println("Register another vehicle for a school member");
                            System.out.println("ID#: ");
                            long idnum = Long.parseLong(input6.nextLine());
                            System.out.println("License#:");
                            String lnum = input6.nextLine();
                            System.out.println("Color:");
                            String col = input6.nextLine();
                            System.out.println("Make:");
                            String mk = input6.nextLine();
                            System.out.println("Model:");
                            String mod = input6.nextLine();
                            log.addVehicle(idnum, lnum, col, mk, mod);
                            log.displayAllSchoolMembers();
                        }
                        else if(options18.equalsIgnoreCase("d"))
                        {
                            System.out.println("ID#: ");
                            long idnumber = Long.parseLong(input7.nextLine());
                            log.deleteSchoolMember(idnumber);
                            log.displayAllSchoolMembers();
                        }
                        else if(options18.equalsIgnoreCase("dv"))
                        {
                            System.out.println("License#: ");
                            String lnum = input8.nextLine();
                            log.deregisterVehicle(lnum);
                            log.displayAllSchoolMembers();
                        }
                        else if(options18.equalsIgnoreCase("vs"))
                        {
                            log.displayAllSchoolMembers();
                        }
                        else if(options18.equalsIgnoreCase("g"))
                        {
                            System.out.println("Start date: 'yyyymmdd'");
                            long start = Long.parseLong(input10.nextLine());
                            System.out.println("End date: 'yyyymmdd'");
                            long end = Long.parseLong(input10.nextLine());
                            String options19 = psMenu();
                            if(options19.equalsIgnoreCase("k"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "key";
                                String timeperiod = start + "" + end;
                                String info = log.displayKeysByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options19.equalsIgnoreCase("d"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "driver";
                                String timeperiod = start + "" + end;
                                String info = log.displayDriverByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options19.equalsIgnoreCase("p"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "pedestrian";
                                String timeperiod = start + "" + end;
                                String info = log.displayPedestrianByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options19.equalsIgnoreCase("dv"))
                            {
                                long id = log.getUserID(username);
                                String fname = log.getUserFName(username);
                                String lname = log.getUserLName(username);
                                String rtype = "dormvisitor";
                                String timeperiod = start + "" + end;
                                String info = log.displayDormVisitorByDate(start, end);
                                if(!info.equals(""))
                                {
                                    log.createReport(fname, lname, type, id, info, rtype, timeperiod);
                                    log.viewAllReports();
                                }
                                else
                                {
                                    System.out.println("No records for selected period");
                                }
                            }
                            else if(options19.equals("l"))
                            {
                                log.saveLists();   
                                goodbyeMessage();
                                System.exit(0);
                            }
                        } 
                        else if(options18.equalsIgnoreCase("v"))
                        {
                            String options20 = psMenu();
                            if(options20.equalsIgnoreCase("k"))
                            {
                                //String rtype = "KEY";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options20.equalsIgnoreCase("d"))
                            {
                                //String rtype = "DRIVER";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options20.equalsIgnoreCase("p"))
                            {
                                //String rtype = "PEDESTRIAN";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options20.equalsIgnoreCase("dv"))
                            {
                                //String rtype = "DORMVISITOR";
                                System.out.println("Entry#");
                                int num = Integer.parseInt(input11.nextLine());
                                log.viewReport(num);
                            }
                            else if(options20.equals("l"))
                            {
                                log.saveLists();
                                goodbyeMessage();
                                System.exit(0);
                            }
                        }
                        else if(options18.equalsIgnoreCase("l"))
                        {
                            log.saveLists();
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                        }
                        options18 = cpMenu();
                    }
                }
                else if(log.checkCredentials(password, username, type) == false)
                {
                    x++;
                    if(x <= 2)
                    {
                        System.out.println("\nInvalid Credentials!");
                    }
                    else if(x == 2)
                    {
                        System.out.println("\nFinal Attempt!");
                    }
                }
            }
            System.out.println("No more attempts!\n\n\n\n");
            
            log.saveLists();
            goodbyeMessage();
            session = false;
            System.exit(0);
        } 
        else if(options.equalsIgnoreCase("l"))
        {
            log.saveLists();
            goodbyeMessage();
            System.exit(0);
        }     
    }
}