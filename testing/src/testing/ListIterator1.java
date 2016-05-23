package testing;

import java.util.Iterator;

public class ListIterator1<E> implements Iterator<E>{
	List1<E> list = null;
	Node current = null;
	
	public ListIterator1(List1<E> l)
	{
		list = l;
		current = l.head;
	}

	@Override
	public boolean hasNext() {
		return (current.next != null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		E data = (E) current.next.data;
		current = current.next;
		return data;
	}

}
