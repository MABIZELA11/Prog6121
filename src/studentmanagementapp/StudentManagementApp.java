package studentmanagementapp;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    studentReport();
                    break;
                case 5:
                    manageCourses();
                    break;
                case 6:
                    exitApplication();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Capture New Student");
        System.out.println("2. Search for Student");
        System.out.println("3. Delete Student");
        System.out.println("4. View Student Report");
        System.out.println("5. Manage Student Courses");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void captureStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int age = 0;
        while (true) {
            System.out.print("Enter student age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) break;
                else System.out.println("Invalid age. Must be 16 or older.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        String gmail = "";
        while (true) {
            System.out.print("Enter student Gmail address: ");
            gmail = scanner.nextLine();
            if (gmail.matches("^[\\w-_.+]+@gmail\\.com$")) break;
            else System.out.println("Invalid Gmail address. Please enter a valid Gmail address.");
        }

        Student student = new Student(id, name, age, gmail);
        students.add(student);
        System.out.println("Student details have been successfully saved.");
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Are you sure you want to delete this student? (yes/no): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    students.remove(student);
                    System.out.println("Student has been deleted.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void studentReport() {
        System.out.println("Student Report:");
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void manageCourses() {
        System.out.print("Enter student ID to manage courses: ");
        String id = scanner.nextLine();
        Student student = null;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                student = s;
                break;
            }
        }
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        while (true) {
            System.out.println("Manage Courses:");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Courses");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course to add: ");
                    String courseToAdd = scanner.nextLine();
                    student.addCourse(courseToAdd);
                    System.out.println("Course added.");
                    break;
                case 2:
                    System.out.print("Enter course to remove: ");
                    String courseToRemove = scanner.nextLine();
                    student.removeCourse(courseToRemove);
                    System.out.println("Course removed.");
                    break;
                case 3:
                    System.out.println("Courses for student " + student.getName() + ": " + student.getCourses());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void exitApplication() {
        System.out.println("Exiting application. Goodbye!");
    }
}
