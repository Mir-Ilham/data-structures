package com.ilham.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

	// Add display names for test
	// Remove redundant code using @before
	
	@Test
	public void testEmptyList() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		
		assertEquals("[]", linkedlist.toString());
		assertEquals(0, linkedlist.length());
	}

	@Test
	public void testAddingElementsAtHead() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		assertEquals("[101, 202, 303]", linkedlist.toString());
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testAddingElementsAtInvalidNegativeIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		assertThrows(IllegalArgumentException.class, () -> linkedlist.addAtIndex(a, -1));
	}
	
	@Test
	public void testAddingElementsAtInvalidPositiveIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(a);
		linkedlist.addBegin(a);
		assertThrows(IllegalArgumentException.class, () -> linkedlist.addAtIndex(a, 4));
	}
	
	@Test
	public void testAddingElementsAtIndexZero() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addAtIndex(c, 0);
		linkedlist.addAtIndex(b, 0);
		linkedlist.addAtIndex(a, 0);
		
		assertEquals("[101, 202, 303]", linkedlist.toString());
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testAddingElementsAtAValidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		linkedlist.addAtIndex(c, 1);
		
		assertEquals("[101, 303, 202, 303]", linkedlist.toString());
		assertEquals(4, linkedlist.length());
		
		linkedlist.addAtIndex(a, 2);
		
		assertEquals("[101, 303, 101, 202, 303]", linkedlist.toString());
		assertEquals(5, linkedlist.length());
	}
	
	@Test
	public void testAddingElementsIndexingAtTail() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		linkedlist.addAtIndex(a, linkedlist.length());
		
		assertEquals("[101, 202, 303, 101]", linkedlist.toString());
		assertEquals(4, linkedlist.length());
	}

	@Test
	public void testAddingElementsAtTail() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addEnd(a);
		linkedlist.addEnd(b);
		linkedlist.addEnd(c);
		
		assertEquals("[101, 202, 303]", linkedlist.toString());
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testAccessingElementAtNegativeInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.get(-1));
	}
	
	@Test
	public void testAccessingElementAtPositiveInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.get(linkedlist.length()));
	}
	
	@Test
	public void testAccessingElementAtValidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertEquals(b, linkedlist.get(1));
	}
	
	@Test
	public void testUpdatingElementAtNegativeInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.set(a, -1));
	}
	
	@Test
	public void testUpdatingElementAtPositiveInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.set(a, linkedlist.length()));
	}
	
	@Test
	public void testUpdatingElementAtValidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		linkedlist.set(c, 2);
		
		assertEquals(c, linkedlist.get(2));
	}

	@Test
	public void testRemovingElementsFromHeadOfEmptyList() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		assertThrows(RuntimeException.class, () -> linkedlist.removeBegin());
	}
	
	@Test
	public void testRemovingElementsFromHead() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		Integer removedElement = linkedlist.removeBegin();
		
		assertEquals("[202, 303]", linkedlist.toString());
		assertEquals(a, removedElement);
		assertEquals(2, linkedlist.length());
	}
	
	@Test
	public void testRemovingElementsByIndexingEmptyList() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		assertThrows(RuntimeException.class, () -> linkedlist.removeAtIndex(0));
	}
	
	@Test
	public void testRemovingElementsBeyondEmptyList() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		linkedlist.removeAtIndex(0);
		linkedlist.removeAtIndex(0);
		linkedlist.removeAtIndex(0);
		assertThrows(RuntimeException.class, () -> linkedlist.removeAtIndex(0));
	}
	
	@Test
	public void testRemovingElementsTillEmptyList() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		linkedlist.removeAtIndex(0);
		linkedlist.removeAtIndex(0);
		linkedlist.removeAtIndex(0);
		
		assertEquals("[]", linkedlist.toString());
		assertEquals(0, linkedlist.length());
	}
	
	@Test
	public void testRemovingElementAtNegativeInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.removeAtIndex(-1));
	}
	
	@Test
	public void testRemovingElementAtPositiveInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.removeAtIndex(linkedlist.length()));
	}
	
	@Test
	public void testRemovingElementAtValidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		Integer d = 404;
		
		linkedlist.addBegin(d);
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		Integer removedElement = linkedlist.removeAtIndex(2);
		
		assertEquals("[101, 202, 404]", linkedlist.toString());
		assertEquals(c, removedElement);
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testRemovingElementAtZeroIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		Integer d = 404;
		
		linkedlist.addBegin(d);
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		Integer removedElement = linkedlist.removeAtIndex(0);
		
		assertEquals("[202, 303, 404]", linkedlist.toString());
		assertEquals(a, removedElement);
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testRemovingElementFromTail() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		Integer d = 404;
		
		linkedlist.addBegin(d);
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		Integer removedElement = linkedlist.removeEnd();
		
		assertEquals("[101, 202, 303]", linkedlist.toString());
		assertEquals(d, removedElement);
		assertEquals(3, linkedlist.length());
	}
}
