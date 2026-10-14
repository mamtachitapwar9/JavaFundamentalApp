import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Collection to store student objects
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    // Safely reads an integer and handles invalid input
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    // Safely reads marks
    private static double readMarks() {
        while (true) {
            System.out.print("Enter marks (0-100): ");

            try {
                double marks = Double.parseDouble(sc.nextLine().trim());

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println("Marks must be between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid marks! Enter a valid number.");
            }
        }
    }

    // Adds a new student
    private static void addStudent() {
        int id = readInt("Enter student ID: ");

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("This ID already exists!");
                return;
            }
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter course: ");
        String course = sc.nextLine().trim();

        if (name.isEmpty() || course.isEmpty()) {
            System.out.println("Name and course cannot be empty.");
            return;
        }

        double marks = readMarks();

        Student student = new Student(id, name, course, marks);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Displays all students
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n===== STUDENT RECORDS =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Searches for a student using ID
    private static void searchStudent() {
        int id = readInt("Enter student ID to search: ");

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student found:");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Deletes a student using ID
    private static void deleteStudent() {
        int id = readInt("Enter student ID to delete: ");

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Main method: program execution starts here
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
