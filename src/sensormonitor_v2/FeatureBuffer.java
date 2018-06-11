package sensormonitor_v2;

/**
 * Created by Michael Del Rosario on 24/05/2018.
 */
public class FeatureBuffer {
    protected int buffIdx;
    protected int featIdx;
    protected double [] buffFeat;
    protected int fixedDelay = 0;

    /**
     *
     * @param buffSize - max number of samples which can fit in the buffer
     */
    public FeatureBuffer(int buffSize){
        buffFeat = new double[buffSize];
    }

    /**
     *
     * @param buffSize    - max number of samples which can fit in the buffer
     * @param delayOffset - number of samples by which the buffer needs to be delayed
     */
    public FeatureBuffer(int buffSize, int delayOffset){
        buffFeat = new double[buffSize];
        fixedDelay = delayOffset;
    }

    /**
     *
     * @param ctr - sample counter used as an index to the buffer
     * @param val - value to be added to the buffer at the index determined by the ctr
     */
    protected void fill(int ctr, double val){
        buffIdx = ctr & (buffFeat.length-1);
        buffFeat[buffIdx]= val;
    }

    /**
     *
     * @param ctr - sample counter used as an index to the buffer
     * @return    - value in the buffer at the index determined by ctr and the delay offset 'fixedDelay'
     */
    protected double retrieve(int ctr){
        featIdx = (ctr-fixedDelay) & (buffFeat.length-1);
        return buffFeat[featIdx];
    }
}
