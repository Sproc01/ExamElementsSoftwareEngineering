package MyAdapter;

import java.util.NoSuchElementException;

/**
 * @author Michele Sprocatti
 */
public class IteratorAdapter implements HListIterator,HIterator
{
    private HList list;
    private int index;
    private boolean canOperation;
    private boolean nextLast;

    public IteratorAdapter(HList l)
    {
        list=l;
        index=-1;
        canOperation=false;
        nextLast=false;
    }

    public IteratorAdapter(HList l, int i)
    {
        list=l;
        index=i-1;
        canOperation=false;
        nextLast=false;
    }

    public boolean hasNext()
    {
        return index<list.size()-1;
    }

    public Object next()
    {
        if(!hasNext())
            throw new NoSuchElementException();
        canOperation=true;
        index++;
        nextLast=true;
        return list.get(index);
    }

    public void remove()
    {
        if(!canOperation)
            throw new IllegalStateException();
        if(nextLast)
        {
            list.remove(index);
            index--;
        }else
            list.remove(index+1);
        canOperation=false;
        nextLast=false;
    }

    public void add(Object o)
    {
        if(o==null)
            throw new IllegalArgumentException();
        list.add(index+1, o);
        index++;
        canOperation=false;
    }

    public boolean hasPrevious()
    {
        return index>-1;
    }

    public int nextIndex()
    {
        if(index>=list.size())
            return list.size();
        return index+1;
    }

    public Object previous()
    {
        if(!hasPrevious())
            throw new NoSuchElementException();
        canOperation=true;
        nextLast=false;
        Object e=list.get(index);
        index--;
        return e;
    }

    public int previousIndex()
    {
        if(index<=0)
            return -1;
        return index;
    }

    public void set(Object o)
    {
        if(o==null)
            throw new IllegalArgumentException();
        if(!canOperation)
            throw new IllegalStateException();
        list.set(index, o);

    }
}