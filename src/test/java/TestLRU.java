/** LRU Tests */

import PageReplacementAlgorithms.*;
import PageReplacementUtilities.*;
import org.junit.jupiter.api.*;

public class TestLRU {
    @Test
    @DisplayName("Test LRU Results")
    void TestLRUResults() {
        // Run simulation with test Processes
        InputConfiguration testInput = new InputConfiguration(new int[]{1,2,3,4,1,5,6,2,1,2,3,7,6,3},4);
        LRU test = new LRU(testInput);
        test.run();

        /** Test Page Fault Count */
        Assertions.assertEquals(10, test.getFaults());
    }
}