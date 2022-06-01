package MyAdapter;
/**
 * An iterator for lists that allows the programmer to traverse the list in either direction, modify the list during iteration, and obtain the iterator's current position in the list. 
 * A ListIterator has no current element; its cursor position always lies between the element that would be returned by a call to previous() and the element that would be returned by a call to next(). 
 * In a list of length n, there are n+1 valid index values, from 0 to n, inclusive.
 * @author Michele Sprocatti
 */
public interface HListIterator extends HIterator
{
    /**
     * Inserts the specified element into the list (optional operation). 
     * The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any. 
     * (If the list contains no elements, the new element becomes the sole element on the list.)
     *  The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. 
     * (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.)
     * @param o the element to insert.
     * @exception UnsupportedOperationException - if the add method is not supported by this list iterator.
     * @exception ClassCastException - if the class of the specified element prevents it from being added to this list.
     * @exception IllegalArgumentException - if some aspect of this element prevents it from being added to this list.
     */
    public void add(Object o);

    /**
     * Returns true if this list iterator has more elements when traversing the list in the reverse direction. (In other words, returns true if previous would return an element rather than throwing an exception.)
     * @return true if the list iterator has more elements when traversing the list in the reverse direction
     */
    public boolean hasPrevious();

    /**
     * Returns the index of the element that would be returned by a subsequent call to next. (Returns list size if the list iterator is at the end of the list.)
     * @return the index of the element that would be returned by a subsequent call to next, or list size if list iterator is at end of list.
     */
    public int nextIndex();

    /**
     * Returns the previous element in the list. 
     * This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next to go back and forth. (Note that alternating calls to next and previous will return the same element repeatedly.)
     * @return the previous element in the list
     * @exception NoSuchElementException if the iteration has no previous element
     */
    public Object previous();
    
    /**
     * Returns the index of the element that would be returned by a subsequent call to previous. (Returns -1 if the list iterator is at the beginning of the list.)
     * @return the index of the element that would be returned by a subsequent call to previous, or -1 if list iterator is at beginning of list.
     */
    public int previousIndex();

    /**
     * Replaces the last element returned by next or previous with the specified element (optional operation). 
     * This call can be made only if neither ListIterator.remove nor ListIterator.add have been called after the last call to next or previous.
     * @param o the element with which to replace the last element returned by next or previous
     * @exception UnsupportedOperationException - if the set operation is not supported by this list iterator
     * @exception ClassCastException - if the class of the specified element prevents it from being added to this list.
     * @exception IllegalArgumentException - if some aspect of the specified element prevents it from being added to this lis
     * @exception IllegalStateException - if neither next nor previous have been called, or remove or add have been called after the last call to next or previous
     */
    public void set(Object o);

    /**
     * Returns true if the iteration has more elements. (In other words, returns true if next would return an element rather than throwing an exception.)
     * @return true if iterator has more elements
     */
    public boolean hasNext();

    /**
     * Return the next element in the iteration
     * @return the next element in the iteration
     * @exception NoSuchElementException if the iteration has no more elements
     */
    public Object next();

    /**
     * Removes from the underlying collection the last element returned by the iterator (optional operation).
     * This method can be called only once per call to next or previous.
     * The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
     * @exception UnsupportedOperationException - if the remove operation is not supported by this Iterator.
     * @exception IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
     */
    public void remove();
}