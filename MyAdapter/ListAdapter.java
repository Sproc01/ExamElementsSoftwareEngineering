package MyAdapter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * A class implementing interface HList and HCollection but does not support null elements
 * @author Michele Sprocatti
 */
public class ListAdapter implements HList, HCollection
{
    Vector<Object> v;

    public ListAdapter()
    {
        v = new Vector<Object>();
    }

    public void add(int index, Object element)
    {
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        if(element==null)
            throw new NullPointerException();
        v.insertElementAt(element, index);
    }

    public boolean add(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        v.add(o);
        return true;
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
        v.removeAllElements();
    }

    public boolean contains(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.contains(o);
    }

    public boolean containsAll(HCollection c)
    {
        return false;
    }

    public boolean equals(Object o)
    {
        if(o==null)
            return false;
        return hashCode()==o.hashCode();
    }

    public Object get(int index)
    {
        if(index<0 || index>=v.size())
            throw new IndexOutOfBoundsException();
        return v.elementAt(index);
    }

    public int hashCode()
    {
        int hash=0;
        for(Enumeration<Object> e=v.elements(); e.hasMoreElements();)
            hash+=e.nextElement().hashCode();
        return hash;
    }

    public int indexOf(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.indexOf(o);
    }

    public boolean isEmpty()
    {
        return v.isEmpty();
    }
    
    public HIterator iterator()
    {
        return null;
    }

    public int lastIndexOf(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.lastIndexOf(o);
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
        if(index<0 || index>=v.size())
            throw new IndexOutOfBoundsException();
        Object e=get(index);
        v.removeElementAt(index);
        return e;
    }

    public boolean remove(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.removeElement(o);
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
        if(index<0 || index>=v.size())
            throw new IndexOutOfBoundsException();
        if(element==null)
            throw new NullPointerException();
        Object e=get(index);
        v.setElementAt(element, index);
        return e;
    }

    public int size()
    {
        return v.size();
    }

    public HList subList(int fromIndex, int toIndex)
    {
        return null;
    }

    public Object[] toArray()
    {
        Object[] array = new Object[v.size()];
        for(int i=0; i<v.size(); i++)
            array[i] = v.elementAt(i);
        return array;
    }

    public Object[] toArray(Object[] a)
    {
        if(a.length<v.size())
            a = new Object[v.size()];
        for(int i=0; i<v.size(); i++)
            a[i]=v.elementAt(i);
        return a;
    }
}