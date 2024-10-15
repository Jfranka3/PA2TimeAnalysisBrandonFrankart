package pa2timeanalysisbrandonfrankart;

/**
 *
 * @author Jacob Frankart and Cole Brandon
 */
public final class PA2TimeAnalysisModelBrandonFrankart 
{
    /**
     * Constructs and returns a string to serve as the report header
     * @return full report header
     */
    public static String reportHeader()
    {
        String tempString = "";
        tempString +=
            """
            RECURSIVE VERSUS ITERATIVE ARRAY OPERATIONS
                        Cole Brandon and Jacob Frankart
                        October 15, 2024
            
            """;
        return tempString;
    }//End public static String reportHeader()
     
    /**
     * Populates an array with longs from 1 to the arraySize
     * @param array the array that is being operated on
     * @param arraySize the size of the array
     * @return the populated array
     */
    public static Long[] populateArray(Long[] array, int arraySize)
    {
        array = new Long[arraySize];
        long val = 1;
        for(int i = 0; i < arraySize; i++)
        {
            array[i] = val;
            val++;
        }
        return array;
    }//End public static Long[] populateList()
    
    /**
     * Following code was drew influence from Lewis and Chase in their
     * 4th edition copy of Java Software Structures
     * Sorts the array of Longs using the bubble sort algorithm
     * @param array the array to sort
     * @return the array sorted in ascending value
     */
    public static Long[] bubbleSort(Long[] array)
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
    }//End public static Long[] bubbleSort
      
    /**
     * Returns a string of asterisks to serve as a visual separator
     * @return the string of asterisks
     */
    public static String asteriskLine()
    {
        String tempString = "";
        for(int i = 49; i > 0; i--){
            tempString += "*";
        }
        return tempString;
    }//End public static String asteriskLine()
   
    /**
     * Returns a string of equals signs to serve as a visual separator
     * @return the string of equals
     */
    public static String equalsLine()
    {
        String tempString = "";
        for(int i = 69; i > 0; i--){
            tempString += "=";
        }
        return tempString;
    }//End public static String equalsLine()
    
    /**
     * Takes a list and recursively adds each long in the list
     * @param array the array to be operated on
     * @param index the size of the list
     * @return the sum of the list
     */
    public static long recursiveSummation(Long[] array, int index)
    {
        // Base Case
        if(array[index-1] <= 1)
            return array[index-1];
      
        return array[index-1] + recursiveSummation(array, index - 1);
    }//End public static long recursiveSummation()    
      
    /**
     * Populates the timeArray with 10001 times from each individual
     * run of the recursiveSummation method
     * @param array
     * @param timesArray
     * @param size
     * @return an array of times
     */
    public static Long[] recursiveSummationTimes(Long[] array, 
            Long[] timesArray, int size)
    {
        timesArray = new Long[size];
        for(int i = 0; i < timesArray.length; i++)
        {
            long start = System.nanoTime();
            PA2TimeAnalysisModelBrandonFrankart.recursiveSummation(array, 
                    array.length);
            long stop = System.nanoTime();
            long elapsed = stop - start;
            timesArray[i] = elapsed/1000;
        }
        return timesArray;
    }//End public static Long[] iterativeSummationTrail()
        
    /**
     * Takes an array and recursively adds each long in the array
     * @param array
     * @return the sum of the list
     */
    public static long iterativeSummation(Long[] array)
    {
        long sum = 0;
        for (int i = 0; i < array.length; i++)
        {
            sum += array[i];
        }
        return sum;
    }//End public static long iterativeSummation()
        
    /**
     * Populates the timeArray with 10001 times from each individual
     * run of the iterativeSummation method
     * @param array
     * @param timesArray
     * @return an array of times
     */
    public static Long[] iterativeSummationTimes(Long[] array, 
            Long[] timesArray, int size)
    {
        timesArray = new Long[size];
        for(int i = 0; i < timesArray.length; i++)
        {
            long start = System.nanoTime();
            PA2TimeAnalysisModelBrandonFrankart.iterativeSummation(array);
            long stop = System.nanoTime();
            long elapsed = stop - start;
            timesArray[i] = elapsed/1000;
        }
        return timesArray;
    }//End public static Long[] iterativeSummationTrail()
        
    /**
     * Recursive Reversal of a given Array
     * @param array the array to be reversed
     * @param front a pointer tracking the current operational 'front'
     * @param end a pointer tracking the current operational 'end'
     * @return the array reversed
     */
    public static Long[] recursiveReversal(Long[] array, int front, int end)
    {
        if (front == end || front > end)
            return array;
        
        long temp = array[front];
        array[front] = array[end];
        array[end] = temp;
        recursiveReversal(array,front+1,end-1);
        return array;
    }//End public static Long[] recursiveReversal()
    
    /**
     * Populates the timeArray with 10001 times from each individual
     * run of the recursiveReversal method
     * @param array
     * @param timesArray
     * @param size
     * @return the time array
     */
    public static Long[] recursiveReversalTimes(Long[] array, 
            Long[] timesArray, int size)
    {
        timesArray = new Long[size];
        for(int i = 0; i < timesArray.length; i++)
        {
            long start = System.nanoTime();
            recursiveReversal(array, 0, array.length - 1);
            long stop = System.nanoTime();
            long elapsed = stop - start;
            timesArray[i] = elapsed/1000;
        }
        return timesArray;
    }//End public static Long[] recursiveSummationTrail()
    
    /**
     * Iterative reversal of a list
     * @param array an array to reverse
     * @return the reversed array
     */
    public static Long[] iterativeReversal(Long[] array)
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
    }//End public static Long[] iterativeReversal
    
    /**
     * Populates the timeArray with 10001 times from each individual
     * run of the iterativeReversal method
     * @param array
     * @param timesArray
     * @param size
     * @return the time array
     */
    public static Long[] iterativeReversalTimes(Long[] array, 
            Long[] timesArray, int size)
    {
        timesArray = new Long[size];
        for(int i = 0; i < timesArray.length; i++)
        {
            long start = System.nanoTime();
            iterativeReversal(array);
            long stop = System.nanoTime();
            long elapsed = stop - start;
            timesArray[i] = elapsed/1000;
        }
        return timesArray;
    }//End public static Long[] iterativeReversalTimes()
}//End public Final Class PA2TimeAnalysisModelBrandonFrankart
