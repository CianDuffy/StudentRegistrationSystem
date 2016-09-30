package com.CianDuffy.CT417;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by cianduffy on 30/09/2016.
 * Unit test for Student Class.
 */
public class StudentTest extends TestCase
{
    private Student testStudent;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StudentTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StudentTest.class );
    }

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