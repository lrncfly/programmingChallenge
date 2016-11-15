package pc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Challenge6Test {
    private Challenge6 challenge6;

    @Before
    public void setUp() throws Exception {
        int[] instructions = new int[] { 299, 492, 495, 399, 492, 495, 399, 283, 279, 689, 78, 100, 000, 000, 000 };
        this.challenge6 = new Challenge6(instructions);
    }

    @Test
    public void testProcessInstructions() {
        assertEquals(16, this.challenge6.processInstructions());
    }

}
