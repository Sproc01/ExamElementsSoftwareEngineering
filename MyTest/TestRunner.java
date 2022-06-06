package myTest;

import myAdapter.*;
import org.junit.runner.*;
import java.util.*;
import org.junit.runner.notification.Failure;

/**
 * Class that run {@link TestList}.
 * It is the class that contains all the test for {@link myAdapter.ListAdapter}.
 * @version JUnit 4.13
 * @version Harmcrest: 1.3
 * @version JVM from JME CLDC 1.1
 * @author Michele Sprocatti
 */
public class TestRunner
{
    /**
     * Main method: run the test suite.
     * This will invoke all test of the suite, and print the result.
     * If there are some failure the method will print the messages of the failure.
     * @param args not used.
     */
    public static void main(String[] args)
    {
        System.out.println("Testing...\n");
        Result res=JUnitCore.runClasses(TestList.class);
        System.out.println("Correct test: "+res.wasSuccessful());
        System.out.println("Number of test for list: "+res.getRunCount());
        System.out.println("Number of failed test for list: "+res.getFailureCount());
        if(res.getFailureCount()>0)
            System.out.println("Message for failed test:");
        for(Failure f:res.getFailures())
        {
            System.out.println(f.getMessage());
        }
        System.out.println("Time used for testing: "+res.getRunTime()+" ms\n");
    }
}