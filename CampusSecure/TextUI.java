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
            System.out.println("Select user type\n\nA - ADMIN\nS - STANDARD\nG - GUEST\nE - End Session");
            answer = input.next();
        }
        return answer;
    }

    public String adminMenu()
    {
        System.out.println("R - Reset user info\nC - Create new user\nG - Generate Report\nE - End Session");
        String answer1 = input.next();
        return answer1;
    }

    public String standardMenu()
    {
        System.out.println("\nK - Keys\nD - Driver\nP - Pedestrian\nM - Main Menu\nE - End Session");
        String answer2 = input.next();
        return answer2;
    }

    public String recordMenu()
    {
        System.out.println("C - Create Record\nU - Update Record\nM - Main Menu\nE - End Session");
        String answer4 = input.next();
        return answer4;
    }

    public String updateMenu()
    {
        System.out.println("First Name: - update first name");
        System.out.println("Last Name: - update lastname");
		System.out.println("Username: - update username");
		System.out.println("Password: - update password");
        System.out.println("ID#: - update phone number");
        System.out.println("M - Main Menu");
        System.out.println("E - End Session");
		String answer3 = input.next();
		return answer3;
    }

    public void logMenu()
    {
        boolean session = true;
        String options = signInMenu();
        int x = 0;
        int y = 0;

        if(options.equalsIgnoreCase("a"))
        {
            while(x < 5)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                System.out.println("Type: ");
                String type = input2.nextLine();
                if(log.checkCredentials(password, username, type) == true)
                {     
                    String options1 = adminMenu();
                    while(session)
                    {
                        if(options1.equalsIgnoreCase("r"))
                        {
                            String response = updateMenu();
                            if(response.equalsIgnoreCase("firstname"))
                            {
                                System.out.println("Firstname: ");
                                String fname = input2.nextLine();
                                System.out.println("Username: ");
                                String name = input2.next();
                                log.resetUser(name, "firstname", fname);
                                log.displayUsers();
                            }
                            else if(response.equalsIgnoreCase("lastname"))
                            {
                                System.out.println("Lastname: ");
                                String lname = input2.nextLine();
                                System.out.println("Username: ");
                                String name = input2.next();
                                log.resetUser(name, "lastname", lname);
                                log.displayUsers();
                            }
                            else if(response.equalsIgnoreCase("username"))
                            {
                                System.out.println("Username: ");
                                String uname = input2.nextLine();
                                System.out.println("Old Username: ");
                                String name = input2.next();
                                log.resetUser(name, "username", uname);
                                log.displayUsers();
                            }
                            else if(response.equalsIgnoreCase("password"))
                            {
                                System.out.println("Password: ");
                                String pword = input2.nextLine();
                                System.out.println("Username: ");
                                String name = input2.next();
                                log.resetUser(name, "password", pword);
                                log.displayUsers();
                            }
                            else if(response.equalsIgnoreCase("id"))
                            {
                                System.out.println("ID#: ");
                                String id = input2.nextLine();
                                System.out.println("Username: ");
                                String name = input2.next();
                                log.resetUser(name, "id", id);
                                log.displayUsers();
                            }
                        }
                        else if(options1.equalsIgnoreCase("c"))
                        {
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
                            System.out.println("Type: ");
                            String ty = input3.next();
                            log.createUser(fname, lname, uname, pword, id, ty);
                            log.displayUsers();
                        }
                        else if(options1.equalsIgnoreCase("g"))
                        {
                            System.out.println("Start date: 'yyyymmdd'");
                            long start = Long.parseLong(input4.nextLine());
                            System.out.println("End date: 'yyyymmdd'");
                            long end = Long.parseLong(input4.next());
                            String options2 = standardMenu();
                            if(options2.equalsIgnoreCase("k"))
                            {
                                System.out.println(log.displayKeysByDate(start, end));
                            }
                            else if(options2.equalsIgnoreCase("d"))
                            {
                                System.out.println(log.displayDriverByDate(start, end));
                            }
                            else if(options2.equalsIgnoreCase("p"))
                            {
                                System.out.println(log.displayPedestrianByDate(start, end));
                            }
                            /*else if(options2.equalsIgnoreCase("m"))
                            {
                                options2 = adminMenu();
                            }*/
                            else if(options2.equalsIgnoreCase("e"))
                            {
                                goodbyeMessage();
                                session = false;
                                System.exit(0);
                                log.saveLists();
                            }
                        }
                        /*else if(options1.equalsIgnoreCase("m"))
                        {
                            options1 = adminMenu();
                        }*/
                        else if(options1.equalsIgnoreCase("e"))
                        {
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                            log.saveLists();
                        }
                        options1 = adminMenu();
                    }
                }
                else if(log.checkCredentials(password, username, type) == false)
                {
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
            goodbyeMessage();
            System.exit(0);
            log.saveLists();
        }
        else if(options.equalsIgnoreCase("s"))
        {
            while(x < 5)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                System.out.println("Type: ");
                String type = input2.nextLine();
                if(log.checkCredentials(password, username, type) == true)
                {
                    while(session)
                    {
                        String options3 = standardMenu();
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
                                System.out.println("Number of keys loaned");
                                int numkeysloaned = Integer.parseInt(input2.nextLine());
                                System.out.println("Time loaned: 'HH:MM A.M./P.M.'");
                                String timeloaned = input2.nextLine();
                                System.out.println("Purpose: ");
                                String purp = input2.next();
                                log.createKey(keynum, keyname, entdate, lfname, llname, numkeysloaned, timeloaned, purp);
                                log.updateKeyReturnTime(log.getKeyEntryNo(), "");
                                log.displayAllKeys();
                            }
                            else if(options4.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input3.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input3.next());
                                log.updateKeyReturnTime(entnum, exit);
                                log.displayAllKeys();
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
                                long date = Long.parseLong(input.nextLine());
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
                                String model = input5.next();
                                log.createDriver(fname, lname, date, timein, purpose, lnum, color, make, model);
                                log.updateDriverExit(log.getDriverEntryNo(), "");
                                log.displayAllDrivers();
                            }
                            else if(options5.equalsIgnoreCase("u"))
                            {
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input4.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input4.next());
                                log.updateDriverExit(entnum, exit);
                                log.displayAllDrivers();
                            }
                        }
                        else if(options3.equalsIgnoreCase("p"))
                        {
                            String options6 = recordMenu();
                            if(options6.equalsIgnoreCase("c"))
                            {
                                //System.out.println("C - Create Record\nUpdate Record");
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
                                String purpose = input6.next();
                                log.createPedestrian(fname, lname, date, timein, purpose);
                                log.updatePedestrianExit(log.getPedestrianEntryNo(), "");
                                log.displayAllPedestrians();
                            }
                            else if(options6.equalsIgnoreCase("u"))
                            {
                                
                                System.out.println("Exit time: 'HH:MM A.M./P.M.'");
                                String exit = input7.nextLine();
                                System.out.println("Entry number:");
                                int entnum = Integer.parseInt(input7.next());
                                log.updatePedestrianExit(entnum, exit);
                                log.displayAllPedestrians();
                            }
                            /*else if(options6.equalsIgnoreCase("m"))
                            {
                                standardMenu();
                            }*/
                            else if(options6.equalsIgnoreCase("e"))
                            {
                                goodbyeMessage();
                                session = false;
                                System.exit(0);
                                log.saveLists();
                            } 
                        } 
                        /*else if(options3.equalsIgnoreCase("m"))
                        {
                            standardMenu();
                        }*/
                        else if(options3.equalsIgnoreCase("e"))
                        {
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                            log.saveLists();
                        } 
                        options3 = standardMenu();
                    }
                }
                else if(log.checkCredentials(password, username, type) == false)
                {
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
            goodbyeMessage();
            System.exit(0);
            log.saveLists();
        }
        else if(options.equalsIgnoreCase("g"))
        {
            while(x < 5)
            {
                System.out.println("Username: ");
                String username = input2.nextLine();
                System.out.println("Password: ");
                String password = input2.nextLine();
                System.out.println("Type: ");
                String type = input2.nextLine();
                while(session)
                {
                    if(log.checkCredentials(password, username, type) == true)
                    {
                        System.out.println("Start date: 'yyyymmdd'");
                        long start = Long.parseLong(input2.nextLine());
                        System.out.println("End date: 'yyyymmdd'");
                        long end = Long.parseLong(input2.next());
                        String options7 = recordMenu();
                        if(options7.equalsIgnoreCase("k"))
                        {
                            System.out.println(log.displayKeysByDate(start, end));
                        }
                        else if(options7.equalsIgnoreCase("d"))
                        {
                            System.out.println(log.displayDriverByDate(start, end));
                        }
                        else if(options7.equalsIgnoreCase("p"))
                        {
                            System.out.println(log.displayPedestrianByDate(start, end));
                        }
                        /*else if(options7.equalsIgnoreCase("m"))
                        {
                            standardMenu();
                        }*/
                        else if(options7.equalsIgnoreCase("e"))
                        {
                            goodbyeMessage();
                            session = false;
                            System.exit(0);
                            log.saveLists();
                        }
                        options7 = recordMenu();
                    }
                    else if(log.checkCredentials(password, username, type) == false)
                    {
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
            }
            System.out.println("No more attempts!\n\n\n\n");
            goodbyeMessage();
            System.exit(0);
            log.saveLists();
        } 
        else if(options.equalsIgnoreCase("e"))
        {
            goodbyeMessage();
            System.exit(0);
            log.saveLists();
        }     
    }
}