public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String userID;

    // class constructor
    public Person(String firstName, String lastName, String email, String userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userID = userID;
    }

    // method to get the user's first name
    public String getFirstName() {
        return firstName;
    }

    // method to set the user's first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // method to get the user's last name
    public String getLastName() {
        return lastName;
    }

    // method to set the user's last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // method to get the user's email
    public String getEmail() {
        return email;
    }

    // method to set the user's email
    public void setEmail(String email) {
        this.email = email;
    }

    // method to get the user's ID
    public String getUserID() {
        return userID;
    }

    // method to set the user's ID
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void accessCanvas() {
        System.out.println("I am a person and I have access to Canvas.");
    }

    // toString method
    @Override
    public String toString() {
        return "Email =" + email + ", first name=" + firstName + ", last name=" + lastName + ", userID=" + userID;
    }
}
