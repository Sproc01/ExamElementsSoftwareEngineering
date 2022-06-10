package myTest;
import myAdapter.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.NoSuchElementException;

/**
 * This test suite provide some test methods for {@link myAdapter.ListAdapter}, {@link myAdapter.IteratorAdapter} and its functionality.
 * <br> <br>
 * Summary: This test suite tests all the functions of the ListAdapter:
 * Sometime single function, sometimes some functions togheter.
 * <br><br>
 * Design: The test suite is design to test the functions of the ListAdapter. In general every test add elements to the list then make some operation on the list. After the result of the operation are tested.
 * <br> <br>
 * Precondition: All the method of the ListAdapter class must be implemented.
 * <br> <br>
 * Postcondition: Every test must be passed to consider the listAdapter implementation correct.
 * <br> <br>
 * Test cases: In this test suite there are various test cases: Adding and removing elements given the index or the element, using HIterator and HListIterator to 
 * visit the element of the list. Test the subList and its use. Also size(), clear() and search methods(contains, indexOf, lastIndexOf) are tested.
 * <br> <br>
 * Execution records: If every condition in every test give positive result the test suite will be correctly executed and these results are considered execution records.
 * <br> <br>
 * Execution variables:
 * <br> -HList l1: list use for the majority of the test
 * <br> -HList l2: list use for functions that use two lists(if more needed we instatiate others).
 * <br> -HListIterator li: ListIterator use for testing his functions
 * <br> -String[] array: elements use for testing
 * @version JUnit 4.13
 * @version Harmcrest: 1.3
 * @version JVM from JME CLDC 1.1
 * @see  myAdapter.HList
 * @see myAdapter.HCollection
 * @see myAdapter.HIterator
 * @see myAdapter.HListIterator
 * @see myAdapter.ListAdapter
 * @see myAdapter.IteratorAdapter
 * @author Michele Sprocatti
 */
public class TestList
{
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};
    HList l1 = null;
    HList l2 = null;
    HListIterator li = null;

    /**
     * Before the test suite this informs the user that the test suite is starting.
     */
    @BeforeClass
    public static void setUpBeforeClass()
    {
        System.out.println("Testing list");
    }

    /**
     * This method provides the setup of the fields before every test that will be executed.
     */
    @Before
    public void setup()
    {
        l1 = new ListAdapter();
        l2 = new ListAdapter();
    }

    //#region test listAdapter

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
     * Expected Results: The constructor initialize a new element.
     */
    @Test
    public void testInitialize()
    {assertNotNull("After the constructor the list is null",l1);}

    /**
     * Test case summary: test that the add method and get method are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test the add method and get method of the listAdapter.
     * <br> <br>
     * Test Description: Some elements are added and then there are assertions that verified that all elements are correctly added to the list.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The add operation function correctly.
     * <br><br>
     * Expected Results: The listAdapter contains all the elements added.
     * @see myAdapter.ListAdapter#add(java.lang.Object)
     * @see myAdapter.ListAdapter#get(int)
     */
    @Test
    public void testAdd()
    {
        l1.add(0,argv[0]);
        assertEquals("Add with index doesn't function correctly","pippo", l1.get(0));
        l1.add(1,argv[1]);
        assertEquals("Add with index doesn't function correctly", "qui", l1.get(1));
        l1.add(2,argv[2]);
        assertEquals("Add with index doesn't function correctly","pluto", l1.get(2));
        l1.add(argv[3]);
        assertEquals("Add without index doesn't function correctly","paperino", l1.get(3));
    }

    /**
     * Test case summary: test that the clear,size methods are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then clear the list.
     * <br> <br>
     * Test Description: It adds some elements. Test that the size is increased correclty. Then clear the list. After this there are assertions that verified that the size is 0.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The clear method remove all the elements from the list.
     * <br><br>
     * Expected Results: The size of the listAdapter is 0 at the end.
     * @see myAdapter.ListAdapter#clear()
     * @see myAdapter.ListAdapter#size()
     */
    @Test
    public void testClearSize()
    {
        l1.add(argv[0]);
        l1.add(argv[1]);
        assertEquals(2,l1.size());
        l1.add(argv[2]);
        assertEquals(3, l1.size());
        l1.clear();
        assertEquals("Clear method is not working correctly", 0, l1.size());
    }

    /**
     * Test case summary: test that the contains method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then verify that they are in the list.
     * <br> <br>
     * Test Description: It adds some elements and then it will verified that the list contains all the elements added.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The contains method return true only if the element passed is in the list.
     * <br><br>
     * Expected Results: The listAdapter contains method return true when the element is in the list.
     * @see myAdapter.ListAdapter#contains(java.lang.Object)    
     */
    @Test
    public void testContains()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        l1.add(null);
        assertEquals("Contains does not function correctly",true, l1.contains(argv[0]));
        assertEquals("Contains does not function correctly",true, l1.contains(argv[1]));
        assertEquals("Contains does not function correctly",true, l1.contains(argv[2]));
        assertEquals("Contains does not function correctly",true, l1.contains(argv[3]));
        assertEquals("Contains does not function correctly",true, l1.contains(null));
        assertEquals("Contains does not function correctly",false, l1.contains("Mondo"));
        assertEquals((argv.length+1), l1.size());
    }

     /**
     * Test case summary: test that the remove method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then remove them one by one.
     * <br> <br>
     * Test Description: It adds some elements and then remove some. After every remove the size is tested. This method also test that if there is a duplicate element the remove method remove only the first occurence.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The remove method remove the specified element from the list.
     * <br><br>
     * Expected Results: The listAdapter does not contain all the elements removed.
     * @see myAdapter.ListAdapter#remove(java.lang.Object)     
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
        assertEquals("Remove doesn't function correclty",true, l1.contains(argv[3]));//there is the duplicate one
        assertEquals(4, l1.size());
        l1.remove(argv[1]);
        l1.remove(null);
        assertEquals("Remove doesn't function correclty", false, l1.contains(argv[1]));
        assertEquals("Remove doesn't function correclty",3, l1.size());
        l1.remove(argv[2]);
        assertEquals("Remove doesn't function correclty",false, l1.contains(argv[2]));
        assertEquals("Remove doesn't function correclty",2, l1.size());
    }

    /**
     * Test case summary: test that the isEmpty method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that after the constructor the list is empty and after adding some elements it is not empty, also after removing all the elements it is empty.
     * <br> <br>
     * Test Description: Assertion that verified that the isEmpty method return true if the list is empty and false if it is not. This test will be executed with an empty list and with a list with some element.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The list is empty at the end of this test.
     * <br><br>
     * Expected Results: The isEmpty method return true if the list is empty and false if it is not.
     * @see myAdapter.ListAdapter#isEmpty()    
     */
    @Test
    public void testIsEmpty()
    {
        assertEquals(true, l1.isEmpty());
        for(int i=0; i<argv.length;i++)
            l1.add(argv[i]);

        assertEquals("isEmpty doesn't function correclty",false, l1.isEmpty());

        for(int i=0; i<argv.length;i++)
            l1.remove(argv[i]);
        assertEquals("isEmpty doesn't function correclty",true, l1.isEmpty());
    }

    /**
     * Test case summary: test that the containsAll method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that that the containsAll method return true if the list contains all the elements of the other list and false if it does not.
     * <br> <br>
     * Test Description: Assertion that verified that after adding some elements to the list and then adding them again to another list, the containsAll method return true if the list contains all the elements of the other list and false if it does not.
     * It also test that if the collection passed is null a NullPointerException is thrown.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The first list contains all of the element that are in the second list.
     * <br><br>
     * Expected Results: The containsAll method return true if the list contains all the elements of the other list and false if it does not.
     * @see myAdapter.ListAdapter#containsAll(HCollection)     
     */
    @Test
    public void testContainsAll()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        try {
            l1.containsAll(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals("ContainsAll doesn't throw NullPointerException", NullPointerException.class, e.getClass());
        }
        l2.add(argv[0]);
        l2.add(argv[1]);
        l2.add(argv[2]);
        assertEquals("ContainsAll doesn't function correctly", true, l1.containsAll(l2));
        l2.add("test");
        assertEquals("ContainsAll doesn't function correctly", false, l1.containsAll(l2));
    }

    /**
     * Test case summary: test that the toArray method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that toArray is correctly working when the size is 0 and when is not 0.
     * <br> <br>
     * Test Description: It tests that the toArray method returns an empty array if the liste is empty.
     * Then after adding some elements to the list, the toArray method is invoked and the element that is returnend is compared with an array containing all elements.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The toArray method returns an empty array if the list is empty and it returns an array with all of the elements of the list if size()!=0.
     * <br><br>
     * Expected Results: The toArray method is correctly working.
     * @see myAdapter.ListAdapter#toArray()
     */
    @Test
    public void testToArrayWithoutArgument()
    {
        assertArrayEquals(new Object[]{}, l1.toArray());
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        assertArrayEquals("toArray return a wrong array",new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio"}, l1.toArray());
    }

    /**
     * Test case summary: test that the addAll methods are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the size of the list is increased by the number of elements of the other list. And it tests that the element are added correctly.
     * <br> <br>
     * Test Description: After adding some elements to the list and then adding others to another list, it use the addAll method to add every element of the second list in the first list.
     * Also it tests:<br>
     * -if the addAll method is invoked with a null parameter the method throws a NullPointerException.<br>
     * -The addAll method must return false if it is invoked with an empty list.<br>
     * It is also tested the addAll(int, HCollection) method with two calls using a wrong index to test the INdexOutOfBoundExcpetion and then with a correct index to test if it inserts the element in the right position.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The list contains the element added before and the element added using the addAll method.
     * <br><br>
     * Expected Results: The addAll(HCollection) method add all the elements of the specified list. The addAll(int, HCollection) add all elements in the right position.
     * @see myAdapter.ListAdapter#addAll(HCollection)
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

        assertEquals("Adding an empty list using addAll return true instead of false",false, l1.addAll(l2));

        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        
        l2.add("Luca");
        l2.add("Giovanni");
        l2.add("Marco");
        l2.add("Matteo");
        l1.addAll(l2);
        assertEquals("addAll method doesn't increase size",10, l1.size());
        assertArrayEquals("addAll method doesn't add the elements in the right order",new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio","Luca","Giovanni","Marco","Matteo"}, l1.toArray());

        try 
        {
            l1.addAll(-1,l2);
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        try 
        {
            l1.addAll(0,null);
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals(NullPointerException.class, e.getClass());
        }

        try 
        {
            l1.addAll(l1.size()+1,l2);
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        l1.addAll(2,l2);
        assertEquals("addAll with index method doesn't increase size",14, l1.size());
        assertArrayEquals("addAll method doesn't add the elements in the right order",new Object[]{"pippo", "qui","Luca","Giovanni","Marco","Matteo", "pluto", "paperino", "qui", "ciccio","Luca","Giovanni","Marco","Matteo"}, l1.toArray());

        l1.clear();
        l1.addAll(0, l2);
        assertEquals("addAll method doesn't increase size",4, l1.size());
        assertArrayEquals("addAll method doesn't add the elements in the right order",new Object[]{"Luca","Giovanni","Marco","Matteo"}, l1.toArray());
    }

    /**
     * Test case summary: test that the retainAll method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the list contains only the element of the second list.
     * <br> <br>
     * Test Description: After adding some elements to one list, a small group of elements are added in a second list, then it tests that the retainAll method remove only the elements that are in the firt list but not in the second.
     * It will invoke also the retainAll method with a null parameter to verify that it will launch NullPointerException.
     * The retainAll method is invoked also with an empty list and it is tested that return false.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The first list contains only the element that are in second list.
     * <br><br>
     * Expected Results: The retainAll method remove all the elements that are in the first list but not in the second.
     * @see myAdapter.ListAdapter#retainAll(HCollection)  
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

        assertEquals("Retain an empty list using retainAll return true instead of false",false, l1.retainAll(l2));

        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        l1.add("Luca");
        l1.add("Giovanni");
        l1.add("Marco");
        l1.add("Matteo");
        for(int i=0;i<argv.length;i++)
            l2.add(argv[i]);

        assertEquals("The retainAll method return false instead of true",true, l1.retainAll(l2));
        assertArrayEquals("The array returned by toArray after the retainAll method is wrong", argv, l1.toArray());
    }

    /**
     * Test case summary: test that the indexOf method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the indexOf method return the correct index of the element(that is the index of the first occurrence of the element in the list).
     * <br> <br>
     * Test Description: Assertion that verified that the indexOf method return the correct index of the element added before.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: IndexOf return the right index if the element is present, -1 if it si not present.
     * <br><br>
     * Expected Results: The indexOf method return the correct index of the element.
     * @see myAdapter.ListAdapter#indexOf(java.lang.Object)    
     */
    @Test
    public void testIndexOf()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        assertEquals("IndexOf return the wrong index",0, l1.indexOf("pippo"));
        assertEquals("IndexOf return the wrong index",2, l1.indexOf("pluto"));
        assertEquals("IndexOf return the wrong index",1, l1.indexOf("qui"));
        assertEquals("IndexOf doesn't return -1 if the list doesn't contain the element",-1, l1.indexOf("Mondo"));
    }

    /**
     * Test case summary: test that the lastIndexOf method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the lastIndexOf method return the correct index of the element(that is the index of the last occurrence of the element in the list).
     * <br> <br>
     * Test Description: Assertion that verified that the lastIndexOf method return the correct index of the element added before.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: LastIndexOf return the right index if the element is present, -1 if it si not present.
     * <br><br>
     * Expected Results: The lastIndexOf method return the correct index of the element.
     * @see myAdapter.ListAdapter#lastIndexOf(java.lang.Object)
     */
    @Test
    public void testLastIndexOf()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        assertEquals("LastIndexOf return the wrong index",0, l1.lastIndexOf("pippo"));
        assertEquals("LastIndexOf return the wrong index",2, l1.lastIndexOf("pluto"));
        assertEquals("LastIndexOf return the wrong index",4, l1.lastIndexOf("qui"));
        assertEquals("LastIndexOf doesn't return -1 if the list doesn't contain the element",-1, l1.lastIndexOf("Mondo"));
    }

    /**
     * Test case summary: test that the removeAll method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the removeAll method is correctly working.
     * <br> <br>
     * Test Description: The removeAll method is invoked with a null parameter to test the throw of NullPointerException.
     * The removeAll method is invoked also with an empty list and it is tested that return false.
     * Then it adds elements to two list; in the second are added a subset of the elements of the first list, then it uses the removeAll method to remove the elements that are in the second list from the first list.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The first list contains only the element that was present before the removeAll operation and that are no present in the second list.
     * <br><br>
     * Expected Results:  The removeAll method remove all the elements that are in the second list from the first.
     * @see myAdapter.ListAdapter#removeAll(HCollection)
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

        assertEquals("Removing an empty list using removeAll return true instead of false",false, l1.removeAll(l2));

        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        l2.add("pippo");
        l2.add("pluto");
        l1.add("pippo");//every duplicate is also removed.
        l1.removeAll(l2);
        assertEquals("The size isn't correct after the removeAll",4, l1.size());
        assertArrayEquals("The array returned by toArray after the removeAll method is wrong", new Object[]{"qui", "paperino", "qui", "ciccio"}, l1.toArray());
    }

    /**
     * Test case summary: test that the equals method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the list is equal to other lists with the same elements in the same order.
     * <br> <br>
     * Test Description: After adding some elements to the first list, the same elements are added to the second and third list. Then they are equals, so the equals method is tested.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The three list are equals when they have same elements in the same order.
     * <br><br>
     * Expected Results: The equals method return true if two list are equals, false otherwise.
     * @see myAdapter.ListAdapter#equals(java.lang.Object)     
     */
    @Test
    public void testEquals()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        for(int i=0;i<argv.length;i++)
            l2.add(argv[i]);

        HList l3=new ListAdapter();
        l3.addAll(l2);

        assertEquals("Lists with the same element are not equal",true, l3.equals(l2));
        assertEquals("Lists with the same element are not equal",true, l1.equals(l2));
        
        l3.clear();
        for(int i=argv.length-1; i>=0; i--)
            l3.add(argv[i]);
        assertEquals("List with some elements is equals to an empty list",false, l1.equals(l3));
    }

     /**
     * Test case summary: test that the hashCode method is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that two lists with the same elements have the same hascode and that the hashcode of one list is the weighted sum of the elements hashcode.
     * <br> <br>
     * Test Description: It adds some elements to two lists, then compare their hashcode. Also it verifies that the hashcode is the result of this algorithm
     * <pre>
     * hashCode = 1;
     * Iterator i = list.iterator();
     * while (i.hasNext()) {
     *     Object obj = i.next();
     *     hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
     * }
     * </pre>
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The two lists have the same hashcode when they have the same elements.
     * <br><br>
     * Expected Results: The two list have the same hashcode if they have the same elements in the same order.
     * @see myAdapter.ListAdapter#hashCode()     
     */
    @Test
    public void testHashCode()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        for(int i=0;i<argv.length;i++)
            l2.add(argv[i]);
        int hashCode=1;
        li = l1.listIterator();
        while (li.hasNext()) 
        {
           Object obj = li.next();
           hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        assertEquals("Two lists with the same elements have different hashcode", hashCode, l1.hashCode());
        assertEquals("Two lists with the same elements have different hashcode",l2.hashCode(), l1.hashCode());
        l2.clear();
        for(int j=argv.length-1; j>=0; j--)
            l2.add(argv[j]);
        assertNotEquals("The list with some elements have the same hashcode of an empty list",l2.hashCode(), l1.hashCode());
    }

    /**
     * Test case summary: test that the toArray with parameters is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the toArray(Object[]) return the correct array
     * <br> <br>
     * Test Description: It verifies that the toArray(null) throw a NullPointerException. After it tests that if the array passed is not null, the method function correctly.
     * This is verified with a parameter that have not the right size so the method must return a new array. But also it is verified that if the size is enough the method modify the array passed.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The toArray(Object[]) return a correct array and if the size of the array passed is enough it will modify that array also.
     * <br><br>
     * Expected Results: The array returned is correct.
     * @see myAdapter.ListAdapter#toArray(Object[])   
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

        assertArrayEquals("The toArray(Object[]) doesn't return the correct array", new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio"}, l1.toArray(a));
        a=new Object[6];
        assertArrayEquals("The toArray(Object[]) doesn't return the correct array", new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio"}, l1.toArray(a));
        assertArrayEquals("The toArray(Object[]) doesn't modify the array passed", new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio"}, a);
        a=new Object[8];
        a[7]="50";
        a[6]="20";
        assertArrayEquals("The toArray(Object[]) doesn't return the correct array",new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio", null, "50"}, l1.toArray(a));
        assertArrayEquals("The toArray(Object[]) doesn't modify the array passed",new Object[]{"pippo", "qui", "pluto", "paperino", "qui", "ciccio", null, "50"}, a);
    }

    /**
     * Test case summary: Test that the subList method manages correctly the index passed. And the subList contains only the element in the correctly range.
     * <br><br>
     * Test Case Design: The test case is designed to test that the subList throw IndexOutOfBoundException when it is expected, and not when it is not expected.
     * <br> <br>
     * Test Description: It invokes two times the subList method:<br>
     * -One with an invalid fromIndex<br>
     * -One with an invalid toIndex<br>
     * And in both of them is tested the throw of IndexOutOfBoundException.
     * At the end it is tested that the subList method return a not null list and then it is verified that the list contains only the element that are in the specified range.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The subList method throws the IndexOutOfBoundException whent it is expected and in the other case it function correctly.
     * <br><br>
     * Expected Results: The subList construction is function correctly.
     * @see myAdapter.ListAdapter#subList(index,index)
     */
    @Test 
    public void testSubListIndex()
    {
        HList subList=null;
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        try
        {
            subList= l1.subList(-1, 1);
            throw new Exception();
        }catch(Exception e)
        {
            assertEquals("Invalid fromIndex for sublist is accepted", IndexOutOfBoundsException.class, e.getClass());
        }

        try
        {
            subList = l1.subList(0, l1.size()+1);
            throw new Exception();
        }catch(Exception e)
        {
            assertEquals("Invalid toIndex for sublist is accepted", IndexOutOfBoundsException.class, e.getClass());
        }
        subList=l1.subList(1,5);
        assertNotNull(subList);
        assertArrayEquals("The elements of the subList are wrong",new Object[]{ "qui", "pluto", "paperino", "qui"}, subList.toArray());

    }

    /**
     * Test case summary: Test that the subList operation are backed correctly into the fatherList.
     * <br><br>
     * Test Case Design: The test case is designed to test that the subList operation are reflected into the fatherList.
     * <br> <br>
     * Test Description: The test use the clear, retainAll, addAll, removeAll, add, remove to test that these operation are reflected into the fatherList.
     * This method uses two lists to invoke these methods, and compare the size expected with the size of the fatherList to understand if the operation are reflected.
     * It is also verified that in the fatherList there are only the element expected.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The subList method manages to modify in the correct way the fatherLIst.
     * <br><br>
     * Expected Results: The subList operation function correctly.
     * @see myAdapter.ListAdapter#subList(index,index)
     */
    @Test 
    public void testSubListOperation()
    {
        HList subList=null;
        for(int i=0;i<argv.length;i++)
        {
            l2.add(argv[i]);
            l1.add(argv[i]);
        }    
        subList=l1.subList(1,5);
        subList.clear();
        assertEquals("The clear operation on the subList doesn't modify in the right way the size of the fatherList",2,l1.size());
        assertArrayEquals("The fatherList haven't the expected elements", new Object[]{"pippo", "ciccio"}, l1.toArray());

        subList.addAll(l2);
        assertEquals("The addAll operation on the subList doesn't modify in the right way the size of the fatherList", 8 ,l1.size());
        assertArrayEquals("The fatherList haven't the expected elements", new Object[]{"pippo","pippo", "qui", "pluto", "paperino", "qui", "ciccio", "ciccio"}, l1.toArray());

        subList.removeAll(l2);
        assertEquals("The removeAll operation on the subList doesn't modify in the right way the size of the fatherList", 2 ,l1.size());
        assertArrayEquals("The fatherList haven't the expected elements", new Object[]{"pippo", "ciccio"}, l1.toArray());

        subList.add(null);
        assertEquals("The add operation on the subList doesn't modify in the right way the size of the fatherList", 3 ,l1.size());
        assertArrayEquals("The fatherList haven't the expected elements", new Object[]{"pippo", null, "ciccio"}, l1.toArray());

        subList.remove(null);
        assertEquals("The remove operation on the subList doesn't modify in the right way the size of the fatherList", 2 ,l1.size());
        assertArrayEquals("The fatherList haven't the expected elements", new Object[]{"pippo", "ciccio"}, l1.toArray());

        subList=null;
        l1.clear();
        l2.clear();
        for(int i=0;i<argv.length;i++)
        {
            l2.add(argv[i]);
            l1.add(argv[i]);
        }
        subList=l1.subList(0,5);
        HList subList2=l2.subList(1,4);
        subList.retainAll(subList2);
        assertEquals("The retainAll operation on the subList doesn't modify in the right way the size of the fatherList", 5 ,l1.size());
        assertArrayEquals("", new Object[]{"qui","pluto","paperino","qui","ciccio"}, l1.toArray());
    }

    //#endregion

    //#region testIterator
    
    /**
     * Test case summary: test that the listIterator return a correct iterator.
     * <br> <br>
     * Test case design: The test case is design to test that the listIterator method return a correct iterator and also that it throws IndexOutOfBoundException if the index is invalid.
     * <br> <br>
     * Test Description: The listIterator method is invoked to test if it returns a not null iterator. Then it is invoked with an invalid index to test the throw of IndexOutOfBoundException.
     * At the end it is invoked with a correct index to test that a next() operation return the correct element.
     * <br><br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The listIterator manages correctly the different construction possibilities.
     * <br><br>
     * Expected Results: The ListIterator is constructed correctly.
     * @see myAdapter.ListAdapter#listIterator()
     * @see myAdapter.ListAdapter#listIterator(index)
     */
    @Test
    public void testListIteratorConstructor()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        
        assertNotNull("The listIterator returned is null",l1.listIterator());

        try
        {
            l1.listIterator(-1);
            throw new Exception();
        } catch (Exception e) {
            assertEquals("Invalid index is accepted",IndexOutOfBoundsException.class, e.getClass());
        }

        li=l1.listIterator(5);
        assertEquals(argv[5],li.next());
    }

    /**
     * Test case summary: test that the iterator is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then visit the list with the iterator. 
     * <br> <br>
     * Test Description: The list is visited with the iterator and the correct behaviour of the iterator is tested.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The iterator visit all the elements.
     * <br><br>
     * Expected Results: All elements are visited by the iterator using only next() operation.
     * @see myAdapter.ListAdapter#iterator()
     */
    @Test
    public void testIterator()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        HIterator li = l1.listIterator();
        assertEquals("The iterator next operation doesn't return the right element",argv[0], li.next());
        assertEquals(argv[1], li.next());
        assertEquals(argv[2], li.next());
        assertEquals(argv[3], li.next());
        assertEquals(argv[4], li.next());
        assertEquals(argv[5], li.next());
        assertEquals(false, li.hasNext());
        try
        {
            li.next();
            throw new Exception();
        } catch (Exception e) {
            assertEquals("At the end of the list the next operation of the iterator doesn't throw NoSuchElementException",NoSuchElementException.class, e.getClass());
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
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The list can be visited forward or backwards using the next() or previous() operation.
     * <br><br>
     * Expected Results: The listIterator visit all the elements forward and backwards.
     * @see  myAdapter.ListAdapter#listIterator()
     * @see  myAdapter.IteratorAdapter#next()
     * @see  myAdapter.IteratorAdapter#hasNext()
     * @see  myAdapter.IteratorAdapter#previous()
     * @see  myAdapter.IteratorAdapter#hasPrevious()
     */
    @Test
    public void testListIterator()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        li= l1.listIterator();
        assertEquals("The ListIterator next operation doesn't return the right element", argv[0], li.next());
        assertEquals("The ListIterator next operation doesn't return the right element",argv[1], li.next());
        assertEquals("The ListIterator next operation doesn't return the right element",argv[2], li.next());
        assertEquals("The ListIterator next operation doesn't return the right element",argv[3], li.next());
        assertEquals("The ListIterator next operation doesn't return the right element",argv[4], li.next());
        assertEquals("The ListIterator next operation doesn't return the right element",argv[5], li.next());
        assertEquals("At the end of the list the ListIterator hasNext return true instead of false",false, li.hasNext());
        try
        {
            li.next();
            throw new Exception();
        }
        catch(Exception e)
        {
            assertEquals("The ListIterator next operation when it is at the the end of the list doesn't throw NoSuchElementException",NoSuchElementException.class, e.getClass());
        }
        assertEquals("At the end of the list the ListIterator hasPrevious return false instead of true", true, li.hasPrevious());
        assertEquals("The ListIterator previous operation doesn't return the right element",argv[5], li.previous());
        assertEquals("The ListIterator previous operation doesn't return the right element", argv[4], li.previous());
        assertEquals("The ListIterator previous operation doesn't return the right element", argv[3], li.previous());
        assertEquals("The ListIterator previous operation doesn't return the right element", argv[2], li.previous());
        assertEquals("The ListIterator previous operation doesn't return the right element", argv[1], li.previous());
        assertEquals("The ListIterator previous operation doesn't return the right element",argv[0], li.previous());
        assertEquals("At the beginning of the list the ListIterator hasPrevious return true instead of false",false, li.hasPrevious());
        try
        {
            li.previous();
            throw new Exception();
        }
        catch(Exception e)
        {
            assertEquals("The ListIterator previous operation when it is at the the beginning of the list doesn't throw NoSuchElementException",NoSuchElementException.class, e.getClass());
        }
    }

    /**
     * Test case summary: test that the listIterator set is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then use the set operation of the ListIterator to change them.
     * <br> <br>
     * Test Description: Some elements are inserted in the list. Then the listIterator is used to change some of them. The element that must be changed is tested.
     * Also it is tested that the set operation can be done only after next/previous operation or after another set operation.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The set operation set the right element and it can be invoked only in certain conditions.
     * <br><br>
     * Expected Results: The listIterator set is correctly working.
     * @see myAdapter.ListAdapter#listIterator()
     * @see myAdapter.IteratorAdapter#set(java.lang.Object)
     */
    @Test
    public void testListIteratorSet()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        li=l1.listIterator();
        li.next();
        li.next();
        li.set("Mondo");
        assertEquals("The ListIterator set doesn't set the element",true, l1.contains("Mondo"));
        assertArrayEquals("The ListIterator set doesn't set the right element",new Object[]{"pippo", "Mondo", "pluto", "paperino", "qui", "ciccio"}, l1.toArray());
        li.set("Ciao");
        assertArrayEquals("The ListIterator set doesn't set the right element", new Object[]{"pippo", "Ciao", "pluto", "paperino", "qui", "ciccio"}, l1.toArray());
        li.add("qui");
        try 
        {
            li.set("qui");
            throw new Exception();
        } catch (Exception e) 
        {
            assertEquals("After an add operation set doesn't throw IllegalStateException", IllegalStateException.class, e.getClass());
        }
        li.previous();
        li.set("M");
        assertArrayEquals("The ListIterator set doesn't set the right element", new Object[]{"pippo", "Ciao", "M", "pluto", "paperino", "qui", "ciccio"}, l1.toArray());
    }

    /** 
     * Test case summary: test that the listIterator add is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then use the add operation of the ListIterator to add another one.
     * <br> <br>
     * Test Description: Some elements are inserted in the list. Then the listIterator is used to add another one after the first element. The presence of the element just added is tested.
     * <br><br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The add operation add the element in the right position.
     * <br><br>
     * Expected Results: The listIterator add is correctly working.
     * @see myAdapter.ListAdapter#listIterator()
     * @see myAdapter.IteratorAdapter#add(java.lang.Object)
     */
    @Test 
    public void testListIteratorAdd()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        li=l1.listIterator();
        li.next();
        li.add("Mondo");
        assertEquals("The add didn't add the element",true, l1.contains("Mondo"));
        assertEquals("The add didn't insert the element in the right position", "Mondo", li.previous());
        li.next();//cursor goes backwards to test the previous element, this call cancels the call to previous.
        //so the next element after the add operation is tested.
        assertEquals("The add didn't insert the element in the right position", "qui", li.next());
    }

     /** 
     * Test case summary: test that the listIterator remove is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then use the ListIterator to remove some.
     * <br> <br>
     * Test Description: Some elements are inserted in the list. Then the listIterator is used to remove the first element. The presence of the element just removed is tested.
     * After other remove operations are tested.
     * Also it is tested that the remove operation can be done only after next/previous operation.
     * <br><br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The remove operation remove the right element.
     * <br><br>
     * Expected Results: The listIterator remove is correctly working.
     * @see myAdapter.ListAdapter#listIterator()
     * @see myAdapter.IteratorAdapter#remove()     
     */
    @Test 
    public void testListIteratorRemove()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        li=l1.listIterator();
        try 
        {
            li.remove();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
        li.next();
        li.remove();
        assertEquals("The ListIterator remove didn't remove the element",false, l1.contains("pippo"));
        assertEquals("At the beginning of the list the ListIterator hasPrevious return true instead of false after the remove of the first element by the ListIterator", false, li.hasPrevious());
        assertEquals("The next operation after removing the first element doesn't fucntion correctly","qui", li.next());
        li.next();
        li.remove();
        assertEquals("The previous operation after removing an element with ListIterator remove doesn't function correctly", "qui",li.previous());
        li.next();
        assertEquals("The next operation after removing an element with ListIterator remove doesn't function correctly","paperino", li.next());
    }

     /** 
     * Test case summary: test that the listIterator nextIndex, previousIndex are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to add some elements then verified if the nextIndex and previousIndex return the correct index.
     * <br> <br>
     * Test Description: Some elements are inserted in the list. Then the listIterator is used to test if call to nextIndex and previousIndex return the correct index.
     * <br><br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: nextIndex and previousIndex return the right index.
     * <br><br>
     * Expected Results: The listIterator nextIndex,previousIndex are correctly working.
     * @see myAdapter.ListAdapter#listIterator()
     * @see myAdapter.IteratorAdapter#nextIndex()
     * @see myAdapter.IteratorAdapter#previousIndex()
     */
    @Test
    public void testPreviousIndexNextIndex()
    {
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        li=l1.listIterator();
        assertEquals("ListIterator previousIndex doesn't return -1 when it is at the beginning of the list",-1, li.previousIndex());
        for(int i=0; i<3;i++)
            li.next();
        assertEquals("ListIterator previousIndex doesn't return the rigth index", 2, li.previousIndex());
        assertEquals("ListIterator nextIndex doesn't return the right index",3, li.nextIndex());
        li.next();
        assertEquals("ListIterator previousIndex doesn't return the rigth index",3, li.previousIndex());
        assertEquals("ListIterator nextIndex doesn't return the right index",4, li.nextIndex());
        while(li.hasNext())
            li.next();
        assertEquals("ListIterator nextIndex doesn't return list.size() when it is at the end of the list",l1.size(), li.nextIndex());
    }

    //#endregion

    //#region test forniti dal docente

    /**
     * Test case summary: test that the backing list operations are correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that any structural operation in the subList is reflected on the fatherList.
     * <br> <br>
     * Test Description: Some elements are added to the list. Then the subList method is invoked, after that one element is added and then removed. The size of the subList and the fatherList is tested after the add operation and the remove operation.
     * Also the subList will be cleared so the size of the lists are tested again.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: Structural changes in the subList are reflected on the fatherList.
     * <br><br>
     * Expected Results: The structural changes in the subList are reflected on the fatherList.
     * @see myAdapter.ListAdapter#subList(int, int)
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
     * Test case summary: test that the subList is correctly working.
     * <br><br>
     * Test Case Design: The test case is designed to test that the subList have only the element from the range specified at the invocation of subList method.
     * <br> <br>
     * Test Description: Some elements are added to the list. Then the subList method is invoked, after that the subList is visited.
     * Other subList are created to test if the recursive subList is correctly working.
     * <br> <br>
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: SubList of subList fucntion correctly.
     * <br><br>
     * Expected Results: The subList have only the elements from the range specified. SubList of SubList are correclty working.
     * @see myAdapter.ListAdapter#subList(int, int)
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
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The listIterator arrive at the end of the list using next(), and the list is empty after visiting and removing the element backwards.
     * <br><br>
     * Expected Results: The ListIterator visit and remove all of the elements.
     * @see myAdapter.ListAdapter#listIterator()
     * @see myAdapter.IteratorAdapter#remove()
     * @see myAdapter.IteratorAdapter#next()
     * @see myAdapter.IteratorAdapter#previous()
     * @see myAdapter.IteratorAdapter#hasNext()
     * @see myAdapter.IteratorAdapter#hasPrevious()
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
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The list isEmpty after removing all of the elements with the listItearator during the forward visit.
     * <br><br>
     * Expected Results: The ListIterator visit and remove all of the elements.
     * @see myAdapter.ListAdapter#listIterator()
     * @see myAdapter.IteratorAdapter#remove()
     * @see myAdapter.IteratorAdapter#next()
     * @see myAdapter.IteratorAdapter#previous()
     * @see myAdapter.IteratorAdapter#hasNext()
     * @see myAdapter.IteratorAdapter#hasPrevious()
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
     * Pre-Condition: The constructor is already invoked. The other methods used by this test are correctly working.
     * <br> <br>
     * Post-Condition: The list isEmpty after removing all of the elements with the listItearator during the backward visit.
     * <br><br>
     * Expected Results: The ListIterator visit all of the elements and remove them.
     * @see myAdapter.ListAdapter#listIterator(int)
     * @see myAdapter.IteratorAdapter#remove()
     * @see myAdapter.IteratorAdapter#next()
     * @see myAdapter.IteratorAdapter#previous()
     * @see myAdapter.IteratorAdapter#hasNext()
     * @see myAdapter.IteratorAdapter#hasPrevious()
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
     * Method that iterate using the specified iterator, during the visit the elements are printed.
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
     * After the test suite this informs the user that the tests have finished.
     */
    @AfterClass
    public static void AfterClass()
    {
        System.out.println("Testing list done");
    }
}