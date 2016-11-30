package pc;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Challenge8Test {

    @Test
    public void testSample() {
        String[] candidates = new String[] { "John Doe", "Jane Doe", "Jane Austen" };
        Challenge8 c = new Challenge8();
        int[][] ballots = { { 1, 2, 3 }, { 2, 1, 3 }, { 2, 3, 1 }, { 1, 2, 3 }, { 3, 1, 2 } };
        c.setCandidates(candidates);
        c.setBallots(ballots);
        List<String> elected = new LinkedList<>();
        elected.add("John Doe");
        assertEquals(elected, c.count());
    }

    @Test
    public void testTie() {
        String[] candidates = new String[] { "John Doe", "Jane Doe", "Jane Austen", "John Grisham" };
        Challenge8 c = new Challenge8();
        int[][] ballots = { { 1, 2, 3, 4 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 1, 2, 4, 3 }, { 3, 1, 4, 2 },
                { 4, 3, 2, 1 } };
        c.setCandidates(candidates);
        c.setBallots(ballots);
        List<String> elected = new LinkedList<>();
        elected.add("John Doe");
        elected.add("John Grisham");
        assertEquals(elected, c.count());
    }

    @Test
    public void testWin() {
        String[] candidates = new String[] { "John Doe", "Jane Doe", "Jane Austen", "John Grisham" };
        Challenge8 c = new Challenge8();
        int[][] ballots = { { 1, 2, 3, 4 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 1, 2, 4, 3 }, { 3, 1, 4, 2 },
                { 4, 3, 2, 1 }, { 4, 2, 1, 3 } };
        c.setCandidates(candidates);
        c.setBallots(ballots);
        List<String> elected = new LinkedList<>();
        elected.add("John Grisham");
        assertEquals(elected, c.count());
    }
}
