package myTest;
import myAdapter.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import org.junit.*;

import java.util.NoSuchElementException;

/**
 * Test class for the ListAdapter class
 * <br> <br> <br>
 * Summary: This test suite tests all the functions of the ListAdapter:
 * Sometime single function, sometimes some functions togheter.
 * <br><br>
 * Design: The test suite is design to test the functions of the ListAdapter class using 4 different fields:
 * two different lists, one iterator and an array of string for testng. It is design to run every test with an empty list so there are no 
 * interaction between tests.
 * <br> <br>
 * Precondition: All the method of the ListAdapter class must be implemented.
 * <br> <br>
 * Postcondition: Every test must be passed to consider the listAdapter class as correct.
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
 * @see myAdapter.HList
 * @see myAdapter.HCollection
 * @see myAdapter.HIterator
 * @see myAdapter.HListIterator
 * @author Michele Sprocatti
 */
public class TestList
{
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};
    HList l1 = null;
    HList l2 = null;
    HListIterator li = null;

    /**
     * Before the test suite this will inform the user that the test suite is starting.
     */
    @BeforeClass
    public static void setUpBeforeClass()
    {
        System.out.println("Testing list");
    }

    /**
     * This method provide the setup of the fields before every test that will be executed.
     */
    @Before
    public void setup()
    {
        l1 = new ListAdapter();
        l2 = new ListAdapter();
    }

    /**
     * Test the constructor of the ListAdapter class.
     * <br> <br>
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
     * Test Case Design: The test case is designed to test the add method and get method of the listAdapter.
     * <br> <br>
     * Test Description:We add some elements and then there is the assertion that verified that all elements are correctly added to the list.
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
     * Test Case Design: The test case is designed to add some elements then clear the list.
     * <br> <br>
     * Test Description: It will add some elements than clear the list. After this there is the assertion that verified that the list is empty and the size is 0.
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
     * Test case summary: test that the contains method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then verify that they are in the list.
     * <br> <br>
     * Test Description: It will add some elements and then it will verified that the list contains all the elements added.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The listAdapter contains all the elements added.
     * <br><br>
     * Expected Results: The listAdapter contains all the elements added.
     */
    @Test
    public void testContains()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        l1.add(null);
        assertEquals(true, l1.contains(argv[0]));
        assertEquals(true, l1.contains(argv[1]));
        assertEquals(true, l1.contains(argv[2]));
        assertEquals(true, l1.contains(argv[3]));
        assertEquals(true, l1.contains(null));
        assertEquals((argv.length+1), l1.size());
    }

     /**
     * Test case summary: test that the remove method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then remove them one by one.
     * <br> <br>
     * Test Description: It adds some elements and then remove some. After every remove the size is tested. This method also test that if there is a duplicate element the remove method remove the first occurence.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The listAdapter does not contain all the elements removed. There is one duplicate element and his presence is verified.
     * <br><br>
     * Expected Results: The listAdapter does not contain all the elements removed.
     */
    @Test
    public void TestRemove()
    {
        l1.add(argv[1]);
        l1.add(argv[0]);
        l1.add(argv[2]);
        l1.add(argv[3]);
        l1.add(argv[3]);
        l1.remove(argv[3]);
        assertEquals(true, l1.contains(argv[3]));//there is the duplicate one
        assertEquals(4, l1.size());
        l1.remove(argv[1]);
        l1.remove(null);
        assertEquals(false, l1.contains(argv[1]));
        assertEquals(3, l1.size());
        l1.remove(argv[2]);
        assertEquals(false, l1.contains(argv[2]));
        assertEquals(2, l1.size());
    }

    /**
     * Test case summary: test that the iterator is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then visit the list with the iterator. 
     * <br> <br>
     * Test Description: The list is visited with the iterator and the correct behaviour of the iterator t is tested.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The iterator visit all the elements.
     * <br><br>
     * Expected Results: The iterator is correctly working.
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
        try {
            iterator.next();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
    }

    /**
     * Test case summary: test that the listIterator is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then visit the list with the listIterator. 
     * <br> <br>
     * Test Description: Assertions that verified that the listIterator visit all the element and it stops at the end of the list. Also it visit the element backwards and it stops at the beginning of the list.
     * Also the throw of the NoSuchElementException is tested.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The listIterator visit all the elements forward and backwards.
     * <br><br>
     * Expected Results: The listIterator is correctly working
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
        try{
            li.next();
            throw new Exception();
        }
        catch(Exception e)
        {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        assertEquals(true, li.hasPrevious());
        assertEquals(argv[5], li.previous());
        assertEquals(argv[4], li.previous());
        assertEquals(argv[3], li.previous());
        assertEquals(argv[2], li.previous());
        assertEquals(argv[1], li.previous());
        assertEquals(argv[0], li.previous());
        assertEquals(false, li.hasPrevious());
        try{
            li.previous();
            throw new Exception();
        }
        catch(Exception e)
        {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
    }

    /**
     * Test case summary: test that the isEmpty method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that after the constructor the list is empty and after adding some elements it is not empty, also after removing all the elements it is empty.
     * <br> <br>
     * Test Description: Assertion that verified that the isEmpty method return true if the list is empty and false if it is not. This test will be executed with an empty list and with a list with some element.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The isEmpty method return true if the list is empty and false if it is not.
     * <br><br>
     * Expected Results: The isEmpty is correctly working
     */
    @Test
    public void testIsEmpty()
    {
        assertEquals(true, l1.isEmpty());
        for(int i=0; i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        assertEquals(false, l1.isEmpty());
        for(int i=0; i<argv.length;i++)
        {
            l1.remove(argv[i]);
        }
        assertEquals(true, l1.isEmpty());
    }

    /**
     * Test case summary: test that the containsAll method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that that the containsAll method return true if the list contains all the elements of the other list and false if it does not.
     * <br> <br>
     * Test Description: Assertion that verified that after adding some elements to the list and then adding them again to another list, the containsAll method return true if the list contains all the elements of the other list and false if it does not.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The containsAll method return true if the list contains all the elements of the other list and false if it does not.
     * <br><br>
     * Expected Results: The containsAll is correctly working.
     */
    @Test
    public void testContainsAll()
    {
        for(int i=0;i<argv.length;i++)
        {
            l1.add(argv[i]);
        }
        try {
            l1.containsAll(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
        l2.add(argv[0]);
        l2.add(argv[1]);
        l2.add(argv[2]);
        assertEquals(true, l1.containsAll(l2));
        l2.add("test");
        assertEquals(false, l1.containsAll(l2));
    }

    /**
     * Test case summary: test that the addAll, toArray methods are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the size of the list is increased by the number of elements of the other list and that il toArray method return the correct array.
     * <br> <br>
     * Test Description: After adding some elements to the list and then adding them again to another list, the addAll method is tested.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The addAll method add all the elements of the specified list.
     * <br><br>
     * Expected Results: The addAll, toArray are correctly working.
     */
    @Test
    public void testAddAll()
    {
        try 
        {
            l1.addAll(null);
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals(NullPointerException.class, e.getClass());
        }

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
     * Test case summary: test that the retainAll, toArray methods are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the list contains only the element of the second list.
     * <br> <br>
     * Test Description: After adding some elements to one list, a small group of elements will be added in a second list, then we test the retainAll method.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The retainAll method remove all the elements that are in the first list but not in the second.
     * <br><br>
     * Expected Results: The retainAll, toArray are correctly working.
     */
    @Test
    public void testRetainAll()
    {
        try 
        {
            l1.retainAll(null);
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals(NullPointerException.class, e.getClass());
        }

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
     * Test case summary: test that the indexOf method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the indexOf method return the correct index of the element(that is the index of the first occurrence of the element in the list).
     * <br> <br>
     * Test Description: Assertion that verified that the indexOf method return the correct index of the element added before.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The indexOf method return the correct index of the element.
     * <br><br>
     * Expected Results: The indexOf is correctly working.
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
     * Test case summary: test that the lastIndexOf method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the lastIndexOf method return the correct index of the element(that is the index of the last occurrence of the element in the list).
     * <br> <br>
     * Test Description: Assertion that verified that the lastIndexOf method return the correct index of the element added before.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The lastIndexOf method return the correct index of the element.
     * <br><br>
     * Expected Results: The lastIndexOf is correctly working.
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
     * Test case summary: test that the removeAll, toArray methods are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that after adding some elements to the list, then create a new list with a small group of the elements in the first list, then use the removeAll method to remove all the elements that are in the second list from the first.
     * <br> <br>
     * Test Description: Assertion that verified that the list contains only the element that are not in the second list
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The removeAll method remove all the elements that are in the second list from the first
     * <br><br>
     * Expected Results: The removeAll, toArray are correctly working
     */
    @Test
    public void testRemoveAll()
    {
        try 
        {
            l1.removeAll(null);
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals(NullPointerException.class, e.getClass());
        }

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
     * Test case summary: test that the equals method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the list is equal to other lists with the same elements in the same order.
     * <br> <br>
     * Test Description: After adding some elements to the first list, the same elements are added to the second and third list. So they are equals and so the equals method is tested.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The three list are equals.
     * <br><br>
     * Expected Results: The equals is correctly working.
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
        try 
        {
            l1.equals(null);
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals(NullPointerException.class, e.getClass());
        }
        HList l3=new ListAdapter();
        l3.addAll(l2);

        assertEquals(true, l3.equals(l2));
        assertEquals(true, l1.equals(l2));
        
        l3.clear();
        for(int i=argv.length-1; i>=0; i--)
        {
            l3.add(argv[i]);
        }
        assertEquals(false, l1.equals(l3));
    }

     /**
     * Test case summary: test that the hashCode method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that two lists with same elements have the same hascode and that the hashcode of one list is the weighted sum of the elements hashcode.
     * <br> <br>
     * Test Description: Assertion that verified that the two list have the same hashcode.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The two list have the same hashcode.
     * <br><br>
     * Expected Results: The hashCode is correctly working.
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
        int hash=0;
        for(int i=0;i<argv.length;i++)
        {
            hash+=argv[i].hashCode()*Math.pow(31, i);
        }
        assertEquals(hash, l1.hashCode());
        assertEquals(l2.hashCode(), l1.hashCode());

        l2.clear();
        for(int i=argv.length-1; i>=0; i--)
        {
            l2.add(argv[i]);
        }
        assertNotEquals(l2.hashCode(), l1.hashCode());
    }

    //#region test esempi

    /**
     * Test case summary: test that the backing list operations are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that any structural operation in the subList is reflected on the fatherList.
     * <br> <br>
     * Test Description: Some elements are added to the list. Then the subList method is invoked, after that one element is added and then removed. The size of the subList and the fatherList is tested after the add operation and the remove operation.
     * Also the subList will be cleared so the size of the lists are tested.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The structural changes in the subList are reflected on the fatherList.
     * <br><br>
     * Expected Results: The subList is correctly working.
     */
    @Test
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
    
    /**
     * Test case summary: test that the backing list is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the subList have only the element from the range specified at the invocation of subList method.
     * <br> <br>
     * Test Description: Some elements are added to the list. Then the subList method is invoked, after that the subList is visited.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The subList have only the elements from the range specified.
     * <br><br>
     * Expected Results: The subList is correctly working.
     */
    @Test
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

    /**
     * Test case summary: test that the ListIterator remove, next,previous are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the ListIterator operations function correctly.
     * <br> <br>
     * Test Description: Some elements are added then a ListIterator is created and the elements are visited forward and backawards, after the elements are removed.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The ListIterator visit and remove all of the elements.
     * <br><br>
     * Expected Results: The ListIterator is correctly working.
     */
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

    /**
     * Test case summary: test that the ListIterator remove is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the ListIterator operation function correctly.
     * <br> <br>
     * Test Description: Some elements are added then a ListIterator is created and the elements are visited and removed.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The ListIterator visit and remove all of the elements.
     * <br><br>
     * Expected Results: The ListIterator is correctly working.
     */
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

    /**
     * Test case summary: test that the ListIterator remove is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the ListIterator visit all the elements backwards and it removed them correctly.
     * <br> <br>
     * Test Description: Some elements are added then a ListIterator is created from the last index and then it visit all of the element backwards. Also the elements are removed.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The ListIterator visit all of the elements and remove them.
     * <br><br>
     * Expected Results: The ListIterator is correctly working.
     */
	@Test
	public void testIterator1()
	{
		System.out.println("TestListIterator #1");
        for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
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

    /**
     * method that iterate using the specified iterator, and print all of the elements of the list.
     * @param iter the iterator used to visit the element of the list.
     */
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
     * Test case summary: test that the toArray with parameters is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the toArray(Object[]) return the correct array
     * <br> <br>
     * Test Description: Assertion that verified that the array returned is correct
     * <br> <br>
     * Pre-Condition: The constructor is already invoked.
     * <br> <br>
     * Post-Condition: The array returned is correct
     * <br><br>
     * Expected Results: The array returned is correct
     */
    @Test
    public void testToArrayWithParameters()
    {
        try
        {
            l1.toArray(null);
            throw new Exception();
        }catch(Exception e)
        { assertEquals(NullPointerException.class, e.getClass());}
        Object[] a=new Object[1];
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        assertArrayEquals(new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio"}, l1.toArray(a));
    }
    /**
     * After the test suite this will inform the user that the tests have finished.
     */
    @AfterClass
    public static void AfterClass()
    {
        System.out.println("Testing list done");
    }
}