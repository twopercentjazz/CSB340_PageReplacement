/** FIFO Tests */

import PageReplacementAlgorithms.*;
import PageReplacementUtilities.*;
import org.junit.jupiter.api.*;

public class TestFIFO {
    @Test
    @DisplayName("Test FIFO Results")
    void TestFIFOResults() {
        // Run simulation with test Processes
        InputConfiguration testInput = new InputConfiguration(new int[]{1,2,3,4,1,5,6,2,1,2,3,7,6,3},4);
        FIFO test = new FIFO(testInput);
        test.run();

        /** Test Page Fault Count */
        Assertions.assertEquals(11, test.getFaults());
    }
}
