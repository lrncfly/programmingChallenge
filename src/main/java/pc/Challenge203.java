package pc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Challenge203 {

    public static void main(String[] args) {
        Challenge203 c = new Challenge203();
        Map<Integer, List<Integer>> hartals = c.calculateHartals(14, 3, 4, 8);
        System.out.println(hartals.size());
        hartals = c.calculateHartals(100, 12, 15, 25, 40);
        System.out.println(hartals.size());
    }

    Map<Integer, List<Integer>> calculateHartals(int days, int ... hartal){
        Map<Integer, List<Integer>> hartals = new HashMap<>();
        for(int h: hartal) {
            int i = 0;
            while(i <= days){
                if (i % 7 != 0 && i %7 != 6 && i % h == 0){
                    if (!hartals.containsKey(i))
                        hartals.put(i, new LinkedList<>());
                    hartals.get(i).add(h);
                }
                i++;
            }
        }
        return hartals;
    }
}
