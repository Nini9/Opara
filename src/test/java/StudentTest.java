/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nini
 */
public class StudentTest {

    public StudentTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getYear method, of class Student.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Student instance = new Student("John", "Smith", "jsr@email.com", "JS441", "freshman");
        String expResult = "freshman";
        String result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setYear method, of class Student.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        String classYear = "freshman";
        Student instance = new Student("John", "Smith", "jsr@email.com", "JS441", "freshman");
        instance.setYear(classYear);
    }

    /**
     * Test of accessCanvas method, of class Student.
     */
    @Test
    public void testAccessCanvas() {
        System.out.println("accessCanvas");
        Student instance = new Student("John", "Smith", "jsr@email.com", "JS441", "freshman");
        instance.accessCanvas();
    }

    /**
     * Test of firePerson method, of class Student.
     */
    @Test
    public void testFirePerson() {
        System.out.println("firePerson");
        Student instance = new Student("John", "Smith", "jsr@email.com", "JS441", "freshman");
        instance.firePerson();
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = new Student("John", "Smith", "jsr@email.com", "JS441", "freshman");
        String expResult = "Email =jsr@email.com, first name=John, last name=Smith, userID=JS441 is a freshman";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
