/** This interface represents all Page Replacement Algorithms. */

package PageReplacementAlgorithms;

public interface AlgorithmInterface {

    /** This method gets the type of scheduling algorithm.
     * @return the algorithm type */
    AlgorithmType getType();

    /** This method runs the algorithm (counting page faults with given input). */
    void run();

    /** This method gets the page fault count.
     * @return The page fault count. */
    int getFaults();

    /** This method prints a detailed record from running the algorithm. */
    void printRecord();

}
