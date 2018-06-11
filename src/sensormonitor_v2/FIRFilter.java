package sensormonitor_v2;

/**
 * Created by Michael Del Rosario on 15/05/2018.
 */

/**
 * Class which implements a Finite Impulse Response filter
 */
public class FIRFilter {
    protected double filtVal;
    protected int buffIdx;
    protected int fwdLoops;
    protected int backPtr;
    final protected double[] _buffer;
    final protected double[] _coeffs;

    /**
     *
     * @param buffSize     - maximum number of samples which can fit in the buffer
     * @param coefficients - array of filter coefficients
     */
    public FIRFilter(int buffSize, double[] coefficients){
        _buffer = new double[buffSize];
        _coeffs = coefficients;
    }

    /**
     *
     * @param ctr - counter used to index into buffer
     * @param val - value to add to filter buffer prior to processing
     */
    protected double process(int ctr, double val){
        buffIdx = ctr & (_buffer.length-1);
        _buffer[buffIdx]= val;

        filtVal = 0; // reset before calculating the new value
        fwdLoops = buffIdx+1;
        backPtr  = 1;
//        Log.d(TAG,"fwdLoops: "+fwdLoops);
        if (fwdLoops >_coeffs.length){ // If the length of the sensor data buffer is longer than the filter
            fwdLoops=_coeffs.length;
        }
        for(int f=0; f<fwdLoops; f++){ // at least once
//            Log.d(TAG,"buffIdx: "+buffIdx+ " f: "+ f);
            filtVal += _buffer[buffIdx] * _coeffs[f];
            buffIdx --;
        }
        for(int b=fwdLoops; b<_coeffs.length; b++){
//            Log.d(TAG,"signalBuffer.length-backPtr: "+(signalBuffer.length-backPtr)+ " b: "+ b);
            filtVal += _buffer[_buffer.length-backPtr]* _coeffs[b];
            backPtr ++;
        }
        return filtVal;
    }
}
