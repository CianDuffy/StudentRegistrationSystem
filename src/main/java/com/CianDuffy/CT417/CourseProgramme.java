package com.CianDuffy.CT417;

import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by cianduffy on 30/09/2016.
 */
public class CourseProgramme
{
    private String name;
    private String courseCode;
    private DateTime startDateTime;
    private DateTime endDateTime;
    private ArrayList<Module> modules;

    private static String defaultName = "Placeholder Name";
    private static String defaultCourseCode = "Placeholder Course Code";

    // Constructors
    public CourseProgramme()
    {
        this.name = defaultName;
        this.courseCode = defaultCourseCode;
        this.startDateTime = new DateTime();
        this.endDateTime = new DateTime();
        this.modules = new ArrayList<Module>();
    }

    public CourseProgramme(String nameString, String courseCodeString)
    {
        this.name = nameString;
        this.courseCode = courseCodeString;
        this.startDateTime = new DateTime();
        this.endDateTime = new DateTime();
        this.modules = new ArrayList<Module>();
    }

    public CourseProgramme(String nameString, String courseCodeString, DateTime startDateTime, DateTime endDateTime, ArrayList<Module> modulesArrayList)
    {
        this.name = nameString;
        this.courseCode = courseCodeString;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.modules = modulesArrayList;
    }

    // Accessor Methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public DateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(DateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public DateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(DateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    // Add and Remove Modules

    public void addModule(Module newModule)
    {
        if (!this.modules.contains(newModule))
        {
            this.modules.add(newModule);
        }
    }

    public void addModules(ArrayList<Module> newModules)
    {
        for(Module newModule : newModules)
        {
            addModule(newModule);
        }
    }

    public void removeModule(Module removeModule)
    {
        if (this.modules.contains(removeModule))
        {
            this.modules.remove(removeModule);
        }
    }

    public void removeModules(ArrayList<Module> removeModules)
    {
        for (Module removeModule : removeModules)
        {
            removeModule(removeModule);
        }
    }

    @Override
    public String toString()
    {
        String courseProgramString = "\n================================================================================\nCourse Name:\t" + this.name + "\nCourse Code:\t" + this.courseCode;

        if (this.modules.size() > 0)
        {
            courseProgramString += "\n--------------------------------------------------------------------------------\nModules:";
            for (Module module : this.modules)
            {
                courseProgramString += module.toString();
            }
        }

        return courseProgramString;
    }
}
