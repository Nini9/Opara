public class Balance {
    private double currentBalance;
    private String date;

    //class constructor 
    public Balance(double currentBalance, String date) {
        this.currentBalance = currentBalance;
        this.date = date;
    }
    //getters and setters 
    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //toString method 
    @Override
    public String toString() {
        return "Current balance =" + currentBalance + ", date =" + date;
    }
    
    
}
