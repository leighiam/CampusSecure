import java.util.*;
import java.io.*;
public class DataManager

{
	public void save(String fileName, ArrayList<Object> object)
	{
		String output = "Successfully save!";
		try
		{
			FileOutputStream fout= new FileOutputStream (fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(object);
			fout.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			e2.printStackTrace();
		}
    }
    
    public void saveUser(String fileName, ArrayList<User> user)
	{
		String output = "Successfully save!";
		try
		{
			FileOutputStream fout= new FileOutputStream (fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(user);
			fout.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			e2.printStackTrace();
		}
	}
    
    public void saveDriver(String fileName, ArrayList<Driver> driver)
	{
		String output = "Successfully save!";
		try
		{
			FileOutputStream fout= new FileOutputStream (fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(driver);
			fout.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			e2.printStackTrace();
		}
    }
    
    public void savePedestrian(String fileName, ArrayList<Pedestrian> pedestrian)
	{
		String output = "Successfully save!";
		try
		{
			FileOutputStream fout= new FileOutputStream (fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(pedestrian);
			fout.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			e2.printStackTrace();
		}
    }
    
    public void saveKey(String fileName, ArrayList<KeyManager> key)
	{
		String output = "Successfully save!";
		try
		{
			FileOutputStream fout= new FileOutputStream (fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(key);
			fout.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			e2.printStackTrace();
		}
	}


	public ArrayList<Object> read(String fileName, ArrayList<Object> object) 
	{
		String output = "Successfully saved!";
		try
		{
			FileInputStream fin= new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			object = (ArrayList<Object>)ois.readObject();
			fin.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			System.out.println(output);
		}
		catch(ClassNotFoundException e3)
		{
			output = "Cannot acces file class.";
			System.out.println(output);
		}
		return object;
	}
    
    public ArrayList<User> readUser(String fileName, ArrayList<User> user) 
	{
		String output = "Successfully saved!";
		try
		{
			FileInputStream fin= new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			user = (ArrayList<User>)ois.readObject();
			fin.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			System.out.println(output);
		}
		catch(ClassNotFoundException e3)
		{
			output = "Cannot acces file class.";
			System.out.println(output);
		}
		return user;
    }
    
    public ArrayList<Driver> readDriver(String fileName, ArrayList<Driver> driver) 
	{
		String output = "Successfully saved!";
		try
		{
			FileInputStream fin= new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			driver = (ArrayList<Driver>)ois.readObject();
			fin.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			System.out.println(output);
		}
		catch(ClassNotFoundException e3)
		{
			output = "Cannot acces file class.";
			System.out.println(output);
		}
		return driver;
    }
    
    public ArrayList<KeyManager> readKey(String fileName, ArrayList<KeyManager> key) 
	{
		String output = "Successfully saved!";
		try
		{
			FileInputStream fin= new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			key = (ArrayList<KeyManager>)ois.readObject();
			fin.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			System.out.println(output);
		}
		catch(ClassNotFoundException e3)
		{
			output = "Cannot acces file class.";
			System.out.println(output);
		}
		return key;
	}
     
    
    public ArrayList<Pedestrian> readPedestrian(String fileName, ArrayList<Pedestrian> pedestrian) 
	{
		String output = "Successfully saved!";
		try
		{
			FileInputStream fin= new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			pedestrian = (ArrayList<Pedestrian>)ois.readObject();
			fin.close();
		}
		catch(FileNotFoundException e1)
		{
			output = "File does not exist.";
			System.out.println(output);
		}
		catch(IOException e2)
		{
			output = "Cannot access file.";
			System.out.println(output);
		}
		catch(ClassNotFoundException e3)
		{
			output = "Cannot acces file class.";
			System.out.println(output);
		}
		return pedestrian;
	}
}