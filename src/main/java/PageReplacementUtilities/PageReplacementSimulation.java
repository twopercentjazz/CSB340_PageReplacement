package PageReplacementUtilities;

import PageReplacementAlgorithms.*;

import java.util.HashMap;

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


    private static String tableBorder(String s)
    {
        String temp = "";
        for (int i = 0; i < s.length(); i++)
        {
            temp += "-";
        }
        return temp;
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
