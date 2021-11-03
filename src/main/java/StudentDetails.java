import java.util.ArrayList;

public class StudentDetails {

    ArrayList<Student> studentArray = new ArrayList<>();

    Student s1 = new Student("Peter", "Lawai", "abc@gmail.com", "12345", "Freshman");
    Student s2 = new Student("James", "Judas", "egf@gmail.com", "22345", "Freshman");
    Student s3 = new Student("John", "Barnabas", "kfw@gmail.com", "32345", "Freshman");
    Student s4 = new Student("Andrew", "Matthew", "zeg@gmail.com", "42345", "Freshman");

    public void test() {
        studentArray.add(s1);
        studentArray.add(s2);
        studentArray.add(s3);
        studentArray.add(s4);
    }

}
