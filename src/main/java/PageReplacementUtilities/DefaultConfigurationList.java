package PageReplacementUtilities;

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
    }

    public InputConfiguration[] getDefaultList() {
        return this.defaultList;
    }
}
