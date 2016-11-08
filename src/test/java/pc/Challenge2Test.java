package pc;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Challenge2Test {

    @Test
    public void testSolve1() {
        String[][] matrix = new String[][] {
            { "*", ".", ".", "." },
            { ".", ".", ".", "." },
            { ".", "*", ".", "." },
            { ".", ".", ".", "." } };
        String[][] expected = new String[][] {
            { "*", "1", "0", "0" },
            { "2", "2", "1", "0" },
            { "1", "*", "1", "0" },
            { "1", "1", "1", "0" } };
        Challenge2 c = new Challenge2(4, 4);
        String[][] solution = c.solve(matrix);
        assertArrayEquals(expected, solution);
    }

    @Test
    public void testSolve2() {
        String[][] matrix = new String[][] {
            { "*", "*", ".", ".", "." },
            { ".", ".", ".", ".", "." },
            { ".", "*", ".", ".", "." } };
        String[][] expected = new String[][] {
            { "*", "*", "1", "0", "0" },
            { "3", "3", "2", "0", "0" },
            { "1", "*", "1", "0", "0" } };
        Challenge2 c = new Challenge2(3, 5);
        String[][] solution = c.solve(matrix);
        assertArrayEquals(expected, solution);
    }

    @Test
    public void testSolve3() {
        String[][] matrix = new String[][] {};
        String[][] expected = new String[][] {};
        Challenge2 c = new Challenge2(0, 0);
        String[][] solution = c.solve(matrix);
        assertArrayEquals(expected, solution);
    }
}
