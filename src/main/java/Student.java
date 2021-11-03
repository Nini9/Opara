public class Student extends Person implements Fireable {
    private String classYear; // freshman, sophomore etc

    // class constructor
    public Student(String firstName, String lastName, String email, String userID, String classYear) {
        super(firstName, lastName, email, userID);
        this.classYear = classYear;
    }

    // getter for class year
    public String getYear() {
        return classYear;
    }

    // setter for class year
    public void setYear(String classYear) {
        this.classYear = classYear;
    }

    @Override
    public void accessCanvas() {
        System.out.println("I am a student with access to limited functions in Canvas.");
    }

    @Override
    public void firePerson() {
        System.out.println("Students is not under any contract. Not fireable.");
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + "is a " + classYear;
    }

}
