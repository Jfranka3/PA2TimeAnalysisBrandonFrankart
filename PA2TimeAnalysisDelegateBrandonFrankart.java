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
    private double recursiveSumAverageTime;
    private double iterativeSumAverageTime;
    private double recursiveRevAverageTime;
    private double iterativeRevAverageTime;
    
    /**
     * no-arg constructor
     */
    public PA2TimeAnalysisDelegateBrandonFrankart()
    {
        testArray = populateArray(testArray);
        System.out.println(reportHeader());
        recursiveSummationTrial(testArray, timeArray);
        iterativeSummationTrial(testArray, timeArray);  
        summationComparison();
        recursiveReversalTrial(testArray, timeArray);
        testArray = populateArray(testArray);
        iterativeReversalTrial(testArray, timeArray);
        reversalComparison();
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
     * Displays the frequency of time in microseconds based on a parameter list
     * @param timesArray
     */
    public void displayFrequencyTable(Long[] timesArray)
    {
        System.out.println("Time in us        Frequency");
        System.out.println("----------        ---------");
        frequencyTableCreate(timesArray);
        System.out.println("\n" + asteriskLine());
        System.out.println("\nShortest time = " + timesArray[0] + " us");
        System.out.println("Longest time = " + timesArray[timesArray.length -1]
                            + " us");
        System.out.print("Total microseconds used in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.1f", (double) iterativeSummation(timesArray));       
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
     * @param array the array to be operated on
     * @param index the size of the list
     * @return the sum of the list
     */
    public long recursiveSummation(Long[] array, int index)
    {
        // Base Case
        if(array[index-1] <= 1)
            return array[index-1];
        
        
        return array[index-1] + recursiveSummation(array, index - 1);
    }//End public long recursiveSummation()    
    
    /**
     * Populates the timeArray with 10001 times from each individual
     * run of the recursiveSummation method
     * @param array
     * @param timesArray
     * @return times
     */
    public Long[] recursiveSummationTimes(Long[] array, Long[] timesArray)
    {
        timeArraySize = 10001;
        sumTime = 0;
        timesArray = new Long[timeArraySize];
        for(int i = 0; i < timesArray.length; i++)
        {
            startTime = System.nanoTime();
            recursiveSummation(array, array.length);
            stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            timesArray[i] = elapsedTime/1000;
            sumTime += elapsedTime/1000;
        }
        return timesArray;
    }//End public Long[] iterativeSummationTrail()
    
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
     * Recursive Reversal of a given Array
     * @param array the array to be reversed
     * @return array reversed
     */
    public Long[] recursiveReversal(Long[] array)
    {
        //Base Cases
        if (array.length == 0)
            return array;
        if (array.length == 1)
            return array;
        
        Long[] reversedArray = new Long[array.length];
        
        reversedArray[0] = array[array.length - 1];
        reversedArray[array.length - 1] = array[0];
        
        //Decrease Array Size
        Long[] newArray = new Long[array.length - 2];
        System.arraycopy(array, 1, newArray, 0, array.length - 2);
        
        //Reverse New Array
        Long[] reversedMiddle = recursiveReversal(newArray);
        
        System.arraycopy(reversedMiddle, 0, reversedArray, 1, reversedMiddle.length);
        
        return reversedArray;
    }//
    
        public Long[] recursiveReversalTimes(Long[] array, Long[] timesArray)
    {
        timeArraySize = 10001;
        sumTime = 0;
        timesArray = new Long[timeArraySize];
        for(int i = 0; i < timesArray.length; i++)
        {
            startTime = System.nanoTime();
            recursiveReversal(array, 0, array.length - 1);
            stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            timesArray[i] = elapsedTime/1000;
            sumTime += elapsedTime/1000;
        }
        return timesArray;
    }//End public Long[] recursiveSummationTrail()
    
    /**
     * Iterative reversal of a list
     * @param array an array to reverse
     * @return the reversed array
     */
    public Long[] iterativeReversal(Long[] array)
    {
        int front = 0;
        int end = array.length - 1;
        long tempFront;
        while(front < end)
        {
            //Swaps values
            tempFront = array[front];
            array[front] = array[end];
            array[end] = tempFront;
            
            front++;
            end--;
        }
        return array;
    }//End public Long[] iterativeReversal

    /**
     * Populates the timeArray with 10001 times from each individual
     * run of the iterativeReversal method
     * @param array
     * @param timesArray
     * @return timesArray
     */
    public Long[] iterativeReversalTimes(Long[] array, Long[] timesArray)
    {
        timeArraySize = 10001;
        sumTime = 0;
        timesArray = new Long[timeArraySize];
        for(int i = 0; i < timesArray.length; i++)
        {
            startTime = System.nanoTime();
            iterativeReversal(array);
            stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            timesArray[i] = elapsedTime/1000;
            sumTime += elapsedTime/1000;
        }
        return timesArray;
    }//End public Long[] iterativeSummationTrail()
    
    
    // HEY HEADS UP MAYBE PUT THIS IN ANOTHER FILE ALONG WITH OTHER "TOOLBOX"
    // METHODS AND MAKE THEM STATICS??? IDK I STOLE THIS FROM THE BOOK
    // MIGHT ALSO NEED TO PUT frequencyTableDisplay IN TOOLBOX IDK
    
     /**
     * Displays the last 10 values in an array
     * @param array the array used
     */
    public void displayLast(Long[] array)
    {
        int end = array.length - 1;
        int current = array.length - 10;
        while (current <= end)
        {
            System.out.println(array[current]);
            current++;
        }
    }//End public void displayLast
   
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
        for(int i = 49; i > 0; i--){
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
        System.out.print("\nAverage iterative sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.5f", (double) sumTime / timeArraySize);
        iterativeSumAverageTime = (double) sumTime / timeArraySize;
        System.out.println(" us\n\n[END Frequency Table]\n");          
    }
    
    /**
     * THE ENTIRE ITERATIVE REVERSAL OF AN ARRAY PORTION
     * @param array
     * @param timesArray
     */
    public void iterativeReversalTrial(Long[] array, Long[] timesArray)
    {
        System.out.println(equalsLine());
        System.out.println("ITERATIVE REVERSAL OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(equalsLine());   
        System.out.println("Here are the last 10 values in the original list:");
        displayLast(array);
        System.out.println(""" 
                           
                           Now we will reverse the list iteratively 10,001 times
                           to see how long it takes on average . . .""");
        timesArray = iterativeReversalTimes(array, timesArray);
        System.out.print("""
                         
                         Reversal verification:  the last 10 ordinal values
                         in the iteratively reversed list:
                         """);
        displayLast(array);
        System.out.println("\n" + asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.print("\nAverage reversal sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.5f", (double) sumTime / timeArraySize);
        iterativeRevAverageTime = (double) sumTime / timeArraySize;
        System.out.println(" us\n\n[END Frequency Table]\n");          
    }
    
    /**
     * THE ENTIRE RECURSIVE REVERSAL OF AN ARRAY PORTION
     * @param array
     * @param timesArray
     */
    public void recursiveReversalTrial(Long[] array, Long[] timesArray)
    {
        System.out.println(equalsLine());
        System.out.println("RECURSIVE REVERSAL OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(equalsLine());   
        System.out.println("Here are the last 10 values in the original list:");
        displayLast(array);
        System.out.println(""" 
                           
                           Now we will reverse the list iteratively 10,001 times
                           to see how long it takes on average . . .""");
        timesArray = recursiveReversalTimes(array, timesArray);
        System.out.print("""
                         
                         Reversal verification:  the last 10 ordinal values
                         in the iteratively reversed list:
                         """);
        displayLast(array);
        System.out.println("\n" + asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.print("\nAverage reversal sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.5f", (double) sumTime / timeArraySize);
        recursiveRevAverageTime = (double) sumTime / timeArraySize;
        System.out.println(" us\n\n[END Frequency Table]\n");          
    }
    
        /**
     * THE ENTIRE recursive SUM OF AN ARRAY PORTION
     * @param array 
     * @param timesArray
     */
    public void recursiveSummationTrial(Long[] array, Long[] timesArray)
    {
        System.out.println(equalsLine());
        System.out.println("RECURSIVE SUM OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(equalsLine());
        System.out.println("According to the Gauss formula,");
        gaussMethod(array);
        System.out.println("\nVerify correctness:  sum of the cells = "
                            + String.format("%,d", recursiveSummation(array, array.length)));
        timesArray = recursiveSummationTimes(array, timesArray);
        System.out.println("\n" + asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.print("\nAverage recursive sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.5f", (double) sumTime / timeArraySize);
        recursiveSumAverageTime = (double) sumTime / timeArraySize;
        System.out.println(" us\n\n[END Frequency Table]\n");          
    }
    
    /**
     * This compares the efficiency of both summation algorithms
     */
    public void summationComparison()
    {
        System.out.println(equalsLine());
        System.out.println("             ALGORITHM COMPARISON FOR SUMMING");
        System.out.println("Average Times to Sum an Array of 6,000 Longs in 10,001 Trials");
        System.out.println(equalsLine());
        System.out.print("\n");
        System.out.println("Time in  us       Algorithm");
        System.out.println("-----------       ---------");
        System.out.printf("%.5f", iterativeSumAverageTime);
        System.out.println("           Iterative");
        System.out.printf("%.5f", recursiveSumAverageTime);
        System.out.println("           Recursive");
        if(recursiveSumAverageTime > iterativeSumAverageTime)
        {
            System.out.print("The recursive sum algorithm took ");
            System.out.printf("%.1f", ((recursiveSumAverageTime/iterativeSumAverageTime)*100)-100);
            System.out.print("% longer.");
        }
        else 
        {
            System.out.print("The iterative sum algorithm took ");
            System.out.printf("%.1f", ((iterativeSumAverageTime/recursiveSumAverageTime)*100)-100);
            System.out.print("% longer.");
        }
        System.out.println("\n");
    }
    
    /**
     * This compares the efficiency of both reversal algorithms
     */
    public void reversalComparison()
    {
        System.out.println(equalsLine());
        System.out.println("             ALGORITHM COMPARISON FOR REVERSAL");
        System.out.println("Average Times to Reverse an Array of 6,000 Longs in 10,001 Trials");
        System.out.println(equalsLine());
        System.out.print("\n");
        System.out.println("Time in  us       Algorithm");
        System.out.println("-----------       ---------");
        System.out.printf("%.5f", iterativeRevAverageTime);
        System.out.println("           Iterative");
        System.out.printf("%.5f", recursiveRevAverageTime);
        System.out.println("           Recursive\n");
        if(recursiveRevAverageTime > iterativeRevAverageTime)
        {
            System.out.print("The recursive reverse algorithm took ");
            System.out.printf("%.1f", ((recursiveRevAverageTime/iterativeRevAverageTime)*100)-100);
            System.out.print("% longer than the iterative algorithm.");
        }
        else 
        {
            System.out.print("The iterative reverse algorithm took ");
            System.out.printf("%.1f", ((iterativeRevAverageTime/recursiveRevAverageTime)*100)-100);
            System.out.print("% longer than the recursive algorithm.");
        }
        System.out.println("");
    }
}   
