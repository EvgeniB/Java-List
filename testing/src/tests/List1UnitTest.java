package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import testing.List1;

public class List1UnitTest {
	List1<Integer> testList = null;

	@Before
	public void setUp() throws Exception {
		testList = new List1<Integer>();
	}

	@Test
	public void testAdd() {
		testList.add(new Integer(5));
		assertTrue(testList.size() == 1);
		assertTrue(((Integer) testList.getHead().data).intValue() == 5);
		assertFalse(testList == null);
	}
	
	public void testAddIndex() {
		testList.add(1, new Integer(10));
		assertTrue(testList.size() == 2);
		assertTrue(((Integer) testList.getHead().data).intValue() == 5);
		assertFalse(testList == null);
	}
	
	public void testAddAll() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		testList.addAll(list);
		assertTrue(testList.size() == 6);
		assertFalse(testList == null);
	}
	
	public void testAddAllIndex() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		testList = new List1<Integer>();
		testList.add(new Integer(0));
		testList.addAll(0, list);
		assertTrue(testList.size() == 5);
		assertTrue(((Integer) testList.getHead().data).intValue() == 5);
		assertTrue(testList.get(5) == 0);
		assertFalse(testList == null);
	}
	
	public void testClear() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.clear();
		assertTrue(testList.size() == 0);
		assertTrue(testList.getHead() == null);
	}
	
	public void testContains() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.add(15);
		testList.add(20);
		assertTrue(testList.contains(new Integer(15)));
		assertTrue(testList.size() == 3);
		assertTrue(testList.get(1) == 15);
	}
	
	public void testContainsAll() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.add(15);
		testList.add(20);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		assertTrue(testList.contains(new Integer(10)));
		assertTrue(testList.contains(new Integer(15)));
		assertTrue(testList.contains(new Integer(20)));
		assertFalse(testList.containsAll(list));
		assertTrue(testList.size() == 3);
		assertTrue(testList.get(1) == 15);
	}
	
	public void testEquals() {
		testList = new List1<Integer>();
		List1<Integer> testList2 = new List1<Integer>();
		testList.add(10);
		testList2.add(10);
		assertTrue(testList.equals(testList2));
		testList.add(15);
		assertFalse(testList.equals(testList2));
	}
	
	public void testGet() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.get(0) == 10);
		testList.add(15);
		assertFalse(testList.get(1) == 10);
	}
	
	public void testHashcode() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.hashCode() == 41);
	}
	
	public void testIndexOf() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.indexOf(new Integer(10)) == 0);
	}
	
	public void testIsEmpty() {
		testList = new List1<Integer>();
		testList.add(10);
		assertFalse(testList.isEmpty());
	}
	
	public void testIterator() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.iterator() != null);
	}
	
	public void testLastIndexOf() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.lastIndexOf(10) == 0);
	}
	
	public void testListIterator() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.listIterator() != null);
	}
	
	public void testListIteratorIndex() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.listIterator(0) != null);
	}
	
	public void testRemove() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.remove(new Integer(10)));
	}
	
	public void testRemoveIndex() {
		testList = new List1<Integer>();
		testList.add(10);
		assertTrue(testList.remove(0) == 10);
	}
	
	public void testRemoveAll() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.add(15);
		testList.add(20);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(15);
		assertTrue(testList.removeAll(list));
		assertTrue((Integer)testList.getHead().data == 20);
	}
	
	public void testRetainAll() {
		testList = new List1<Integer>();
		testList.add(15);
		testList.add(20);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(15);
		testList.retainAll(list);
		assertTrue((Integer)testList.getHead().data == 20);
	}
	
	public void testSet() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.set(0, 20);
		assertTrue((Integer)testList.getHead().data == 20);
	}
	
	public void testSubList() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.add(20);
		testList.subList(0, 1);
		assertTrue(testList.size() == 1);
		testList.subList(0, 0);
		assertTrue(testList.size() == 0);
	}
	
	public void testToArray() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.add(20);
		Integer[] arr = (Integer[]) testList.toArray();
		assertTrue(arr[0] == 10);
		assertTrue(arr[0] == 20);
	}
	
	public void testToArrayType() {
		testList = new List1<Integer>();
		testList.add(10);
		testList.add(20);
		Integer[] arr = new Integer[0];
		testList.toArray(arr);
		assertTrue(arr[0] == 10);
		assertTrue(arr[0] == 20);
	}

}
