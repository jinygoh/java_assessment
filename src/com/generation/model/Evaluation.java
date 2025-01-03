package com.generation.model;

import java.util.List;
//Evaluation.java is not fully implemented, but it seems to be related to the Student.java class, possibly for evaluating student performance.
//An interface in Java is like a set of rules that says, "Any character in this game must be able to attack, defend, and heal." It doesn't tell them how to do it, just that they must be able to do it.
public interface Evaluation
{
    //Returns the average grade of the student.
    double getAverage();

    //Returns a list of courses that the student has been approved for.
    List<Course> getApprovedCourses();

}
