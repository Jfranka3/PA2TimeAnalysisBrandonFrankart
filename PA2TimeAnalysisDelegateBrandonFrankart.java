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
    private ArrayList<Long> testList;
    
    /**
     * no-arg constructor
     */
    public PA2TimeAnalysisDelegateBrandonFrankart()
    {
        /** 
         * Populates testList with longs from 1-6000
         * Tests an iterative and recursive adding of the list
         */
        testList = new ArrayList(6000);
        for(long i = 1; i < 6001; i++)
        {
            testList.add(i);
        }
        System.out.println(reportHeader());
        System.out.println(recursiveSummation(testList.size()));
        System.out.println(iterativeSummation());
        System.out.println(gaussMethod());
        
    }
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
        long sum = 0;
        for(int i = 0; i < testList.size(); i++)
        {
            sum += testList.get(i);
        }
        return sum;
    }//End public long iterativeSummation()
    
    public long gaussMethod()
    {
        long sum = testList.size()*(testList.size() + 1) / 2;
        return sum;
    }//End public long gaussMethod()
    
    
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
}
