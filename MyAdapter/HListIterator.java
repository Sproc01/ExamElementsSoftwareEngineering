package MyAdapter;

public interface HListIterator
{
    public void add(Object o);
    public boolean hasNext();
    public boolean hasPrevious();
    public Object next();
    public int nextIndex();
    public Object previous();
    public int previousIndex();
    public void remove();
    public void set(Object o);
}