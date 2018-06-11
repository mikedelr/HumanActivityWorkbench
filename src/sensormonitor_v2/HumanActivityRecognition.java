package sensormonitor_v2;

/**
 * Created by Michael Del Rosario on 14/01/2016.
 */
public class HumanActivityRecognition {
    public static final String TAG = "FilterSensorData";
    protected static final int TWO_AND_A_HALF_SEC = 100; //2.50 seconds @ 40Hz
    protected static final int ONE_AND_A_QTR_SEC  = 50;  //1.25 seconds @ 40Hz
    public static final int ACC_GYR_MAG_DELAY_MICROS = 25000; // 40hz
    public static final int PRESSURE_DELAY_MICROS    = 50000; // 20Hz
    public static final double GYR_DT = (double)ACC_GYR_MAG_DELAY_MICROS/1000000;

    /**
     * Buffer sizes declared here must be power of two so that we can iterate through the buffer using bit-shifting
     * which is computationally efficient compared to using modulus operator
     */
    protected static int RUNNING_BUFFER_SIZE = 128;
    protected static int FILTER_BUFFER_SIZE = 512;
    protected static int WINDOW_BUFFER_SIZE = 256;
    protected static int MAX_BUFFER_SIZE = Math.max(Math.max(RUNNING_BUFFER_SIZE,FILTER_BUFFER_SIZE),WINDOW_BUFFER_SIZE);

    protected static int CNT_RESET_VALUE = MAX_BUFFER_SIZE*MAX_BUFFER_SIZE*MAX_BUFFER_SIZE;

    protected boolean _bDifPreConverged = false;

    /**
     * counter for accelerometer/gyroscope/magnetometer (MIMU) data //
     */
    protected int _smpCtr = 0;

    /**
     * counter for barometer which is sampled at a reduced rate compared to MIMU
     */
    protected int _barSmpCtr = 0;

    /**
     * DigitalFilter Objects
     **/
    protected FIRFilter _firFilterLpfDifBar = new FIRFilter(FILTER_BUFFER_SIZE, FilterCoefficients.difPre80);

    protected FIRFilter _firFilterLpfDifAccX = new FIRFilter(FILTER_BUFFER_SIZE, FilterCoefficients.lpfDif50);
    protected FIRFilter _firFilterLpfDifAccY = new FIRFilter(FILTER_BUFFER_SIZE, FilterCoefficients.lpfDif50);
    protected FIRFilter _firFilterLpfDifAccZ = new FIRFilter(FILTER_BUFFER_SIZE, FilterCoefficients.lpfDif50);

    protected FIRFilter _firFilterBpfGyrX = new FIRFilter(FILTER_BUFFER_SIZE, FilterCoefficients.bpf_1_18);
    protected FIRFilter _firFilterBpfGyrY = new FIRFilter(FILTER_BUFFER_SIZE, FilterCoefficients.bpf_1_18);
    protected FIRFilter _firFilterBpfGyrZ = new FIRFilter(FILTER_BUFFER_SIZE, FilterCoefficients.bpf_1_18);

    /**
     *  allocate memory for the most recent filtered values
     **/
    public double _difPre = 0;

    public double _lpfDifAccX = 0;
    public double _lpfDifAccY = 0;
    public double _lpfDifAccZ = 0;
    public double _sumSqLpfDifAccXYZ = 0;

    public double _bpfGyrX = 0;
    public double _bpfGyrY = 0;
    public double _bpfGyrZ = 0;
    public double _sumSqBpfGyrXYZ = 0;

    /**
     *  Window Handlers for calculating the running sum
     **/
    WindowHandler _winHandSumDifPre = new WindowHandler(WINDOW_BUFFER_SIZE, TWO_AND_A_HALF_SEC);
    WindowHandler _winHandSumSqBpfGyrXYZ = new WindowHandler(WINDOW_BUFFER_SIZE, TWO_AND_A_HALF_SEC);
    WindowHandler _winHandSumSqLpfDifAccXYZ = new WindowHandler(WINDOW_BUFFER_SIZE, TWO_AND_A_HALF_SEC);

    /**
     *  Feature buffers
     */
    private static final int delayAccGyr = 110;
    FeatureBuffer _featBuffSumDifPre = new FeatureBuffer(WINDOW_BUFFER_SIZE);
    FeatureBuffer _featBuffSumSqLpfDifAccXYZ = new FeatureBuffer(WINDOW_BUFFER_SIZE, delayAccGyr);
    FeatureBuffer _featBuffSumSqBpfGyrXYZ = new FeatureBuffer(WINDOW_BUFFER_SIZE, delayAccGyr);

    /**
     *  Running sum Values for accumulated features
     */
    public double _cRunSumDifPre = 0;
    public double _cRunSumSqBpfGyrXYZ = 0;
    public double _cRunSumSqLpfDifAccXYZ = 0;

    /**
     *  Counter for determining when to classify the activity
     */
    protected int _featureCtr = 0;
    protected boolean _bClassifyNow = false;
    public static int TIME_TO_CLASSIFY = ONE_AND_A_QTR_SEC;


    /**
     *  Feature vectors for classification
     **/
    protected double _featSumDifPre = 0;
    protected double _featSumSqBpfGyrXYZ = 0;
    protected double _featSumSqLpfDifAccXYZ = 0;

    /**
     * Model built using the J48 Decision Tree Algorithm
     */
    protected ClassifierBasic _classifierBasic = new ClassifierBasic();

    protected int _stateIdentified = -1;

    /**
     * Default constructor
     */
    public HumanActivityRecognition(){

    }

    /**
     *  Reset the sample counters to zero once they reach a pre-defined maximum value
     **/
    public void checkCounters(){
        if(_smpCtr == CNT_RESET_VALUE){
            _smpCtr = 0;
        }
        if(_barSmpCtr == CNT_RESET_VALUE){
            _barSmpCtr = 0;
        }
    }

    public int getStateIdentified(){
        return _stateIdentified;
    }

    public void update(SensorData sensorData){
        checkCounters();
//        Log.d(TAG, "smpCtr:" + smpCtr);

        /**
         * Process barometer data
         */
        processBarometerData(sensorData);
//        if(sensorData.barLoaded){
////            Log.d(TAG, "smpCtr: " + smpCtr + " barSmpCtr: " + barSmpCtr);
//            if (!_bDifPreConverged) {
//                if (!(_barSmpCtr < FilterCoefficients.difPre80.length)) {
//                    _bDifPreConverged = true;
//                }
//            }
//            _difPre = _firFilterLpfDifBar.process(_barSmpCtr,sensorData.bar);
//            if (!_bDifPreConverged) {
//                _difPre = 0;
//            }
//            _barSmpCtr++;
//        }

        /**
         * Process Accelerometer Signals
         */
        processAccelerometerData(sensorData);
//        _lpfDifAccX = _firFilterLpfDifAccX.process(_smpCtr, sensorData.acc[0]);
//        _lpfDifAccY = _firFilterLpfDifAccY.process(_smpCtr, sensorData.acc[1]);
//        _lpfDifAccZ = _firFilterLpfDifAccZ.process(_smpCtr, sensorData.acc[2]);
//        _sumSqLpfDifAccXYZ = _lpfDifAccX * _lpfDifAccX + _lpfDifAccY * _lpfDifAccY + _lpfDifAccZ * _lpfDifAccZ;

        /**
         * Process Gyroscope Signals
         */
        processGyroscopeData(sensorData);
//        _bpfGyrX = _firFilterBpfGyrX.process(_smpCtr,sensorData.gyr[0]);
//        _bpfGyrY = _firFilterBpfGyrY.process(_smpCtr,sensorData.gyr[1]);
//        _bpfGyrZ = _firFilterBpfGyrZ.process(_smpCtr,sensorData.gyr[2]);
//        _sumSqBpfGyrXYZ = (_bpfGyrX * _bpfGyrX + _bpfGyrY * _bpfGyrY + _bpfGyrZ * _bpfGyrZ);

        /**
         * Calculate running sums
         */
        _cRunSumDifPre = _winHandSumDifPre.updateRunningSum(_smpCtr, _difPre);
        _cRunSumSqBpfGyrXYZ = _winHandSumSqBpfGyrXYZ.updateRunningSum(_smpCtr, _sumSqBpfGyrXYZ);
        _cRunSumSqLpfDifAccXYZ = _winHandSumSqLpfDifAccXYZ.updateRunningSum(_smpCtr, _sumSqLpfDifAccXYZ);

        /**
         * Add running sums to buffer to account for delay
         */
        _featBuffSumDifPre.fill(_smpCtr, _cRunSumDifPre);
        _featBuffSumSqBpfGyrXYZ.fill(_smpCtr, _cRunSumSqBpfGyrXYZ);
        _featBuffSumSqLpfDifAccXYZ.fill(_smpCtr, _cRunSumSqLpfDifAccXYZ);

        if (_bDifPreConverged) {
            _featureCtr++;
//            Log.d(TAG,"featureCtr: "+featureCtr);
            if (_featureCtr == TIME_TO_CLASSIFY){
                _bClassifyNow = true;
                _featureCtr = 0; //reset the counter
            } else{
                _bClassifyNow = false;
            }
        }
        /** Store as vector and classify**/
        if (_bClassifyNow){
//            Log.d(TAG, "smpCtr:" + smpCtr);
//            Log.d(TAG,"...ready to classify");

            _featSumDifPre = _featBuffSumDifPre.retrieve(_smpCtr);
            _featSumSqBpfGyrXYZ = _featBuffSumSqBpfGyrXYZ.retrieve(_smpCtr);
            _featSumSqLpfDifAccXYZ = _featBuffSumSqLpfDifAccXYZ.retrieve(_smpCtr);

            _stateIdentified = _classifierBasic.classifyThreeFeaturesPMEAS(
                    _featSumDifPre, _featSumSqBpfGyrXYZ, _featSumSqLpfDifAccXYZ);
        }
        /** Increment Counters **/
        _smpCtr++;
    }

    public void processAccelerometerData(SensorData sensorData){
        _lpfDifAccX = _firFilterLpfDifAccX.process(_smpCtr, sensorData.acc[0]);
        _lpfDifAccY = _firFilterLpfDifAccY.process(_smpCtr, sensorData.acc[1]);
        _lpfDifAccZ = _firFilterLpfDifAccZ.process(_smpCtr, sensorData.acc[2]);
        _sumSqLpfDifAccXYZ = _lpfDifAccX * _lpfDifAccX + _lpfDifAccY * _lpfDifAccY + _lpfDifAccZ * _lpfDifAccZ;
    }

    public void processGyroscopeData(SensorData sensorData){
        _bpfGyrX = _firFilterBpfGyrX.process(_smpCtr,sensorData.gyr[0]);
        _bpfGyrY = _firFilterBpfGyrY.process(_smpCtr,sensorData.gyr[1]);
        _bpfGyrZ = _firFilterBpfGyrZ.process(_smpCtr,sensorData.gyr[2]);
        _sumSqBpfGyrXYZ = (_bpfGyrX * _bpfGyrX + _bpfGyrY * _bpfGyrY + _bpfGyrZ * _bpfGyrZ);
    }

    public void processBarometerData(SensorData sensorData){
        if(sensorData.barLoaded){
//            Log.d(TAG, "smpCtr: " + smpCtr + " barSmpCtr: " + barSmpCtr);
            if (!_bDifPreConverged) {
                if (!(_barSmpCtr < FilterCoefficients.difPre80.length)) {
                    _bDifPreConverged = true;
                }
            }
            _difPre = _firFilterLpfDifBar.process(_barSmpCtr,sensorData.bar);
            if (!_bDifPreConverged) {
                _difPre = 0;
            }
            _barSmpCtr++;
        }
    }

    /**
     * Debugging Helper functions below
     */

    public double get_featSumDifPre(){return _featSumDifPre;}

    public double get_featSumSqBpfGyrXYZ(){return _featSumSqBpfGyrXYZ;}

    public double get_featSumSqLpfDifAccXYZ(){return _featSumSqLpfDifAccXYZ;}
}
