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
    private boolean canRemove;

    public IteratorAdapter(HList l)
    {
        list=l;
        index=-1;
        canOperation=false;
        canRemove=false;
    }

    public IteratorAdapter(HList l, int i)
    {
        list=l;
        index=i-1;
        canOperation=false;
        canRemove=false;
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
        canRemove=true;
        index++;
        return list.get(index);
    }

    public void remove()
    {
        if(!canRemove)
            throw new IllegalStateException();
        list.remove(index);
        canRemove=false;
        canOperation=false;
    }

    public void add(Object o)
    {
        if(o==null)
            throw new IllegalArgumentException();
        list.add(index+1, o);
        index++;
        canRemove=false;
        canOperation=false;
    }

    public boolean hasPrevious()
    {
        return index>0;
    }

    public int nextIndex()
    {
        if(index>=list.size())
            return list.size();
        index++;
        return index;
    }

    public Object previous()
    {
        if(!hasPrevious())
            throw new NoSuchElementException();
        canOperation=true;
        canRemove=true;
        Object e=list.get(index);
        index--;
        return e;
    }

    public int previousIndex()
    {
        if(index<=0)
            return -1;
        index--;
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