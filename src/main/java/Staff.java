public class Staff extends Person {
    private int numOfYears; // number of years on the contract agreement

    // class constructor
    public Staff(String firstName, String lastName, String email, String userID, int numOfYears) {
        super(firstName, lastName, email, userID);
        this.numOfYears = numOfYears;
    }

    // getter for number of years
    public int getNumOfYears() {
        return numOfYears;
    }

    // setter for number of years
    public void setNumOfYears(int numOfYears) {
        this.numOfYears = numOfYears;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + "number of years on contract =" + numOfYears;
    }
}
