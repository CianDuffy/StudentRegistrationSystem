package com.CianDuffy.CT417;

import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * Created by cianduffy on 30/09/2016.
 * Class that contains attributes required for students in the registration system.
 */
public class Student
{
    private String name;
    private DateTime DOB;
    private String ID;

    // Constructor

    public Student(String name, DateTime DOB, String ID) {
        this.name = name;
        this.DOB = DOB;
        this.ID = ID;
    }

    // Accessor Methods

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDOB() {
        return DOB;
    }

    public void setDOB(DateTime DOB) {
        this.DOB = DOB;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAge() {
        int age;
        DateTime currentDateTime = new DateTime();
        Period periodBetweenDOBAndNow = new Period(DOB, currentDateTime);

        age = periodBetweenDOBAndNow.getYears();
        return age;
    }

    public String getUsername() {
        String usernameString = this.name.toLowerCase();
        usernameString = usernameString.replaceAll("\\s", "");

        int age = getAge();

        if (age > 0)
        {
            usernameString += String.valueOf(age);
        }

        return usernameString;
    }

    @Override
    public String toString()
    {
        UtilityManager utilityManager = UtilityManager.getInstance();
        return "Name:\t" + this.name + "\tDOB:\t" + utilityManager.stringFromDateTime(this.DOB) + "\tUsername:\t" + getUsername();
    }
}

