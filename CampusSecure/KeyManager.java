import java.io.*;

public class KeyManager extends Key implements Serializable
{
	
	private Name loaneeName;
	private static int entries;
	private int entryNo;
	private int numOfKeysLoaned;
	private String loanedTime;
	private String returnTime;
	private String keyPurpose;
	
	public KeyManager(String keynum, String keyname, long keydate, String fname, String lname, int numkeysloaned, String timeloaned, String keypurpose) 
	{
		super(keynum, keyname, keydate);
		loaneeName = new Name(fname, lname);
		entries++;
		entryNo = entries;
		numOfKeysLoaned = numkeysloaned;
		loanedTime = timeloaned;
		keyPurpose = keypurpose;
	}
	
	public int getEntryNo()
	{
		return this.entryNo;
	}

	public String getKeyNum() 
	{
		return super.getKeyNum();
	}
	
	public String getKeyName() 
	{
		return super.getKeyName();
	}
	
	public long getKeyDate() 
	{
		return super.getKeyDate();
	}

	public int getNumOfKeys() 
	{
		return this.numOfKeysLoaned;
	}
	
	public void setReturnTime(String rtime) 
	{
		returnTime = rtime;
	}
	
	public String getLoaneeName() 
	{
		return loaneeName.getFullName();
	}
	
	public String getLoanedTime() 
	{
		return loanedTime;
	}
	
	public String getReturnTime() 
	{
		return returnTime;
	}
	
	public String getKeyPurpose() 
	{
		return keyPurpose;
	}

	public String toString()
	{
		String[] names = getLoaneeName().split(" ");
		String record1 = "Entry#: " + getEntryNo() + "\tKey Date: " + super.toString(getKeyDate()) + "\tKey#: " + getKeyNum() + "\tKey Name:" + getKeyName() + "\tLoanee Firstname: " + names[0] + "\tLoannee Lastname: " + names[1];
		String record2 = "\tNumber of Keys Loaned" + getNumOfKeys() + "\tTime Loaned" + getLoanedTime() + "\tPurpose" + getKeyPurpose() + "\tTime Returned: " + getReturnTime();
		String records = record1 + record2 + "\n";
		return records;
	}
}
