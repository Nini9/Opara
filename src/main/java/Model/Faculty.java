package Model;

import java.util.Scanner;

public class Faculty extends Person implements Fireable {
    // Login Details Variable Instantiation
    private String username;
    private String password;

    // class constructor
    public Faculty(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // get the username of the faculty member
    public String getUsername() {
        return username;
    }

    // set the password of the faculty member
    public void setUsername(String username) {
        this.username = username;
    }

    // get the password of the faculty member
    public String getPassword() {
        return password;
    }

    // set the password of the faculty member
    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return super.toString() + "Username =" + username;
    }

}
