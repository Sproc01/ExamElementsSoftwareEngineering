package myAdapter;

/**
 * A class implementing interface HList and HCollection. It supports duplicate and null elements.
 * @author Michele Sprocatti
 */
public class ListAdapter implements HList, HCollection
{
    private Vector v;
    /**
     * Create a new empty list
     */
    public ListAdapter()
    {
        v = new Vector();
    }

    /**
     * Create a new list with the element of the given collection.
     * @exception NullPointerException if the collection is null
     * @param c the collection to be copied
     */
    public ListAdapter(HCollection c)
    {
        if(c==null)
            throw new NullPointerException();
        v = new Vector();
        addAll(c);
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any)
     * and any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted.
     * @param element element to be inserted.
     *
     * @throws IndexOutOfBoundsException     if the index is out of range (index
     *                                       < 0 || index > size()).
     * @see {@link HList#add(int, Object)} 
     */
    public void add(int index, Object element)
    {
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        v.insertElementAt(element, index);
    }

    /**
     * Appends the specified element to the end of this list.
     * <p>
     * @param obj element to be appended to this list.
     * @return true (as per the general contract of the Collection.add method).
     * @see {@link HList#add(Object)} 
     */
    public boolean add(Object o)
    {
        v.addElement(o);
        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this
     * list, in the order that they are returned by the specified collection's
     * iterator. The behavior of this operation is unspecified
     * if the specified collection is modified while the operation is in progress.
     * (Note that this will occur if the specified collection is this list, and it's
     * nonempty.)
     *
     * @param coll collection whose elements are to be added to this list.
     * @return true if this list changed as a result of the call.
     *
     * @throws NullPointerException     if the specified collection is null.
     * @see #add(Object)
     * @see {@link HList#addAll(HCollection)} 
     */
    public boolean addAll(HCollection c)
    {
        if(c==null)
            throw new NullPointerException();
        Object[] o=c.toArray();
        boolean res=false;
        for(int i=0; i<o.length; i++)
            if(!add(o[i]))
                return false;
            else 
                res=true;
        return res;
    }

   /**
     * Inserts all of the elements in the specified collection into this list at the
     * specified position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (increases their
     * indices). The new elements will appear in this list in the order that they
     * are returned by the specified collection's iterator. The behavior of this
     * operation is unspecified if the specified collection is modified while the
     * operation is in progress. (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param index index at which to insert first element from the specified
     *              collection.
     * @param coll     elements to be inserted into this list.
     * @return true if this list changed as a result of the call.
     *
     * @throws NullPointerException          if
     *                                       the specified collection is null.
     * @throws IndexOutOfBoundsException     if the index is out of range (index
     *                                       < 0 || index > size()).
     * @see {@link HList#addAll(int, HCollection)} 
     */
    public boolean addAll(int index, HCollection c)
    {
        if(c==null)
            throw new NullPointerException();
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        Object[] o=c.toArray();
        int i=0;
        for(i=0; i<o.length; i++)
        {
            add(index, o[i]);
            index++;
        }
        if(i>0)
            return true;
        else
            return false;
    }

    /**
     * Removes all of the elements from this list. This list
     * will be empty after this call returns (unless it throws an exception).
     * @see {@link HList#clear()} 
     */
    public void clear()
    {
        v.removeAllElements();
    }

    /**
     *
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e such
     * that (o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e)).
     *
     * @param obj element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     * @see {@link HList#contains(Object)} 
     */
    public boolean contains(Object o)
    {
        return v.contains(o);
    }

    /**
     *
     * Returns true if this list contains all of the elements of the specified
     * collection.
     *
     * @param coll collection to be checked for containment in this list.
     * @return true if this list contains all of the elements of the specified
     *         collection.
     * @throws NullPointerException if the specified collection is null.
     * @see #contains(Object)
     * @see {@link HList#containsAll(HCollection)} 
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
     * Compares the specified object with this list for equality. Returns true if
     * and only if the specified object is also a list, both lists have the same
     * size, and all corresponding pairs of elements in the two lists are
     * <i>equal</i>. (Two elements e1 and e2 are <i>equal</i> if (e1==null ?
     * e2==null : e1.equals(e2)).) In other words, two lists are defined to be equal
     * if they contain the same elements in the same order. This definition ensures
     * that the equals method works properly across different implementations of the
     * List interface.
     *
     * @param obj the object to be compared for equality with this list.
     * @return true if the specified object is equal to this list.
     * @see {@link HList#equals(Object)} 
     */
    public boolean equals(Object o)
    {
        if(o==null)
            return false;
        return hashCode()==o.hashCode();
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of element to return.
     * @return the element at the specified position in this list.
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *                                   || index >= size()).
     * @see {@link HList#get(int)} 
     */
    public Object get(int index)
    {
        if(index<0 || index>=size())
            throw new IndexOutOfBoundsException();
        return v.elementAt(index);
    }

    /**
     * Returns the hash code value for this list. The hash code of a list is defined
     * to be the result of the following calculation:
     *
     * <pre>
     * hashCode = 1;
     * Iterator i = list.iterator();
     * while (i.hasNext()) {
     *     Object obj = i.next();
     *     hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
     * }
     * </pre>
     *
     * This ensures that list1.equals(list2) implies that
     * list1.hashCode()==list2.hashCode() for any two lists, list1 and list2, as
     * required by the general contract of Object.hashCode.
     *
     * @return the hash code value for this list.
     * @see Object#hashCode()
     * @see Object#equals(Object)
     * @see #equals(Object)
     * @see {@link HList#hashCode()} 
     */
    public int hashCode()
    {
        int hashCode = 1;
        HIterator i = this.iterator();
        while (i.hasNext()) 
        {
           Object obj = i.next();
           hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    /**
     * Returns the index in this list of the first occurrence of the specified
     * element, or -1 if this list does not contain this element. More formally,
     * returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param obj element to search for.
     * @return the index in this list of the first occurrence of the specified
     *         element, or -1 if this list does not contain this element.
     * @see {@link HList#indexOf(Object)} 
     */
    public int indexOf(Object o)
    {
        return v.indexOf(o);
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements.
     * @see {@link HList#isEmpty()} 
     */
    public boolean isEmpty()
    {
        return size()==0;
    }
    
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence.
     * @see {@link HList#iterator()} 
     */
    public HIterator iterator()
    {
        return new IteratorAdapter(this);
    }

    /**
     * Returns the index in this list of the last occurrence of the specified
     * element, or -1 if this list does not contain this element. More formally,
     * returns the highest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param obj element to search for.
     * @return the index in this list of the last occurrence of the specified
     *         element, or -1 if this list does not contain this element.
     * @see {@link HList#lastIndexOf(Object)} 
     */
    public int lastIndexOf(Object o)
    {
        return v.lastIndexOf(o);
    }

    /**
     * Returns a list iterator of the elements in this list (in proper sequence).
     *
     * @return a list iterator of the elements in this list (in proper sequence).
     * @see {@link HList#listIterator()} 
     */
    public HListIterator listIterator()
    {
        return new IteratorAdapter(this);
    }

    /**
     * Returns a list iterator of the elements in this list (in proper sequence),
     * starting at the specified position in this list. The specified index
     * indicates the first element that would be returned by an initial call to the
     * next method. An initial call to the previous method would return the element
     * with the specified index minus one.
     *
     * @param index index of first element to be returned from the list iterator (by
     *              a call to the next method).
     * @return a list iterator of the elements in this list (in proper sequence),
     *         starting at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *                                   || index > size()).
     * @see {@link HList#listIterator(int)} 
     */
    public HListIterator listIterator(int index)
    {
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        return new IteratorAdapter(this, index);
    }
    
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from
     * their indices). Returns the element that was removed from the list.
     *
     * @param index the index of the element to removed.
     * @return the element previously at the specified position.
     *
     * @throws IndexOutOfBoundsException     if the index is out of range (index
     *                                       < 0 || index >= size()).
     * @see {@link HList#remove(int)} 
     */
    public Object remove(int index)
    {
        if(index<0 || index>=size())
            throw new IndexOutOfBoundsException();
        Object e=get(index);
        v.removeElementAt(index);
        return e;
    }

    /**
     * Removes the element at the specified position in this list. 
     * Shifts any subsequent elements to the left (subtracts one from
     * their indices). Returns the element that was removed from the list.
     *
     * @param index the index of the element to removed.
     * @return the element previously at the specified position.
     *
     * @throws IndexOutOfBoundsException     if the index is out of range (index
     *                                       < 0 || index >= size()).
     * @see {@link HList#remove(Object)} 
     */
    public boolean remove(Object o)
    {
        return v.removeElement(o);
    }

    /**
     * Removes from this list all the elements that are contained in the specified
     * collection.
     *
     * @param coll collection that defines which elements will be removed from this
     *          list.
     * @return true if this list changed as a result of the call.
     *
     * @throws NullPointerException          if the specified collection is null.
     * @see #remove(Object)
     * @see #contains(Object)
     * @see {@link HList#removeAll(Collection)} 
     */
    public boolean removeAll(HCollection c)
    {
        int j=0;
        if(c==null)
            throw new NullPointerException();
        Object[] o=c.toArray();
        for(int i=0; i<o.length; i++)
            while(remove(o[i]))
                j++;
        if(j>0)
            return true;
        else
            return false;
    }
    
    /**
     * Retains only the elements in this list that are contained in the specified
     * collection. In other words, removes from this list all
     * the elements that are not contained in the specified collection.
     *
     * @param coll collection that defines which elements this set will retain.
     *
     * @return true if this list changed as a result of the call.
     *
     * @throws NullPointerException          if the specified collection is null.
     * @see #remove(Object)
     * @see #contains(Object)
     * @see {@link HList#retainAll(Collection)} 
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
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of element to replace.
     * @param element element to be stored at the specified position.
     * @return the element previously at the specified position.
     *
     * @throws IndexOutOfBoundsException     if the index is out of range (index
     *                                       < 0 || index >= size()).
     * @see {@link HList#set(int, Object)} 
     */
    public Object set(int index,Object element)
    {
        if(index<0 || index>=size())
            throw new IndexOutOfBoundsException();
        Object e=get(index);
        v.setElementAt(element, index);
        return e;
    }

    /**
     * Returns the number of elements in this list. If this list contains more than
     * Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this list.
     * @see {@link HList#size()}
     */
    public int size()
    {
        if(v.size()<0)
            return Integer.MAX_VALUE;
        return v.size();
           
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex,
     * inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the
     * returned list is empty.) The returned list is backed by this list, so
     * non-structural changes in the returned list are reflected in this list, and
     * vice-versa. The returned list supports all of the optional list operations
     * supported by this list.
     * <p>
     *
     * This method eliminates the need for explicit range operations (of the sort
     * that commonly exist for arrays). Any operation that expects a list can be
     * used as a range operation by passing a subList view instead of a whole list.
     * For example, the following idiom removes a range of elements from a list:
     *
     * <pre>
     * list.subList(from, to).clear();
     * </pre>
     *
     * Similar idioms may be constructed for indexOf and lastIndexOf, and all of the
     * algorithms in the Collections class can be applied to a subList.
     * <p>
     *
     * The semantics of the list returned by this method become undefined if the
     * backing list (i.e., this list) is <i>structurally modified</i> in any way
     * other than via the returned list. (Structural modifications are those that
     * change the size of this list, or otherwise perturb it in such a fashion that
     * iterations in progress may yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList.
     * @param toIndex   high endpoint (exclusive) of the subList.
     * @return a view of the specified range within this list.
     *
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *                                   (fromIndex < 0 || toIndex > size ||
     *                                   fromIndex > toIndex).
     * @see {@link HList#subList(int, int)} 
     */
    public HList subList(int fromIndex, int toIndex)
    {
        if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        SubList subList=new SubList(this, fromIndex);
        for(int i=fromIndex; i<toIndex; i++)
            ((SubList)subList).hiddenAdd(get(i));
        return subList;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the Collection.toArray method.
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence.
     * @see {@link HList#toArray()} 
     */
    public Object[] toArray()
    {
        Object[] array = new Object[size()];
        for(int i=0; i<size(); i++)
            array[i] = v.elementAt(i);
        return array;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the Collection.toArray(Object[]) method.
     *
     * @param arrayTarget the array into which the elements of this list are to be
     *                    stored, if it is big enough; otherwise, a new array of the
     *                    same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list.
     *
     * @throws NullPointerException if the specified array is null.
     * @see {@link HList#toArray(Object[])} 
     */
    public Object[] toArray(Object[] a)
    {
        if(a==null)
            throw new NullPointerException();
        if(a.length<size())
            a = new Object[size()];
        int i=0;
        for(i=0; i<size(); i++)
            a[i]=v.elementAt(i);
        if(i<a.length)
            a[i]=null;
        return a;
    }

    /**
     * Internal class that it si used to generate the subList with his proprieties.
     */
    private class SubList extends ListAdapter
    {
        private HList father;
        private int fromIndex;

        /**
         * create a new subList.
         * @param l the list that represents the father of this subList.
         * @param fI the starting index for the subList in the father list.
         */
        public SubList(HList l, int fI)
        {
            father=l;
            fromIndex=fI;
        }

        /**
         * method used to add the elements to the subList from the father list.
         * @param o
         */
        private void hiddenAdd(Object o)
        {super.add(o);}
        /**
         * Inserts the specified element at the specified position in this list.
         * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
         * Also it adds the element in the right position in the father list.
         * @param index index at which the specified element is to be inserted.
         * @param element element to be inserted.
         * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
         */
        public void add(int index, Object element)
        {
            super.add(index, element);
            father.add(index+fromIndex, element);
        }

        /**
         * Ensures that this list contains the specified element.
         * Returns true if this list changed as a result of the call.
         * Also it adds the element in the right position in the father list.
         * @param element element whose presence in this list is to be ensured.
         * @return true if this list changed as a result of the call.
         */
        public boolean add(Object o)
        {
            super.add(o);
            int i=lastIndexOf(o);
            father.add(i+fromIndex,o);
            return true;
        }

        /**
         * Removes all of the elements from this list. 
         * This list will be empty after this method returns unless it throws an exception.
         * Remove the range of elements in this subList form the father list.
         */
        public void clear()
        {
            int sz=size();
            for(int i=0; i<sz; i++)
                father.remove(get(i)); 
            super.clear();
        }
        
        /**
         * Removes the element at the specified position in this list. 
         * Shifts any subsequent elements to the left (subtracts one from their indices). 
         * Returns the element that was removed from the list.
         * Remove the same element from the father list.
         * @param index the index of the element to be removed.
         * @return the element previously at the specified position.
         * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
         */
        public Object remove(int index)
        {
            Object e=super.remove(index);
            father.remove(index+fromIndex);
            return e;
        }

        /**
         * Removes the first occurrence of the specified element from this list, if it is present.
         * Remove the same element from the father list.
         * If this list does not contain the element, it is unchanged.
         * @param o element to be removed from this list, if present.
         * @return true if this list changed as a result of the call.
         */
        public boolean remove(Object o)
        {
            int i=indexOf(o);
            if(i!=-1)
                father.remove(i+fromIndex);
            return super.remove(o);
        }

        /**
         * Replaces the element at the specified position in this list with the specified element. Then this change is reported in the father list.
         * @param index index of the element to replace.
         * @param element element to be stored at the specified position.
         * @return the element previously at the specified position.
         * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
         */
        public Object set(int index,Object element)
        {
            Object e=super.set(index, element);
            father.set(index+fromIndex, element);
            return e;
        }       
    }
}