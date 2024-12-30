package com.generation.model;

//Represents a course with attributes like code, name, credits, and a module.
//Course.java has a reference to a Module.java object, which represents the module that the course belongs to.
public class Course
{
    private final String code;
    private final String name;
    private final int credits;
    private final Module module;

    public Course( String code, String name, int credits, Module module )
    {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.module = module;
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public int getCredits()
    {
        return credits;
    }

    public Module getModule()
    {
        return module;
    }

    @Override
    public String toString()
    {
        return "Course{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", credits=" + credits + ", module="
            + module + '}';
    }
}
