package pc;

import java.util.LinkedList;
import java.util.List;

public class Challenge1 {

    public static void main(String[] args) {
        Challenge1 c = new Challenge1();
        System.out.println(c.challenge1(1, 10));
        System.out.println(c.challenge1(100, 200));
        System.out.println(c.challenge1(200, 210));
        System.out.println(c.challenge1(900, 1000));
    }

    public String challenge1(int start, int end) {
        // return start + " " + end + " " +
        // Collections.max(sequenceLengthRange(start, end));
        return start + " " + end + " " + findMax(sequenceLengthRange(start, end));
    }

    public List<Integer> sequenceLengthRange(int start, int end) {
        List<Integer> sequence = new LinkedList<Integer>();
        for (int i = start; i < end; i++) {
            // List<Integer> tmpSequence = new LinkedList<Integer>();
            // sequence.add(generateSequenceRecursive(i, tmpSequence).size());
            sequence.add(generateSequenceSequential(i).size());
        }
        return sequence;
    }

    public List<Integer> generateSequenceRecursive(int start, List<Integer> sequence) {
        sequence.add(start);
        if (start == 1) {
            return sequence;
        } else if (start % 2 == 0) {
            return generateSequenceRecursive(start / 2, sequence);
        } else {
            return generateSequenceRecursive((start * 3) + 1, sequence);
        }
    }

    public List<Integer> generateSequenceSequential(int start) {
        List<Integer> sequence = new LinkedList<Integer>();
        while (start != 1) {
            sequence.add(start);
            if (start % 2 == 0) {
                start = start / 2;
            } else {
                start = (start * 3) + 1;
            }
        }
        sequence.add(start);
        return sequence;
    }

    public int findMax(List<Integer> list) {
        int max = 0;
        for (Integer i : list) {
            if (i > max)
                max = i;
        }
        return max;
    }
}
