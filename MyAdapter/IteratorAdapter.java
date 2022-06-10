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
     * Returns true if this list iterator has more elements when traversing
     * the list in the forward direction. (In other words, returns true if
     * next would return an element rather than throwing an exception.)
     *
     * @return true if the list iterator has more elements when traversing
     *         the list in the forward direction.
     * @see {@link Hiterator#hasNext()}, {@link HListIterator#hasNext()}
     */
    public boolean hasNext()
    {
        return index<list.size();
    }

    /**
     * Returns the next element in the list. This method may be called repeatedly to
     * iterate through the list, or intermixed with calls to previous to go
     * back and forth. (Note that alternating calls to next and
     * previous will return the same element repeatedly.)
     *
     * @return the next element in the list.
     * @exception NoSuchElementException if the iteration has no next element.
     * @see {@link Hiterator#next()}, {@link HListIterator#next()}
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
     * Removes from the list the last element that was returned by next or
     * previous. This call can only be made once per
     * call to next or previous. It can be made only if
     * ListIterator.add has not been called after the last call to
     * next or previous.
     *
     * @exception IllegalStateException         neither next nor
     *                                          previous have been called,
     *                                          or remove or add
     *                                          have been called after the last call
     *                                          to * next or
     *                                          previous.
     * @see {@link HIterator#remove()}, {@link HListIterator#remove()}
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
     * Inserts the specified element into the list. The element
     * is inserted immediately before the next element that would be returned by
     * next, if any, and after the next element that would be returned by
     * previous, if any. (If the list contains no elements, the new element
     * becomes the sole element on the list.) The new element is inserted before the
     * implicit cursor: a subsequent call to next would be unaffected, and
     * a subsequent call to previous would return the new element. (This
     * call increases by one the value that would be returned by a call to
     * nextIndex or previousIndex.)
     *
     * @param obj the element to insert.
     * @see {@link HListIterator#add()}
     */
    public void add(Object o)
    {
        list.add(index, o);
        index++;
        canOperation=false;
        nextLast=false;
    }

    /**
     * Returns true if this list iterator has more elements when traversing
     * the list in the reverse direction. (In other words, returns true if
     * previous would return an element rather than throwing an exception.)
     *
     * @return true if the list iterator has more elements when traversing
     *         the list in the reverse direction.
     * @see {@link HListIterator#hasPrevious()}
     */
    public boolean hasPrevious()
    {
        return index>0;
    }

   /**
     * Returns the index of the element that would be returned by a subsequent call
     * to next. (Returns list size if the list iterator is at the end of
     * the list.)
     *
     * @return the index of the element that would be returned by a subsequent call
     *         to next, or list size if list iterator is at end of list.
     * @see {@link HListIterator#nextIndex()}
     */
    public int nextIndex()
    {
        if(index>=list.size())
            return list.size();
        return index;
    }

    /**
     * Returns the previous element in the list. This method may be called
     * repeatedly to iterate through the list backwards, or intermixed with calls to
     * next to go back and forth. (Note that alternating calls to
     * next and previous will return the same element repeatedly.)
     *
     * @return the previous element in the list.
     *
     * @exception NoSuchElementException if the iteration has no previous element.
     * @see {@link HListIterator#previous()}
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
     * Returns the index of the element that would be returned by a subsequent call
     * to previous. (Returns -1 if the list iterator is at the beginning of
     * the list.)
     *
     * @return the index of the element that would be returned by a subsequent call
     *         to previous, or -1 if list iterator is at beginning of list.
     * @see {@link HListIterator#hasPrevious()}
     */
    public int previousIndex()
    {
        if(index<=0)
            return -1;
        return index-1;
    }
    
    /**
     * Replaces the last element returned by next or previous with
     * the specified element. This call can be made only if
     * neither ListIterator.remove nor ListIterator.add have been
     * called after the last call to next or previous.
     *
     * @param obj the element with which to replace the last element returned by
     *          next or previous.
     *
     * @exception IllegalStateException         if neither next nor
     *                                          previous have been called,
     *                                          or remove or add
     *                                          have been called after the last call
     *                                          to next or
     *                                          previous.
     * @see {@link HListIterator#set()}
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