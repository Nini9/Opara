import java.util.Scanner;

<<<<<<< HEAD
public class Faculty extends Person implements Fireable {
    private String dateOfEmployment;

    // class constructor
=======
public class Faculty extends People implements Fireable{
    private String dateOfEmployment;

    //class constructor 
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
    public Faculty(String firstName, String lastName, String email, String userID, String dateOfEmployment) {
        super(firstName, lastName, email, userID);
        this.dateOfEmployment = dateOfEmployment;
    }
<<<<<<< HEAD

    // get the date of employment of the faculty member
    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    // set the date of employment of the faculty member
    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public void accessCanvas() {
        System.out.println("I am a faculty member and can access canvas and change grades for students.");
    }

    @Override
    public void firePerson() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What's your contract period?");
        int numOfYears = scan.nextInt();
        if (numOfYears < 4) {
            System.out.println("You have spent less than the regular contract period. Not fireable");
        } else {
            System.out.println("You can be fired.");
        }
        scan.close();
    }

=======
    //get the date of employment of the faculty member 
    public String getDateOfEmployment() {
        return dateOfEmployment;
    }
    //set the date of employment of the faculty member 
    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
    @Override
    public String accessCanvas()
    {
        return "I am a faculty member and can access canvas and change grades for students.";
    }
    @Override
    public void firePerson() {
        Scanner scan = new Scanner(System.in);
        int numOfYears = scan.nextInt();
        if (numOfYears < 4)
        {
            System.out.println("You have spent less than the regular contract period. Not fireable");
        }
        else{
            System.out.println("You can be fired.");
        }
    }
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
    @Override
    public String toString() {
        return super.toString() + "date of employment =" + dateOfEmployment;
    }
<<<<<<< HEAD

=======
    
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
}
