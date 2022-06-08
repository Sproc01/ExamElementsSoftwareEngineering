package myAdapter;

import java.util.Enumeration;

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
     */
    public ListAdapter(HCollection c)
    {
        v = new Vector();
        addAll(c);
    }
    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted.
     * @param element element to be inserted.
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size()).
     * @see {@link HList#add(int, Object)} 
     */
    public void add(int index, Object element)
    {
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        v.insertElementAt(element, index);
    }

    /**
     * Ensures that this list contains the specified element.
     * Returns true if this list changed as a result of the call.
     * @param element element whose presence in this list is to be ensured.
     * @return true if this list changed as a result of the call
     * @see {@link HList#add(Object)} 
     */
    public boolean add(Object o)
    {
        v.addElement(o);
        return true;
    }

    /**
     * Inserts all of the elements in the specified collection into this list at the specified position.
     * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress.
     * @param c collection containing elements to be inserted into this list.
     * @exception NullPointerException if the specified collection is null.
     * @see {@link HList#addAll(HCollection)} 
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
     * Inserts all of the elements in the specified collection into this list from the specified position.
     * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress.
     * @param index index at which to insert the first element from the specified collection.
     * @param c collection containing elements to be inserted into this list.
     * @return true if this list changed as a result of the call.
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size()).
     * @exception NullPointerException if the specified collection is null.
     * @see {@link HList#addAll(int, HCollection)} 
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
     * This list will be empty after this method ends.
     * @see {@link HList#clear()} 
     */
    public void clear()
    {
        v.removeAllElements();
    }

    /**
     * Returns true if this list contains the specified element.
     * @param element element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     * @see {@link HList#contains(Object)} 
     */
    public boolean contains(Object o)
    {
        return v.contains(o);
    }

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     * @param c collection containing elements to be checked for containment in this list.
     * @return true if this list contains all of the elements of the specified collection.
     * @exception NullPointerException if the specified collection is null.
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
     * Override of the Object.equals method.
     * @param o object to be compared.
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
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     * @see {@link HList#get(int)} 
     */
    public Object get(int index)
    {
        if(index<0 || index>=size())
            throw new IndexOutOfBoundsException();
        return v.elementAt(index);
    }

    /**
     * Override of the Object.hashCode method.
     * @return the hash code value for this list.
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
     * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
     * @param o element to be searched for.
     * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
     * @see {@link HList#indexOf(Object)} 
     */
    public int indexOf(Object o)
    {
        return v.indexOf(o);
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     * @see {@link HList#isEmpty()} 
     */
    public boolean isEmpty()
    {
        return size()==0;
    }
    
    /**
     * Returns an HIterator over the elements in this list in proper sequence.
     * @return an HIterator over the elements in this list in proper sequence.
     * @see {@link HList#iterator()} 
     */
    public HIterator iterator()
    {
        return new IteratorAdapter(this);
    }

    /**
     * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
     * @param o element to be searched for.
     * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
     * @see {@link HList#lastIndexOf(Object)} 
     */
    public int lastIndexOf(Object o)
    {
        return v.lastIndexOf(o);
    }

    /**
     * Returns a HListIterator over the elements in this list in proper sequence.
     * @return a HListIterator over the elements in this list in proper sequence.
     * @see {@link HList#listIterator()} 
     */
    public HListIterator listIterator()
    {
        return new IteratorAdapter(this);
    }

    /**
     * Returns a HListIterator over the elements in this list in proper sequence, starting at the specified position in this list.
     * @param index index of the first element to be returned from the new HListIterator (by a call to next).
     * @return a HListIterator over the elements in this list in proper sequence, starting at the specified position in this list.
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size()).
     * @see {@link HList#listIterator(int)} 
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
     * @param index the index of the element to be removed.
     * @return the element previously at the specified position.
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
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
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     * @param o element to be removed from this list, if present.
     * @return true if this list changed as a result of the call.
     * @see {@link HList#remove(Object)} 
     */
    public boolean remove(Object o)
    {
        return v.removeElement(o);
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     * If an element to be removed is present more than once, every copy of the element is removed.
     * If an element to be removed is not present in this list, it will be ignored.
     * @param c collection containing elements to be removed from this list.
     * @return true if this list changed as a result of the call.
     * @exception NullPointerException if the specified collection is null.
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
     * Removes from this list all of its elements that are not contained in the specified collection.
     * If an element is contained in the specified collection but not in the list this method won't add it.
     * @param c collection containing elements to be retained in this list, if present.
     * @return true if this list changed as a result of the call.
     * @exception NullPointerException if the specified collection is null.
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
     * Replaces the element at the specified position in this list with the specified element.
     * @param index index of the element to replace.
     * @param element element to be stored at the specified position.
     * @return the element previously at the specified position.
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
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
     * Returns the number of elements in this list. If there are more elements than Integer.MAX_VALUE, returns Integer.MAX_VALUE.
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
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
     * (If fromIndex and toIndex are equal, the returned list is empty.).
     * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. 
     * The returned list supports all of the optional list operations supported by this list.
     * This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays). 
     * Any operation that expects a list can be used as a range operation by passing a subList view instead of a whole list. 
     * For example, the following idiom removes a range of elements from a list:
     * list.subList(from, to).clear(); Similar idioms may be constructed for indexOf and lastIndexOf, and all of the algorithms in the Collections class can be applied to a subList. 
     * Structural changes to the list (adding and removing elements) that are not performed through the returned list won't have effect on the subList. In fact the subList state depends on the operation invoked on the fatherList.
     * @param fromIndex index of the first element to be copied.
     * @param toIndex index after the last element to be copied.
     * @return a HList containing the elements in the specified range from this list.
     * @exception IndexOutOfBoundsException if fromIndex is out of range (fromIndex < 0 || fromIndex >= size()).
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
     * Returns an array containing all of the elements in this list.
     * The returned array will be "safe" in that no references to it are maintained by this list.
     * @return an array containing all of the elements in this list.
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
     * Returns an array containing all of the elements in this list; 
     * the runtime type of the returned array is that of the specified array. 
     * If the list fits in the specified array, it is returned therein, if there is space for other elements.
     * Otherwise, a new array is allocated with object type and the size of this list.
     * @return an array containing all of the elements in this list
     * @throws NullPointerException if the array is null
     * @see {@link HList#toArray(Object[])} 
     */
    public Object[] toArray(Object[] a)
    {
        if(a==null)
            throw new NullPointerException();
        if(a.length<size())
            a = new Object[size()];
        for(int i=0; i<size(); i++)
            a[i]=v.elementAt(i);
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
                father.remove(i+fromIndex); 
            super.clear();
        }
        
        /**
         * Removes the element at the specified position in this list (optional operation). 
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
         * Removes from this list all of its elements that are not contained in the specified collection.
         * If an element is contained in the specified collection but not in the list this method won't add it.
         * Also it will do the same operation in the father list.
         * @param c collection containing elements to be retained in this list, if present.
         * @return true if this list changed as a result of the call.
         * @exception NullPointerException if the specified collection is null.
         */
        public boolean retainAll(HCollection c)
        {
            int sz=size();
            for(int i=0; i<sz; i++)
            {
                if(!c.contains(get(i)))
                    father.remove(i+fromIndex);
            }
            return super.retainAll(c);
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