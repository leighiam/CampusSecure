//import java.time.*;
import java.util.*;
import java.io.*;

public class PedestrianTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Pedestrian ped1 = new Pedestrian("Lucy", "Hale", 20190926L, "12:00 P.M.", "Meeting with campus director");
        

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
        String purpose = input.nextLine();
        Pedestrian ped2 = new Pedestrian(fname, lname, date, timein, purpose);
        System.out.println("\n\n");

        System.out.println(ped1.getEntryNo());
        System.out.println(ped1.getName());
        System.out.println(ped1.getEntryDate());
        System.out.println(ped1.getEntryTime());
        System.out.println(ped1.getPurpose());
        System.out.println("\n\n");

        System.out.println(ped2.getEntryNo());
        System.out.println(ped2.getName());
        System.out.println(ped2.getEntryDate());
        System.out.println(ped2.getEntryTime());
        System.out.println(ped2.getPurpose());
        System.out.println("\n\n");

        ped1.setExitTime("2:00 P.M.");
        System.out.println("Enter ExitTime:");
        String extime = input.next();
        ped2.setExitTime(extime);

        System.out.println(ped1.toString());
        System.out.println("\n\n");
        System.out.println(ped2.toString());
        System.out.println("\n\n");

        System.out.println("Aite Bye! :)");
    }
}