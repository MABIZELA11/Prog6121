package studentmanagementapp;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private int age;
    private String gmail;
    private List<String> courses; // New field for courses

    // Constructor
    public Student(String id, String name, int age, String gmail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gmail = gmail;
        this.courses = new ArrayList<>(); // Initialize courses list
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGmail() { return gmail; }
    public List<String> getCourses() { return courses; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGmail(String gmail) { this.gmail = gmail; }

    // Methods to manage courses
    public void addCourse(String course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gmail: " + gmail + ", Courses: " + courses;
    }
}
