<<<<<<< HEAD
public class Staff extends Person {
    private int numOfYears; // number of years on the contract agreement

    // class constructor
=======
public class Staff extends People {
    private int numOfYears; //number of years on the contract agreement 
    
    //class constructor 
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
    public Staff(String firstName, String lastName, String email, String userID, int numOfYears) {
        super(firstName, lastName, email, userID);
        this.numOfYears = numOfYears;
    }
<<<<<<< HEAD

    // getter for number of years
    public int getNumOfYears() {
        return numOfYears;
    }

    // setter for number of years
    public void setNumOfYears(int numOfYears) {
        this.numOfYears = numOfYears;
    }

    // toString method
=======
    //getter for number of years 
    public int getNumOfYears() {
        return numOfYears;
    }
    //setter for number of years 
    public void setNumOfYears(int numOfYears) {
        this.numOfYears = numOfYears;
    }
    //toString method
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
    @Override
    public String toString() {
        return super.toString() + "number of years on contract =" + numOfYears;
    }
<<<<<<< HEAD

=======
    
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
}
