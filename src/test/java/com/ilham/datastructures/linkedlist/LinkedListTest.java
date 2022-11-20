package com.ilham.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

	// Add display names for test
	
	LinkedList<Integer> linkedlist;
	
	Integer a = 101;
	Integer b = 202;
	Integer c = 303;
	Integer d = 404;
	
	@BeforeEach
	void init() {
		linkedlist = new LinkedList<Integer>();
	}
	
	@Test
	public void testEmptyList() {
		assertEquals("[]", linkedlist.toString());
		assertEquals(0, linkedlist.length());
	}

	@Test
	public void testAddingElementsAtHead() {
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		assertEquals("[101, 202, 303]", linkedlist.toString());
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testAddingElementsAtInvalidNegativeIndex() {
		assertThrows(IllegalArgumentException.class, () -> linkedlist.addAtIndex(a, -1));
	}
	
	@Test
	public void testAddingElementsAtInvalidPositiveIndex() {
		linkedlist.addBegin(a);
		linkedlist.addBegin(a);
		linkedlist.addBegin(a);
		assertThrows(IllegalArgumentException.class, () -> linkedlist.addAtIndex(a, 4));
	}
	
	@Test
	public void testAddingElementsAtIndexZero() {
		linkedlist.addAtIndex(c, 0);
		linkedlist.addAtIndex(b, 0);
		linkedlist.addAtIndex(a, 0);
		
		assertEquals("[101, 202, 303]", linkedlist.toString());
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testAddingElementsAtAValidIndex() {
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
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		linkedlist.addAtIndex(a, linkedlist.length());
		
		assertEquals("[101, 202, 303, 101]", linkedlist.toString());
		assertEquals(4, linkedlist.length());
	}

	@Test
	public void testAddingElementsAtTail() {
		linkedlist.addEnd(a);
		linkedlist.addEnd(b);
		linkedlist.addEnd(c);
		
		assertEquals("[101, 202, 303]", linkedlist.toString());
		assertEquals(3, linkedlist.length());
	}
	
	@Test
	public void testAccessingElementAtNegativeInvalidIndex() {
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.get(-1));
	}
	
	@Test
	public void testAccessingElementAtPositiveInvalidIndex() {
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.get(linkedlist.length()));
	}
	
	@Test
	public void testAccessingElementAtValidIndex() {
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertEquals(b, linkedlist.get(1));
	}
	
	@Test
	public void testUpdatingElementAtNegativeInvalidIndex() {
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.set(a, -1));
	}
	
	@Test
	public void testUpdatingElementAtPositiveInvalidIndex() {
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.set(a, linkedlist.length()));
	}
	
	@Test
	public void testUpdatingElementAtValidIndex() {
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		linkedlist.set(c, 2);
		
		assertEquals(c, linkedlist.get(2));
	}

	@Test
	public void testRemovingElementsFromHeadOfEmptyList() {
		assertThrows(RuntimeException.class, () -> linkedlist.removeBegin());
	}
	
	@Test
	public void testRemovingElementsFromHead() {
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
		assertThrows(RuntimeException.class, () -> linkedlist.removeAtIndex(0));
	}
	
	@Test
	public void testRemovingElementsBeyondEmptyList() {
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
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.removeAtIndex(-1));
	}
	
	@Test
	public void testRemovingElementAtPositiveInvalidIndex() {
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		
		assertThrows(IllegalArgumentException.class, () -> linkedlist.removeAtIndex(linkedlist.length()));
	}
	
	@Test
	public void testRemovingElementAtValidIndex() {
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
