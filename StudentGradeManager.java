import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Grade Manager =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Summary Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displaySummary();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        double grade;
        while (true) {
            System.out.print("Enter student grade (0 - 100): ");
            grade = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            if (grade >= 0 && grade <= 100) break;
            else System.out.println("Invalid grade. Try again.");
        }

        students.add(new Student(name, grade));
        System.out.println("Student added successfully.");
    }

    private static void displaySummary() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        double total = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        Student topStudent = null, bottomStudent = null;

        System.out.println("\n---- Student Grades ----");
        for (Student s : students) {
            System.out.printf("%s: %.2f%n", s.name, s.grade);
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                bottomStudent = s;
            }
        }

        double average = total / students.size();

        System.out.println("\n---- Summary ----");
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.printf("Highest Grade: %.2f (%s)%n", highest, topStudent.name);
        System.out.printf("Lowest Grade : %.2f (%s)%n", lowest, bottomStudent.name);
    }
}
