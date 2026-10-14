import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String course;
    double marks;

    Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id
                + ", Name: " + name
                + ", Course: " + course
                + ", Marks: " + marks);
    }
}

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Choose a number from 1 to 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        sc.close();
    }

    static void addStudent() {
        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter course: ");
            String course = sc.nextLine();

            System.out.print("Enter marks (0-100): ");
            double marks = Double.parseDouble(sc.nextLine());

            if (name.trim().isEmpty() || course.trim().isEmpty()
                    || marks < 0 || marks > 100) {
                System.out.println("Enter valid details and marks.");
                return;
            }

            students.add(new Student(nextId++, name, course, marks));
            System.out.println("Student added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Marks must be a valid number.");
        }
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter student ID: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            for (Student student : students) {
                if (student.id == id) {
                    student.display();
                    return;
                }
            }

            System.out.println("Student not found.");
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid ID.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            for (Student student : students) {
                if (student.id == id) {
                    students.remove(student);
                    System.out.println("Student deleted successfully!");
                    return;
                }
            }

            System.out.println("Student not found.");
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid ID.");
        }
    }
}