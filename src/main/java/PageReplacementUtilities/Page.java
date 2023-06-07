package PageReplacementUtilities;

public class Page implements Comparable<Page> {
    private int reference;
    private int priority;

    public Page(int reference) {
        setReference(reference);
        setPriority(0);
    }

    @Override
    public int compareTo(Page other) {
        if(this.priority == other.getPriority()) {
            return 0;
        } else if(this.priority > other.getPriority()) {
            return -1;
        } else {
            return 1;
        }
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void incrementPriority() {
        this.priority++;
    }

    public int getReference() {
        return this.reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }
}
