import sensormonitor_v2.SensorData;

import java.util.ArrayList;

/**
 * Created by Michael Del Rosario on 12/04/2018.
 */
public class DataHelper {
    public static final String HOME_DIR = System.getProperty("user.home");
    public static final String SUB_DIR = "\\Dropbox\\PostGrad\\2015\\ActClassAhrs\\RealTimeVerification\\CSVFiles\\";
    public static final String rtSubDir = "\\Dropbox\\PostGrad\\2015\\ActClassAhrs\\RealTimeVerification\\CompleteTest\\";
    public static final String fileRawSensorData = HOME_DIR + rtSubDir + "AccGyrMagBar_2016114_132857.csv";//
    public static final String rtPMEASDir = "\\Dropbox\\PostGrad\\2015\\ActClassAhrs\\RealTimeVerification\\CompleteTest\\PMEAS_RT_DATA\\";
    private static double timeScale = 1000000;

    public static SensorData updateData(ArrayList<Double> rawSensorValues){
        SensorData sensorData = new SensorData();
        sensorData.accT   = new Double (((rawSensorValues.get(0))*timeScale )).longValue();
        sensorData.acc[0] = (rawSensorValues.get(1));
        sensorData.acc[1] = (rawSensorValues.get(2));
        sensorData.acc[2] = (rawSensorValues.get(3));
        sensorData.accLoaded =true;
        sensorData.gyrT   = new Double (((rawSensorValues.get(4))*timeScale )).longValue();
        sensorData.gyr[0] = (rawSensorValues.get(5));
        sensorData.gyr[1] = (rawSensorValues.get(6));
        sensorData.gyr[2] = (rawSensorValues.get(7));
        sensorData.gyrLoaded =true;
        sensorData.barT = 0;
        sensorData.bar  = 0;
        sensorData.barLoaded = false;
//        System.out.println("isNan: " + Double.isNaN( rawSensorValues.get(9))  );
        if (  !Double.isNaN( rawSensorValues.get(9)) ) {
            sensorData.barT = new Double ((rawSensorValues.get(8)*timeScale)).longValue();
            sensorData.bar  = (rawSensorValues.get(9));
            sensorData.barLoaded = true;
        }
        sensorData.magT   = new Double(((rawSensorValues.get(10))*timeScale )).longValue();
        sensorData.mag[0] = (rawSensorValues.get(11));
        sensorData.mag[1] = (rawSensorValues.get(12));
        sensorData.mag[2] = (rawSensorValues.get(13));
        sensorData.magLoaded =true;
        return sensorData;
    }

}
