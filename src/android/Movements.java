package android;



import java.util.HashMap;

/**
 * Created by Michael Del Rosario on 17/04/2015.
 */
public class Movements {
    public static final int NUM_ACTIVITIES = 6;
    public static final int STANDING = 1;
    public static final int SITTING = 2;
    public static final int LYING   = 3;
    public static final int WALKING = 4;
    public static final int WALKUP  = 5;
    public static final int WALKDN  = 6;
    public static final int LIFTUP  = 7;
    public static final int LIFTDN  = 8;
    public static final int TRANSITION = 9;
    public static final int SEDENTARY  = 10;
    public static final int STATIONARY = 11;


    public static final double TIME_CONSTANT = 1.28;
    public static final int    ACT_COUNT_PER_HOUR = 2440;
    // TODO: add additional movements here
//    public static void toContentValues(long timestamp, String activityStr, ContentValues contentValues){
//        contentValues.clear();
//        contentValues.put(MovementSQLiteHelper.COLUMN_ACTIVITY, activityStr);
//        contentValues.put(MovementSQLiteHelper.COLUMN_DATE_TIME,timestamp);
//        contentValues.put(MovementSQLiteHelper.COLUMN_SYNC,MovementSQLiteHelper.SYNC_STATUS_NEGATIVE);
//    }
//


    /** Profile definitions for activity upload of AIT app data **/
    public static final HashMap<String,Integer> NewResults5;
    static
    {
        NewResults5 = new HashMap<>();
        NewResults5.put("MDC_VND_UNSW_ACTIVITY_TYPE_WALKING"    ,0);
        NewResults5.put("MDC_VND_UNSW_ACTIVITY_TYPE_WALKUP"     ,0);
        NewResults5.put("MDC_VND_UNSW_ACTIVITY_TYPE_WALKDN"     ,0);
        NewResults5.put("MDC_VND_UNSW_ACTIVITY_TYPE_TRANSITION" ,0);
        NewResults5.put("MDC_VND_UNSW_ACTIVITY_TYPE_STATIONARY" ,0);
    }

    /** Profile definitions for activity upload of AIT app data **/
    public static final HashMap<String,Integer> NewResults;
    static
    {
        NewResults = new HashMap<>();
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_STANDING"   ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_SITTING"    ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_LYING"      ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_WALKING"    ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_WALKUP"     ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_WALKDN"     ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_LIFTUP"     ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_LIFTDN"     ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_TRANSITION" ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_SEDENTARY"  ,0);
        NewResults.put("MDC_VND_UNSW_ACTIVITY_TYPE_STATIONARY" ,0);
    }

    /** Profile definitions for activity upload of AIT app data **/
    public static final HashMap<Integer,String> AITKey;
    static
    {
        AITKey = new HashMap<>();
        AITKey.put(STANDING,   "MDC_VND_UNSW_ACTIVITY_TYPE_STANDING");
        AITKey.put(SITTING,    "MDC_VND_UNSW_ACTIVITY_TYPE_SITTING");
        AITKey.put(LYING,      "MDC_VND_UNSW_ACTIVITY_TYPE_LYING");
        AITKey.put(WALKING,    "MDC_VND_UNSW_ACTIVITY_TYPE_WALKING");
        AITKey.put(WALKUP,     "MDC_VND_UNSW_ACTIVITY_TYPE_WALKUP");
        AITKey.put(WALKDN,     "MDC_VND_UNSW_ACTIVITY_TYPE_WALKDN");
        AITKey.put(LIFTUP,     "MDC_VND_UNSW_ACTIVITY_TYPE_LIFTUP");
        AITKey.put(LIFTDN,     "MDC_VND_UNSW_ACTIVITY_TYPE_LIFTDN");
        AITKey.put(TRANSITION, "MDC_VND_UNSW_ACTIVITY_TYPE_TRANSITION");
        AITKey.put(SEDENTARY,  "MDC_VND_UNSW_ACTIVITY_TYPE_SEDENTARY");
        AITKey.put(STATIONARY, "MDC_VND_UNSW_ACTIVITY_TYPE_STATIONARY");
        //TODO: add stationary key
//        AITKey.put(STATIONARY, );
    }
    public static final String AIT_UNITS_VALUE ="MDC_DIM_S";
    public static final HashMap<Integer,String> AITValue;
    static
    {
        AITValue = new HashMap<>();
        AITValue.put(STANDING,   "48885");
        AITValue.put(SITTING,    "28159");
        AITValue.put(LYING,      "8209");
        AITValue.put(WALKING,    "39194");
        AITValue.put(WALKUP,     "24882");
        AITValue.put(WALKDN,     "53667");
        AITValue.put(LIFTUP,     "24681");
        AITValue.put(LIFTDN,     "38442");
        AITValue.put(TRANSITION, "8161");
        AITValue.put(SEDENTARY,  "12324");
        //TODO: add stationary value
//        AITValue.put(STATIONARY, "");
    }

    // key value pair
    public static final HashMap<Integer,String> Legend;
    static
    {
        Legend = new HashMap<>();
        Legend.put(STANDING,   "Standing");
        Legend.put(SITTING,    "Sitting");
        Legend.put(LYING,      "Lying");
        Legend.put(WALKING,    "Walking");
        Legend.put(WALKUP,     "Stair Ascent");
        Legend.put(WALKDN,     "Stair Descent");
        Legend.put(LIFTUP,     "Lift Up");
        Legend.put(LIFTDN,     "Lift Dn");
        Legend.put(TRANSITION, "Transition");
        Legend.put(SEDENTARY,  "Sedentary");
        Legend.put(STATIONARY, "Stationary");
        // TODO: add additional movements here, do not change order
    }

    public static final HashMap<String,Integer> LegendKey;
    static
    {
        LegendKey = new HashMap<>();
        LegendKey.put("Standing",STANDING);
        LegendKey.put("Sitting",SITTING);
        LegendKey.put("Lying",LYING     );
        LegendKey.put("Walking",WALKING);
        LegendKey.put("Stair Ascent",WALKUP);
        LegendKey.put("Stair Descent",WALKDN);
        LegendKey.put("Lift Up",LIFTUP);
        LegendKey.put("Lift Dn",LIFTDN);
        LegendKey.put("Transition",TRANSITION);
        LegendKey.put("Sedentary",SEDENTARY);
        LegendKey.put("Stationary",STATIONARY);
        // TODO: add additional movements here, do not change order
    }

    public static final HashMap<Integer,String> LegendColors;
    static
    {
        LegendColors = new HashMap<>();
        LegendColors.put(STANDING,   "#9E9D24");
        LegendColors.put(SITTING,    "#FFFFFF");
        LegendColors.put(LYING,      "#FFFFFF");
        LegendColors.put(WALKING,    "#F57C00");
        LegendColors.put(WALKUP,     "#D50000");
        LegendColors.put(WALKDN,     "#388E3C");
        LegendColors.put(LIFTUP,     "#FFFFFF");
        LegendColors.put(LIFTDN,     "#FFFFFF");
        LegendColors.put(TRANSITION, "#7B1FA2");
        LegendColors.put(SEDENTARY,  "#1976D2");
        LegendColors.put(STATIONARY, "#1976D2");
        // TODO: add additional movements here, do not change order
    }
    public static final HashMap<Integer,String> LegendTime;
    static
    {
        LegendTime = new HashMap<>();
        LegendTime.put(STANDING,   "Standing Time");
        LegendTime.put(SITTING,    "Sitting Time");
        LegendTime.put(LYING,      "Lying Time");
        LegendTime.put(WALKING,    "Walking Time");
        LegendTime.put(WALKUP,     "Walk Up Time");
        LegendTime.put(WALKDN,     "Walk Down Time");
        LegendTime.put(LIFTUP,     "Lift Up Time");
        LegendTime.put(LIFTDN,     "Lift Down Time");
        LegendTime.put(TRANSITION, "Changing Activity\nTime");
        LegendTime.put(SEDENTARY,  "Sedentary Time");
        LegendTime.put(STATIONARY, "Stationary Time");
        // TODO: add additional movements here, do not change order
    }

}
