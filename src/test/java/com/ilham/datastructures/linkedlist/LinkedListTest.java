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

}
