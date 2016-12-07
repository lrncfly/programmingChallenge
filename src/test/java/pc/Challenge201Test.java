package pc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Challenge201Test {
    @Test
    public void test2() {
        int[] numbers = new int[] { 4, 1, 4, 2, 3 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test3() {
        int[] numbers = new int[] { 5, 1, 4, 2, -1, 6 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test4() {
        int[] numbers = new int[] { 11, 1, 2, 4, 7, 11, 16, 22, 29, 37, 46, 56 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test5() {
        int[] numbers = new int[] { 2, 50, 100 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test6() {
        int[] numbers = new int[] { 4, -25, -27, -24, -23 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test7() {
        int[] numbers = new int[] { 1, 100 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test8() {
        int[] numbers = new int[] { 6, 196, 200, 199, 202, 204, 209 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test9() {
        int[] numbers = new int[] { 3000, -3002, 3005, -2997 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test10() {
        int[] numbers = new int[] { 4, 1, 4, 2, 3 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test11() {
        int[] numbers = new int[] { 5, 1, 4, 2, -1, 6 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test12() {
        int[] numbers = new int[] { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test13() {
        int[] numbers = new int[] { 10, 1, 2, 4, 7, 11, 16, 22, 29, 37, 46 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test14() {
        int[] numbers = new int[] { 10, -1, -2, -4, -7, -11, -16, -22, -29, -37, -46 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test15() {
        int[] numbers = new int[] { 10, -1, -1, -4, -7, -11, -16, -22, -29, -37, -46 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test16() {
        int[] numbers = new int[] { 1, 1 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test17() {
        int[] numbers = new int[] { 2, 1, 2 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test18() {
        int[] numbers = new int[] { 2, 2, 1 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test19() {
        int[] numbers = new int[] { 4, 0, 4, 2, 3 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test20() {
        int[] numbers = new int[] { 4, 1, 3, 2, 4 };
        Challenge201 c = new Challenge201();
        assertEquals("Not Jolly", c.isJolly(numbers));
    }

    @Test
    public void test21() {
        int[] numbers = new int[] { 1, 2 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }

    @Test
    public void test22() {
        int[] numbers = new int[] { 6, 1, 4, 3, 7, 5, 10 };
        Challenge201 c = new Challenge201();
        assertEquals("Jolly", c.isJolly(numbers));
    }
}
