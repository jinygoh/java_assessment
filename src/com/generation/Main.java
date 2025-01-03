package com.generation;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

//Main.java is the entry point of the application, and it uses the services provided by CourseService.java and StudentService.java to manage courses and students.
public class Main
{

    //throws ParseException indicates that it may encounter a parsing error and that the caller of the method should handle this exception appropriately.
    public static void main( String[] args )
        throws ParseException
    {
        // studentService is the responsible for managing students
        StudentService studentService = new StudentService();
        // courseService is the responsible for managing courses
        CourseService courseService = new CourseService();
        // The Scanner object is used to get user input
        Scanner scanner = new Scanner( System.in );
        int option = 0;
        do
        {
            // Shows the main menu
            PrinterHelper.showMainMenu();
            // Gets the user's option
            option = scanner.nextInt();
            // Switches over the different options
            switch ( option )
            {
                case 1:
                    // Registers a new student
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    // Finds a student by ID
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    // Grades a student
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    // Enrolls a student to a course
                    enrollStudentToCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    // Shows the student summary
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    // Shows the courses summary
                    showCoursesSummary( courseService, scanner );
                    break;
            }
        }
        while ( option != 7 );
    }

    // Enrolls a student to a course
    //param studentService the service to manage students
    //param courseService  the service to manage courses
    // param scanner        the scanner to read the user's input
    private static void enrollStudentToCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        // Prompts the user to insert the student ID
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        // Finds the student with the given ID
        Student student = studentService.findStudent( studentId );
        // If the student doesn't exist, prints an error message
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        // Prints the found student
        System.out.println( student );
        // Prompts the user to insert the course ID
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        // Finds the course with the given ID
        Course course = courseService.getCourse( courseId );
        // If the course doesn't exist, prints an error message
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        // Prints the found course
        System.out.println( course );
        // Enrolls the student to the course
        courseService.enrollStudent( courseId, student );
        studentService.enrollToCourse( studentId, course );
        // Prints a success message
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        // Shows a summary of courses
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        // Shows a summary of students
        studentService.showSummary();
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {
        // TODO: implement this option
        System.out.println("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student != null) {
            System.out.println("Enter grade: ");
            double grade = scanner.nextDouble();
            student.setGrade(grade);
            System.out.println("Student grade updated successfully. Student Grade is " + grade);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
        // end of TODO
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        // Prompts the user to insert the student ID
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        // Finds the student with the given ID
        Student student = studentService.findStudent( studentId );
        if ( student != null )
        {
            // Prints the found student
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
        else
        {
            // Prints an error message
            System.out.println( "Student with Id = " + studentId + " not found" );
        }
    }

    //This method creates a new student by prompting the user for input using the PrinterHelper.createStudentMenu method, and then subscribes the student using the StudentService.subscribeStudent method.
    private static void registerStudent( StudentService studentService, Scanner scanner )
        throws ParseException
    {
        // Creates a new student using the PrinterHelper.createStudentMenu method
        Student student = PrinterHelper.createStudentMenu( scanner );
        // Subscribes the student
        studentService.subscribeStudent( student );
    }
}