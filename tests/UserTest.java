//import java.time.*;
import java.util.*;
import java.io.*;

public class UserTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        User user1 = new User("Lucy", "Hale", "lucyhale2", "lulu1296", 200929256L, "admin");
        

        System.out.println("Enter pedestrian info");
        System.out.println("Firstname:");
        String fname = input.nextLine();
        System.out.println("Lastname:");
        String lname = input.nextLine();
        System.out.println("Username: ");
        String username = input.nextLine();
        System.out.println("Password: ");
        String password = input.nextLine();
        System.out.println("ID#:");
        long id = Long.parseLong(input.nextLine());
        System.out.println("Type: ");
        String type = input.next();
        User user2 = new User(fname, lname, username, password, id, type);
        System.out.println("\n\n");

        System.out.println(user1.getName());
        System.out.println(user1.getUsername());
        System.out.println(user1.getPassword());
        System.out.println(user1.getID());
        if(user1.authenType(Type.valueOf("ADMIN")) == true)
        {
            System.out.println(user1.getType());
        }
        System.out.println("\n\n");

        System.out.println(user2.getName());
        System.out.println(user2.getUsername());
        System.out.println(user2.getPassword());
        System.out.println(user2.getID());
        if(user2.authenType(Type.valueOf("STANDARD")) == true)
        {
            System.out.println(user2.getType());
        }
        System.out.println("\n\n");

        System.out.println(user1.toString());
        System.out.println("\n\n");
        System.out.println(user2.toString());
        System.out.println("\n\n");

        System.out.println("Aite Bye! :)");
    }
}