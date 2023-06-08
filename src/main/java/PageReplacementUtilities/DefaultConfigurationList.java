package PageReplacementUtilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DefaultConfigurationList {
    final static int initialFrameSize = 3;
    final static int defaultConfigurationCount = 30;
    final static int[] listSizes = {10, 15, 20};
    final static int[] FrameSizes = {3, 5, 7};
    private InputConfiguration[] defaultList;

    public DefaultConfigurationList() {
        defaultList = new InputConfiguration[defaultConfigurationCount];
        for(int i = 0; i < 3; i++) {
            defaultList[i] = new InputConfiguration((i + 1) * -1, initialFrameSize);
        }
        int index = 3;
        for(int i  = 0; i < 3; i++) {
            for(int j  = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    defaultList[index] = new InputConfiguration((listSizes[j]), FrameSizes[k]);
                    index++;
                }
            }
        }
        setDefaultList(groupConfigs());
    }

    public InputConfiguration[] getDefaultList() {
        return this.defaultList;
    }

    public void setDefaultList(InputConfiguration[] defaultList) {
        this.defaultList = defaultList;
    }

    private InputConfiguration[] groupConfigs() {
        InputConfiguration[] temp = new InputConfiguration[defaultList.length];
        HashMap<Integer, List<InputConfiguration>> map = createConfigMap();
        int index = 0;
        for (int i = 1; i < 10; i++) {
            for (InputConfiguration config : map.get(i)) {
                temp[index] = config;
                index++;
            }
        }
        return temp;
    }

    private HashMap<Integer, List<InputConfiguration>> createConfigMap() {
        HashMap<Integer, List<InputConfiguration>> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < 3; i++) {
            map.get(7).add(getDefaultList()[i]);
        }
        for (int i = 3; i < getDefaultList().length; i += 9) {
            map.get(1).add(getDefaultList()[i]);
        }
        for (int i = 4; i < getDefaultList().length; i += 9) {
            map.get(2).add(getDefaultList()[i]);
        }
        for (int i = 5; i < getDefaultList().length; i += 9) {
            map.get(3).add(getDefaultList()[i]);
        }
        for (int i = 6; i < getDefaultList().length; i += 9) {
            map.get(4).add(getDefaultList()[i]);
        }
        for (int i = 7; i < getDefaultList().length; i += 9) {
            map.get(5).add(getDefaultList()[i]);
        }
        for (int i = 8; i < getDefaultList().length; i += 9) {
            map.get(6).add(getDefaultList()[i]);
        }
        for (int i = 9; i < getDefaultList().length; i += 9) {
            map.get(7).add(getDefaultList()[i]);
        }
        for (int i = 10; i < getDefaultList().length; i += 9) {
            map.get(8).add(getDefaultList()[i]);
        }
        for (int i = 11; i < getDefaultList().length; i += 9) {
            map.get(9).add(getDefaultList()[i]);
        }
        return map;
    }
}
