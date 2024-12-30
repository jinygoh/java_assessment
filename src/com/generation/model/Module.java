package com.generation.model;

import java.util.HashMap;
import java.util.Map;

//Represents a module with attributes like code, name, description, and prerequisites.

public class Module
{
    private final String code;
    private final String name;
    private final String description;
    private final Map<String, Module> prerequisites = new HashMap<>();

    public Module( String code, String name, String description )
    {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    //method add prerequisite module to current module. takes a Module object as a parameter and adds it to the prerequisites map, using the prerequisite module's code as the key.
    //For example, if you have a module MATH-101 and you want to add ALG-101 as a prerequisite, you would call MATH-101.addPrerequisite(ALG-101).
    public void addPrerequisite( Module module )
    {
        prerequisites.put( module.code, module );
    }


    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public Map<String, Module> getPrerequisites()
    {
        return prerequisites;
    }

    @Override
    public String toString()
    {
        return "Module{" + "name='" + name + '\'' + '}';
    }
}
