/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa2timeanalysisbrandonfrankart;
import java.util.ArrayList;
/**
 *
 * @author jmfra
 */
public final class PA2TimeAnalysisDelegateBrandonFrankart
{
    //------private instance fields----
    
    /**
     * Creates an ArrayList of longs with an initial size capacity of 6000
     */
    private ArrayList<Long> testList = new ArrayList(6000);
    
    /**
     * no-arg constructor
     */
    public PA2TimeAnalysisDelegateBrandonFrankart()
    {
        /** 
         * Sets testList with longs from 1-6000
         * Tests an iterative and recursive adding of the list
         */
        for(long i = 1; i < 6001; i++)
        {
            testList.add(i);
        }
        System.out.println(recursiveSummation(testList.getLast()));
        System.out.println(iterativeSummation());
        
    }
    /**
     * Takes the largest long of an ordered list and recursively adds each
     * previous long
     * @param N the largest long of the ordered list
     * @return the sum of the list
     */
    public long recursiveSummation(long N)
    {

        // Base Case
        if(N <= 1)
            return N;
        
        long sum = N + recursiveSummation(N - 1);
        return sum;
    }//End public long recursiveSummation()
    
    /**
     * Takes the largest long of an ordered list and iteratively adds each
     * previous long
     * @return the sum of the list
     */
    public long iterativeSummation()
    {
        long sum = 0;
        for(int i = 0; i < 6000; i++)
        {
            sum += testList.get(i);
        }
        return sum;
    }//End public long iterativeSummation()
}