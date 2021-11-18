import java.io.*;
import java.util.ArrayList;

public class SerializedDataCollection {
    // Instantiation of the model classes (Student and Staff)
    ArrayList<Student> studentArray = new ArrayList<>();
    ArrayList<Staff> staffArray = new ArrayList<>();

    public SerializedDataCollection() {
        studentArray.add(new Student("Peter", "Lawai", "abc@gmail.com", "12345", "Freshman"));
        studentArray.add(new Student("James", "Judas", "egf@gmail.com", "22345", "Freshman"));
        studentArray.add(new Student("John", "Barnabas", "kfw@gmail.com", "32345", "Freshman"));
        studentArray.add(new Student("Andrew", "Matthew", "zeg@gmail.com", "42345", "Freshman"));

        // Serialized file checker
        fileChecker();
    }

    public void fileChecker() {
        File tempFile = new File(".\\\\studentsDetails.ser");
        boolean exists = tempFile.exists();

        if (exists == false) {
            serialize();
        }
    }

    public void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream("studentsDetails.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(studentArray);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deSerialize() {
        try {
            FileInputStream fis = new FileInputStream(".\\\\studentsDetails.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            studentArray = (ArrayList<Student>) ois.readObject();

            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

}
