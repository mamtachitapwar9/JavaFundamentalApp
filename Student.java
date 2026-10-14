public class Student {

    // Private variables to store student information
    private int id;
    private String name;
    private String course;
    private double marks;

    // Constructor: initializes a student object
    public Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    // Returns the student's ID
    public int getId() {
        return id;
    }

    // Displays the student's information
    public void displayStudent() {
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Marks      : " + marks);
        System.out.println("-----------------------------");
    }
}