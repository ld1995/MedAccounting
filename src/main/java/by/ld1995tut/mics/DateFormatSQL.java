package by.ld1995tut.mics;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatSQL
{
    public DateFormatSQL(String date)
    {
        getSearchDate(date);
    }

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public static Date getSearchDate(String date)
    {
        java.util.Date docAge = null;
        try {
            docAge = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(docAge.getTime());
        return sqlDate;
    }

    public static java.sql.Time getTimePerson(String timeToday)
    {
        java.util.Date docDate = null;
        try {
            docDate = timeFormat.parse(timeToday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Time time = new java.sql.Time(docDate.getTime());
        return time;
    }
}
