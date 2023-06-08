/** OPT Tests */

import PageReplacementAlgorithms.*;
import PageReplacementUtilities.*;
import org.junit.jupiter.api.*;

public class TestOPT {
    @Test
    @DisplayName("Test OPT Results")
    void TestOPTResults() {
        // Run simulation with test Processes
        InputConfiguration testInput = new InputConfiguration(new int[]{1,2,3,4,1,5,6,2,1,2,3,7,6,3},4);
        OPT test = new OPT(testInput);
        test.run();

        /** Test Page Fault Count */
        Assertions.assertEquals(7, test.getFaults());
    }
}