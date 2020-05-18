package campussecure.log;

import java.io.Serializable;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Report implements Serializable
{
    private Name name;
    private UserType utype;
    private LocalDate dategen;
    private LocalTime timegen;
    private String reportInfo;
    private ReportType rtype;
    private String timeperiod;
    private long uID;
    private int entryNo;

    public Report(String fname, String lname, String utype, long uID, String reportInfo, String rtype, String timeperiod)
    {
        this.name = new Name(fname, lname);
        this.utype = UserType.valueOf(utype.toUpperCase());
        this.uID = uID;
        this.reportInfo = reportInfo;
        this.rtype = ReportType.valueOf(rtype.toUpperCase());
        this.timeperiod = timeperiod;
        this.dategen = LocalDate.now();
        this.timegen = LocalTime.now();
    }

    public void setEntryNo(int num)
    {
        this.entryNo = num;
    }

    public int getEntryNo()
    {
        return this.entryNo;
    }

    private String formatDate(LocalDate localDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String formattedDate = formatter.format(localDate);
        return formattedDate; 
    }

    private String formatTime(LocalTime localTime)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        String formattedTime = formatter.format(localTime);
        return formattedTime;
    }

    public String getName()
    {
        return this.name.getFullName();
    }

    public UserType getUserType()
    {
        return this.utype;
    }

    public String getDate()
    {
        return formatDate(this.dategen);
    }

    public String getTime()
    {
        return formatTime(this.timegen);
    }

    public String getReportInfo()
    {
        return this.reportInfo;
    }

    public ReportType getReportType()
    {
        return this.rtype;
    }

    public String getTimePeriod()
    {
        String start1 = this.timeperiod.substring(0,4);
        String start2 = this.timeperiod.substring(4,6);
        String start3 = this.timeperiod.substring(6,8);
        String end1 = this.timeperiod.substring(8,12);
        String end2 = this.timeperiod.substring(12,14);
        String end3 = this.timeperiod.substring(14);
        String period = start1 + "/" + start2 + "/" + start3 + " - " + end1 + "/" + end2 + "/" + end3; 
        return period;
    }

    public long getID()
    {
        return this.uID;
    }

    public String toString(long record)
    {
        String newrecord = ""+record+"";
        return newrecord;
    }

    public String toString()
    {
        String record = "Report#: " + getEntryNo() + "\n" + getReportType() + " Report\n" + "Time Period: " + getTimePeriod() + "\n\n" + getReportInfo() + "\n\nName: " + getName() + "\nID#: " + toString(getID()) + "\nDate: " + getDate() + "\nTime: " + getTime();
        return record;
    }
}