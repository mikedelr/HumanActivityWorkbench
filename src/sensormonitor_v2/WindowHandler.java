package sensormonitor_v2;

/**
 * Created by Michael Del Rosario on 17/01/2016.
 *
 * Class for managing the contents of a buffer that contains filtered signals that are kept for a pre-defined
 * window equal to the length of the buffer
 */
public class WindowHandler {
    protected int buffIdx;
    protected int winIdx;
    protected int oldIdx;
    protected double runningSum;
    protected double [] buffRunSum = new double[]{};
    protected int nSumLength = 0;

    /**
     *
     * @param buffSize    - max number of samples which can be stored in the buffer
     * @param lengthToSum - number of samples to sum
     */
    public WindowHandler(int buffSize, int lengthToSum){
        buffRunSum = new double[buffSize];
        nSumLength = lengthToSum;
    }

    /**
     *
     * @param smpCtr - sample count used to index buffer
     * @param val    - value to be added to the running sum
     * @return       - updated running sum
     */
    protected double updateRunningSum(int smpCtr, double val){
        buffIdx = smpCtr & (buffRunSum.length-1);
        buffRunSum[buffIdx]= val;
        winIdx =  smpCtr & (buffRunSum.length-1);
        //add new value to the running sum
        runningSum += buffRunSum[winIdx];
        oldIdx = winIdx-nSumLength;
        if (oldIdx < 0){
            oldIdx = buffRunSum.length - nSumLength + winIdx;
        }
        //subtract the oldest value from the running sum
        runningSum -= buffRunSum[oldIdx];
        return runningSum;
    }
}
