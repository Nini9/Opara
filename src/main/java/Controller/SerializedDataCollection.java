package Controller;

import Model.*;
import java.io.*;
import java.util.ArrayList;

public class SerializedDataCollection {
    // Instantiation of the model classes (Student, Staff and Faculty)
    ArrayList<Student> studentArray = new ArrayList<>();
    ArrayList<Staff> staffArray = new ArrayList<>();
    ArrayList<Faculty> facultyArray = new ArrayList<>();

    // Array for tracking the current user id
    // index 0 tracks for students
    // index 1 tracks for staff
    int[] userIdGenerator = { 1, 1 };


    FileOutputStream fileOut;

    // Class Constructor
    public SerializedDataCollection() {

        // Adding the username and password to the faculty arraylist
        facultyArray.add(new Faculty("sample", "sample"));

        // Serialized file checker
        fileChecker();
    }

    // Method to check serialized files existence
    public void fileChecker() {
        File studentTempFile = new File("src/serializedData/studentsDetails.ser");
        File staffTempFile = new File("src/serializedData/staffDetails.ser");
        File facultyTempFile = new File("src/serializedData/facultyDetails.ser");
        File userIdTrackerTempFile = new File("src/serializedData/userId.txt");

        boolean studentTempFileExists = studentTempFile.exists();
        boolean staffTempFileExists = staffTempFile.exists();
        boolean facultyTempFileExists = facultyTempFile.exists();
        boolean userIdTrackerTempFileExists = userIdTrackerTempFile.exists();

        if (studentTempFileExists == false || staffTempFileExists == false || facultyTempFileExists == false) {
            serializeDetails(studentArray);
            serializeDetails(staffArray);
            serializeDetails(facultyArray);
        }

        if (userIdTrackerTempFileExists == false) {
            serializeUserIdTracker();
        }

    }

    // Serialize method for Models
    public void serializeDetails(ArrayList<?> arrayName) {
        try {
            if (arrayName == studentArray) {
                fileOut = new FileOutputStream("src/serializedData/studentsDetails.ser");
            } else if (arrayName == staffArray) {
                fileOut = new FileOutputStream("src/serializedData/staffDetails.ser");
            } else if (arrayName == facultyArray) {
                fileOut = new FileOutputStream("src/serializedData/facultyDetails.ser");
            }

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(arrayName);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize method for models
    public void deSerializeDetails(ArrayList<?> arrayName, String storedFileName) {
        try {
            FileInputStream fis = new FileInputStream("src/serializedData/" + storedFileName + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            if (arrayName == studentArray) {
                studentArray = castToAnything(ois.readObject());
            } else if (arrayName == staffArray) {
                staffArray = castToAnything(ois.readObject());
            } else if (arrayName == facultyArray) {
                facultyArray = castToAnything(ois.readObject());
            }

            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    // Serialize method for user id tracker
    public void serializeUserIdTracker() {
        try {
            FileOutputStream fos = new FileOutputStream("src/serializedData/userId.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(userIdGenerator);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize method for user id tracker
    public void deSerializeUserIdTracker() {
        try {
            FileInputStream fis = new FileInputStream("src/serializedData/userId.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            userIdGenerator = castToAnything(ois.readObject());

            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method to suppress the deserialization type casting message
    @SuppressWarnings("unchecked")
    public static <T> T castToAnything(Object obj) {
        return (T) obj;
    }

}
