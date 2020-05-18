import java.io.Serializable;

public class Key implements Serializable
{
	
	private String keyNum;
	private String keyName;
	private long keyDate;
	
	public Key(String num, String name, long date) 
	{
		keyNum = num;
		keyName = name;
		keyDate = date;
	}
	
	/*public void setKeyNum(String num) 
	{
		keyNum = num;
	}
	
	public void setKeyName(String name) 
	{
		keyName = name;
	}*/
	
	public String getKeyNum() 
	{
		return keyNum;
	}
	
	public String getKeyName() 
	{
		return keyName;
	}
	
	public long getKeyDate() 
	{
		return keyDate;
	}

	public String toString(long record)
    {
        String newrec = ""+record+"";
        String newrecord = newrec.substring(0,4) + "-" + newrec.substring(4,6) + "-" + newrec.substring(6);
        return newrecord;
    }
}
