import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        // Load previous records
        FileManager.loadStudents(tracker);

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Average Marks");
            System.out.println("7. Highest Marks");
            System.out.println("8. Lowest Marks");
            System.out.println("9. Summary Report");
            System.out.println("10. Save Records");
            System.out.println("11. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    tracker.addStudent(name, marks);
                    break;

                case 2:
                    tracker.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Student Name to Search: ");
                    name = sc.nextLine();
                    tracker.searchStudent(name);
                    break;

                case 4:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Marks: ");
                    int newMarks = sc.nextInt();

                    tracker.updateMarks(name, newMarks);
                    break;

                case 5:
                    System.out.print("Enter Student Name to Delete: ");
                    name = sc.nextLine();
                    tracker.deleteStudent(name);
                    break;

                case 6:
                    tracker.averageMarks();
                    break;

                case 7:
                    tracker.highestMarks();
                    break;

                case 8:
                    tracker.lowestMarks();
                    break;

                case 9:
                    tracker.summaryReport();
                    break;

                case 10:
                    FileManager.saveStudents(tracker.getStudents());
                    break;

                case 11:
                    FileManager.saveStudents(tracker.getStudents());
                    System.out.println("\nThank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}