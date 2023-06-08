import PageReplacementAlgorithms.*;
import PageReplacementUtilities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

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
        System.out.println();
        PageReplacementSimulation sim = new PageReplacementSimulation();
        DefaultConfigurationList testDefault = sim.getInput();


        //
        System.out.println("\nConfiguration Legend:");
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
        sim.runSimulation();
        System.out.println();
        System.out.println();

        //
        sim.printFaultCountResults();
        System.out.println();

        //
        sim.printFaultRateResults();
        System.out.println();

        //
        sim.printFaultCountAvgPerConfig(sim.configAvgs());
        System.out.println();

        //
        sim.printFaultRateAvgPerConfig(sim.configAvgs());
        System.out.println();

        //
        sim.printFaultCountTotalAvgPerConfig(sim.configAvgs());
        System.out.println();

        //
        HashMap<Double, String> results = sim.printFaultRateTotalAvgPerConfigResults(sim.configAvgs());
        ArrayList<Double> avgList = new ArrayList<>(results.keySet());
        avgList.sort(Comparator.naturalOrder());

        //
        System.out.println();
        System.out.println("The Top 3 Configurations (for this run)");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1st Place: " + results.get(avgList.get(0)) + " - with a combined average fault rate of "
                + Math.round(avgList.get(0) * 100.00)/100.00 + "%");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("2nd Place: " + results.get(avgList.get(1)) + " - with a combined average fault rate of "
                + Math.round(avgList.get(1) * 100.00)/100.00 + "%");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("3rd Place: " + results.get(avgList.get(2)) + " - with a combined average fault rate of "
                + Math.round(avgList.get(2) * 100.00)/100.00 + "%");
        System.out.println("-----------------------------------------------------------------------\n");
    }
}
