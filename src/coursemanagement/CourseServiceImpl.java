package coursemanagement;

import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {

    private List<Course> courses;
    private User user;
    private Scanner scanner;

    public CourseServiceImpl(List<Course> courses, User user, Scanner scanner) {
        this.courses = courses;
        this.user = user;
        this.scanner = scanner;
    }

    @Override
    public void showCourses() {
        System.out.println("\n--- Kurslar ---");

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public void buyCourse() {
        showCourses();

        System.out.print("Kursun adını daxil edin: ");
        Course course = findCourse(scanner.nextLine());

        if (course == null) {
            System.out.println("Kurs tapılmadı!");
        } else if (user.hasCourse(course)) {
            System.out.println("Bu kurs artıq alınıb!");
        } else if (course.getQuota() <= 0) {
            System.out.println("Kursda yer yoxdur!");
        } else if (user.getBalance() < course.getPrice()) {
            System.out.println("Balans kifayət etmir!");
        } else {
            user.decreaseBalance(course.getPrice());
            course.decreaseQuota();
            user.addCourse(course);
            System.out.println("Kurs uğurla alındı!");
        }
    }

    @Override
    public void showMyCourses() {
        System.out.println("\n--- Aldığım Kurslar ---");

        if (user.getMyCourses().isEmpty()) {
            System.out.println("Hələ kurs almamısınız.");
            return;
        }

        for (Course course : user.getMyCourses()) {
            System.out.println(course);
        }
    }

    @Override
    public void showBalance() {
        System.out.println("Balans: " + user.getBalance() + " AZN");
    }

    @Override
    public void increaseBalance() {
        System.out.print("Məbləği daxil edin: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount > 0) {
            user.increaseBalance(amount);
            System.out.println("Balans artırıldı!");
        } else {
            System.out.println("Yanlış məbləğ!");
        }
    }

    private Course findCourse(String name) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null;
    }
}