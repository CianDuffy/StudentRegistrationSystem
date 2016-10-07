package com.CianDuffy.CT417;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by cianduffy on 07/10/2016.
 */
public class UtilityManagerTest extends TestCase
{
    UtilityManager utilityManager;
    DateTimeFormatter dateTimeFormatter;

    @Override
    protected void setUp()
    {
        utilityManager = UtilityManager.getInstance();
        dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");
    }

    public void testStringForDateTime()
    {
        String expectedString = "01/01/2000";
        String actualString = utilityManager.stringFromDateTime(dateTimeFormatter.parseDateTime("01/01/2000"));

        assertEquals(expectedString, actualString);
    }

    public void testDateTimeForString()
    {
        DateTime expectedDateTime = dateTimeFormatter.parseDateTime("01/01/2000");
        DateTime actualDateTime = utilityManager.dateTimeFromString("01/01/2000");

        assertEquals(expectedDateTime, actualDateTime);
    }
}
