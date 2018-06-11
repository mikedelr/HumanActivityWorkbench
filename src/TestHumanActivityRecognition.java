import org.junit.Test;
import sensormonitor_v2.HumanActivityRecognition;
import sensormonitor_v2.SensorData;

import java.util.ArrayList;

/**
 * Created by Michael Del Rosario on 12/04/2018.
 */
public class TestHumanActivityRecognition {
    public TestHumanActivityRecognition() {
    }

    @Test
    public void Test_complete(){
        System.out.println("Start of loop");
        SensorData sensorData;
        CSVRead rawRead = new CSVRead(DataHelper.fileRawSensorData); 		// READ DATA FILE
        rawRead.ReadFile();
        int SIMULATION_LENGTH = rawRead.rowList.size();
//        System.out.println("simLength: "+ SIMULATION_LENGTH);
        HumanActivityRecognition _har = new HumanActivityRecognition();

        for (int i=0; i<  SIMULATION_LENGTH; i++){
            ArrayList<Double> rawSensorData; //raw sensor data
            rawSensorData = rawRead.rowList.get(i);
            sensorData = DataHelper.updateData(rawSensorData);
//            _filterSensorData.update(sensorData);
            _har.update(sensorData);
            int stateToPrint = _har.getStateIdentified();

            /**
             * Output state estimate
             */
            System.out.println("state; "+stateToPrint + ";");

            /**
             * Output aligned feature values
             */
//            System.out.println("i : " + i + " , " + _filterSensorData2.get_featSumDifPre() + " , "
//                    + _filterSensorData2.get_featSumSqBpfGyrXYZ() + " , "
//                    + _filterSensorData2.get_featSumSqLpfDifAccXYZ());
        }
    }
}
