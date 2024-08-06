package StudentMgmtSys;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600; //static = value not specific to object but something true for all objects
    private static int id = 1000;

    // Constructor: prompt user to enter students name and year
    public Student() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = scan.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = scan.nextLine();

        System.out.println("1 - Freshmen");
        System.out.println("2 - Sophemore");
        System.out.println("3 - Junior");
        System.out.println("4 - Senior");
        System.out.print("Enter student class level: ");
        this.gradeYear = scan.nextInt();

        setStudentID();
    }

    // Generate ID
    private void setStudentID() {
        //Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        //Get inside loop, user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner scan = new Scanner(System.in);
            String course = scan.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
    }
    
    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner scan = new Scanner(System.in);
        int payment = scan.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status
    // Some people prefer to return a String
    public String showInfo() {
        return "\nName: " + firstName + " " + lastName + 
        "\nGrade Level: " + gradeYear +
        "\nStudent ID: " + studentID +
        "\nCourse(s) Enrolled: " + courses + 
        "\nBalance: $" + tuitionBalance +
        "\n";
    }

}
