//JUnit Test for People Class
import org.junit.Test;

import jdk.jfr.Timestamp;

import static org.junit.Assert.*;

public class PeopleTest {
    public PeopleTest(){
        People p = new People("John", "Smith", "jsr@email.com", "JS441");
    }

    @Test
    public void testFirstName(){
        String expected = "John";
        String actual = p.getFirstName();
        assertEquals(expected, actual);
    }
    @Test
    public void testLastName(){
        String expected = "Smith";
        String actual = p.getLastName();
        assertEquals(expected, actual);
    }
    @Test
    public void testEmail(){
        String expected = "jsr@email.com";
        String actual = p.getEmail();
        assertEquals(expected, actual);
    }
    @Test
    public void testUserID(){
        String expected = "JS441";
        String actual = p.getUserID();
        assertEquals(expected, actual);
    }
}
