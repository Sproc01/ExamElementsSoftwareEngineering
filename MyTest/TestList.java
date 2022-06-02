package MyTest;
import MyAdapter.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

/**
 * Test class for the ListAdapter class
 * @author Michele Sprocatti
 */
public class TestList
{
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};
    HList l1 = null;
    HList l2 = null;
    HListIterator li = null;

    @BeforeClass
    public static void setUpBeforeClass()
    {
        System.out.println("Testing list");
    }

    @Before
    public void setup()
    {
        l1 = new ListAdapter();
        l2 = new ListAdapter();
    }
    @Test
    public void testInitialize()
    {assertNotNull(l1);}

    @Test
    public void testAdd()
    {
        l1.add(0,3);
        assertEquals(3, l1.get(0));
    }

    @Test
    public void testClear()
    {
        l1.add(3);
        l1.add(4);
        l1.clear();
        assertEquals(0, l1.size());
    }

    @Test
    public void testContains()
    {
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(1);
        assertEquals(true, l1.contains(3));
    }

    @Test
    public void TestRemove()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        l1.remove("Mondo");
        assertEquals(false, l1.contains("Mondo"));
    }

    @Ignore @Test
    public void TestSubList()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        l2=l1.subList(1, 3);
        assertEquals(2, l2.size());
        assertArrayEquals(new Object[]{"pluto","Ciao"}, l2.toArray());
    }

    @Test
    public void TestIterator()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        HIterator iterator = l1.iterator();
        assertEquals("Pippo", iterator.next());
        assertEquals("pluto", iterator.next());
        assertEquals("Ciao", iterator.next());
        assertEquals("Mondo", iterator.next());
        assertEquals(false, iterator.hasNext());
    }

    @Test
    public void TestListIterator()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        li= l1.listIterator();
        assertEquals("Pippo", li.next());
        assertEquals("pluto", li.next());
        assertEquals("Ciao", li.next());
        assertEquals("Mondo", li.next());
        assertEquals(true, li.hasPrevious());
        assertEquals("Mondo", li.previous());
        assertEquals("Ciao", li.previous());
        assertEquals("pluto", li.previous());
        assertEquals("Pippo", li.previous());
        assertEquals(false, li.hasPrevious());
    }

    @Test
    public void testIsEmpty()
    {
        assertEquals(true, l1.isEmpty());
    }

    @Test
    public void testContainsAll()
    {

        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");

        l2.add("Pippo");
        l2.add("pluto");
        l2.add("Ciao");
        l2.add("Mondo");
        assertEquals(true, l1.containsAll(l2));
    }

    @Test
    public void testAddAll()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        l2.add("Luca");
        l2.add("Giovanni");
        l2.add("Marco");
        l2.add("Matteo");
        l1.addAll(l2);
        assertEquals(8, l1.size());
        assertArrayEquals(new Object[]{"Pippo","pluto","Ciao","Mondo","Luca","Giovanni","Marco","Matteo"}, l1.toArray());
    }

    @Test
    public void testRetainAll()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");

        l2.add("Pippo");
        l2.add("pluto");
        assertEquals(true, l1.retainAll(l2));
        assertArrayEquals(new Object[]{"Pippo","pluto"}, l1.toArray());
    }

    @Test
    public void testIndexOf()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        assertEquals(0, l1.indexOf("Pippo"));
        assertEquals(1, l1.indexOf("pluto"));
        assertEquals(2, l1.indexOf("Ciao"));
        assertEquals(3, l1.indexOf("Mondo"));
    }

    @Test
    public void testLastIndexOf()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        assertEquals(0, l1.lastIndexOf("Pippo"));
        assertEquals(1, l1.lastIndexOf("pluto"));
    }

    @Test
    public void testRemoveAll()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");
        HList l2=new ListAdapter();
        l2.add("Pippo");
        l2.add("pluto");
        l1.removeAll(l2);
        assertEquals(2, l1.size());
        assertArrayEquals(new Object[]{"Ciao","Mondo"}, l1.toArray());
    }

    @Test
    public void testEquals()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");

        l2.add("Pippo");
        l2.add("pluto");
        l2.add("Ciao");
        l2.add("Mondo");

        HList l3=new ListAdapter();
        l3.addAll(l2);

        assertEquals(true, l3.equals(l2));
        assertEquals(true, l1.equals(l2));
    }

    @Test
    public void testHashCode()
    {
        l1.add("Pippo");
        l1.add("pluto");
        l1.add("Ciao");
        l1.add("Mondo");

        l2.add("Pippo");
        l2.add("pluto");
        l2.add("Ciao");
        l2.add("Mondo");
        assertEquals(l2.hashCode(), l1.hashCode());
    }

    //#region test esempi

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

    @AfterClass
    public static void AfterClass()
    {
        System.out.println("Testing list done");
    }
}