package pa2timeanalysisbrandonfrankart;
/**
 *
 * @author jmfra and brando
 */
public final class PA2TimeAnalysisDelegateBrandonFrankart
{
    //------private instance fields----
    private Long[] testArray;
    private Long[] timeArray;
    private long startTime;
    private long stopTime;
    private long sumTime;
    private long elapsedTime;
    private int testArraySize;
    private int timeArraySize;
    
    /**
     * no-arg constructor
     */
    public PA2TimeAnalysisDelegateBrandonFrankart()
    {
        System.out.println(reportHeader());
        iterativeSummationTrial(testArray, timeArray);
        //testArray = populateArray(testArray);
        //timeArray = iterativeSummationTimes(testArray, timeArray);  
        //frequencyTableDisplay();
    }//End public PA2TimeAnalysisDelegateBrandonFrankart()

    /**
     * Populates an array with longs from 1-6000
     * @param array
     * @return the populated array
     */
    public Long[] populateArray(Long[] array)
    {
        testArraySize = 6000;
        array = new Long[testArraySize];
        long val = 1;
        for(int i = 0; i < testArraySize; i++)
        {
            array[i] = val;
            val++;
        }
        return array;
    }//End public Long[] populateList()
    
    /**
     * Takes an array and recursively adds each long in the array
     * @param array
     * @return the sum of the list
     */
    public long iterativeSummation(Long[] array)
    {
        long sum = 0;
        for(int i = 0; i < array.length; i++)
        {
            sum += array[i];
        }
        return sum;
    }//End public long iterativeSummation()
    
    /**
     * Uses the Gauss method to sum the contents of an array
     * @param array the array to sum
     */
    public void gaussMethod(Long[] array)
    {
        long firstNum = array[0];
        String lastNum = String.format("%,d", array[array.length - 1]);
        long gaussSum = array.length*(array.length + 1) / 2;
        System.out.println("the sum of " + firstNum + " to " + lastNum +
                           " is " + String.format("%,d", gaussSum));
    }//End public long gaussMethod()

    /**
     * Populates the timeArray with 10001 times from each individual
     * run of the iterativeSummation method
     * @param array
     * @param timesArray
     * @return times
     */
    public Long[] iterativeSummationTimes(Long[] array, Long[] timesArray)
    {
        timeArraySize = 10001;
        sumTime = 0;
        timesArray = new Long[timeArraySize];
        for(int i = 0; i < timesArray.length; i++)
        {
            startTime = System.nanoTime();
            iterativeSummation(array);
            stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            timesArray[i] = elapsedTime/1000;
            sumTime += elapsedTime/1000;
        }
        return timesArray;
    }//End public Long[] iterativeSummationTrail()
    
    /**
     * Displays the frequency of time in microseconds based on a parameter list
     * @param timesArray
     */
    public void displayFrequencyTable(Long[] timesArray)
    {
        System.out.println("Time in us        Frequency");
        System.out.println("----------        ---------");
        frequencyTableCreate(timesArray);
    }//End public void frequencyTableDisplay
    
    /**
     * Iterates through the timeArray array and finds the frequency of each time
     * @param timesArray
     */
    public void frequencyTableCreate(Long[] timesArray)
    {
        bubbleSort(timesArray);
        long currentTime = timesArray[0];
        int currentFrequency = 0;
        for (int i =0; i < timesArray.length; i++)
        {
            if(timesArray[i].compareTo(currentTime) == 0)
            {
                currentFrequency++;
            }
            else
            {
                System.out.printf("%-4d %17d\n", currentTime, currentFrequency);
                currentTime = timesArray[i];
                currentFrequency = 1;
            }
        }
        System.out.printf("%-4d %17d\n", currentTime, currentFrequency);
    }//End public void frequencyTableCreate
    
    /**
     * Takes a list and recursively adds each long in the list
     * @param N the size of the list
     * @return the sum of the list
     */
    public long recursiveSummation(int N)
    {
        // Base Case
        if(testArray[N-1] <= 1)
            return testArray[N-1];
        
        long sum = testArray[N-1] + recursiveSummation(N - 1);
        return sum;
    }//End public long recursiveSummation()    
    
    
    
    
    // HEY HEADS UP MAYBE PUT THIS IN ANOTHER FILE ALONG WITH OTHER "TOOLBOX"
    // METHODS AND MAKE THEM STATICS??? IDK I STOLE THIS FROM THE BOOK
    // MIGHT ALSO NEED TO PUT frequencyTableDisplay IN TOOLBOX IDK
    
    
   
    /**
     * Sorts the array of Longs using the bubble sort algorithm
     * CITE THIS!!!!
     * @param array
     * @return array
     */
    public Long[] bubbleSort(Long[] array)
    {
        int position;
        int index; 
        long temp;
        for (position = array.length - 1; position >= 0; position--)
        { 
            for (index = 0; index <= position - 1; index++)
            {
                if (array[index].compareTo(array[index+1]) > 0)
                {
                    // Swaps values
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }//End public Long[] bubbleSort
    
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
    
    
    
    
    
    
    //PUT EACH OF OUR TRIALS DOWN HERE
    
    
    
    
    /**
     * THE ENTIRE ITERATIVE SUM OF AN ARRAY PORTION
     * @param array 
     * @param timesArray
     */
    public void iterativeSummationTrial(Long[] array, Long[] timesArray)
    {
        array = populateArray(array);
        System.out.println(equalsLine());
        System.out.println("ITERATIVE SUM OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(equalsLine());
        System.out.println("According to the Gauss formula,");
        gaussMethod(array);
        System.out.println("\nVerify correctness:  sum of the cells = "
                            + String.format("%,d", iterativeSummation(array)));
        timesArray = iterativeSummationTimes(array, timesArray);
        System.out.println("\n" + asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.println("\n" + asteriskLine());
        System.out.println("\nShortest time = " + timesArray[0] + " us");
        System.out.println("Longest time = " + timesArray[timesArray.length -1]
                            + " us");
        System.out.print("Total microseconds used in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.1f", (double) iterativeSummation(timesArray));
        System.out.print("\nAverage iterative sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.5f", (double) sumTime / timeArraySize);
        System.out.println(" us\n\n[END Frequency Table]");
    }
}   
