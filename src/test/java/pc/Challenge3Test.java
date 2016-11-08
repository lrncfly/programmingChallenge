package pc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Challenge3Test {

    @Test
    public void testAverage() {
        double[] expenses = new double[] { 10, 11, 9, 8, 12 };
        Challenge3 c = new Challenge3(5);
        assertEquals(10, c.average(expenses), 0);
    }

    @Test
    public void testAverage1() {
        double[] expenses = new double[] { 10.00, 20.00, 30.00 };
        Challenge3 c = new Challenge3(3);
        assertEquals(20.0, c.average(expenses), 0.0);
    }

    @Test
    public void testAverage2() {
        double[] expenses = new double[] { 15.00, 15.01, 3.00, 3.01 };
        Challenge3 c = new Challenge3(4);
        assertEquals(9.0, c.average(expenses), 0.0);
    }

    @Test
    public void testAverage3() {
        double[] expenses = new double[] { 9999.10, 9999.10, 9999.0, 9999.10 };
        Challenge3 c = new Challenge3(4);
        assertEquals(9999.07, c.average(expenses), 0.0);
    }

    @Test
    public void testDifference() {
        double[] expenses = new double[] { 10, 11, 9, 8, 12 };
        double average = 10;
        Challenge3 c = new Challenge3(5);
        assertEquals(3, c.difference(expenses, average), 0.00);
    }

    @Test
    public void testDifference1() {
        double[] expenses = new double[] { 10.00, 20.00, 30.00 };
        double average = 20;
        Challenge3 c = new Challenge3(3);
        assertEquals(10, c.difference(expenses, average), 0.00);
    }

    @Test
    public void testDifference2() {
        double[] expenses = new double[] { 15.00, 15.01, 3.00, 3.01 };
        double average = 9.0;
        Challenge3 c = new Challenge3(4);
        assertEquals(11.99, c.difference(expenses, average), 0.00);
    }

    @Test
    public void testDifference3() {
        double[] expenses = new double[] { 9999.10, 9999.10, 9999.0, 9999.10 };
        double average = 9999.07;
        Challenge3 c = new Challenge3(4);
        assertEquals(0.06, c.difference(expenses, average), 0.00);
    }
}
