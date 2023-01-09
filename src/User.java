package com.example.playground.OOP_Company;

public class User implements Comparable<User> {

    public User(Personal subordinates, String firstName, String lastName, int age) {
        this(firstName, lastName, age);
        this.subordinates = subordinates;
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Personal getSubordinates() {
        return subordinates;
    }

    private Personal subordinates = new Personal();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
        String fullName = this.firstName + " " + this.lastName;
        String fullNameO = o.firstName + " " + o.lastName;
        if (fullName.equals(fullNameO)) {
            return this.age - o.age;
        }
        return fullName.compareTo(fullNameO);
    }
}