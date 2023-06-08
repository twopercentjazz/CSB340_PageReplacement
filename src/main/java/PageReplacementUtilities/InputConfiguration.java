/** This class represents page replacement input consisting of a reference list and a frame size. */

package PageReplacementUtilities;
import java.util.Random;

public class InputConfiguration {
    private static final int[] given1 = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
    private static final int[] given2 = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
    private static final int[] given3 = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
    private int[] pageReferenceList;
    private int pageFramesSize;


    public InputConfiguration(int page, int frame) {
        if (page > 0) {
            setPageReferenceList(createRandomList(page));
        } else {
            if (page == -1) {
                setPageReferenceList(given1);
            } else if (page == -2) {
                setPageReferenceList(given2);
            } else {
                setPageReferenceList(given3);
            }
        }
        setPageFramesSize(frame);
    }

    public InputConfiguration(int[] reference, int frame) {
        setPageReferenceList(reference);
        setPageFramesSize(frame);
    }

    public int[] createRandomList(int size) {
        Random rand = new Random();
        int[] list = new int[size];
        for(int i = 0; i < size; i ++) {
            list[i] = rand.nextInt(10);
        }
        return list;
    }

    public int getPageFramesSize() {
        return this.pageFramesSize;
    }

    public void setPageFramesSize(int size) {
        this.pageFramesSize = size;
    }

    public int[] getPageReferenceList() {
        return this.pageReferenceList;
    }

    public void setPageReferenceList(int[] list) {
        this.pageReferenceList = list;
    }
}
