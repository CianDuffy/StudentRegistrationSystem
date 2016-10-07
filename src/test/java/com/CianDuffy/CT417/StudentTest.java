package com.CianDuffy.CT417;

import junit.framework.TestCase;
import org.joda.time.DateTime;

/**
 * Created by cianduffy on 30/09/2016.
 * Unit tests for Student Class.
 */
public class StudentTest extends TestCase
{
    private Student testStudent;
    private UtilityManager utilityManager;

    @Override
    protected void setUp()
    {
        utilityManager = UtilityManager.getInstance();
        testStudent = new Student("Nick Faldo", utilityManager.dateTimeFromString("01/01/1994"), "1234567");
    }

    public void testGetUsername()
    {
        String expectedUsername = "nickfaldo22";
        String actualUsername = testStudent.getUsername();

        assertEquals(expectedUsername, actualUsername);
    }

    public void testGetAge()
    {
        int expectedAge = 22;
        int actualAge = testStudent.getAge();

        assertEquals(expectedAge, actualAge);
    }

    public void testToString()
    {
        String expectedString = "Name:\tNick Faldo\tDOB:\t01/01/1994\tUsername:\tnickfaldo22";
        String actualString = testStudent.toString();

        assertEquals(expectedString, actualString);
    }
}