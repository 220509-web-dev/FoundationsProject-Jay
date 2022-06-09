package dev.jay.entitities;

public class Student {

    private int student_id;
    private String FirstName;
    private String LastName;

    private String username;
    private String password;
    private int class_id;

    public Student(int student_id, String FirstName, String LastName, String user, String password, int class_id) {
        this.student_id = student_id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.username = username;
        this.password = password;
        this.class_id = class_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public Student() {
    }
}
