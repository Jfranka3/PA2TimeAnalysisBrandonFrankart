package pa2timeanalysisbrandonfrankart;

/**
 *
 * @authors Jacob Frankart and Cole Brandon
 */
public final class PA2TimeAnalysisDelegateBrandonFrankart
{
    //------private instance fields----
    private Long[] testArray;
    private Long[] timeArray;
    private long startTime;
    private long stopTime;
    private long elapsedTime;
    private long sumTime;
    private final int testArraySize;
    private final int timeArraySize;
    private double recursiveSumAverageTime;
    private double iterativeSumAverageTime;
    private double recursiveRevAverageTime;
    private double iterativeRevAverageTime;
    
    /**
     * no-arg constructor
     */
    public PA2TimeAnalysisDelegateBrandonFrankart()
    {
        timeArraySize = 10001;
        testArraySize = 6000;
        testArray = PA2TimeAnalysisModelBrandonFrankart.populateArray(
                testArray, testArraySize);
        System.out.println(
                PA2TimeAnalysisModelBrandonFrankart.reportHeader());
        recursiveSummationTrial(testArray, timeArray);
        iterativeSummationTrial(testArray, timeArray);  
        summationComparison();
        recursiveReversalTrial(testArray, timeArray);
        testArray = PA2TimeAnalysisModelBrandonFrankart.populateArray(
                testArray, testArraySize);
        iterativeReversalTrial(testArray, timeArray);
        reversalComparison();
    }//End public PA2TimeAnalysisDelegateBrandonFrankart()
    
    
    /**
     * Displays the frequency of time in microseconds based on a 
     * parameter list
     * @param timesArray
     */
    public void displayFrequencyTable(Long[] timesArray)
    {
        System.out.println("Time in us        Frequency");
        System.out.println("----------        ---------");
        frequencyTableCreate(timeArray);
        System.out.println("\n" + 
                PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        System.out.println("\nShortest time = " + timeArray[0] + " us");
        System.out.println("Longest time = " + timeArray[timeArray.length -1]
                            + " us");
        System.out.print("Total microseconds used in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        System.out.printf("%.1f", (double) 
                PA2TimeAnalysisModelBrandonFrankart.iterativeSummation(
                        timeArray));       
    }//End public void frequencyTableDisplay
    
    
    /**
     * THE ENTIRE ITERATIVE SUM OF AN ARRAY PORTION
     * @param array 
     * @param timesArray
     */
    public void iterativeSummationTrial(Long[] array, Long[] timesArray)
    {
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("ITERATIVE SUM OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("According to the Gauss formula,");
        gaussMethod(array);
        System.out.println("\nVerify correctness:  sum of the cells = "
            + String.format("%,d", PA2TimeAnalysisModelBrandonFrankart.iterativeSummation(array)));
        timeArray = PA2TimeAnalysisModelBrandonFrankart.iterativeSummationTimes(array, timesArray, timeArraySize);
        System.out.println("\n" + PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.print("\nAverage iterative sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        sumTime = PA2TimeAnalysisModelBrandonFrankart.iterativeSummation(timeArray);
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
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("ITERATIVE REVERSAL OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());   
        System.out.println("Here are the last 10 values in the original list:");
        displayLast(array);
        System.out.println(""" 
                           
                           Now we will reverse the list iteratively 10,001 times
                           to see how long it takes on average . . .""");
        timeArray = PA2TimeAnalysisModelBrandonFrankart.iterativeReversalTimes(array, timesArray, timeArraySize);
        System.out.print("""
                         
                         Reversal verification:  the last 10 ordinal values
                         in the iteratively reversed list:
                         """);
        displayLast(array);
        System.out.println("\n" + PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.print("\nAverage reversal sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        sumTime = PA2TimeAnalysisModelBrandonFrankart.iterativeSummation(timeArray);
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
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("RECURSIVE REVERSAL OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());   
        System.out.println("Here are the last 10 values in the original list:");
        displayLast(array);
        System.out.println(""" 
                           
                           Now we will reverse the list iteratively 10,001 times
                           to see how long it takes on average . . .""");
        timeArray = PA2TimeAnalysisModelBrandonFrankart.recursiveReversalTimes(array, timesArray, timeArraySize);
        System.out.print("""
                         
                         Reversal verification:  the last 10 ordinal values
                         in the iteratively reversed list:
                         """);
        displayLast(array);
        System.out.println("\n" + PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.print("\nAverage reversal sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        sumTime = PA2TimeAnalysisModelBrandonFrankart.iterativeSummation(timeArray);
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
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("RECURSIVE SUM OF AN ARRAY OF " + 
                           String.format("%,d", testArraySize) + " LONGS");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("According to the Gauss formula,");
        gaussMethod(array);
        System.out.println("\nVerify correctness:  sum of the cells = "
                            + String.format("%,d", PA2TimeAnalysisModelBrandonFrankart.recursiveSummation(array, array.length)));
        timeArray = PA2TimeAnalysisModelBrandonFrankart.recursiveSummationTimes(array, timesArray, timeArraySize);
        System.out.println("\n" + PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        System.out.println("Frequency Table of Elapsed Times in "
                           + String.format("%,d", timeArraySize) + " Trials");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.asteriskLine());
        displayFrequencyTable(timesArray);
        System.out.print("\nAverage recursive sum time in " + 
                         String.format("%,d", timeArraySize) + " trials = ");
        sumTime = PA2TimeAnalysisModelBrandonFrankart.iterativeSummation(timeArray);
        System.out.printf("%.5f", (double) sumTime / timeArraySize);
        recursiveSumAverageTime = (double) sumTime / timeArraySize;
        System.out.println(" us\n\n[END Frequency Table]\n");          
    }
    
    
    /**
     * This compares the efficiency of both summation algorithms
     */
    public void summationComparison()
    {
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("             ALGORITHM COMPARISON FOR SUMMING");
        System.out.println("Average Times to Sum an Array of 6,000 Longs in 10,001 Trials");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
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
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
        System.out.println("             ALGORITHM COMPARISON FOR REVERSAL");
        System.out.println("Average Times to Reverse an Array of 6,000 Longs in 10,001 Trials");
        System.out.println(PA2TimeAnalysisModelBrandonFrankart.equalsLine());
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
    }//End public void gaussMethod()
    
    /**
     * Displays the last 10 values in an array
     * @param array the array to display
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
    }//End public void displayLast()
    
    /**
     * Iterates through the timeArray array and finds the frequency of each time
     * @param timesArray
     */
    public void frequencyTableCreate(Long[] timesArray)
    {
        PA2TimeAnalysisModelBrandonFrankart.bubbleSort(timesArray);
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
}//End public final class PA2TimeAnalysisDelegateBrandonFrankart  
