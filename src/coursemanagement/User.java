package coursemanagement;

import java.util.ArrayList;
import java.util.List;

public class User {

    private double balance;
    private List<Course> myCourses;

    public User(double balance) {
        this.balance = balance;
        myCourses = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Course> getMyCourses() {
        return myCourses;
    }

    public void increaseBalance(double amount) {
        balance += amount;
    }

    public void decreaseBalance(double amount) {
        balance -= amount;
    }

    public void addCourse(Course course) {
        myCourses.add(course);
    }

    public boolean hasCourse(Course course) {
        return myCourses.contains(course);
    }
}