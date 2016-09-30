package com.CianDuffy.CT417;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by cianduffy on 30/09/2016.
 * Singleton Object that handles commonly used utility methods.
 */
public class UtilityManager
{
    private static UtilityManager instance = null;
    private DateTimeFormatter dateTimeFormatter;

    private UtilityManager()
    {
        this.dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");
    }

    public static UtilityManager getInstance()
    {
        if (instance == null)
        {
            instance = new UtilityManager();
        }
        return instance;
    }

    public String stringFromDateTime(DateTime dateTime)
    {
        String dateTimeString = this.dateTimeFormatter.print(dateTime);

        return dateTimeString;
    }

    public DateTime dateTimeFromString(String dateTimeString)
    {
        DateTime dateTime =  new DateTime(this.dateTimeFormatter.parseDateTime(dateTimeString));

        return dateTime;
    }
}
