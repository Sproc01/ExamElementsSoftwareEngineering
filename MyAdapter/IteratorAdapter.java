package myAdapter;

import java.util.NoSuchElementException;

/**
 * Iterator adapter implements HIterator and HListIterator interface.
 * @author Michele Sprocatti
 */
public class IteratorAdapter implements HListIterator,HIterator
{
    private HList list;
    private int index;
    private boolean canOperation;
    private boolean nextLast;

    /**
     * Build the iterator, it starts from 0.
     * @param l list to iterate.
     */
    public IteratorAdapter(HList l)
    {
        list=l;
        index=0;
        canOperation=false;
        nextLast=false;
    }

    /**
     * Build the iterator but it starts from the index.
     * @param l list to iterate.
     * @param i index to start.
     */
    public IteratorAdapter(HList l, int i)
    {
        list=l;
        index=i;
        canOperation=false;
        nextLast=false;
    }

    /**
     * Return boolean that indicates if there is a next element.
     * @return true if the iterator has more elements.
     */
    public boolean hasNext()
    {
        return index<list.size();
    }

    /**
     * Return the next element if there is one, otherwise throw NoSuchElementException.
     * @return the next element.
     * @exception NoSuchElementException if there is no next element.
     */
    public Object next()
    {
        if(!hasNext())
            throw new NoSuchElementException();
        canOperation=true;
        Object e=list.get(index);
        index++;
        nextLast=true;
        return e;
    }

    /**
     * Remove the last element returned by next() or previous() only if next() or previous is the last operation.
     * @exception IllegalStateException if next() or previous() is not the last operation.
     */
    public void remove()
    {
        if(!canOperation)
            throw new IllegalStateException();
        if(nextLast)
        {
            list.remove(index-1);
            index--;
        }else
        {
            list.remove(index);
        }    

        canOperation=false;
        nextLast=false;
    }

    /**
     * The element is inserted immediately before the next element that would be returned by next, 
     * if any, and after the next element that would be returned by previous
     * if any. (If the list contains no elements, the new element becomes the sole element on the list.) 
     * The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, 
     * and a subsequent call to previous would return the new element.
     */
    public void add(Object o)
    {
        list.add(index, o);
        index++;
        canOperation=false;
        nextLast=false;
    }

    /**
     * Return true if there is a previous element.
     * @return true if there is a previous element.
     */
    public boolean hasPrevious()
    {
        return index>0;
    }

    /**
     * Return the next index, formally the index of the next element to be returned by next().
     * If there is no next element, return the size of the list.
     * @return the next index.
     */
    public int nextIndex()
    {
        if(index>=list.size())
            return list.size();
        return index;
    }

    /** Return the previous element if there is one, otherwise throw NoSuchElementException.
     * @return the previous element.
     * @exception NoSuchElementException if there is no previous element.
     */
    public Object previous()
    {
        if(!hasPrevious())
            throw new NoSuchElementException();
        canOperation=true;
        nextLast=false;
        index--;
        return list.get(index);
    }

    /**
     * Return the previous index, formally the index of the previous element to be returned by previous().
     * If there is no previous element, return -1.
     * @return the previous index.
     */
    public int previousIndex()
    {
        if(index<=0)
            return -1;
        return index-1;
    }
    /**
     * Set the element return by next() or previous().
     * @param o the element to set.
     * @exception IllegalStateException if neither next nor previous have been called, 
     * or remove or add have been called after the last call to next or previous.
     */
    public void set(Object o)
    {
        if(!canOperation)
            throw new IllegalStateException();
        if(nextLast)
            list.set(index-1, o);
        else
            list.set(index, o);
    }
}