package com.CianDuffy.CT417;

import junit.framework.TestCase;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cianduffy on 06/10/2016.
 * Unit Tests for Module Class.
 */
public class ModuleTest extends TestCase
{
    private Module testModule;
    private UtilityManager utilityManager;
    private Student testStudent1, testStudent2, testStudent3;
    private ArrayList<Student> studentArrayList;

    @Override
    protected void setUp()
    {
        utilityManager = UtilityManager.getInstance();
        testModule = new Module("Test Module", "Test ID");

        testStudent1 = new Student("Test Student 1", utilityManager.dateTimeFromString("01/01/2000"), "1");
        testStudent2 = new Student("Test Student 2", utilityManager.dateTimeFromString("01/01/2000"), "2");
        testStudent3 = new Student("Test Student 3", utilityManager.dateTimeFromString("01/01/2000"), "3");

        studentArrayList = new ArrayList<Student>();
        studentArrayList.add(testStudent1);
        studentArrayList.add(testStudent2);
        studentArrayList.add(testStudent3);
    }

    public void testAddStudent()
    {
        testModule.addStudent(testStudent1);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent1);
        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testAddMultipleStudents()
    {
        testModule.addStudents(studentArrayList);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent1);
        expectedStudents.add(testStudent2);
        expectedStudents.add(testStudent3);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testAddExistingStudent()
    {
        testModule.addStudents(studentArrayList);
        testModule.addStudent(testStudent1);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent1);
        expectedStudents.add(testStudent2);
        expectedStudents.add(testStudent3);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testAddMultipleExistingStudents()
    {
        testModule.addStudents(studentArrayList);

        ArrayList<Student> newStudents = new ArrayList<Student>();
        newStudents.add(testStudent1);
        newStudents.add(testStudent2);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent1);
        expectedStudents.add(testStudent2);
        expectedStudents.add(testStudent3);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testAddMultipleStudentsSomeExisting()
    {
        testModule.addStudent(testStudent1);
        testModule.addStudent(testStudent2);

        ArrayList<Student> newStudents = new ArrayList<Student>();
        newStudents.add(testStudent1);
        newStudents.add(testStudent3);

        testModule.addStudents(newStudents);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent1);
        expectedStudents.add(testStudent2);
        expectedStudents.add(testStudent3);

        ArrayList<Student> actualStudents = testModule.getStudents();



        assertEquals(expectedStudents, actualStudents);
    }

    public void testRemoveStudent()
    {
        testModule.addStudents(studentArrayList);
        testModule.removeStudent(testStudent2);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent1);
        expectedStudents.add(testStudent3);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testRemoveMultipleStudents()
    {
        testModule.addStudents(studentArrayList);

        ArrayList<Student> removedStudents = new ArrayList<Student>();
        removedStudents.add(testStudent1);
        removedStudents.add(testStudent3);

        testModule.removeStudents(removedStudents);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent2);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testRemoveStudentNotInModule()
    {
        testModule.addStudent(testStudent1);
        testModule.addStudent(testStudent3);

        testModule.removeStudent(testStudent2);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent1);
        expectedStudents.add(testStudent3);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testRemoveMultipleStudentsNotInModule()
    {
        testModule.addStudent(testStudent2);

        ArrayList<Student> removedStudents = new ArrayList<Student>();
        removedStudents.add(testStudent1);
        removedStudents.add(testStudent3);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent2);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testRemoveMultipleStudentsSomeInModule()
    {
        testModule.addStudent(testStudent1);
        testModule.addStudent(testStudent2);

        ArrayList<Student> removedStudents = new ArrayList<Student>();
        removedStudents.add(testStudent1);
        removedStudents.add(testStudent3);

        testModule.removeStudents(removedStudents);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(testStudent2);

        ArrayList<Student> actualStudents = testModule.getStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    public void testToString()
    {
        testModule.addStudent(testStudent1);
        String expectedString = "\n--------------------------------------------------------------------------------" +
                "\nModule Name:\tTest Module\nModule Code:\tTest ID" +
                "\nStudents:\n" + testStudent1;
        String actualString = testModule.toString();

        assertEquals(expectedString, actualString);
    }
}
