package pc;

import java.util.HashSet;
import java.util.Set;

public class Challenge201 {

    public static void main(String[] args) {
        int[] numbers = new int[] { 4, 1, 4, 2, 3 };

        Challenge201 c = new Challenge201();
        String jolly = c.isJolly(numbers);
        System.out.println(jolly);
        numbers = new int[] { 5, 1, 4, 2, -1, 6 };
        jolly = c.isJolly(numbers);
        System.out.println(jolly);
    }

    public String isJolly(int[] numbers) {
        String jolly = "Jolly";
        if (numbers.length == 2)
            return jolly;
        Set<Integer> n = new HashSet<>();
        for (int i = 1; i < numbers.length - 1; i++) {
            int diff = Math.abs(numbers[i] - numbers[i + 1]);
            if (diff > 0 && diff < numbers[0])
                n.add(diff);
            else
                return "Not Jolly";
        }
        if (n.size() != numbers[0] - 1)
            jolly = "Not Jolly";
        return jolly;
    }
}
