package MyAdapter;

import MyAdapter.HCollection;

/**
* An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.
* Unlike sets, lists typically allow duplicate elements. More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2), and they typically allow multiple null elements if they allow null elements at all. It is not inconceivable that someone might wish to implement a list that prohibits duplicates, by throwing runtime exceptions when the user attempts to insert them, but we expect this usage to be rare.
* The List interface places additional stipulations, beyond those specified in the Collection interface, on the contracts of the iterator, add, remove, equals, and hashCode methods. Declarations for other inherited methods are also included here for convenience.
* The List interface provides four methods for positional (indexed) access to list elements. Lists (like Java arrays) are zero based. Note that these operations may execute in time proportional to the index value for some implementations (the LinkedList class, for example). Thus, iterating over the elements in a list is typically preferable to indexing through it if the caller does not know the implementation.
* The List interface provides a special iterator, called a ListIterator, that allows element insertion and replacement, and bidirectional access in addition to the normal operations that the Iterator interface provides. A method is provided to obtain a list iterator that starts at a specified position in the list.
* The List interface provides two methods to search for a specified object. From a performance standpoint, these methods should be used with caution. In many implementations they will perform costly linear searches.
* The List interface provides two methods to efficiently insert and remove multiple elements at an arbitrary point in the list.
* Note: While it is permissible for lists to contain themselves as elements, extreme caution is advised: the equals and hashCode methods are no longer well defined on a such a list.
* Some list implementations have restrictions on the elements that they may contain. For example, some implementations prohibit null elements, and some have restrictions on the types of their elements. Attempting to add an ineligible element throws an unchecked exception, typically NullPointerException or ClassCastException. Attempting to query the presence of an ineligible element may throw an exception, or it may simply return false; some implementations will exhibit the former behavior and some will exhibit the latter. More generally, attempting an operation on an ineligible element whose completion would not result in the insertion of an ineligible element into the list may throw an exception or it may succeed, at the option of the implementation. Such exceptions are marked as "optional" in the specification for this interface.
* @author Michele Sprocatti
* @see {@link #HCollection}
 */
public interface HList extends HCollection
{
    /**
     * Inserts the specified element at the specified position in this list (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @exception UnsupportedOperationException if the add method is not supported by this list
     * @exception ClassCastException if the class of the specified element prevents it from being added to this list
     * @exception NullPointerException if the specified element is null and this list does not support null elements
     * @exception IllegalArgumentException if some aspect of the specified element prevents it from being added to this list
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    void add(int index, Object element);

    /**
     * Inserts all of the elements in the specified collection into this list at the specified position (optional operation). 
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). 
     * The new elements will appear in this list in the order that they are returned by the specified collection's iterator. 
     * The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress. 
     * (Note that this will occur if the specified collection is this list, and it's nonempty.)
     * @param index  index at which to insert first element from the specified collection.
     * @param c elements to be inserted into this list.
     * @return true if this list changed as a result of the call.
     * @exception UnsupportedOperationException if the addAll method is not supported by this list
     * @exception ClassCastException if the class of an element of the specified collection prevents it from being added to this list
     * @exception NullPointerException if the specified collection contains one or more null elements and this list does not support null elements, or if the specified collection is null
     * @exception IllegalArgumentException if some aspect of an element of the specified collection prevents it from being added to this list
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    boolean addAll(int index, HCollection c);

    /**
     * returns the element at the specified position in this list
     * @param index index of element to return
     * @return the element at the specified position in this list
     * @exception IndexOutOfBoundException if the index is out of range (index < 0 || index >= size())
     */
    Object get(int index);

    /**
     * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element. 
     * More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     * @param o element to search for
     * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element
     * @exception ClassCastException if the type of the specified element is incompatible with this list (optional)
     * @exception NullPointerException if the specified element is null and this list does not support null elements (optional)
     */
    int indexOf(Object o);

    /**
     * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element. 
     * More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     * @param o element to search for
     * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
     * @exception ClassCastException - if the type of the specified element is incompatible with this list (optional).
     * @exception NullPointerException - if the specified element is null and this list does not support null elements (optional).
     */
    int lastIndexOf(Object o);

    /**
     * Returns a list iterator of the elements in this list (in proper sequence).
     * @return a list iterator of the elements in this list (in proper sequence)
     */
    HListIterator listIterator();

    /**
     * Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. 
     * The specified index indicates the first element that would be returned by an initial call to the next method. An initial call to the previous method would return the element with the specified index minus one.
     * @param index index of the first element to be returned from the list iterator (by a call to the next method)
     * @return a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    HListIterator listIterator(int index);

    /**
     * Removes the element at the specified position in this list (optional operation). Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @exception UnsupportedOperationException if the remove method is not supported by this list
     * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    Object remove(int index);
    Object set(int index,Object element);

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
     * (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. 
     * The returned list supports all of the optional list operations supported by this list.
     * This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays). Any operation that expects a list can be used as a range operation by passing a subList view instead of a whole list. 
     * For example, the following idiom removes a range of elements from a list:
	 *  list.subList(from, to).clear();
     * Similar idioms may be constructed for indexOf and lastIndexOf, and all of the algorithms in the Collections class can be applied to a subList.
     * The semantics of the list returned by this method become undefined if the backing list (i.e., this list) is structurally modified in any way other than via the returned list. 
     * (Structural modifications are those that change the size of this list, or otherwise perturb it in such a fashion that iterations in progress may yield incorrect results.)
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @exception IndexOutOfBoundsException for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex).
     */
    HList subList(int fromIndex, int toIndex);

    /**
     * Ensures that this collection contains the specified element (optional operation). Returns true if this collection changed as a result of the call. (Returns false if this collection does not permit duplicates and already contains the specified element.)
     * Collections that support this operation may place limitations on what elements may be added to this collection. In particular, some collections will refuse to add null elements, and others will impose restrictions on the type of elements that may be added. Collection classes should clearly specify in their documentation any restrictions on what elements may be added.
     * If a collection refuses to add a particular element for any reason other than that it already contains the element, it must throw an exception (rather than returning false). This preserves the invariant that a collection always contains the specified element after this call returns.
     * @return true if this collection changed as a result of the call
     * @param o element whose presence in this collection is to be ensured
     * @exception UnsupportedOperationException add is not supported by this collection
     * @exception ClassCastException class of the specified element prevents it from being addede to this collection
     * @exception NullPointerException if the specified element is null and this collection does not support null elements
     * @exception IllegalArgumentException some aspect of the specified element prevents it from being added to this collection
     */
    public boolean add(Object o);


    /**
     * Adds all of the elements in the specified collection to this collection (optional operation). The behavior of this operation is undefined if the specified collection is modified while the operation is in progress. (This implies that the behavior of this call is undefined if the specified collection is this collection, and this collection is nonempty.)
     * @param c elements to be inserted into this collection
     * @return true if this collection changed as a result of the call
     * @see {@link #add(Object)}
     * @exception UnsupportedOperationException if this collection does not support th addAll method
     * @exception NullPointerException if the specified collection contains one or more  null elements and this collection does not support null elements, or if the specified collection is null
     * @exception IllegalArgumentException some aspect of an element of the specified collection prevents it from being added to this collection
     */
    public boolean addAll(HCollection c);

    /**
     * Removes all of the elements from this collection (optional operation). This collection will be empty after this method returns unless it throws an exception.
     * @exception UnsupportedOperationException if the clear method is not supported by this collection
     */
    public void clear();

    /**
     * Returns true if this collection contains the specified element.
     * More formally, returns true if and only if this collection contains at least one element e such that (o==null ? e==null : o.equals(e)).
     * @param o element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element
     * @exception ClassCastException if the type of the specified element is incompatible with this collection(optional)
     * @exception NullPointerException if the specified element is null and this collection does not permit null elements(optional)
     */
    public boolean contains(Object o);


    /**
     * Returns true if this collection contains all of the elements in the specified collection.
     * @param c collection to be checked for containment in this collection
     * @return true if this collection contains all of the elements in the specified collection
     * @exception ClassCastException if the types of one or more elements in the specified collection are incompatible with this collection(optional)
     * @exception NullPointerException if the specified collection contains one or more null elements and this collection does not support null elements(optional)
     * @exception NullPointerException if the specified collection is null
     * @see {@link #contains(Object)}
     */
    public boolean containsAll(HCollection c);

    /**
     * Compares the specified object with this collection for equality.
     * While the Collection interface adds no stipulations to the general contract for the Object.equals, programmers who implement the Collection interface "directly" (in other words, create a class that is a Collection but is not a Set or a List) must exercise care if they choose to override the Object.equals. It is not necessary to do so, and the simplest course of action is to rely on Object's implementation, but the implementer may wish to implement a "value comparison" in place of the default "reference comparison." (The List and Set interfaces mandate such value comparisons.)
     * The general contract for the Object.equals method states that equals must be symmetric (in other words, a.equals(b) if and only if b.equals(a)). The contracts for List.equals and Set.equals state that lists are only equal to other lists, and sets to other sets. Thus, a custom equals method for a collection class that implements neither the List nor Set interface must return false when this collection is compared to any list or set. (By the same logic, it is not possible to write a class that correctly implements both the Set and List interfaces.)
     * @param o object to be compared for equality with this collection
     * @return true if the specified object is equal to this collection
     * @see {@link Object#equals(Object)}, {@link HList#equals(Object)}, {@link Set#equals(Object)}
     */
    public boolean equals(Object o);

    /**Returns the hash code value for this collection. 
     * While the Collection interface adds no stipulations to the general contract for the Object.hashCode method, programmers should take note that any class that overrides the Object.equals method must also override the Object.hashCode method in order to satisfy the general contract for the Object.hashCodemethod. In particular, c1.equals(c2) implies that c1.hashCode()==c2.hashCode(). 
     * @return the hash code value for this collection
     * @see {@link Object#hashCode()}, {@link HList#hashCode()}, {@link Set#hashCode()}
     */
    public int hashCode();

    /**
     * Returns true if this collection contains no elements.
     * @return true if this collection contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns an iterator over the elements in this collection. 
     * There are no guarantees concerning the order in which the elements are returned (unless this collection is an instance of some class that provides a guarantee).
     * @return an iterator over the elements in this collection
     */
    HIterator iterator();

    /**
     * Removes a single instance of the specified element from this collection, if it is present (optional operation). More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this collection contains one or more such elements. Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
     * @param o element to be removed from this collection, if present
     * @return true if this collection contained the specified element
     * @exception ClassCastException if the type of the specified element is incompatible with this collection(optional)
     * @exception NullPointerException if the specified element is null and this collection does not permit null elements(optional)
     * @exception UnsupportedOperationException remove is not supported by this collection
     */
    public boolean remove(Object o);

    /**
     * Removes all this collection's elements that are also contained in the specified collection (optional operation). After this call returns, this collection will contain no elements in common with the specified collection.
     * @param c elements to be removed from this collection
     * @return true if this collection changed as a result of the call
     * @exception UnsupportedOperationException if the removeAll method is not supported by this collection
     * @exception ClassCastException if the types of one or more elements in this collection are incompatible with the specified collection(optional)
     * @exception NullPointerException if the specified collection is null
     * @exception NullPointerException if this collection contains one or more null elements and the specified collection does not support null elements(optional)
     * @see {@link #remove(Object)}
     */
    public boolean removeAll(HCollection c);

    /**
     * Retains only the elements in this collection that are contained in the specified collection (optional operation). In other words, removes from this collection all of its elements that are not contained in the specified collection.
     * @param c  elements to be retained in this collection.
     * @return true if this collection changed as a result of the call
     * @exception UnsupportedOperationException if the retainAll method is not supported by this collection
     * @exception ClassCastException if the types of one or more elements in this collection are incompatible with the specified collection(optional)
     * @exception NullPointerException if the specified collection is null
     * @exception NullPointerException if this collection contains one or more null elements and the specified collection does not support null elements(optional)
     * @see {@link #remove(Object)},{@link #contains(Object)}
     */
    public boolean retainAll(HCollection c);

    /**
     * Returns the number of elements in this collection. 
     * If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * @return the number of elements in this collection
     */
    public int size();

    /**
     * Returns an array containing all of the elements in this collection. If the collection makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order.
     * The returned array will be "safe" in that no references to it are maintained by this collection. (In other words, this method must allocate a new array even if this collection is backed by an array). The caller is thus free to modify the returned array.
     * This method acts as bridge between array-based and HCollection-based APIs.
     * @return an array containing all of the elements in this collection
     */
    public Object[] toArray();


    /**
     * Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array. If the collection fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this collection.
     * If this collection fits in the specified array with room to spare (i.e., the array has more elements than this collection), the element in the array immediately following the end of the collection is set to null. This is useful in determining the length of this collection only if the caller knows that this collection does not contain any null elements.)
     * If this collection makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order.
     * Like the toArray method, this method acts as bridge between array-based and collection-based APIs. Further, this method allows precise control over the runtime type of the output array, and may, under certain circumstances, be used to save allocation costs
     * Suppose l is a List known to contain only strings. The following code can be used to dump the list into a newly allocated array of String:
     * String[] x = (String[]) v.toArray(new String[0]);
     * Note that toArray(new Object[0]) is identical in function to toArray().
     * @param a  the array into which the elements of this collection are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of this collection
     * @exception ArrayStoreException if the runtime type of the specified array is not a supertype of the runtime type of every element in this collection
     * @exception NullPointerException if the specified array is null
     */ 
    public Object[] toArray(Object[] a);
}