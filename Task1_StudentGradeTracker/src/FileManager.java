import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // Save students to file
    public static void saveStudents(ArrayList<Student> students) {

        try {

            FileWriter fw = new FileWriter("students.txt");

            for (Student s : students) {

                fw.write(s.getName() + "," + s.getMarks());
                fw.write("\n");
            }

            fw.close();

            System.out.println("Records saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving records.");
        }
    }

    // Load students from file
    public static void loadStudents(GradeTracker tracker) {

        File file = new File("students.txt");

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];
                int marks = Integer.parseInt(data[1]);

                tracker.addStudent(name, marks);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Error while loading records.");
        }
    }
}