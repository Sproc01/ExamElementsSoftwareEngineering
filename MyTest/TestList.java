package myTest;
import myAdapter.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

/**
 * Test class for the ListAdapter class
 * <br> <br>
 * Summary: In this test suite we test all the functions of the ListAdapter:
 * Sometime single function can be tested, sometimes more than one function togheter.
 * <br><br>
 * Design: The test suite is design to test the functions of the ListAdapter class using 4 different fields:
 * two different lists, one iterator and an array of string for testng. It is design to the run every test with an empty list so there are no 
 * interaction between tests.
 * <br> <br>
 * Description: The listAdapter is a class that implements the HList and HCollection interfaces, in this test suite we
 * test all the functions. We use string as element type.
 * <br> <br>
 * Precondition: ...
 * <br> <br>
 * Postcondition: ....
 * <br> <br>
 * Test cases: In this test suite there are various test cases: Adding and removing elements given the index or the element, using HIterator and HListIterator to 
 * visit the element of the list, test subList and his use, testing size(), clear() methods, test every search method(contains, indexOf, lastIndexOf),
 * <br> <br>
 * Execution records: If every condition in every test give positive result the test suite will be executed corrected and these results are considered Execution records.
 * <br> <br>
 * Execution variables:
 * <br> HList l1: list use for the majority of the test
 * <br> HList l2: list use for functions that use two lists(if more needed we instatiate others).
 * <br> HListIterator li: ListIterator use for testing his functions
 * <br> String[] array: elements use for testing
 * @version JUnit 4.13
 * @version Harmcrest: 1.3
 * @version JVM from JME CLDC 1.1
 * @author Michele Sprocatti
 */
public class TestList
{
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};
    HList l1 = null;
    HList l2 = null;
    HListIterator li = null;

    /**
     * Before the test suite this will inform the user that the test suite is starting
     */
    @BeforeClass
    public static void setUpBeforeClass()
    {
        System.out.println("Testing list");
    }

    /**
     * This method provide the setup of the fields before every test that will be executed
     */
    @Before
    public void setup()
    {
        l1 = new ListAdapter();
        l2 = new ListAdapter();
    }

    /**
     * Test case summary: test that the constructor of the listAdapter is working correctly.
     * <br><br>
     * Test Case Design: The test case is designed to test the constructor of the listAdapter.
     * <br> <br>
     * Test Description: Assertion that verified that the listAdapter is not null.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The constructor return a non null element.
     * <br><br>
     * Expected Results: The listAdapter is not null.
     */
    @Test
    public void testInitialize()
    {assertNotNull(l1);}

    /**
     * Test case summary: test that the add method and get method are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test the add method and get method of the listAdapter 4 times
     * <br> <br>
     * Test Description: Assertion that verified that all elements are correctly added to the list.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The listAdapter contains all the elements added.
     * <br><br>
     * Expected Results: The listAdapter contains all the elements added.
     */
    @Test
    public void testAdd()
    {
        l1.add(0,argv[0]);
        assertEquals("pippo", l1.get(0));
        l1.add(1,argv[1]);
        assertEquals("qui", l1.get(1));
        l1.add(2,argv[2]);
        assertEquals("pluto", l1.get(2));
        l1.add(argv[3]);
        assertEquals("paperino", l1.get(3));
    }

    /**
     * Test case summary: test that the clear method and isEmpty method are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then clear the list
     * <br> <br>
     * Test Description: Assertion that verified that the list is empty and the size is 0.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The listAdapter is empty and the size is 0.
     * <br><br>
     * Expected Results: The listAdapter is empty.
     */
    @Test
    public void testClear()
    {
        l1.add(argv[0]);
        l1.add(argv[1]);
        l1.add(argv[2]);
        l1.clear();
        assertEquals(0, l1.size());
        assertEquals(true, l1.isEmpty());
    }

    /**
     * 
     */
    @Test
    public void testContains()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        assertEquals(true, l1.contains(argv[0]));
        assertEquals(true, l1.contains(argv[1]));
        assertEquals(true, l1.contains(argv[2]));
        assertEquals(true, l1.contains(argv[3]));
        assertEquals(argv.length, l1.size());
    }

    /**
     * 
     */
    @Test
    public void TestRemove()
    {
        l1.add(argv[1]);
        l1.add(argv[0]);
        l1.add(argv[2]);
        l1.add(argv[3]);
        l1.remove(argv[3]);
        assertEquals(false, l1.contains(argv[3]));
        assertEquals(3, l1.size());
        l1.remove(argv[1]);
        assertEquals(false, l1.contains(argv[1]));
        assertEquals(2, l1.size());
        l1.remove(argv[2]);
        assertEquals(false, l1.contains(argv[2]));
        assertEquals(1, l1.size());
    }

    /**
     * 
     */
    @Test
    public void TestIterator()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        HIterator iterator = l1.iterator();
        assertEquals(argv[0], iterator.next());
        assertEquals(argv[1], iterator.next());
        assertEquals(argv[2], iterator.next());
        assertEquals(argv[3], iterator.next());
        assertEquals(argv[4], iterator.next());
        assertEquals(argv[5], iterator.next());
        assertEquals(false, iterator.hasNext());
    }

    /**
     * 
     */
    @Test
    public void TestListIterator()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        li= l1.listIterator();
        assertEquals(argv[0], li.next());
        assertEquals(argv[1], li.next());
        assertEquals(argv[2], li.next());
        assertEquals(argv[3], li.next());
        assertEquals(argv[4], li.next());
        assertEquals(argv[5], li.next());
        assertEquals(false, li.hasNext());
        assertEquals(true, li.hasPrevious());
        assertEquals(argv[5], li.previous());
        assertEquals(argv[4], li.previous());
        assertEquals(argv[3], li.previous());
        assertEquals(argv[2], li.previous());
        assertEquals(argv[1], li.previous());
        assertEquals(argv[0], li.previous());
        assertEquals(false, li.hasPrevious());
    }

    /**
     * 
     */
    @Test
    public void testIsEmpty()
    {
        assertEquals(true, l1.isEmpty());
    }

    /**
     * 
     */
    @Test
    public void testContainsAll()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        l2.add(argv[0]);
        l2.add(argv[1]);
        l2.add(argv[2]);
        assertEquals(true, l1.containsAll(l2));
    }

    /**
     * 
     */
    @Test
    public void testAddAll()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        l2.add("Luca");
        l2.add("Giovanni");
        l2.add("Marco");
        l2.add("Matteo");
        l1.addAll(l2);
        assertEquals(10, l1.size());
        assertArrayEquals(new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio","Luca","Giovanni","Marco","Matteo"}, l1.toArray());
    }

    /**
     * 
     */
    @Test
    public void testRetainAll()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        l1.add("Luca");
        l1.add("Giovanni");
        l1.add("Marco");
        l1.add("Matteo");
        for(int i=0;i<argv.length;i++)
        {
            l2.add(argv[i]);
        }
        assertEquals(true, l1.retainAll(l2));
        assertArrayEquals(argv, l1.toArray());
    }

    /**
     * 
     */
    @Test
    public void testIndexOf()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        assertEquals(0, l1.indexOf("pippo"));
        assertEquals(2, l1.indexOf("pluto"));
        assertEquals(1, l1.indexOf("qui"));
        assertEquals(-1, l1.indexOf("Mondo"));
    }

    /**
     * 
     */
    @Test
    public void testLastIndexOf()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        assertEquals(0, l1.lastIndexOf("pippo"));
        assertEquals(2, l1.lastIndexOf("pluto"));
        assertEquals(4, l1.lastIndexOf("qui"));
        assertEquals(-1, l1.lastIndexOf("Mondo"));
    }

    /**
     * 
     */
    @Test
    public void testRemoveAll()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        l2.add("pippo");
        l2.add("pluto");
        l1.removeAll(l2);
        assertEquals(4, l1.size());
        assertArrayEquals(new Object[]{"qui", "paperino", "qui", "ciccio"}, l1.toArray());
    }

    /**
     * 
     */
    @Test
    public void testEquals()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        for(int i=0;i<argv.length;i++)
        {
            l2.add(argv[i]);
        }

        HList l3=new ListAdapter();
        l3.addAll(l2);

        assertEquals(true, l3.equals(l2));
        assertEquals(true, l1.equals(l2));
    }

    /**
     * 
     */
    @Test
    public void testHashCode()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        for(int i=0;i<argv.length;i++)
        {
            l2.add(argv[i]);
        }

        assertEquals(l2.hashCode(), l1.hashCode());
    }

    //#region test esempi

    @Ignore @Test
	public void testBacking()
	{
		System.out.println("TestBacking");
		for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
		System.out.println("List.toString() ? " + l1);

		int dl0, dl1, dli, dsl0, dsl1, dsli;

		iterate(l1.iterator());
		System.out.println(l1 + " " + l1.size());
		dl0 = l1.size();

		l2 = l1.subList(0, argv.length/2);
		dsl0 = l2.size();

		l2.add("pipperissimo");
		dli = l1.size();
		dsli = l2.size();

		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dli, dl0+1);
		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dsli, dsl0+1);

		l2.remove("pipperissimo");
		assertEquals("\n*** list remove is NOT backed correctly ***\n", l1.size(), dl0);
		assertEquals("\n*** list remove is NOT backed correctly ***\n", l2.size(), dsl0);


		iterate(l2.iterator());
		System.out.println(l2 + " " + l2.size());

		l2.clear();
		dl1 = l1.size();
		dsl1 = l2.size();
		System.out.println(l1 + " " + l1.size());
		iterate(l1.iterator());
		System.out.println(l2 + " " + l2.size());
		iterate(l2.iterator());

		System.out.println(dl0 + " " + dl1 + " " + dsl0 + " " + dsl1);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dsl0, (dl0/2));
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dsl1, 0);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dl1, (dl0 - dsl0));

	}
    
    @Ignore @Test
	public void testRecursiveSublist()
	{
		System.out.println("TestRecursive SubListing");
		System.out.println(l1.size());
		
		assertEquals("List Starts not empty", l1.size(), 0);
		int prev = l1.size();
		for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
		System.out.println(l1.size());
		prev = l1.size();
		for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
		System.out.println(l1.size());
		prev = l1.size();
		for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
		System.out.println(l1.size());
		iterate(l1.iterator());

		int after = 0;
		int count = 0;
		while(l1.size()>=2)
		{
			count++;
			prev = l1.size();
			l1 = l1.subList(1, prev-1);
			after = l1.size();
			System.out.println(after);
			assertEquals("Iterative Sublisting not working at " + count + " iteration", after, (prev-2));
			iterate(l1.iterator());
		}
	}

	@Test
	public void testIterator3()
	{
		System.out.println("TestListIterator #3");
		int dl0, dl1, dl2;

		dl0 = l1.size();
		for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
		dl1 = l1.size();
		iterate(l1.iterator());
		li = l1.listIterator();
		while(li.hasNext())
			li.next();
		while(li.hasPrevious())
		{
			System.out.print(li.previous() + " ");
			iterate(l1.iterator());
			li.remove();
		}
		dl2 = l1.size();
		iterate(l1.iterator());

		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", dl1, (dl0+argv.length));
		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", dl2, 0);
	}

	@Test
	public void testIterator2()
	{
		System.out.println("TestListIterator #2");
		int dl0, dl1, dl2;
		dl0 = l1.size();
		for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
		dl1 = l1.size();
		iterate(l1.iterator());
		li = l1.listIterator();
		while(li.hasNext())
		{
			System.out.print(li.next() + " ");
			iterate(l1.iterator());
			li.remove();
		}
		dl2 = l1.size();
		iterate(l1.iterator());

		assertEquals("\n*** insertion and forward removal not working ***\n", dl1, (dl0+argv.length));
		assertEquals("\n*** insertion and forward removal not working ***\n", dl2, 0);
	}

	@Test
	public void testIterator1()
	{
		System.out.println("TestListIterator #1");
		iterate(l1.iterator());
		li = l1.listIterator(l1.size());
		while(li.hasPrevious())
		{
			System.out.print(li.previous() + " ");
			iterate(l1.iterator());
			li.remove();
		}
		iterate(l1.iterator());

		assertEquals("\n*** listiterator from end not working ***\n", l1.size(), 0);
	}

    public static void iterate(HIterator iter)
	{
		System.out.print("{");
		while(iter.hasNext())
		{
			System.out.print(iter.next() + "; ");
		}
		System.out.println("}");
	}

    //#endregion

    /**
     * After the test suite this will inform the user that the tests have finished.
     */
    @AfterClass
    public static void AfterClass()
    {
        System.out.println("Testing list done");
    }
}