package pc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class Challenge203Test {
    Challenge203 c;

    @Before
    public void setUp() throws Exception {
        c = new Challenge203();
    }

    @Test
    public void test1() {
        assertEquals(5, c.calculateHartals(14, 3, 4, 8).size());
    }

    @Test
    public void test2() {
        assertEquals(15, c.calculateHartals(100, 12, 15, 25, 40).size());
    }

    @Test
    public void testFriday() {
        assertEquals(0, c.calculateHartals(7, 6).size());
    }

    @Test
    public void testSaturday() {
        assertEquals(0, c.calculateHartals(7, 7).size());
    }

    @Test
    public void testManySaturdays() {
        assertEquals(0, c.calculateHartals(14, 7, 7, 7).size());
    }
    
    @Test
    public void testOutOfBounds() {
        assertEquals(0, c.calculateHartals(14, 17).size());
    }
    
    @Test
    public void testEveryday() {
        assertEquals(5, c.calculateHartals(7, 1).size());
    }
    
    @Test
    public void testEverydayTwoWeeks() {
        assertEquals(10, c.calculateHartals(13, 1).size());
    }
}
