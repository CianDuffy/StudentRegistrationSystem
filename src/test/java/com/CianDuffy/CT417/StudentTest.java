package com.CianDuffy.CT417;

import junit.framework.TestCase;

/**
 * Created by cianduffy on 30/09/2016.
 * Unit test for Student Class.
 */
public class StudentTest extends TestCase
{
    private Student testStudent;

    @Override
    protected void setUp()
    {
        UtilityManager utilityManager = UtilityManager.getInstance();
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
}