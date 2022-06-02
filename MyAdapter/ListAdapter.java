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
    int fromIndex,toIndex;
    boolean father;

    /**
     * Create a new list
     */
    public ListAdapter()
    {
        v = new Vector<Object>();
        father=false;
        fromIndex=0;
        toIndex=0;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     * @exception NullPointerException if the element is null
     */
    public void add(int index, Object element)
    {
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        if(element==null)
            throw new NullPointerException();
        /*if(contains(element))
            throw new IllegalArgumentException();*/
        v.insertElementAt(element, index);
    }

    /**
     * Ensures that this list contains the specified element.
     * Returns true if this list changed as a result of the call.
     * This class does not support null elements
     * @param element element whose presence in this list is to be ensured
     * @return true if this list changed as a result of the call
     * @exception NullPointerException if the element is null
     */
    public boolean add(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        /*if(contains(o))
            return false;*/
        v.add(o);
        return true;
    }

    /**
     * Inserts all of the elements in the specified collection into this list at the specified position
     * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress
     * This list does not support null elements
     * @param c collection containing elements to be inserted into this list
     * @exception NullPointerException if the specified collection is null or if one of the elements is null
     */
    public boolean addAll(HCollection c)
    {
        if(c==null)
            throw new NullPointerException();
        Object[] o=c.toArray();
        for(int i=0; i<o.length; i++)
            if(!add(o[i]))
                return false;
        return true;
    }

    /**
     * Inserts all of the elements in the specified collection into this list from the specified position
     * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress
     * This list does not support null elements
     * @param index index at which to insert the first element from the specified collection
     * @param c collection containing elements to be inserted into this list
     * @return true if this list changed as a result of the call
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     * @exception NullPointerException if the specified collection is null or if one of the elements is null
     */
    public boolean addAll(int index, HCollection c)
    {
        if(c==null)
            throw new NullPointerException();
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        Object[] o=c.toArray();
        for(int i=0; i<o.length; i++)
        {
            add(index, o[i]);
            index++;
        }
        return true;
    }

    /**
     * Removes all of the elements from this list. 
     * This list will be empty after this method returns unless it throws an exception.
     */
    public void clear()
    {
        v.removeAllElements();
    }

    /**
     * Returns true if this list contains the specified element.
     * This list does not support null elements
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * @exception NullPointerException if the element is null
     */
    public boolean contains(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.contains(o);
    }

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     * @param c collection containing elements to be checked for containment in this list
     * @return true if this list contains all of the elements of the specified collection
     * @exception NullPointerException if the specified collection is null or one of his element is null
     */
    public boolean containsAll(HCollection c)
    {
        if(c==null)
            throw new NullPointerException();
        Object[] o=c.toArray();
        for(int i=0;i<o.length;i++)
            if(!contains(o[i]))
                return false;
        return true;
    }

    /**
     * Override of the Object.equals method
     * @param o object to be compared
     * @return true if the specified object is equal to this list
     * @exception NullPointerException if the specified object is null
     */
    public boolean equals(Object o)
    {
        if(o==null)
            return false;
        return hashCode()==o.hashCode();
    }

    /**
     * Returns the element at the specified position in this list
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public Object get(int index)
    {
        if(index<0 || index>=v.size())
            throw new IndexOutOfBoundsException();
        return v.elementAt(index);
    }

    /**
     * Override of the Object.hashCode method
     * @return the hash code value for this list
     */
    public int hashCode()
    {
        int hash=0;
        for(Enumeration<Object> e=v.elements(); e.hasMoreElements();)
            hash+=e.nextElement().hashCode();
        return hash;
    }

    /**
     * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
     * @param o element to be searched for
     * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element
     * @exception NullPointerException if the element is null
     */
    public int indexOf(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.indexOf(o);
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    public boolean isEmpty()
    {
        return v.isEmpty();
    }
    
    /**
     * Returns an HIterator over the elements in this list in proper sequence.
     * @return an HIterator over the elements in this list in proper sequence
     */
    public HIterator iterator()
    {
        return new IteratorAdapter(this);
    }

    /**
     * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
     * @param o element to be searched for
     * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element
     * @exception NullPointerException if the element is null
     */
    public int lastIndexOf(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.lastIndexOf(o);
    }

    /**
     * Returns a HListIterator over the elements in this list in proper sequence.
     * @return a HListIterator over the elements in this list in proper sequence
     */
    public HListIterator listIterator()
    {
        return new IteratorAdapter(this);
    }

    /**
     * Returns a HListIterator over the elements in this list in proper sequence, starting at the specified position in this list.
     * @param index index of the first element to be returned from the new HListIterator (by a call to next)
     * @return a HListIterator over the elements in this list in proper sequence, starting at the specified position in this list
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    public HListIterator listIterator(int index)
    {
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        return new IteratorAdapter(this, index);
    }
    
    /**
     * Removes the element at the specified position in this list (optional operation). 
     * Shifts any subsequent elements to the left (subtracts one from their indices). 
     * Returns the element that was removed from the list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public Object remove(int index)
    {
        if(index<0 || index>=v.size())
            throw new IndexOutOfBoundsException();
        Object e=get(index);
        v.removeElementAt(index);
        return e;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     * @param o element to be removed from this list, if present
     * @return true if this list changed as a result of the call
     * @exception NullPointerException if the element is null
     */
    public boolean remove(Object o)
    {
        if(o==null)
            throw new NullPointerException();
        return v.removeElement(o);
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     * If an element to be removed is present more than once, it is removed once.
     * If an element to be removed is not present in this list, it will remove the others
     * @param c collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     * @exception NullPointerException if the specified collection is null or one of his element is null
     */
    public boolean removeAll(HCollection c)
    {
        boolean res=false;
        if(c==null)
            throw new NullPointerException();
        Object[] o=c.toArray();
        for(int i=0; i<o.length; i++)
            if(o[i]==null)
                throw new NullPointerException();
            else
            {
                res=true;
                remove(o[i]);
            }
        return res;
    }
    
    /**
     * Removes from this list all of its elements that are not contained in the specified collection.
     * If an element is contained in the specified collection but not in the list this method won't add it
     * @param c collection containing elements to be retained in this list, if present
     * @return true if this list changed as a result of the call
     * @exception NullPointerException if the specified collection is null or one of his element is null
     */
    public boolean retainAll(HCollection c)
    {
        boolean res=false;
        if(c==null)
            throw new NullPointerException();
        Object[] o=toArray();
        for(int i=0; i<o.length; i++)
            if(!c.contains(o[i]))
            { 
               remove(o[i]);
               res=true;
            }
        return res;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     * @exception NullPointerException if the element is null
     */
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

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size()
    {
        return v.size();
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
     * (If fromIndex and toIndex are equal, the returned list is empty.) 
     * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. 
     * The returned list supports all of the optional list operations supported by this list.
     * This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays). 
     * Any operation that expects a list can be used as a range operation by passing a subList view instead of a whole list. 
     * For example, the following idiom removes a range of elements from a list:
     * list.subList(from, to).clear(); Similar idioms may be constructed for indexOf and lastIndexOf, and all of the algorithms in the Collections class can be applied to a subList. 
     * Structural changes to the list (adding and removing elements) that are not performed through the returned list will affect the subList object.
     * @param fromIndex index of the first element to be copied
     * @param toIndex index after the last element to be copied
     * @return a HList containing the elements in the specified range from this list
     * @exception IndexOutOfBoundsException if fromIndex is out of range (fromIndex < 0 || fromIndex >= size())
     */
    public HList subList(int fromIndex, int toIndex)
    {
        if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        this.fromIndex=fromIndex;
        this.toIndex=toIndex;
        father=true;
        return this;
    }

    /**
     * Returns an array containing all of the elements in this list.
     * The returned array will be "safe" in that no references to it are maintained by this list
     * @return an array containing all of the elements in this list
     */
    public Object[] toArray()
    {
        Object[] array = new Object[v.size()];
        for(int i=0; i<v.size(); i++)
            array[i] = v.elementAt(i);
        return array;
    }

    /**
     * Returns an array containing all of the elements in this list; 
     * the runtime type of the returned array is that of the specified array. 
     * If the list fits in the specified array, it is returned therein. 
     * Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
     * @return an array containing all of the elements in this list
     * @throws NullPointerException if the array is null
     */
    public Object[] toArray(Object[] a)
    {
        if(a==null)
            throw new NullPointerException();
        if(a.length<v.size())
            a = new Object[v.size()];
        for(int i=0; i<v.size(); i++)
            a[i]=v.elementAt(i);
        return a;
    }
}