package tests;

import static org.junit.Assert.*;

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
		
	}
	
	public void testAddAllIndex() {
		
	}
	
	public void testClear() {
		
	}
	
	public void testContains() {
		
	}
	
	public void testContainsAll() {
		
	}
	
	public void testEquals() {
		
	}
	
	public void testGet() {
		
	}
	
	public void testIndexOf() {
		
	}
	
	public void testIsEmpty() {
		
	}
	
	public void testIterator() {
		
	}
	
	public void testLastIndexOf() {
		
	}
	
	public void testListIterator() {
		
	}
	
	public void testListIteratorIndex() {
		
	}
	
	public void testRemove() {
		
	}
	
	public void testRemoveIndex() {
		
	}
	
	public void testRemoveAll() {
		
	}
	
	public void testRetainAll() {
		
	}
	
	public void testSet() {
		
	}
	
	public void testSubList() {
		
	}
	
	public void testToArray() {
		
	}
	
	public void testToArrayType() {
		
	}

}
