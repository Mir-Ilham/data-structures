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
}
