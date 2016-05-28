package testing;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import testing.ListIterator1;

public class List1<E> implements List<E>{
	Node head = null;
	int size = 0;
	
<<<<<<< HEAD
	public Node getHead(){
		return head;
	}
	
	public int getSize(){
		return size;
	}
	
=======
>>>>>>> refs/remotes/origin/master
	public List1()
	{
		
	}
	
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
		current.next = new Node(arg0, 
				current, null);
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
	
	public boolean equals(Object o){
		if(!(o instanceof List1<?>))
			return false;
		List1<?> list2 = (List1<?>) o;
		
		if(this.size != list2.size)
		{
			return false;
		}
		Node current = this.head;
		Node current2 = list2.head;
		while(current != null)
		{
			if(!current.equals(current2))
				return false;
			current = current.next;
		}
		return true;
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
	
	public int hashCode()
	{
		 int hashCode = 1;
	     for (E e : this)
	         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
		return hashCode	;
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
		ListIterator<E> iterator = new ListIterator2<E>(this, arg0);
		return iterator;
	}

	@Override
	public boolean remove(Object arg0) {
		Node current = head;
		while(current != arg0 && current != null)
		{
			current = current.next;
		}
		if(current == null)
			return false;
		current.previous.next = current.next;
		return true;
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
		for(Object element : arg0){
			while(this.contains(element))
				this.remove(element);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		List1<E> list = new List1<E>();
		for(E element : this){
			if(!arg0.contains(element))
				list.add(element);
		}
		this.removeAll(list);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int arg0, E arg1) {
		Node current = this.head;
		for(int i=0;i<arg0;i++)
			current = current.next;
		current.previous.next.data = arg1;
		return (E) current.data;
	}

	@Override
	public int size() {
		return size;
	}

	//APPARENTLY NOT NEEDED FOR LINKED LISTS
	@SuppressWarnings("unchecked")
	public void sort(Comparator<? super E> c) {
	E[] arr = (E[])new Object[this.size];
	E[] temp = (E[])new Object[this.size];
	Node current = this.head;
	for(int i=0;i<this.size;i++){
		arr[i] = (E) current.data;
		current = current.next;
		}
	//sort
	
	TopDownMergeSort(arr, temp , this.size);
	
	//end of sort
	
	this.head = null;
	for(int i=0;i<this.size;i++){
		this.add(arr[i]);
		}
	}
	
	@Override
	public List<E> subList(int arg0, int arg1) {
		if(arg0 == arg1)
			return null;
		
		List1<E> list = new List1<E>();
		
		for(int i=arg0;i<arg1;i++){
		list.add(this.get(i));	
		}
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
	
		Object[] arr = new Object[this.size];
		
		Node current = this.head;
		for(int i=0;i<this.size;i++){
			arr[i] = (E) current.data;
			current = current.next;
			}
		
		return arr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] arg0) {
		if(arg0.length < this.size)
			arg0 = (T[]) new Object[this.size];
		
		Node current = this.head;
		for(int i=0;i<this.size;i++){
			arg0[i] = (T) current.data;
			current = current.next;
			}
		
		if(arg0.length > this.size)
			arg0[arg0.length] = null;
		
		return arg0;
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
	//MERGESORT TAKEN FROM WIKIPEDIA//////////////////////////
	
	// Array A[] has the items to sort; array B[] is a work array.
	public void TopDownMergeSort(E[] A, E[] B, int n)
	{
	    TopDownSplitMerge(A, 0, n, B);
	}

	// iBegin is inclusive; iEnd is exclusive (A[iEnd] is not in the set).
	public void TopDownSplitMerge(E[] A, int iBegin, int iEnd
			, E[] B)
	{
	    if(iEnd - iBegin < 2)                       // if run size == 1
	        return;                                 //   consider it sorted
	    // recursively split runs into two halves until run size == 1,
	    // then merge them and return back up the call chain
	    int iMiddle = (iEnd + iBegin) / 2;              // iMiddle = mid point
	    TopDownSplitMerge(A, iBegin,  iMiddle, B);  // split / merge left  half
	    TopDownSplitMerge(A, iMiddle,    iEnd, B);  // split / merge right half
	    TopDownMerge(A, iBegin, iMiddle, iEnd, B);  // merge the two half runs
	    CopyArray(B, iBegin, iEnd, A);              // copy the merged runs back to A
	}

	//  Left half is A[iBegin:iMiddle-1].
	// Right half is A[iMiddle:iEnd-1   ].
	public void TopDownMerge(E[] A, int iBegin, int iMiddle
			, int iEnd, E[] B)
	{
	    int i = iBegin;
	    int j = iMiddle;
	    
	    // While there are elements in the left or right runs...
	    for (int k = iBegin; k < iEnd; k++) {
	        // If left run head exists and is <= existing right run head.
	        if (i < iMiddle && (j >= iEnd /*|| A[i] <= A[j]*/)) {
	            B[k] = A[i];
	            i = i + 1;
	        } else {
	            B[k] = A[j];
	            j = j + 1;    
	        }
	    } 
	}

	public void CopyArray(E[] B, int iBegin, int iEnd, E[] A)
	{
	    for(int k = iBegin; k < iEnd; k++)
	        A[k] = B[k];
	}
	//////////////////////////////////////////////////////////
}
