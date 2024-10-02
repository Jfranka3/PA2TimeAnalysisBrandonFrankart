package pa2timeanalysisbrandonfrankart;
import java.util.ArrayList;
/**
 *
 * @author jmfra and brando
 */
public final class PA2TimeAnalysisDelegateBrandonFrankart
{
    //------private instance fields----
    private ArrayList<Long> testList = new ArrayList(6000);
    private ArrayList<Long> timeListItSum = new ArrayList(10001);
    private ArrayList<Long> timeListItRev = new ArrayList(10001);
    private ArrayList<Long> timeListRecSum = new ArrayList(10001);
    private ArrayList<Long> timeListRecRev = new ArrayList(10001);
    private long startTime;
    private long stopTime;
    private long elapsedTime;
    
    /**
     * no-arg constructor
     */
    public PA2TimeAnalysisDelegateBrandonFrankart()
    {
        System.out.println(reportHeader());
        System.out.println(equalsLine());
        populateList();
        iterativeSummationTrial();              
    }//End public PA2TimeAnalysisDelegateBrandonFrankart()

    /**
     * Populates the testList with longs from 1-6000
     */
    public void populateList()
    {
        for(long i = 1; i < 6001; i++)
        {
            testList.add(i);
        }
    }//End public void populateList()
    
    /**
     * Takes a list and recursively adds each long in the list
     * @param N the size of the list
     * @return the sum of the list
     */
    public long recursiveSummation(int N)
    {

        // Base Case
        if(testList.get(N-1) <= 1)
            return testList.get(N-1);
        
        long sum = testList.get(N-1) + recursiveSummation(N - 1);
        return sum;
    }//End public long recursiveSummation()
    
    /**
     * Takes a list and recursively adds each long in the list
     * @return the sum of the list
     */
    public long iterativeSummation()
    {
        long tempSum = 0;
        for(int i = 0; i < testList.size(); i++)
        {
            tempSum += testList.get(i);
        }
        return tempSum;
    }//End public long iterativeSummation()
    
    public long gaussMethod()
    {
        long tempSum = testList.size()*(testList.size() + 1) / 2;
        return tempSum;
    }//End public long gaussMethod()

    /**
     * Populates the timeListItSum with 10001 times from each individual
     * run of the iterativeSummation method
     */
    public void iterativeSummationTrial()
    {
        for(int i = 0; i < 10001; i++)
        {
            startTime = System.nanoTime();
            iterativeSummation();
            stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            timeListItSum.add(elapsedTime/1000);
        }
    }//End public iterativeSummationTrail()    
    
    /**
     * Constructs and returns a string to serve as the report header
     * @return full report header
     */
    public String reportHeader()
    {
        String tempString = "";
        tempString +=
            "RECURSIVE VERSUS ITERATIVE ARRAY OPERATIONS" + "\n" +
            "            Cole Brandon and Jacob Frankart" + "\n" +
            "            October 15, 2024" + "\n" + "\n";
        return tempString;
    }//End public String reportHeader()
    
    /**
     * Returns a string of asterisks to serve as a visual seperator
     * @return tempString
     */
    private String asteriskLine()
    {
        String tempString = "";
        for(int i = 64; i > 0; i--){
            tempString += "*";
        }
        return tempString;
    }//End public String asteriskLine()
    
    /**
     * Returns a string of equals signs to serve as a visual seperator
     * @return tempString
     */
    private String equalsLine()
    {
        String tempString = "";
        for(int i = 69; i > 0; i--){
            tempString += "=";
        }
        return tempString;
    }//End public String equalsLine()
}
