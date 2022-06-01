package MyTest;
import MyAdapter.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

public class TestList
{
    @BeforeClass
    public static void setUpBeforeClass()
    {
        System.out.println("Testing list");
    }

    @Test
    public void testInitialize()
    {
        HList list = new ListAdapter();
        assertNotNull(list);
    }

    @Test
    public void testAdd()
    {
        HList list = new ListAdapter();
        list.add(0,3);
        assertEquals(3, list.get(0));
    }

    @Test
    public void testClear()
    {
        HList list = new ListAdapter();
        list.add(3);
        list.add(4);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testContains()
    {
        HList list = new ListAdapter();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        assertEquals(true, list.contains(3));
    }

    @Test
    public void TestRemove()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        list.remove("Mondo");
        assertEquals(false, list.contains("Mondo"));
    }

    @Test
    public void TestSubList()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList sublist = list.subList(1,3);
        assertEquals(2, sublist.size());
        assertArrayEquals(new Object[]{"pluto","Ciao"}, sublist.toArray());
    }

    @Test
    public void TestIterator()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HIterator iterator = list.iterator();
        assertEquals("Pippo", iterator.next());
        assertEquals("pluto", iterator.next());
        assertEquals("Ciao", iterator.next());
        assertEquals("Mondo", iterator.next());
        assertEquals(false, iterator.hasNext());
    }

    @Ignore @Test
    public void TestListIterator()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HListIterator iterator = list.listIterator();
        assertEquals("Pippo", iterator.next());
        assertEquals("pluto", iterator.next());
        assertEquals("Ciao", iterator.next());
        assertEquals("Mondo", iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals("Ciao", iterator.previous());
        assertEquals("pluto", iterator.previous());
        assertEquals("Pippo", iterator.previous());
        assertEquals(false, iterator.hasPrevious());
    }

    @Test
    public void testIsEmpty()
    {
        HList list = new ListAdapter();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testContainsAll()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2 = new ListAdapter();
        list2.add("Pippo");
        list2.add("pluto");
        list2.add("Ciao");
        list2.add("Mondo");
        assertEquals(true, list.containsAll(list2));
    }

    @Test
    public void testAddAll()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2 = new ListAdapter();
        list2.add("Luca");
        list2.add("Giovanni");
        list2.add("Marco");
        list2.add("Matteo");
        list.addAll(list2);
        assertEquals(8, list.size());
        assertArrayEquals(new Object[]{"Pippo","pluto","Ciao","Mondo","Luca","Giovanni","Marco","Matteo"}, list.toArray());
    }

    @Test
    public void testRetainAll()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2 = new ListAdapter();
        list2.add("Pippo");
        list2.add("pluto");
        assertEquals(true, list.retainAll(list2));
        assertArrayEquals(new Object[]{"Pippo","pluto"}, list.toArray());
    }

    @Test
    public void testIndexOf()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        assertEquals(0, list.indexOf("Pippo"));
        assertEquals(1, list.indexOf("pluto"));
        assertEquals(2, list.indexOf("Ciao"));
        assertEquals(3, list.indexOf("Mondo"));
    }

    @Test
    public void testLastIndexOf()
    {
        HList list = new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        assertEquals(0, list.lastIndexOf("Pippo"));
        assertEquals(1, list.lastIndexOf("pluto"));
    }

    @Test
    public void testRemoveAll()
    {
        HList list=new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2=new ListAdapter();
        list2.add("Pippo");
        list2.add("pluto");
        list.removeAll(list2);
        assertEquals(2, list.size());
        assertArrayEquals(new Object[]{"Ciao","Mondo"}, list.toArray());
    }

    @Test
    public void testEquals()
    {
        HList list=new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2=new ListAdapter();
        list2.add("Pippo");
        list2.add("pluto");
        list2.add("Ciao");
        list2.add("Mondo");
        HList list3=new ListAdapter();
        list3.addAll(list2);
        assertEquals(true, list3.equals(list2));
        assertEquals(true, list.equals(list2));
    }

    @Test
    public void testHashCode()
    {
        HList list=new ListAdapter();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2=new ListAdapter();
        list2.add("Pippo");
        list2.add("pluto");
        list2.add("Ciao");
        list2.add("Mondo");
        assertEquals(list2.hashCode(), list.hashCode());
    }

    //#region test esempi
    //test esempi
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "ciao", "ciccio"};
    HList l1 = new ListAdapter();
    HList l2 = new ListAdapter();
    HListIterator li = null;

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

    @AfterClass
    public static void AfterClass()
    {
        System.out.println("Testing list done");
    }
}