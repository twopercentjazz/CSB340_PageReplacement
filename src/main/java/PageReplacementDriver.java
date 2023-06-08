import PageReplacementAlgorithms.*;
import PageReplacementUtilities.*;

public class PageReplacementDriver {

    public static void main(String[] args) {
        //
        InputConfiguration testInput = new InputConfiguration(new int[]{1,2,3,4,1,5,6,2,1,2,3,7,6,3},4);

        FIFO test1 = new FIFO(testInput);
        test1.run();
        System.out.println();
        test1.printRecord();
        System.out.println();

        LRU test2 = new LRU(testInput);
        test2.run();
        test2.printRecord();
        System.out.println();

        OPT test3 = new OPT(testInput);
        test3.run();
        test3.printRecord();
        System.out.println();

        //
        DefaultConfigurationList testDefault = new DefaultConfigurationList();
        int count = 1;
        String space = " ";
        for (InputConfiguration config : testDefault.getDefaultList()) {
            System.out.print("[input " + count + "]" + space + " FrameSize: " + config.getPageFramesSize()
                    + "  RefList: [");
            count++;
            if (count == 10) {
                space = "";
            }
            for (int i : config.getPageReferenceList()) {
                System.out.print(" " + i);
            }
            System.out.print(" ] RefListSize: " + config.getPageReferenceList().length);
            System.out.println();
        }

        //
        System.out.println();
        PageReplacementSimulation sim = new PageReplacementSimulation();
        sim.runSimulation();
        sim.printResults();
    }
}
