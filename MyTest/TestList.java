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
        HList list = new HListClass();
        assertNotNull(list);
    }

    @Test
    public void testAdd()
    {
        HList list = new HListClass();
        list.add(0,3);
        assertEquals(3, list.get(0));
    }

    @Test
    public void testAdd2()
    {
        HList list = new HListClass();
        list.add(3);
        assertEquals(3, list.get(0));
    }

    @Test
    public void TestAdd3()
    {
        HList list = new HListClass();
        list.add(0,3);
        list.add(1,4);
        assertArrayEquals(new Object[]{3,4}, list.toArray());
    }

    @Test
    public void TestAdd4()
    {
        HList list = new HListClass();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        assertArrayEquals(new Object[]{3,4,5,6}, list.toArray());
    }

    @Test
    public void testClear()
    {
        HList list = new HListClass();
        list.add(3);
        list.add(4);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testContains()
    {
        HList list = new HListClass();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        assertEquals(true, list.contains(3));
    }

    @Test
    public void TestRemove1()
    {
        HList list = new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        list.remove("Mondo");
        assertEquals(false, list.contains("Mondo"));
    }

    @Test
    public void TestRemove2()
    {
        HList list = new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        list.remove(1);
        assertEquals(false, list.contains("pluto"));
    }

    @Test
    public void TestSubList()
    {
        HList list = new HListClass();
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
        HList list = new HListClass();
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

    @Test
    public void TestListIterator()
    {
        HList list = new HListClass();
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
        HList list = new HListClass();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testContainsAll()
    {
        HList list = new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2 = new HListClass();
        list2.add("Pippo");
        list2.add("pluto");
        list2.add("Ciao");
        list2.add("Mondo");
        assertEquals(true, list.containsAll(list2));
    }

    @Test
    public void testAddAll()
    {
        HList list = new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2 = new HListClass();
        list2.add("Luca");
        list2.add("Giovanni");
        list2.add("Marco");
        list2.add("Matteo");
        list.addAll(list2);
        assertEquals(8, list.size());
        assertArrayEquals(new Object[]{"Pippo","pluto","Ciao","Mondo","Luca","Giovanni","Marco","Matteo"}, list.toArray());
    }

    @Test
    public void testAddAll2()
    {
        HList list = new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2 = new HListClass();
        list2.add("Luca");
        list2.add("Giovanni");
        list2.add("Marco");
        list2.add("Matteo");
        list.addAll(1,list2);
        assertEquals(8, list.size());
        assertArrayEquals(new Object[]{"Pippo","Luca","Giovanni","Marco","Matteo","pluto","Ciao","Mondo"}, list.toArray());
    }

    @Test
    public void testRetainAll()
    {
        HList list = new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2 = new HListClass();
        list2.add("Pippo");
        list2.add("pluto");
        assertEquals(true, list.retainAll(list2));
        assertArrayEquals(new Object[]{"Pippo","pluto"}, list.toArray());
    }

    @Test
    public void testIndexOf()
    {
        HList list = new HListClass();
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
        HList list = new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        list.add("Pippo");
        assertEquals(4, list.lastIndexOf("Pippo"));
        assertEquals(1, list.lastIndexOf("pluto"));
    }

    @Test
    public void testRemoveAll()
    {
        HList list=new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2=new HListClass();
        list2.add("Pippo");
        list2.add("pluto");
        list.removeAll(list2);
        assertEquals(2, list.size());
        assertArrayEquals(new Object[]{"Ciao","Mondo"}, list.toArray());
    }

    @Test
    public void testEquals()
    {
        HList list=new HListClass();
        list.add("Pippo");
        list.add("pluto");
        list.add("Ciao");
        list.add("Mondo");
        HList list2=new HListClass();
        list2.add("Pippo");
        list2.add("pluto");
        list2.add("Ciao");
        list2.add("Mondo");
        HList list3=new HListClass();
        list3.addAll(list2);
        assertEquals(true, list3.equals(list2));
        assertEquals(true, list.equals(list2));
    }

    @AfterClass
    public static void AfterClass()
    {
        System.out.println("Testing list done");
    }
}