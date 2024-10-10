package pa2timeanalysisbrandonfrankart;
/**
 *
 * @author jmfra and brando
 */
public final class PA2TimeAnalysisDelegateBrandonFrankart
{
    //------private instance fields----
    private Long[] testList = new Long[6000];
    private Long[] timeList = new Long[10001];
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
        frequencyTableDisplay();
    }//End public PA2TimeAnalysisDelegateBrandonFrankart()

    /**
     * Populates the testList with longs from 1-6000
     */
    public void populateList()
    {
        long val = 1;
        for(int i = 0; i < 6000; i++)
        {
            testList[i] = val;
            val++;
        }
    }//End public void populateList()
    
    /**
     * Takes a list and recursively adds each long in the list
     * @return the sum of the list
     */
    public long iterativeSummation()
    {
        long tempSum = 0;
        for(int i = 0; i < testList.length; i++)
        {
            tempSum += testList[i];
        }
        return tempSum;
    }//End public long iterativeSummation()
    
    public long gaussMethod()
    {
        long tempSum = testList.length*(testList.length + 1) / 2;
        return tempSum;
    }//End public long gaussMethod()

    /**
     * Populates the timeList with 10001 times from each individual
 run of the iterativeSummation method
     */
    public void iterativeSummationTrial()
    {
        for(int i = 0; i < 10001; i++)
        {
            startTime = System.nanoTime();
            iterativeSummation();
            stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            timeList[i] = elapsedTime/1000;
        }
    }//End public iterativeSummationTrail()
    
    /**
     * Displays the frequency of time in microseconds based on a parameter list
     */
    public void frequencyTableDisplay()
    {
        System.out.println("Time in us        Frequency");
        System.out.println("----------        ---------");
        bubbleSort();
        frequencyTableCreate();
    }//End public void frequencyTableDisplay
    
    /**
     * Iterates through the timeList array and finds the frequency of each time
     */
    public void frequencyTableCreate()
    {
        long currentTime = timeList[0];
        int currentFrequency = 0;
        for (int i =0; i < timeList.length - 1; i++)
        {
            if(timeList[i].compareTo(currentTime) == 0)
            {
                currentFrequency++;
            }
            else
            {
                System.out.println(currentTime + "            " + currentFrequency);
                currentTime = timeList[i];
                currentFrequency = 1;
            }
        }
    }//End public void frequencyTableCreate
    
    /**
     * Takes a list and recursively adds each long in the list
     * @param N the size of the list
     * @return the sum of the list
     */
    public long recursiveSummation(int N)
    {
        // Base Case
        if(testList[N-1] <= 1)
            return testList[N-1];
        
        long sum = testList[N-1] + recursiveSummation(N - 1);
        return sum;
    }//End public long recursiveSummation()    
    
    
    
    
    // HEY HEADS UP MAYBE PUT THIS IN ANOTHER FILE ALONG WITH OTHER "TOOLBOX"
    // METHODS AND MAKE THEM STATICS??? IDK I STOLE THIS FROM THE BOOK
    // MIGHT ALSO NEED TO PUT frequencyTableDisplay IN TOOLBOX IDK
    
    
   
    /**
     * Sorts the array of Longs using the bubble sort algorithm
     * CITE THIS!!!!
     */
    public void bubbleSort()
    {
        int position;
        int index; 
        long temp;
        for (position = timeList.length - 1; position >= 0; position--)
        { 
            for (index = 0; index <= position - 1; index++)
            {
                if (timeList[index].compareTo(timeList[index+1]) > 0)
                {
                    // Swaps values
                    temp = timeList[index];
                    timeList[index] = timeList[index + 1];
                    timeList[index + 1] = temp;
                }
            }
        }
    }//End public static void bubbleSort
    
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
