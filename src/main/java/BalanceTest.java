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
