package android;

/**
 * Created by Michael Del Rosario on 9/05/2018.
 * mock the android builtin Log class for the purposes of testing logic of code (designed for android) on a desktop
 */

public class Log {
    public static void d(String string, String string2){
        System.out.println("TAG: " + string + " " + string2);
    }

    public static void w (String string, String string2){
        System.out.println("TAG: " + string + " " + string2);
    }
}
