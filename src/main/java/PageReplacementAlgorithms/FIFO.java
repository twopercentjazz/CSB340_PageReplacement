package PageReplacementAlgorithms;

import PageReplacementUtilities.*;
import java.util.*;

public class FIFO {
    private static final AlgorithmType type = AlgorithmType.FIFO;
    private InputConfiguration input;
    private Queue<Page> frames;
    private int faults;
    private List<String> record;

    public FIFO(InputConfiguration input) {
        setInput(input);
        setFrames(new LinkedList<>());
        setFaults(0);
        setRecord(new ArrayList<>());
    }

    public void run() {
        fillInitialFrames();
        for (int i = input.getPageFramesSize(); i < input.getPageReferenceList().length; i++) {
            addToRecord(i, !containsPage(input.getPageReferenceList()[i]));
            if (!containsPage(input.getPageReferenceList()[i])) {
                frames.poll();
                frames.add(new Page(input.getPageReferenceList()[i]));
                incrementFaults();
            }
            addToRecord();
        }
    }

    private void fillInitialFrames() {
        for (int i = 0; i < input.getPageReferenceList().length; i++) {
            if (frames.size() == input.getPageFramesSize()) {
                break;
            }
            addToRecord(i, !containsPage(input.getPageReferenceList()[i]));
            if (!containsPage(input.getPageReferenceList()[i])) {
                frames.add(new Page(input.getPageReferenceList()[i]));
                incrementFaults();
            }
            addToRecord();
        }
    }

    public InputConfiguration getInput() {
        return this.input;
    }

    public void setInput(InputConfiguration input) {
        this.input = input;
    }

    public Queue<Page> getFrames() {
        return this.frames;
    }

    public void setFrames(Queue<Page> frames) {
        this.frames = frames;
    }

    public int getFaults() {
        return this.faults;
    }

    public void setFaults(int faults) {
        this.faults = faults;
    }

    public void incrementFaults() {
        this.faults++;
    }

    public List<String> getRecord() {
        return this.record;
    }

    public void setRecord(List<String> record) {
        this.record = record;
    }

    public AlgorithmType getType() {
        return type;
    }

    public boolean containsPage(int reference) {
        for (Page p : getFrames()) {
            if (p.getReference() == reference) {
                return true;
            }
        }
        return false;
    }

    public void addToRecord(int i, boolean fault) {
        String outcome = " ";
        if (fault) {
            outcome += "fault";
        } else {
            outcome += "hit  ";
        }
        getRecord().add(input.getPageReferenceList()[i] + outcome);
    }

    public void addToRecord() {
        String temp = "[";
        for (Page p : frames) {
            temp += " " + p.getReference();
        }
        temp += " ]";
        getRecord().add(temp);
    }

    public void printRecord() {
        System.out.println("   " + getType() + " Algorithm");
        System.out.println("---------------------");
        int flag = 0;
        for (String s : record) {
            System.out.print(s + " ");
            flag++;
            if(flag == 2) {
                System.out.println();
                flag = 0;
            }
        }
        System.out.println("---------------------");
        System.out.println("Total Faults: " + getFaults());
    }
}
