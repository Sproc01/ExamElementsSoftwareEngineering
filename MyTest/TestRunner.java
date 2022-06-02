package MyTest;

import MyAdapter.*;
import org.junit.runner.*;
import java.util.*;
import org.junit.runner.notification.Failure;

/**
 * Test running class for the ListAdapter class
 * @author Michele Sprocatti
 */
public class TestRunner
{
    public static void main(String[] args)
    {
        System.out.println("Testing...\n");
        Result res=JUnitCore.runClasses(TestList.class);
        System.out.println("Correct test: "+res.wasSuccessful());
        for(Failure f:res.getFailures())
        {
            System.out.println(f.getMessage());
        }
        System.out.println("Number of test for list: "+res.getRunCount());
        System.out.println("Number of failed test for list: "+res.getFailureCount());
        System.out.println("Time used for testing: "+res.getRunTime()+" ms\n");
    }
}