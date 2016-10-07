package com.CianDuffy.CT417;

import junit.framework.TestCase;

/**
 * Created by cianduffy on 07/10/2016.
 */
public class CourseProgrammeTest extends TestCase
{
    private CourseProgramme testCourseProgram;
    private Module testModule;
    private Student testStudent;

    private UtilityManager utilityManager;

    @Override
    protected void setUp()
    {
        utilityManager = UtilityManager.getInstance();

        testStudent = new Student("Test Student", utilityManager.dateTimeFromString("01/01/1994"), "Test Student ID");

        testModule = new Module("Test Module", "Test Module ID");
        testModule.addStudent(testStudent);

        testCourseProgram = new CourseProgramme("Test Course Programme", "Test Course Code");
        testCourseProgram.setStartDateTime(utilityManager.dateTimeFromString("01/09/2016"));
        testCourseProgram.setEndDateTime(utilityManager.dateTimeFromString("10/05/2017"));
        testCourseProgram.addModule(testModule);
    }

    public void testToString()
    {
        String expectedString = "\n================================================================================" +
                "\nCourse Name:\tTest Course Programme\nCourse Code:\tTest Course Code" +
                "\n--------------------------------------------------------------------------------\nModules:" +
                testModule.toString();
        String actualString = testCourseProgram.toString();

        assertEquals(expectedString, actualString);
    }
}
