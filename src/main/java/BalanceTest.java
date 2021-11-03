<<<<<<< HEAD
/*
 * //JUnit Test for Balance Class import static
 * org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import org.junit.jupiter.api.Test;
 * 
 * public class BalanceTest { Balance b;
 * 
 * public BalanceTest() { b = new Balance(150.4, "11/9/18"); }
 * 
 * @Test public void getCurrentBalance() { double expected = 150.4; double
 * actual = b.getCurrentBalance(); assertEquals(expected, actual, 0.00001); }
 * 
 * @Test public void TestgetDate() { String expected = "11/9/18"; String actual
 * = b.getDate(); assertEquals(expected, actual); } }
 */
=======
//JUnit Test for Balance Class
import org.junit.Test;

import jdk.jfr.Timestamp;

import static org.junit.Assert.*;

public class BalanceTest 
{
    public BalanceTest()
    {
        Balance b = new Balance(150.4, "11/9/18");
    }

    @Test
    public void getCurrentBalance()
    {
        double expected = 150.4;
        double actual = b.getCurrentBalance();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void TestgetDate()
    {
        String expected = "11/9/18";
        String actual = b.getDate();
        assertEquals(expected, actual);
    }
}
>>>>>>> df04e8769d6c195def46741370d7316aa48e5c6d
