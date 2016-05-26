package testing;

import java.util.ListIterator;

public class ListIterator2<E> implements ListIterator<E>{
	List1<E> list = null;
	Node previous = null;
	Node next = null;
	boolean left = false;

	public ListIterator2(List1<E> l)
	{
		list = l;
		previous = l.head.previous;
		next = l.head;
	}
	
	public ListIterator2(List1<E> l, int index)
	{
		list = l;
		if(index == 0)
		{
			previous = null;
			next = l.head;
		}
		else
		{
			previous = l.head;
			next = l.head.next;
		}
	}
	
	public ListIterator2(Node head)
	{
		list = new List1<E>(head);
		next = list.head;
	}
	
	@Override
	public void add(E arg0) {
		list.add(arg0);
	}

	@Override
	public boolean hasNext() {
		return (next != null);
	}
	
	@Override
	public boolean hasPrevious() {
		return (previous != null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		previous = next;
		next = next.next;
		left = false;
		return (E) previous.data;
	}

	@Override
	public int nextIndex() {
		Node current = list.head;
		int count = 0;
		while(current != null && current != next)
		{
			count++;
			current = current.next;
		}
		
		if(count == list.size)
			return list.size;
		
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E previous() {		
		next = previous;
		previous = previous.previous;
		left = true;
		return (E) next.data;
	}

	@Override
	public int previousIndex() {
		Node current = list.head;
		int count = 0;
		while(current != null && current != previous)
		{
			count++;
			current = current.next;
		}
		
		if(count == 0)
			return -1;
		
		return count;
	}

	@Override
	public void remove() {
		int index = 0;
		if(left)
		{
		index = nextIndex();	
		next = next.next;
		list.remove(index);
		}
		else
		{
		index = previousIndex();
		previous = 	previous.getPrevious();
		list.remove(index);	
		}
	}

	@Override
	public void set(E arg0) {
		Node current = list.head;
		if(left)
		{
			while(current.next != next)
			{
			current = current.next;
			}
			current.next.data = arg0;
		}
		else
		{
			while(current.next != previous)
			{
			current = current.next;
			}
			current.next.data = arg0;
		}
	}

}
