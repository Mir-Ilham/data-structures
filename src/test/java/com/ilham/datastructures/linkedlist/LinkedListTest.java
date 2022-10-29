package com.ilham.datastructures.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

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
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddingElementsAtInvalidNegativeIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		
		linkedlist.addAtIndex(a, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddingElementsAtInvalidPositiveIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(a);
		linkedlist.addBegin(a);
		
		linkedlist.addAtIndex(a, 4);
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testAccessingElementAtNegativeInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		linkedlist.get(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAccessingElementAtPositiveInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		linkedlist.get(linkedlist.length());
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testUpdatingElementAtNegativeInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		linkedlist.set(a, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUpdatingElementAtPositiveInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(a);
		linkedlist.addBegin(b);
		linkedlist.addBegin(c);
		
		linkedlist.set(a, linkedlist.length());
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

	@Test(expected = RuntimeException.class)
	public void testRemovingElementsFromHeadOfEmptyList() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.removeBegin();
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
	
	@Test(expected = RuntimeException.class)
	public void testRemovingElementsByIndexingEmptyList() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.removeAtIndex(0);
	}
	
	@Test(expected = RuntimeException.class)
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
		linkedlist.removeAtIndex(0);
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemovingElementAtNegativeInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		linkedlist.removeAtIndex(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemovingElementAtPositiveInvalidIndex() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		Integer a = 101;
		Integer b = 202;
		Integer c = 303;
		
		linkedlist.addBegin(c);
		linkedlist.addBegin(b);
		linkedlist.addBegin(a);
		linkedlist.removeAtIndex(linkedlist.length());
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
