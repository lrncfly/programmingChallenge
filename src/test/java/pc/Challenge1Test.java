package pc;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;;

public class Challenge1Test {

    private Challenge1 c;

    @Before
    public void setup(){
        this.c = new Challenge1();
    }

    @Test
    public void testChallenge1() {
        assertEquals("1 10 20", c.challenge1(1, 10));
        assertEquals("100 200 125", c.challenge1(100, 200));
        assertEquals("200 210 89", c.challenge1(200, 210));
        assertEquals("900 1000 174", c.challenge1(900, 1000));
    }

    @Test
    public void testSequenceLengthRange() {
        int[] testList = new int[] {1, 2, 8, 3, 6, 9, 17, 4, 20};
        assertEquals(generateList(testList), c.sequenceLengthRange(1, 10));
        testList = new int[] {26, 26, 26, 88, 13, 39, 13, 101, 114, 114, 114, 70, 21, 13, 34, 34, 21, 21, 34, 34, 21, 96, 21, 47, 109, 109, 109, 47, 8, 122, 29, 29, 29, 29, 29, 42, 16, 91, 16, 42, 16, 16, 104, 104, 24, 117, 117, 117, 24, 24, 16, 16, 24, 37, 24, 86, 37, 37, 37, 55, 11, 99, 24, 24, 112, 112, 112, 68, 11, 50, 11, 125, 32, 32, 32, 81, 19, 32, 32, 32, 19, 19, 94, 94, 19, 45, 19, 45, 107, 107, 107, 45, 14, 120, 120, 120, 27, 27, 27, 120};
        assertEquals(generateList(testList), c.sequenceLengthRange(100, 200));
        testList = new int[] {27, 19, 27, 40, 27, 27, 89, 89, 14, 40};
        assertEquals(generateList(testList), c.sequenceLengthRange(200, 210));
        testList = new int[] {55, 55, 55, 117, 16, 68, 16, 55, 16, 16, 42, 42, 37, 130, 130, 130, 37, 37, 130, 130, 37, 130, 37, 68, 130, 130, 130, 117, 24, 130, 37, 37, 86, 86, 86, 130, 24, 174, 24, 86, 130, 130, 130, 37, 37, 37, 37, 37, 37, 37, 29, 29, 37, 29, 37, 29, 55, 55, 55, 130, 24, 50, 50, 50, 24, 24, 24, 143, 99, 50, 99, 37, 99, 99, 143, 143, 24, 99, 50, 50, 24, 24, 143, 143, 50, 24, 50, 37, 50, 50, 99, 99, 112, 94, 24, 24, 50, 50, 50, 50};
        assertEquals(generateList(testList), c.sequenceLengthRange(900, 1000));
    }

    @Test
    public void testGenerateSequenceRecursive() {
        List<Integer> sequence = new LinkedList<Integer>();
        int[] testList = new int[] {1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(1, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {2,1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(2, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {3, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(3, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(4, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(5, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {6, 3, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(6, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(7, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(8, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {9, 28, 14, 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(9, sequence));
        sequence = new LinkedList<Integer>();
        testList = new int[] {10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceRecursive(10, sequence));
    }

    @Test
    public void testGenerateSequenceSequential() {
        int[] testList = new int[] {1};
        assertEquals(generateList(testList), c.generateSequenceSequential(1));
        testList = new int[] {2,1};
        assertEquals(generateList(testList), c.generateSequenceSequential(2));
        testList = new int[] {3, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(3));
        testList = new int[] {4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(4));
        testList = new int[] {5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(5));
        testList = new int[] {6, 3, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(6));
        testList = new int[] {7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(7));
        testList = new int[] {8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(8));
        testList = new int[] {9, 28, 14, 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(9));
        testList = new int[] {10, 5, 16, 8, 4, 2, 1};
        assertEquals(generateList(testList), c.generateSequenceSequential(10));
    }

    @Test
    public void testFindMax() {
        int[] testList = new int[] {1};
        assertEquals(1, c.findMax(generateList(testList)));
        testList = new int[] {2,1};
        assertEquals(2, c.findMax(generateList(testList)));
        testList = new int[] {3, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(16, c.findMax(generateList(testList)));
        testList = new int[] {4, 2, 1};
        assertEquals(4, c.findMax(generateList(testList)));
        testList = new int[] {5, 16, 8, 4, 2, 1};
        assertEquals(16, c.findMax(generateList(testList)));
        testList = new int[] {6, 3, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(16, c.findMax(generateList(testList)));
        testList = new int[] {7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(52, c.findMax(generateList(testList)));
        testList = new int[] {8, 4, 2, 1};
        assertEquals(8, c.findMax(generateList(testList)));
        testList = new int[] {9, 28, 14, 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
        assertEquals(52, c.findMax(generateList(testList)));
        testList = new int[] {10, 5, 16, 8, 4, 2, 1};
        assertEquals(16, c.findMax(generateList(testList)));
        testList = new int[] {};
        assertEquals(0, c.findMax(generateList(testList)));
    }

    private List<Integer> generateList(int[] sequence){
        List<Integer> list = new LinkedList<Integer>();
        for (Integer integer : sequence) {
            list.add(integer);
        }
        return list;
    }
}
