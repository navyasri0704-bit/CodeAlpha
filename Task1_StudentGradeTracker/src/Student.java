public class Student {

    private String name;
    private int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for marks
    public int getMarks() {
        return marks;
    }

    // Setter for marks
    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Display student details
    public void display() {
        System.out.println("Name  : " + name);
        System.out.println("Marks : " + marks);
    }
}