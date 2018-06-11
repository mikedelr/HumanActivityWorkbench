import java.io.File;

/**
 * Created by Michael Del Rosario on 12/12/2016.
 */
public class FileHelper {
    public static File[] filesInDirectory(String directory){
        File folder = new File(directory);
        return folder.listFiles();
    }

    /**
     * generates a unique sub-directory by appending the unix time to the end of a string
     * @param subDir
     * @return
     */
    public static String genUniqueDirName(String subDir){
        //Generate unique directory name
        Long unixTime = System.currentTimeMillis() / 1000L;
        String timeStamp = Long.toString(unixTime);
        return "\\"+timeStamp+"_"+subDir;
    }

    /**
     * Makes a directory for the output
     * @param outputDir - string denoting full path
     */
    public static void makeDir(String outputDir){
        //Create directory to storeOutputs
        File fileTestResults = new File(outputDir);
        boolean created      = fileTestResults.mkdir();
        if(!created){
            System.out.println("Failed to create:= "+outputDir );
        }
    }
}
