import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Michael Del Rosario on 15/12/2015.
 */
public class CSVRead {

    String fileName;

    @SuppressWarnings("rawtypes")
    public ArrayList <ArrayList> rowList = new ArrayList<ArrayList>();
    public CSVRead(String FileName){
        this.fileName=FileName;
    }

    public void ReadFile(){
        try {
            //storeValues.clear();//just in case this is the second call of the ReadFile Method./
            BufferedReader br = new BufferedReader( new FileReader(fileName));

            StringTokenizer st = null;
            int lineNumber = 0, tokenNumber = 0;

            while( (fileName = br.readLine()) != null){
                lineNumber++;
                ArrayList <Double> row = new ArrayList<Double>();
                st = new StringTokenizer(fileName, ",");
                while(st.hasMoreTokens())
                {
                    row.add(Double.parseDouble(st.nextToken()));
                }
                rowList.add(row);
                //reset token number
                tokenNumber = 0;
            }
            // Check contents by printing
//			ArrayList <Double> tempRow;
//			for(int idx = 0; idx < rowList.size(); idx++)
//			{
//				tempRow = rowList.get(idx);
//				System.out.println(tempRow);
//			}
            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    //mutators and accesors
    public void setFileName(String newFileName)	{
        this.fileName=newFileName;
    }
    public String getFileName()	{
        return fileName;
    }

}
