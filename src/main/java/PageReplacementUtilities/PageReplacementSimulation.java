package PageReplacementUtilities;

import PageReplacementAlgorithms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PageReplacementSimulation {
    private DefaultConfigurationList input;
    private HashMap<AlgorithmType, int[]> results;

    public PageReplacementSimulation() {
        setInput(new DefaultConfigurationList());
        setResults(new HashMap<>());
        results.put(AlgorithmType.FIFO, new int[getInput().getDefaultList().length]);
        results.put(AlgorithmType.LRU, new int[getInput().getDefaultList().length]);
        results.put(AlgorithmType.OPT, new int[getInput().getDefaultList().length]);
    }

    public void runSimulation() {
        int index = 0;
        for (InputConfiguration config : getInput().getDefaultList()) {
            FIFO fifo = new FIFO(config);
            fifo.run();
            getResults().get(fifo.getType())[index] = fifo.getFaults();
            LRU lru = new LRU(config);
            lru.run();
            getResults().get(lru.getType())[index] = lru.getFaults();
            OPT opt = new OPT(config);
            opt.run();
            getResults().get(opt.getType())[index] = opt.getFaults();
            index++;
        }
    }

    public void printFaultCountResults() {
        System.out.println("\nFault Counts:");
        String header = String.format("%-9s%-7s%-6s%-6s","Config",AlgorithmType.FIFO,
                AlgorithmType.LRU,AlgorithmType.OPT);
        String border = tableBorder(header);
        System.out.println(border + "\n" + header + "\n" + border);
        for (int i = 0; i < getInput().getDefaultList().length; i++) {
            System.out.println(String.format("%-9d%-7s%-6s%-6s",i + 1,getResults().get(AlgorithmType.FIFO)[i],
                    getResults().get(AlgorithmType.LRU)[i],getResults().get(AlgorithmType.OPT)[i]));
            System.out.println(border);
            if ((i + 1) % 3 == 0 && (i + 1) % 21 != 0) {
                System.out.println(border);
            }
        }
    }

    public void printFaultRateResults() {
        System.out.println("\nFault Rates:");
        String header = String.format("%-11s%-9s%-8s%-8s","Config",AlgorithmType.FIFO,
                AlgorithmType.LRU,AlgorithmType.OPT);
        String border = tableBorder(header);
        System.out.println(border + "\n" + header + "\n" + border);
        for (int i = 0; i < getInput().getDefaultList().length; i++) {
            System.out.println(String.format("%-11d%-9.0f%-8.0f%-8.0f",i + 1,
                    (double) getResults().get(AlgorithmType.FIFO)[i] /
                            getInput().getDefaultList()[i].getPageReferenceList().length * 100,
                    (double) getResults().get(AlgorithmType.LRU)[i] /
                            getInput().getDefaultList()[i].getPageReferenceList().length * 100,
                    (double) getResults().get(AlgorithmType.OPT)[i] /
                            getInput().getDefaultList()[i].getPageReferenceList().length * 100));
            System.out.println(border);
            if ((i + 1) % 3 == 0 && (i + 1) % 21 != 0) {
                System.out.println(border);
            }
        }
    }

    public void printFaultCountAvgPerConfig(HashMap<Integer, List<Double>> avg) {
        String[] configList = {"[r:10,f:3]","[r:10,f:5]","[r:10,f:7]","[r:15,f:3]",
                "[r:15,f:5]","[r:15,f:7]","[r:20,f:3]","[r:20,f:5]","[r:20,f:7]"};
        System.out.println("\nFault Count Averages Per Configuration:");
        String header = String.format("%-17s%-10s%-10s%-10s","Config Group",AlgorithmType.FIFO,
                AlgorithmType.LRU,AlgorithmType.OPT);
        String border = tableBorder(header);
        System.out.println(border + "\n" + header + "\n" + border);
        for (int i = 1; i < 10; i++) {
            System.out.println(String.format("%-17s%-10.2f%-10.2f%-10.2f",configList[i - 1],avg.get(i).get(0),
                    avg.get(i).get(1),avg.get(i).get(2)));
            System.out.println(border);
        }
    }


    private String tableBorder(String s)
    {
        String temp = "";
        for (int i = 0; i < s.length(); i++)
        {
            temp += "-";
        }
        return temp;
    }

    public HashMap<Integer, List<Double>> configAvgs() {
        AlgorithmType[] temp = {AlgorithmType.FIFO, AlgorithmType.LRU, AlgorithmType.OPT};
        HashMap<Integer, List<Double>> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] group1 = {0, 1, 2};
        int[] group2 = {3, 4, 5};
        int[] group3 = {6, 7, 8};
        int[] group4 = {9, 10, 11};
        int[] group5 = {12, 13, 14};
        int[] group6 = {15, 16, 17};
        int[] group7 = {18, 19, 20, 21, 22, 23};
        int[] group8 = {24, 25, 26};
        int[] group9 = {27, 28, 29};
        ArrayList<int[]> groups = new ArrayList<>(Arrays.asList(group1,group2,group3,group4,
                group5,group6,group7,group8,group9));
        for (int i = 1; i < 10; i++) {
            for (AlgorithmType type : temp) {
                map.get(i).add(CalcAvg(groups.get(i - 1), type));
            }
        }
        return map;
    }

    public double CalcAvg(int[] range, AlgorithmType type)
    {
        double sum = 0;
        for (Integer i : range) {

            sum += getResults().get(type)[i];
        }
        return sum / range.length;
    }


    public DefaultConfigurationList getInput() {
        return this.input;
    }

    public void setInput(DefaultConfigurationList input) {
        this.input = input;
    }

    public HashMap<AlgorithmType, int[]> getResults() {
        return this.results;
    }

    public void setResults(HashMap<AlgorithmType, int[]> results) {
        this.results = results;
    }
}
