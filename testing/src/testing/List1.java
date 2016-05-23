package testing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import testing.ListIterator1;

public class List1<E> implements List<E>{
	Node head = null;
	int size = 0;
	
	public List1(Node head)
	{
		size++;
		this.head = head;
	}

	@Override
	public boolean add(E arg0) {
		size++;
		//go to tail and add node
		Node current = head;
		if(head == null){
			head = new Node(arg0, null, null);
			return true;
		}
		while(current.next != null){
			current = current.next;
		}
		Node previous = head;
		while(previous.next.next != null){
			previous = previous.next;
		}
		current.next = new Node(arg0, previous.next, null);
		return true;
	}

	@Override
	public void add(int arg0, E arg1) {
		Node current = head;
		size++;
		if(size == 0)
			head = new Node(arg1, null, null);
		else{
		if(arg0 == 0)
		{
			head = new Node(arg1, null, head);
		} else {
			Node previous = null;
					for(int i=0;i<arg0-1;i++)
					{
						if(i == arg0-1)
							previous = current;
						current = current.next;
					}
					current.next = new Node(arg1, previous.next, current.next.next);
				}
		}
		
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		for(E iterable_element : arg0)
			add(iterable_element);
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		int count = 0;
		for(E element : arg1)
		{
			add(arg0+count, element);
			count++;
		}
		return true;
	}

	@Override
	public void clear() {
		size = 0;
		head = null;
	}

	@Override
	public boolean contains(Object arg0) {
		Node current = head;
		while(current != null)
		{
			if(current.data.equals(arg0))
			{
				System.out.println("List contains element arg0.");
				return true;
			}
			current = current.next;
		}
		System.out.println("List does not contain element arg0.");
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for(Object el : arg0)
			contains(el);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int arg0) {
		Node current = head; 
		for(int i=0;i<arg0;i++)
		{
			current = current.next;
		}
		return (E) current.data;
	}

	@Override
	public int indexOf(Object arg0) {
		if(!contains(arg0))
			return -1;
		else
		{
			Node current = head;
			int count = 0;
			while(current.data != arg0 && current != null)
			{
				count++;
				current = current.next;
			}
			return count;
		}
	}

	@Override
	public boolean isEmpty() {
		return (size == 0 ? true : false);
	}

	@Override
	public Iterator<E> iterator() {
		ListIterator1<E> iterator = new ListIterator1<E>(this);
		return (Iterator<E>) iterator;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		if(!contains(arg0))
			return -1;
		else
		{
			Node current = head;
			int count = 0;
			int count2 = 0;
			while(current != null)
			{
				if(current.data == arg0)
					count2 = 0;
				count++;
				count2++;
				current = current.next;
			}
			return count-count2;
		}
	}

	@Override
	public ListIterator<E> listIterator() {
		ListIterator<E> iterator = new ListIterator2<E>(this);
		return (ListIterator<E>) iterator;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int arg0) {
		if(size == 0)
			return null;
		else
		{
			Node current = head;
			for(int i=0;i<arg0;i++)
			{
				current = current.next;
			}
			size--;
			current.next = current.next.next;
			return (E) current.next.data;
		}
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void toString_(){
		System.out.print("[");
		Node current = head;
		for(int i=0;i<size;i++){
			if(i < size-1)
			System.out.print(current.data + ", ");
			else
			System.out.print(current.data + "]");
			current = current.next;
		}
	}

}
