import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(String name, int marks) {
        students.add(new Student(name, marks));
        System.out.println("Student added successfully.");
    }

    // Display Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n------ Student Records ------");

        for (Student s : students) {
            s.display();
            System.out.println("----------------------------");
        }
    }

    // Search Student
    public void searchStudent(String name) {

        for (Student s : students) {

            if (s.getName().equalsIgnoreCase(name)) {

                System.out.println("\nStudent Found");
                s.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update Marks
    public void updateMarks(String name, int newMarks) {

        for (Student s : students) {

            if (s.getName().equalsIgnoreCase(name)) {

                s.setMarks(newMarks);
                System.out.println("Marks updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent(String name) {

        for (Student s : students) {

            if (s.getName().equalsIgnoreCase(name)) {

                students.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Average Marks
    public void averageMarks() {

        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }

        int total = 0;

        for (Student s : students) {
            total += s.getMarks();
        }

        double average = (double) total / students.size();

        System.out.println("Average Marks = " + average);
    }

    // Highest Marks
    public void highestMarks() {

        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }

        Student highest = students.get(0);

        for (Student s : students) {

            if (s.getMarks() > highest.getMarks()) {
                highest = s;
            }
        }

        System.out.println("\nHighest Marks Student");
        highest.display();
    }

    // Lowest Marks
    public void lowestMarks() {

        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }

        Student lowest = students.get(0);

        for (Student s : students) {

            if (s.getMarks() < lowest.getMarks()) {
                lowest = s;
            }
        }

        System.out.println("\nLowest Marks Student");
        lowest.display();
    }

    // Summary Report
    public void summaryReport() {

        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }

        int total = 0;
        Student highest = students.get(0);
        Student lowest = students.get(0);

        for (Student s : students) {

            total += s.getMarks();

            if (s.getMarks() > highest.getMarks()) {
                highest = s;
            }

            if (s.getMarks() < lowest.getMarks()) {
                lowest = s;
            }
        }

        double average = (double) total / students.size();

        System.out.println("\n========== SUMMARY REPORT ==========");
        System.out.println("Total Students : " + students.size());
        System.out.println("Average Marks  : " + average);
        System.out.println("Highest Marks  : " + highest.getName() + " (" + highest.getMarks() + ")");
        System.out.println("Lowest Marks   : " + lowest.getName() + " (" + lowest.getMarks() + ")");
    }

    // Return student list (used for file handling)
    public ArrayList<Student> getStudents() {
        return students;
    }
}
