//import java.time.*;
import java.util.*;
import java.io.*;

public class DriverTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Driver drive1 = new Driver("Lucy", "Hale", 20190926L, "12:00 P.M.", "Meeting with campus director", "AB1234", "Blue", "Honda", "Fit");
        

        System.out.println("Enter driver info\n");
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
        String model = input.nextLine();
        Driver drive2 = new Driver(fname, lname, date, timein, purpose, lnum, color, make, model);
        System.out.println("\n\n");

        System.out.println(drive1.getEntryNo());
        System.out.println(drive1.getName());
        System.out.println(drive1.toString(drive1.getEntryDate()));
        System.out.println(drive1.getEntryTime());
        System.out.println(drive1.getPurpose());
        System.out.println(drive1.getLicenseNum());
        System.out.println(drive1.getColor());
        System.out.println(drive1.getMake());
        System.out.println(drive1.getModel());
        System.out.println("\n\n");

        System.out.println(drive2.getEntryNo());
        System.out.println(drive2.getName());
        System.out.println(drive2.getEntryDate());
        System.out.println(drive2.getEntryTime());
        System.out.println(drive2.getPurpose());
        System.out.println(drive2.getLicenseNum());
        System.out.println(drive2.getColor());
        System.out.println(drive2.getMake());
        System.out.println(drive2.getModel());
        System.out.println("\n\n");

        drive1.setExitTime("2:00 P.M.");
        System.out.println("Enter ExitTime:");
        String extime = input.next();
        drive2.setExitTime(extime);

        System.out.println(drive1.toString());
        System.out.println("\n\n");
        System.out.println(drive2.toString());
        System.out.println("\n\n");

        System.out.println("Aite Bye! :)");
    }
}