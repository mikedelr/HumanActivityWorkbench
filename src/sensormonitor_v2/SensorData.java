package sensormonitor_v2;

/**
 * Created by Michael Del Rosario on 30/03/2015.
 */
public class SensorData {

    public double [] acc = {0,0,0};
    public long accT=0;
    public boolean accLoaded=false;

    public double [] gyr = {0,0,0};
    public long gyrT=0;
    public boolean gyrLoaded=false;

    public double bar=0;
    public long barT=0;
    public boolean barLoaded=false;

    public double [] mag = {0,0,0};
    public long magT=0;
    public boolean magLoaded=false;

    public SensorData(){
    }

    public void reset(){
        this.acc[0]    = 0;
        this.acc[1]    = 0;
        this.acc[2]    = 0;
        this.accT      = 0;
        this.accLoaded = false;

        this.gyr[0]    = 0;
        this.gyr[1]    = 0;
        this.gyr[2]    = 0;
        this.gyrT      = 0;
        this.gyrLoaded = false;

        this.mag[0]    = 0;
        this.mag[1]    = 0;
        this.mag[2]    = 0;
        this.magT      = 0;
        this.magLoaded = false;

        this.bar       = 0;
        this.barT      = 0;
        this.barLoaded = false;
    }

    public SensorData(SensorData sensorData) {
        this.barT = sensorData.barT;
        this.bar = sensorData.bar;
    }

    public void copy(SensorData s){

    }

    public boolean isLoaded(){
        return ((accLoaded && gyrLoaded && magLoaded)
                || (accLoaded && gyrLoaded && barLoaded && magLoaded));
    }

    //For debugging will cause GC if left on
    public String toString(){
        return Long.toString(accT)+','+Double.toString(acc[0])+','+Double.toString(acc[1])+','+Double.toString(acc[2])+','+
                Long.toString(gyrT)+','+Double.toString(gyr[0])+','+Double.toString(gyr[1])+','+Double.toString(gyr[2])+','+
                Long.toString(barT)+','+Double.toString(bar)+','+
                Long.toString(magT)+','+Double.toString(mag[0])+','+Double.toString(mag[1])+','+Double.toString(mag[2]);
    }

    public String accToString(){
        return Long.toString(accT);
    }

    //For debugging will cause GC if left on
    public String timesToString(){
        return Long.toString(accT)+','+Long.toString(gyrT)+','+Long.toString(barT)+','+Long.toString(magT);
    }

}
