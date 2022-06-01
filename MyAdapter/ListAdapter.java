package MyAdapter;

/**
 * @author Michele Sprocatti
 */
public class ListAdapter implements HList, HCollection
{
    public void add(int index, Object element)
    {

    }

    public boolean add(Object o)
    {
        return false;
    }

    public boolean addAll(HCollection c)
    {
        return false;
    }

    public boolean addAll(int index, HCollection c)
    {
        return false;
    }

    public void clear()
    {

    }

    public boolean contains(Object o)
    {
        return false;
    }

    public boolean containsAll(HCollection c)
    {
        return false;
    }

    public boolean equals(Object o)
    {
        return false;
    }

    public Object get(int index)
    {
        return null;
    }

    public int hashCode()
    {
        return 0;
    }

    public int indexOf(Object o)
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return false;
    }
    
    public HIterator iterator()
    {
        return null;
    }

    public int lastIndexOf(Object o)
    {
        return 0;
    }

    public HListIterator listIterator()
    {
        return null;
    }

    public HListIterator listIterator(int index)
    {
        return null;
    }
    
    public Object remove(int index)
    {
        return null;
    }

    public boolean remove(Object o)
    {
        return false;
    }

    public boolean removeAll(HCollection c)
    {
        return false;
    }
    
    public boolean retainAll(HCollection c)
    {
        return false;
    }

    public Object set(int index,Object element)
    {
        return null;
    }

    public int size()
    {
        return 0;
    }

    public HList subList(int fromIndex, int toIndex)
    {
        return null;
    }

    public Object[] toArray()
    {
        return null;
    }

    public Object[] toArray(Object[] a)
    {
        return null;
    }
}