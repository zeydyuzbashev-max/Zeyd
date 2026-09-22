package coursemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManagementApp {

    private CourseService courseService;
    private Scanner scanner;

    public CourseManagementApp() {

        scanner = new Scanner(System.in);

        List<Course> courses = new ArrayList<>();

        courses.add(new Course("Java", 100, 5));
        courses.add(new Course("Python", 80, 3));
        courses.add(new Course("C++", 70, 4));
        courses.add(new Course("SQL", 50, 6));

        User user = new User(150);

        courseService = new CourseServiceImpl(courses, user, scanner);
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== COURSE MANAGEMENT SYSTEM =====");
            System.out.println("1. Kurslara bax");
            System.out.println("2. Kurs al");
            System.out.println("3. Aldığım kurslar");
            System.out.println("4. Balansımı göstər");
            System.out.println("5. Balans artır");
            System.out.println("6. Çıxış");

            System.out.print("Seçiminizi daxil edin: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> courseService.showCourses();
                case 2 -> courseService.buyCourse();
                case 3 -> courseService.showMyCourses();
                case 4 -> courseService.showBalance();
                case 5 -> courseService.increaseBalance();

                case 6 -> {
                    running = false;
                    System.out.println("Proqramdan çıxıldı.");
                }

                default -> System.out.println("Yanlış seçim!");
            }
        }
    }
}