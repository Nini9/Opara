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
public class BalanceTest {

    public BalanceTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getCurrentBalance method, of class Balance.
     */
    @Test
    public void testGetCurrentBalance() {
        System.out.println("getCurrentBalance");
        Balance instance = new Balance(150.4, "11/9/18");
        double expResult = 150.4;
        double result = instance.getCurrentBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCurrentBalance method, of class Balance.
     */
    @Test
    public void testSetCurrentBalance() {
        System.out.println("setCurrentBalance");
        double currentBalance = 150.4;
        Balance instance = new Balance(150.4, "11/9/18");
        instance.setCurrentBalance(currentBalance);
    }

    /**
     * Test of getDate method, of class Balance.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Balance instance = new Balance(150.4, "11/9/18");
        String expResult = "11/9/18";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class Balance.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "11/9/18";
        Balance instance = new Balance(150.4, "11/9/18");
        instance.setDate(date);
    }

    /**
     * Test of toString method, of class Balance.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Balance instance = new Balance(150.4, "11/9/18");
        String expResult = "Current balance =150.4, date =11/9/18";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
