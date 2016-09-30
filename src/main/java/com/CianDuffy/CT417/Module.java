package com.CianDuffy.CT417;

import java.util.ArrayList;

/**
 * Created by cianduffy on 30/09/2016.
 *
 */
public class Module
{
    private String name;
    private String ID;
    private ArrayList<Student> students;

    private static String defaultName = "Placeholder Name";
    private static String defaultID = "Placeholder ID";


    // Constructors
    public Module()
    {
        this.name = defaultName;
        this.ID = defaultID;
        this.students = new ArrayList<Student>();
    }

    public Module(String name, String ID)
    {
        this.name = name;
        this.ID = ID;
        this.students = new ArrayList<Student>();
    }

    public Module(String name, String ID, ArrayList<Student> students) {
        this.name = name;
        this.ID = ID;
        this.students = students;
    }

    // Accessor Methods

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public void setStudents(ArrayList<Student> students)
    {
        this.students = students;
    }

    // Add and Remove Students

    public void addStudent(Student newStudent)
    {
        if (!this.students.contains(newStudent))
        {
            this.students.add(newStudent);
        }
    }

    public void addStudents(ArrayList<Student> newStudents)
    {
        for(Student newStudent : newStudents)
        {
            addStudent(newStudent);
        }
    }

    public void removeStudent(Student removeStudent)
    {
        if (this.students.contains(removeStudent))
        {
            this.students.remove(removeStudent);
        }
    }

    public void removeStudents(ArrayList<Student> removeStudents)
    {
        for (Student removeStudent : removeStudents)
        {
            removeStudent(removeStudent);
        }
    }

    // toString
    @Override
    public String toString()
    {
        String moduleString = "\n--------------------------------------------------------------------------------\nModule Name:\t" + this.name + "\nModule Code:\t" + this.ID;

        if (this.students.size() > 0)
        {
            moduleString += "\nStudents:";
            for (Student student : this.students)
            {
                moduleString += "\n" + student.toString();
            }
        }

        return moduleString;
    }
}

